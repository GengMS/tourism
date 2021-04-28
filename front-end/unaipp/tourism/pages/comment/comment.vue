<template>
	<view>
		<dongTai :dongData="dongData" :index="null" :isComment="true"></dongTai>
		<view class="ping">
			<input type="text" v-model="content"/><button type="default" @click="uploadComments()">评论</button>
		</view>
		<view class="comment_container">
			<comment v-for="(item,index) in commentsData" :key="index" :commentData="item"></comment>
		</view>
	</view>
</template>

<script>
	import dongTai from "../compent/dongTai";
	import comment from "../compent/comment.vue"
	export default {
		components:{
			dongTai,
			comment
		},
		data() {
			return {
				dongData:{},
				commentsData:[],
				content:""
			}
		},
		methods: {
			uploadComments(){
				let that = this;
				uni.request({
					url:getApp().globalData.lv_tai+"uploadComments/"+this.dongData.dId+"/"+getApp().globalData.user.uId+"/"+this.content,
					method:"POST",
					success(res) {
						if(res.data){
							that.dongData.commentsCount++;
							let uId = getApp().globalData.user.uId;
							let name = getApp().globalData.user.name;
							let imgUrl = getApp().globalData.user.imgUrl;
							let content = that.content;
							that.commentsData.unshift({
								uId: uId,
								name: name,
								imgUrl: imgUrl,
								content: content
							})
						}
					}
				})
			},
			getCommentsData(){
				let that = this;
				uni.request({
					url:getApp().globalData.lv_tai+"comment/list/"+this.dongData.dId,
					success(res) {
						that.commentsData = res.data;
						for (var i = 0; i < that.commentsData.length; i++) {
							that.commentsData[i].imgUrl = that.commentsData[i].imgUrl.replace(/\^/g,"/")
						}
					}
				})
			}
		},
		onLoad(options) {
			this.dongData = JSON.parse(options.dongData);
			this.getCommentsData();
		}
	}
</script>

<style scoped>
.ping{
	display: flex;
	padding: 0 10px;
	align-items: center;
	margin: 20px 0;
}
.ping>input{
	width: 70%;
	height: 45px;
	font-size: 30px;
	line-height: 30px;
	 box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
}
.ping>button{
	width: 30%;
	text-align: center;
	
}
.comment_container{
	width: 86%;
	margin: 0 auto;
}
</style>

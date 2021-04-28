<template>
	<view class="dongTai">
		<view class="user_infor">
			<image :src="dongData.imgUrl" mode=""></image>
			{{dongData.userName}}
			
		</view>
		<view class="title">
			{{dongData.content[0].content}}
		</view>
		<view class="imgList">
			<image v-for="(item,index) in dongData.content" v-if="item.type == `图片`" :src="item.content" mode=""></image>
		</view>
		<view class="di" v-if="dongData.sight.length > 0">
			<image src="../../static/di.png" mode=""></image>
			{{dongData.sight}}
		</view>
		<view class="jiao">
			<view class="" @click="dot()">
				<image :src="dotImgUrl" mode="" v-show="!dongData.goDot"></image>
				<image :src="dotImgAct" mode="" v-show="dongData.goDot"></image>
				{{dongData.dotCount}}
			</view>
			<view class="" @click="goComment()">
				<image src="../../static/ping.png" mode=""></image>
				{{dongData.commentsCount}}
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		props:["dongData","index","isComment"],
		data() {
			return {
				dotImgUrl:"../../static/dot.png",
				dotImgAct:"../../static/dot_act.png",
				IsDot:"",
				dotCount:""
			}
		},
		methods: {
			dot(){
				if(this.isComment) {
					uni.showToast({
						title: '返回后可点赞',
						image:'/static/close.png',
						duration: 2000
					});
					return;
				}
				let index = this.index;
				let that = this;
				
				if(this.dongData.goDot){
					uni.request({
						url:getApp().globalData.lv_tai+"decDot/"+this.dongData.dId+"/"+getApp().globalData.user.uId,
						method:"POST",
						success(res) {
							if( res.data ){
								that.$parent.dataList[index].dotCount--;
								that.$parent.dataList[index].goDot = false;
							}
							
						}
					})
				}else {
					uni.request({
						url:getApp().globalData.lv_tai+"increDot/"+this.dongData.dId+"/"+getApp().globalData.user.uId,
						method:"POST",
						success(res) {
							if( res.data ){
								that.$parent.dataList[index].dotCount++;
								that.$parent.dataList[index].goDot = true;
							}
							
						}
					})
				}
				
			},
			goComment(){
				let dongData = JSON.stringify(this.dongData);
				console.log(typeof(dongData))
				
				uni.navigateTo({
					url:"../comment/comment?dongData="+dongData
				})
			}
		},
		// beforeMount() {
		// 	this.IsDot = this.dongData.goDot;
		// 	this.dotCount = this.dongData.dotCount;
		// 	console.log(this.dotCount)
		// }
	}
</script>

<style scoped>
	.di{
		display: flex;
		height: 20px;
		align-items: center;
	}
	.di>image{
		width: 20px;
		height: 20px;
		margin-right: 8px;
	}
.dongTai{
	padding: 10px ;
	background: rgba(0, 0, 0, 0.04);
	box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
	margin-top: 20px;
}
.user_infor{
	display: flex;
	align-items: center;
}
.user_infor>image{
	width: 40px;
	height: 40px;
	border-radius: 4px;
}
.title{
	font-size: 20px;
	margin: 10px 0;
}
.dongTai .imgList{
	display: flex;
	flex-wrap: wrap;
}
.dongTai .imgList>image{
	width: 80px;
	height: 80px;
	
	padding: 6px;
}
.jiao{
	display: flex;
	margin-top: 10px;
}
.jiao>view{
	display: flex;
	align-items: center;
	height: 30px;
	margin-left: 10px;
}
.jiao image{
	height: 100%;
	width: 30px;
}
</style>

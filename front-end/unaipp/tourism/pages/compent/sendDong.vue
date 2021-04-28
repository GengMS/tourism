<template>
	<view class="sendDong">
		
		<view class="" style="display: flex; justify-content: space-between; " >
			<text>
				动态发布
			</text>
			
			<text @click="hidden()">x</text>
		</view>
		<view class="title">
			标题
			
			<input type="text" v-model="dong.title" maxlength="50" />
			
		</view>
		<view class="" style="margin: 10px 0;">
			<view class="dong_imgList">
				<image v-for="(item,index) in dong.imgList" :src="item" mode=""></image>
			</view>
			
			<button type="default" @click="uploadImg()">上传图片</button>
		</view>
		
		<view class="">
			地点：
			<input type="text" v-model="dong.sight" />
		</view>
		<button type="priamry" style="margin-top: 10px;" @click="send()">发布</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				dong:{
					type:0,
					uId:0,
					title:"",
					sight:"",
					imgList:[
						
					]
				}
			}
		},
		methods: {
			send(){
				if(this.dong.title.length == 0){
					uni.showToast({
						title: '标题不能为空',
						image: '/static/close.png',
						duration: 2000
					});
					return;
				}
				let data = JSON.stringify(this.dong);
				let that = this;
				uni.request({
					url:getApp().globalData.lv_tai+"dong/upload",
					method:"POST",
					data:data,
					success(res) {
						if(res.data){
							that.hidden();
							uni.showToast({
								title: '发布成功'
							});
						}
					},
					fail(){
						uni.showToast({
							title: '发布错误',
							image: '/static/close.png',
							duration: 2000
						});
					}
				})
			},
			hidden(){
				this.$parent.sendDongShow = false;
			},
			uploadImg() {
				if(this.dong.imgList.length >= 5){
					uni.showToast({
						title: '最多上传五张',
						image: '/static/close.png',
						duration: 2000
					});
					return;
				}
				uni.chooseImage({
					success: (chooseImageRes) => {
						const tempFilePaths = chooseImageRes.tempFilePaths;
						let size = chooseImageRes.tempFiles[0].size;
						console.log(size)
						if(size > 1*1024*1024*2){
							uni.showToast({
								title: '体积大于2M',
								image: '/static/close.png',
								duration: 2000
							});
							return;
						}
						let that = this;
					
						uni.uploadFile({
							url: getApp().globalData.login+'upload', 
							filePath: tempFilePaths[0],
							name: 'file',
							success: (uploadFileRes) => {
								if(uploadFileRes.data != "error"){
									that.dong.imgList.push(uploadFileRes.data)
								}else{
									uni.showToast({
										title: '上传错误',
										image: '/static/close.png',
										duration: 2000
									});
								}
								
							},
							fail(res) {
								uni.showToast({
									title: '上传错误',
									image: '/static/close.png',
									duration: 2000
								});
								
							}
						});
					}
				});
			},
		},
		beforeMount() {
			this.dong.uId = getApp().globalData.user.uId;
			console.log(this.dong)
		}
	}
</script>

<style scoped>
	.dong_imgList{
		display: flex;
		flex-wrap: wrap;
	}
	.dong_imgList image{
		padding: 0.1%;
		height: 130px;
		width: 33%;
		max-width: 33%;
	}
	
.sendDong{
	position: fixed;
	top: 25%;
	left: 50%;
	width: 80%;
	transform: translate(-50%);
	padding: 10px;
	background: white;
	border-radius: 4px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
}
</style>

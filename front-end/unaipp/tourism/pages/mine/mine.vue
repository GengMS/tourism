<template>
	<view>
		<view class="f1">
			<view class="mine_container">
				<view class="con_f1">
					<image :src="imgUrl" mode="" ></image>
					<text class="kong"> </text>
					{{name}}
				</view>
				<view class="">
					{{theSay}}
				</view>
			</view>
		</view>

		<view class="mine_container f2">

			<view class="">
				<view class=""@click="updateShow = !updateShow">
					修改信息
				</view>
				<view class="update_infor" v-if="updateShow" >
					
						<view class="">
							头像：<image :src="user.imgUrl" mode=""></image>
							<button type="default" class="update_imgUrl" @click="uploadImg()">修改</button>
						</view>
						<view class="">
							用户名：<input type="text" v-model="user.name" />
						</view>
						<view class="">
							签名：<input type="text" v-model="user.theSay" />
						</view>
					<button type="primary" @click="updateInfor()">提交修改</button>
					
				</view>
			</view>
			<view class="" @click="goLvTu()">
				我的旅图
			</view>
			<view class="" @click="goLogin()">
				登出
			</view>
		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				name: "",
				imgUrl: "https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png",
				theSay: "",
				user:{
					uId:0,
					name:"",
					imgUrl:"",
					theSay:""
				},
				updateShow:false
			}
		},
		methods: {
			updateInfor(){
				this.user.imgUrl = this.user.imgUrl.replace(/\//g, "^");
				console.log(this.user.imgUrl)
				let that = this;
				uni.request({
					method:"POST",
					url:getApp().globalData.login+"updateUserInfor/"+JSON.stringify(this.user),
					success(res) {
						if(res.data) {
							that.user.imgUrl = that.user.imgUrl.replace(/\^/g, "/");
							that.name = that.user.name;
							that.imgUrl = that.user.imgUrl;
							that.theSay = that.user.theSay;
							getApp().globalData.user.name = that.user.name;
							getApp().globalData.user.imgUrl = that.user.imgUrl
							getApp().globalData.user.theSay = that.user.theSay;
							
							uni.showToast({ title: '修改成功' });
						}
					}
,				})
			},
			goLogin(){
				uni.redirectTo({
					url: "../login/login"
				})
			},
			goLvTu(){
				uni.navigateTo({
					url:"../lv_tu/lv_tu"
				})
			},
			uploadImg() {
				uni.chooseImage({
					success: (chooseImageRes) => {
						const tempFilePaths = chooseImageRes.tempFilePaths;
						let that = this;
						uni.uploadFile({
							url: getApp().globalData.login+'upload', 
							filePath: tempFilePaths[0],
							name: 'file',
							success: (uploadFileRes) => {
								if(uploadFileRes.data != "error") {
									this.user.imgUrl = uploadFileRes.data.replace(/\^/g, "/");
								}
								
							},
							fail(res) {
								console.log(res)
							}
						});
					}
				});
			}
		},
		onShow() {
			if (getApp().globalData.user.uId == null) {
				uni.redirectTo({
					url: "../login/login"
				})
			}
			this.name = getApp().globalData.user.name;
			if (getApp().globalData.user.isInfor == 1) {
				this.imgUrl = getApp().globalData.user.imgUrl
				this.theSay = getApp().globalData.user.theSay
			}
			this.user.uId = getApp().globalData.user.uId
			this.user.name = this.name;
			this.user.imgUrl = this.imgUrl;
			this.user.theSay = this.theSay
		},

		beforeCreate() {
			if (getApp().globalData.user.uId == null) {
				uni.redirectTo({
					url: "../login/login"
				})
			}
		}
	}
</script>

<style scoped>
	.update_imgUrl{
		display:inline-block;
	}
	.kong {
		margin: 0 20rpx;
	}

	.mine_container {
		width: 80%;
		margin: 0 auto;
	}

	.f1 {
		border-radius: 4px !important;
		box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
		padding: 20rpx 0;
		background: #08af23;
	}

	.con_f1 {
		display: flex;
		align-items: center;
	}

	.con_f1>image {
		width: 80rpx;
		height: 80rpx;

	}
	.f2{
		padding: 20px 0;
	}
	.f2>view{
		border-radius: 4px;
		box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
		padding: 0 5px;
	}
	.f2>view>view:nth-child(1){
		height: 30px;
		line-height: 30px;
		
	}
	.f2>view:nth-child(2),.f2>view:nth-child(3){
		height: 30px;
		line-height: 30px;
		padding: 5px;
		margin-top: 20px;
	}
	.update_infor{
		margin: 10px 0;
	}
	.update_infor image{
		width: 120rpx;
		height: 120rpx;
	}
	.update_infor>view{
		border-bottom: dashed 1px #3B4144;
		padding: 10px 0;
	}
</style>

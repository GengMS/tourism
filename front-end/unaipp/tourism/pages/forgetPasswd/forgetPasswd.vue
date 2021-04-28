<template>
	<view>
		<view class="forget_title">
			<text>忘记密码</text>
		</view>
		<view class="forget_container">
			<view class="item">
				<text class="iconfont iconmimaffffffpx"></text>
				<input type="text" v-model="email" placeholder="邮箱" />
			</view>
			<view class="item">
				<input type="text" v-model="code" placeholder="邮箱验证码" />
				<button type="default" @click="getCode()" :disabled="disables">{{second == 60?'获取':second}}</button>
			</view>
			<view class="item">
				<text class="iconfont iconmimaffffffpx"></text>
				<input type="text" v-model="password" placeholder="新密码" />
			</view>
			<button type="warn" class="forget_sumbit" @click="updatePassword()">修改</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				email: "",
				code: "",
				password: "",
				second: 60,
				disables: false
			}
		},
		methods: {
			getCode() {
				console.log(this.email.length)
				if (this.email.length == 0) {
					uni.showToast({
						title: '邮箱不能为空',
						image: '/static/close.png',
						duration: 2000
					});
					return;
				}
				this.disables = true;
				let that = this;
				var interva = setInterval(function() {
					that.second--;
					console.log(that.second + "-")
					if (that.second == 0) {
						that.second = 60;
						that.disables = false;
						clearInterval(interva)
					}
				}, 1000)

				uni.request({
					url: getApp().globalData.login + "getMailCode/" + this.email,
					success(res) {
						if (!res.data) {
							that.second = 60
							that.disables = false;
							clearInterval(interva)
						}
						console.log(res.data)
					}
				})

			},
			updatePassword() {
				if (this.email.length == 0 || this.code.length == 0 || this.password.length != 8) {
					uni.showToast({
						title: '格式错误（密码须为八位）',
						image: '/static/close.png',
						duration: 2000
					});
					return;
				}
				console.log()
				uni.request({
					url:getApp().globalData.login+"updatePasswd/"+this.email+"/"+this.password+"/"+this.code,
					method:"POST",
					success(res) {
						console.log(res)
						if(res.data){
							uni.showToast({
								title:"修改成功"
							})
						}else{
							uni.showToast({
								title:"修改失败"
							})
						}
					}
				})
			},
		}
	}
</script>

<style lang="scss" scoped>
	.forget_title {
		color: $base-color;
		text-align: center;
		padding: 20px 0;
		font-size: 60rpx;
	}

	.forget_container {
		width: 80%;
		margin: 0 auto;
		padding: 20px 0;
	}

	.forget_container>.item {
		display: flex;
		margin-top: 20px;
		font-size: 20px;
	}

	.forget_container>view:nth-child(2) {
		align-items: center;
	}

	.forget_container>view>input {
		margin-left: 10rpx;
		border-bottom: 1px solid black;
		width: 100%;
	}

	.forget_container>.item>button {
		width: 30%;
	}

	.forget_sumbit {
		margin-top: 20px;
	}
</style>

<template>
	<view class="login">
		
		<!--顶部返回按钮-->
		<!-- #ifndef MP-WEIXIN -->
		<text class="back-btn iconfont iconzuo" @tap="navBack"></text>
		<!-- #endif -->
		
		<view class="login-top bg-active">
			<view class="desc">
				<view class="title">Hi~</view>
				<text>{{ appName }}欢迎您</text>
			</view>
			<image class="login-pic" src="/static/login-pic.png"></image>
		</view>
		<view class="login-type-content">
			<image class="login-bg" src="/static/login-bg.png" :style="{height: tabCurrentIndex === 1 ? '150vw' : '94vw'}"></image>
			<view class="main">
				<view class="nav-bar">
					<view
							class="nav-bar-item"
							v-for="(item, index) in typeList"
							:key="index"
							:class="tabCurrentIndex === index ? 'nav-bar-item-active text-active' : ''"
							@tap="tabClick(index)"
					>
						{{ item.text }}
					</view>
				</view>
				<block v-if="tabCurrentIndex === 0">
					<view class="login-type-form">
						<view class="input-item">
							<text class="iconfont iconzhanghuffffffpx"></text>
							<input
									class="login-type-input"
									type="text"
									name="mobile"
									v-model="loginParams.mobile"
									placeholder="请输入邮箱"
									
							/>
						</view>
						<view class="input-item" v-if="loginByPass">
							<text class="iconfont iconmimaffffffpx"></text>
							<input
									class="login-type-input"
									type="password"
									v-model="loginParams.password"
									placeholder="请输入密码"
									maxlength="20"
							/>
						</view>
						<view class="input-item input-item-sms-code" v-if="!loginByPass">
							<text class="iconfont iconyanzhengma"></text>
							<view class="input-wrapper">
								<view class="rf-input-wrapper">
									<input
											type="number"
											class="login-type-input"
											v-model="loginParams.code"
											placeholder="请输入验证码"
											maxlength="4"
									/>
								</view>
								<button
										class="sms-code-btn"
										@tap.stop="getSmsCode('login')"
								>
									<text>获取验证码</text>
								</button>
							</view>
						</view>
					</view>
					<view class="login-type-tips">
						
						<text @tap="navTo('/pages/forgetPasswd/forgetPasswd')">忘记密码？</text>
					</view>
					<button
							class="confirm-btn bg-active"
							:disabled="btnLoading"
							:loading="btnLoading"
							@tap="toLogin"
					>
						登录
					</button>
				</block>
				<block v-if="tabCurrentIndex === 1">
					<view class="login-type-form">
						<view class="input-item">
							<text class="iconfont iconmimaffffffpx"></text>
							<input
									class="login-type-input"
									type="text"
									name="mobile"
									v-model="registerParams.mobile"
									placeholder="请输入邮箱"
									
							/>
						</view>
						<view class="input-item input-item-sms-code">
							<text class="iconfont iconmimaffffffpx"></text>
							<view class="input-wrapper">
								<view class="rf-input-wrapper">
									<input
											type="text"
											class="login-type-input"
											v-model="registerParams.code"
											placeholder="请输入验证码"
											
									/>
								</view>
								<button
										class="sms-code-btn"
										:disabled="disables"
										@click="getCode()"
								>
									
										{{second == 60?'获取':second}}
									
								</button>
							</view>
						</view>
						<view class="input-item">
							<text class="iconfont iconmimaffffffpx"></text>
							<input
									class="login-type-input"
									type="password"
									v-model="registerParams.password"
									placeholder="请输入密码"
									maxlength="20"
							/>
						</view>
					</view>
					<button
							class="confirm-btn bg-active"
							:disabled="btnLoading"
							:loading="btnLoading"
							@tap="toRegister"
					>
						注册
					</button>
				</block>
			</view>
		</view>
    <view class="login-type-bottom text-active">
      {{ appName }} 版权所有
    </view>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				loginParams: {
					mobile: '',
					
					password: ''
				},
				registerParams: {
					mobile: '',
					password: '',
					code: ''
				},
				btnLoading: false,
				reqBody: {},
				codeSeconds: 0, // 验证码发送时间间隔
				loginByPass: true,
				smsCodeBtnDisabled: true,
				userInfo: null,
				appName: '通了旅游',
				tabCurrentIndex: 0,
				typeList: [
					{
						text: '登录'
					},
					{
						text: '注册'
					}
				],
				second: 60,
				disables: false
			};
		},
		onLoad(options) {
			this.tabCurrentIndex = parseInt(options.type || 0, 10);
		},
		methods: {
			getCode() {
				if (this.registerParams.length == 0) {
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
					url: getApp().globalData.login + "getMailCode/" + this.registerParams.mobile,
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
			// 发送验证码并进入倒计时
			async getSmsCode(usage = 'login') {
		    uni.showToast({ title: '点击了获取验证码' });
			},
			// 切换登录方式
			showLoginBySmsCode() {
				this.loginByPass = !this.loginByPass;
			},
			// 返回上一页
			navBack() {
				uni.navigateBack();
			},
			// 统一跳转路由
			navTo(url) {
		    uni.navigateTo({ url });
			},
			// 提交表单
			async toLogin() {
				
				uni.request({
					method:"POST",
					url:`${getApp().globalData.login}login/${this.loginParams.mobile}/${this.loginParams.password}`,
					success:(res) => {
						console.log(res)
						if(res.data != null && res.data.length != 0) {
							uni.showToast({ title: '登录成功' });
							getApp().globalData.user.uId = res.data.uId;
							getApp().globalData.user.identity = res.data.identity;
							if(res.data.infor == 0) {
								getApp().globalData.user.isInfor = res.data.infor;
								getApp().globalData.user.name = res.data.email;
								uni.switchTab({
									url:"../index/index"
								})
							} else{
								
								uni.request({
									method:"POST",
									url:getApp().globalData.login+"getUserInfor/"+res.data.uId,
									success(res1) {
										getApp().globalData.user.isInfor = 1;
										getApp().globalData.user.name = res1.data.name;
										getApp().globalData.user.imgUrl = res1.data.imgUrl;
										getApp().globalData.user.theSay = res1.data.theSay;
										getApp().globalData.user.imgUrl = getApp().globalData.user.imgUrl.replace(/\^/g, "/")
										uni.switchTab({
											url:"../index/index"
										})
									}
								})
							}
						}else{
							uni.showToast({
								title: '登录错误',
								image:'/static/close.png',
								duration: 2000
							});
						}
						 
					}
				})
		   
			},
			// 切换登录/注册
			tabClick(index) {
				this.tabCurrentIndex = index;
			},
			// 注册账号
			async toRegister() {
				if( this.registerParams.mobile.length == 0 || this.registerParams.password.length != 8|| this.registerParams.code.length == 0){
					uni.showToast({
						title: '数据格式错误',
						image: '/static/close.png',
						duration: 2000
					});
				}
				uni.request({
					url:getApp().globalData.login+"register/"+this.registerParams.mobile+"/"+this.registerParams.password+"/"+this.registerParams.code,
					method:"POST",
					success(res) {
						if(res.data) {
							uni.showToast({
								title:"注册成功"
							})
						}else{
							uni.showToast({
								title: '注册错误',
								image: '/static/close.png',
								duration: 2000
							});
						}
					}
				})
			}
		}
	};
</script>
<style lang="scss">
	page {
		background: #fff;
	}
	.login {
		width: 100%;
		position: relative;
    .bg-active {
      background-color: $base-color;
      color: #fff;
    }
    .text-active, .iconfont {
      color: $base-color;
    }
		.back-btn {
			position: absolute;
			left: 40rpx;
			z-index: 9999;
			padding-top: var(--status-bar-height);
			top: 40rpx;
			font-size: 48rpx;
			color: #fff;
		}
		.login-top {
			height: 460rpx;
			position: relative;
			.desc {
        color: #fff;
				position: absolute;
				top: 200rpx;
				left: 40rpx;
				font-size: 48rpx;
				.title {
					font-size: 48rpx;
				}
			}
			.login-pic {
				position: absolute;
				width: 220rpx;
				height: 270rpx;
				right: 30rpx;
				top: 100rpx;
			}
		}
		.login-type-content {
			position: relative;
			top: -72rpx;
			.login-bg {
				width: 94vw;
				height: 94vw;
				margin: 0 3vw;
			}
			.main {
				width: 94vw;
				position: absolute;
				top: 0;
				left: 3vw;
				.nav-bar {
					display: flex;
					height: 100rpx;
					justify-content: center;
					align-items: center;
					position: relative;
					z-index: 10;
					.nav-bar-item {
						flex: 1;
						display: flex;
						height: 100%;
						line-height: 96rpx;
						font-size: 32rpx;
						display: flex;
						margin: 0 120rpx;
						justify-content: center;
					}
					.nav-bar-item-active {
						border-bottom: 5rpx solid;
					}
				}
				.login-type-form {
					width: 80%;
					margin: 50rpx auto;
					.input-item {
						position: relative;
						height: 90rpx;
						line-height: 90rpx;
						margin-bottom: 30rpx;
						.iconfont {
							font-size: 50rpx;
							position: absolute;
							left: 0;
						}
						.login-type-input {
							height: 90rpx;
							padding-left: 80rpx;
							border-bottom: 1rpx solid rgba(0, 0, 0, .1);
						}
						.sms-code-btn, sms-code-resend {
							width: 240rpx;
							font-size: 26rpx;
						}
					}
				}
				.login-type-tips {
					padding: 0 50rpx;
					display: flex;
					justify-content: space-between;
          font-size: 28upx;
          color: #666;
				}
				.confirm-btn {
          margin-top: 60upx;
          width: 80%;
					height: 80rpx;
					line-height: 80rpx;
				}
			}
		}
		.login-type-bottom {
			width: 100%;
			padding-bottom: 30rpx;
			text-align: center;
			font-size: 32rpx;
		}
    // 发送验证码样式
    .input-item-sms-code {
      .input-wrapper {
        display: flex;
        justify-content: space-between;
        align-items: center;
      }

      .sms-code-btn {
        width: 200upx;
        background-color: #fff;
        display: flex;
        padding: 15upx 0;
        justify-content: center;
        align-items: center;
        border-radius: 12upx;
      }

      .sms-code-resend {
        color: #666;
      }
    }
	}
</style>

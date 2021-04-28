<template>
	<view class="sendPhoneNum">
		<view class="f1">
			<view class="" >
				输入您的手机号:
			</view>
			<view class="" @click="sendNumHidden()">
				x
			</view>
		</view>
		<input type="text" v-model="phoneNum" />
		<button type="default" @click="sendNum()">发送</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				phoneNum:""
			}
		},
		methods: {
			sendNumHidden(){
				this.$parent.sendNumShow = false;
			},
			sendNum(){
				var phoneNumTest = new RegExp(/^((\+|00)86)?((134\d{4})|((13[0-3|5-9]|14[1|5-9]|15[0-9]|16[2|5|6|7]|17[0-8]|18[0-9]|19[0-2|5-9])\d{8}))$/);
				let that = this;
				if(phoneNumTest.test(this.phoneNum)){
					uni.request({
						url:getApp().globalData.team+"savePhoneNum/"+this.phoneNum,
						success(res) {
							if(res.data){
								uni.showToast({ title: '提交成功' });
								that.sendNumHidden();
							}
						}
					})
				}else{
					uni.showModal({
						title:"手机号错误"
					})
				}
			}
		}
	}
</script>

<style scoped>
	.f1{
		display: flex;
		justify-content: space-between;
	}
.sendPhoneNum{
	position: fixed;
	top: 30%;
	left: 50%;
	transform: translate(-50%);
	border-radius: 4px;
	 box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
	 padding: 10px;
	 background: white;
}
</style>

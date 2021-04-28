<script>
	export default {
		globalData:{
			width:0,
			height:0,
			login:"http://192.168.16.240:81/",
			lv_tu:"http://192.168.16.240:82/",
			lv_tai:"http://192.168.16.240:83/",
			team:"http://192.168.16.240:84/",
			user:{
				uId:null,
				name:null,
				imgUrl:null,
				theSay:null,	
				identity: null,
				isInfor:null
			}
		},
		onLaunch: function() {
			
			let that = this;
			uni.getSystemInfo({
				success: function(res) {
					// #ifdef MP
					that.$scope.globalData.height = res.windowHeight
					that.$scope.globalData.width = res.windowWidth
					// #endif
					
					// #ifndef MP
					getApp().globalData.height = res.windowHeight
					getApp().globalData.width = res.windowWidth
					// #endif
				}
			})
		},
		onShow: function() {
			
			
		},
		onHide: function() {
			console.log('App Hide')
		}
	}
</script>

<style>
	/*每个页面公共css */
	
	
	@import url('./common/iconfront.css');
	
</style>

<template>
	<view>
		<view class="title">
			<view class="">
				{{title}}
			</view>

		</view>
		<view class="re_jing" :style="{maxWidth:width}">
			
			<view class="" v-for="(item,index) in reList" @click="goRe(item)" :style="{background:backImgList[index]}">
				{{item}}
			</view>
			<view class="" @click="goNewst()" :style="{background:zuiBackImg}" >
				最新动态
			</view>
		</view>
		<view class="dong_con">
			<dong v-for="(item,index) in dataList" :key="index" :index="index" :dongData="item"></dong>
		</view>
		<view class="lv_tai_pos" @click="sendDongShow = !sendDongShow">
			<image src="../../static/tabbar/icon_published.png" mode=""></image>
		</view>
		<sendDong v-if="sendDongShow" ></sendDong>
	</view>
</template>

<script>
	import dong from "../compent/dongTai"
	import sendDong from "../compent/sendDong"
	export default {
		components: {
			dong,
			sendDong
		},
		data() {
			return {
				width: 0,
				title: "最新动态",
				zuiBackImg: "url(" + require("../../static/lv_dong/CoUBYGBii_CAZY8sACBYq-4zEog798.png") + ")",
				backImgList: [
					"url(http://192.168.112.145:8888/group1/M00/00/02/wKhwkWB8zLWALgC1AAC7rgrAj0E29.jpeg)",
					"url(http://192.168.112.145:8888/group1/M00/00/02/wKhwkWB8z_WAdW9MAADZPC_YEuI07.jpeg)",
					"url(http://192.168.112.145:8888/group1/M00/00/02/wKhwkWB8z_qAIWwGAADni5x-vvY16.jpeg)",
				],
				sendDongShow:false,
				pageIndex:1,
				maxPageIndex:0,
				dataList:[],
				linList:[],
				reList:[]
			}
		},
		methods: {
			
			goNewst(){
				this.title = "最新动态";
				this.pageIndex = 1;
				this.getPageIndex();
				this.getData();
			},
			getReMaxPage(){
				let that = this;
				uni.request({
					url:getApp().globalData.lv_tai+"countDong/"+this.title,
					method:"POST",
					success(res) {
						
						console.log("----------------")
						console.log(res.data)
						that.maxPageIndex = parseInt(res.data/10+1); 
						console.log(that.maxPageIndex)
						console.log("----------------")
					}
				})
			},
			goRe(item){
				
				console.log("++++++++++++")
				this.pageIndex = 1;
				this.title = item;
				let that = this;
				uni.request({
					url:getApp().globalData.lv_tai+"listDongBySight/"+getApp().globalData.user.uId+"/"+item+"/"+this.pageIndex,
					success(res) {
						that.getReMaxPage();
						that.dataList = res.data;
						for (var i = 0; i < that.dataList.length; i++) {
							that.dataList[i].imgUrl = that.dataList[i].imgUrl.replace(/\^/g,"/")
							for (let i1 = 0; i1 < that.dataList[i].length; i++) {
								if(that.dataList[i][i1].type == "图片") {
									that.dataList[i][i1].content = that.dataList[i][i1].content.replace(/\^/g,"/");
								}
								
							}
						}
						console.log(that.dataList)
					}
				})
			},
			getData(){
				let that = this;
				uni.request({
					url:getApp().globalData.lv_tai+"dong/listDong/"+getApp().globalData.user.uId+"/"+this.pageIndex,
					success(res) {
						that.dataList = res.data;
						for (var i = 0; i < that.dataList.length; i++) {
							that.dataList[i].imgUrl = that.dataList[i].imgUrl.replace(/\^/g,"/")
							for (let i1 = 0; i1 < that.dataList[i].length; i++) {
								if(that.dataList[i][i1].type == "图片") {
									that.dataList[i][i1].content = that.dataList[i][i1].content.replace(/\^/g,"/");
								}
							}
						}
						console.log(that.dataList)
					}
				})
			},
			getPageIndex(){
				let that = this;
				uni.request({
					url:getApp().globalData.lv_tai+"countDong",
					method:"POST",
					success(res) {
						that.maxPageIndex =parseInt(res.data/10+1); 
						console.log(that.maxPageIndex)
					}
				})
			},
			getRe(){
				let that = this;
				uni.request({
					url:getApp().globalData.lv_tai+"sights",
					method:"POST",
					success(res) {
						that.reList = res.data
					}
				})
			}
		},
		onHide() {
			this.pageIndex = 1;
		},
		onReachBottom(){
			
			this.linList = [];
			if(this.title == "最新动态"){
				if(this.pageIndex >= this.maxPageIndex){
					
				}else{
					this.pageIndex++;
					let that = this;
					uni.request({
						url:getApp().globalData.lv_tai+"dong/listDong/"+getApp().globalData.user.uId+"/"+this.pageIndex,
						success(res) {
							console.log("----------")
							console.log(res.data)
							console.log("-----------------")
							that.linList = res.data;
							for (var i = 0; i < that.linList.length; i++) {
								that.linList[i].imgUrl = that.linList[i].imgUrl.replace(/\^/g,"/")
								for (let i1 = 0; i1 < that.linList[i].length; i++) {
									if(that.linList[i][i1].type == "图片") {
										that.linList[i][i1].content = that.linList[i][i1].content.replace(/\^/g,"/");
									}
									
								}
								
							}
							for (var i2 = 0; i2 < that.linList.length; i2++) {
								that.dataList.push(that.linList[i2]);
							}
							console.log(that.dataList)
						}
					})
				}
			} else{
				if(this.pageIndex >= this.maxPageIndex){
					
				}else{
					this.pageIndex++;
					let that = this;
					uni.request({
						url:getApp().globalData.lv_tai+"listDongBySight/"+getApp().globalData.user.uId+"/"+this.title+"/"+this.pageIndex,
						success(res) {
							that.linList = res.data;
							for (var i = 0; i < that.linList.length; i++) {
								that.linList[i].imgUrl = that.linList[i].imgUrl.replace(/\^/g,"/")
								for (let i1 = 0; i1 < that.linList[i].length; i++) {
									if(that.linList[i][i1].type == "图片") {
										that.linList[i][i1].content = that.linList[i][i1].content.replace(/\^/g,"/");
									}
									
								}
								
							}
							for (var i2 = 0; i2 < that.linList.length; i2++) {
								that.dataList.push(that.linList[i2]);
							}
							console.log(that.dataList)
						}
					})
				}
			}
			
			
		},
		onShow() {
				if(getApp().globalData.user.uId == null) {
					// #ifdef H5
					uni.navigateTo({
						url:"../login/login"
					})
					// #endif
			
					// #ifndef H5
					uni.redirectTo({
						url:"../login/login"
					})
					// #endif
					return;
				}
			this.width = getApp().globalData.width + 'px';
			this.getData();
			this.getPageIndex();
			this.getRe();
		},
		onPullDownRefresh() {
			this.pageIndex = 1;
			if(this.title == "最新动态") {
				this.getPageIndex();
				this.getData();
				uni.stopPullDownRefresh();
				console.log(this.dataList)
			}else{
				let that = this;
				uni.request({
					url:getApp().globalData.lv_tai+"listDongBySight/"+getApp().globalData.user.uId+"/"+this.title+"/"+this.pageIndex,
					success(res) {
						that.getReMaxPage();
						that.dataList = res.data;
						for (var i = 0; i < that.dataList.length; i++) {
							that.dataList[i].imgUrl = that.dataList[i].imgUrl.replace(/\^/g,"/")
							for (let i1 = 0; i1 < that.dataList[i].length; i++) {
								if(that.dataList[i][i1].type == "图片") {
									that.dataList[i][i1].content = that.dataList[i][i1].content.replace(/\^/g,"/");
								}
								
							}
						}
						console.log(that.dataList)
					}
				})
				uni.stopPullDownRefresh();
			}
			
			 
		}
		// onShow(){
		// 	if(getApp().globalData.user.uId == null) {
		// 		// #ifdef H5
		// 		uni.navigateTo({
		// 			url:"../login/login"
		// 		})
		// 		// #endif

		// 		// #ifndef H5
		// 		uni.redirectTo({
		// 			url:"../login/login"
		// 		})
		// 		// #endif

		// 	}
		// },
	}
</script>

<style scoped>
	.title {
		display: flex;
		justify-content: space-between;
		font-size: 30px;
		padding: 6px 5px;
		border-bottom: 1px solid black;

	}

	.scroll-view_H {
		display: flex !important;
	}

	.re_jing {
		overflow: scroll;
		max-height: 80px;
		display: flex;
	}

	.re_jing>view {
		width: 140px;
		height: 80px;
		background-position: center,0;
		min-width: 140px;
		background-size:100% 100%; 
		text-align: center;
		line-height: 80px;
		font-size: 26px;
		font-weight: bold;
		color: white;
	}
	.dong_con{
		padding: 0 15px;
	}
	.lv_tai_pos>image{
		position: fixed;
		width: 40px;
		height: 40px;
		right: 10px;
		bottom: 20px;
	}
</style>

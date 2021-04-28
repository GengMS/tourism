<template>
	<view class="container">

		<swiper :style="{height:height}" indicator-dots="true" autoplay="true" interval="3000" duration="1000">
			<swiper-item v-for="(item,index) in dataList" :key="index">
				<view class="swiper-item">
					<view class="wen" :style="{'background-image': 'url('+item.imgUrl+')'}">
						<text class="title-area" @click="tiao(index)">{{item.title}}</text>
					</view>
				</view>
			</swiper-item>
		</swiper>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				href: 'https://b1-q.mafengwo.net/s18/M00/8B/73/CoUBYGByc2-AURzRACqlgVz36fw746.png?imageMogr2%2Fthumbnail%2F%21750x422r%2Fgravity%2FCenter%2Fcrop%2F%21750x422%2Fquality%2F90',
				height: 0,
				title: "欢迎您",
				dataList: [],
				inforData:[]
			}
		},
		methods: {
			getData() {
				let that = this;
				uni.request({
					url: getApp().globalData.team + "listHomePageShow",
					success(res) {
						if (res.data.length <= 0) {
							that.dataList.push({
								title:"欢迎",
								imgUrl:"https://b1-q.mafengwo.net/s18/M00/8B/73/CoUBYGByc2-AURzRACqlgVz36fw746.png?imageMogr2%2Fthumbnail%2F%21750x422r%2Fgravity%2FCenter%2Fcrop%2F%21750x422%2Fquality%2F90"
							})
						} else {
							that.dataList = res.data;
							that.getInforData();
						}
					}
				})
			},
			getInforData(){
				for (let i = 0; i < this.dataList.length; i++) {
					let that = this;
					uni.request({
						url:getApp().globalData.team+"getTeamInfor/"+this.dataList[i].tId,
						success(res) {
							that.inforData.push(res.data)
						}
					})
					
				}
				console.log(this.inforData)
			},
			tiao(index){
				if(this.inforData.length <= 0) {
					return;
				}else{
					uni.setStorage({
						key:"teamInfor",
						data: this.inforData[index],
						success() {
							uni.navigateTo({
								url:"../teamInfor/teamInfor"
							})
						}
					})
				}
			}
		},
		
		onLoad() {
			this.height = getApp().globalData.height + 'px'
			this.getData();
		}
	}
</script>

<style scoped>
	.swiper-item {
		height: 100%;
	}

	.container {
		padding: 14px;
		font-size: 14px;
		line-height: 24px;
	}

	.container .wen {
		height: 100%;
		padding: 20rpx;
		background-image: url('https://th.bing.com/th/id/R18b3ff40a55fd2e5eb4d6a93246d0241?rik=ysUDYhNTYJ6qfQ&riu=http%3a%2f%2f222.186.12.239%3a10010%2fcyfj_170327%2f004.jpg&ehk=AYF5OpTrtQZHa9FfKnsa0TQ5X1QcNga2N8T2tCWu0lQ%3d&risl=&pid=ImgRaw');
		background-position: center;
		background-size: cover;
	}

	.title-area {
		color: white;
		font-size: 60rpx;
	}

	.scorll_geng {
		display: flex;
	}
</style>

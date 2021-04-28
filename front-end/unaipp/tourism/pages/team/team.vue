<template>
	<view>
		<view class="top_pop" v-show="shaiShow">
			<view class="">
				筛选
				<text @click="cancal()">x</text>
			</view>
			<pick-regions :defaultRegion="defaultRegionCode" @getRegion="handleGetRegion">
				出发地：
				<text>{{regionName}}</text>
			</pick-regions>
			<pick-regions :defaultRegion="defaultRegionCode" @getRegion="handleGetRegion1">
				目的地：<text>{{regionName1}}</text>
			</pick-regions>
			<view class="">
				<checkbox-group @change="checkboxChange">
					<label>
						<checkbox value="1024-2000" color="#FFCC33" style="transform:scale(0.7)" />1024-2000
					</label>
					<label>
						<checkbox value="2000-3000" color="#FFCC33" style="transform:scale(0.7)" />2000-3000
					</label>
					<label>
						<checkbox value="3000-13880" color="#FFCC33" style="transform:scale(0.7)" />3000-13880
					</label>
				</checkbox-group>
			</view>
			<button type="default" @click="shai()">筛选</button>
		</view>
		<view class="shai">
			<view class="" @click="toggleOrder">
				价格
				<text v-show="directionShow == 0">&#8595</text>
				<text v-show="directionShow == 1">&#8593</text>
				<text v-show="directionShow == 2">|</text>
			</view>
			<view class="" @click="letshaiShow()">
				筛选
			</view>
		</view>
		<TeamInfor v-for="(item, index) in dataList" :key="index" :item="item"></TeamInfor>
	</view>
</template>

<script>
	import pickRegions from '@/components/pick-regions/pick-regions.vue'
	import TeamInfor from "@/pages/compent/TeamInfor.vue"
	export default {
		components: {
			pickRegions,
			TeamInfor
		},
		data() {
			return {
				dataList: [],
				region: [],
				defaultRegion: ['广东省', '广州市', '番禺区'],
				defaultRegionCode: '440113',
				region1: [],
				selectOption: {
					departure: null,
					destination: null,
					order: null,
					priceList: [],
				},
				directionShow: 2,
				maxPageSize:0,
				pageSize:1,
				shaiShow:false,
				pushData:""
			}
		},
		computed: {

			regionName() {
				if(this.region.length <= 0){
					
				}else{
					// 转为字符串
					this.selectOption.departure = this.region.map(item => item.name).join('-');
					return this.selectOption.departure;
				}
				
			},

			regionName1() {
				if(this.region1.length <= 0){
					
				}else{
					// 转为字符串
					this.selectOption.destination = this.region1.map(item => item.name).join('-');
					return this.selectOption.destination;
				}
				
			}
		},
		methods: {
			cancal(){
				this.shaiShow = false;
			},
			letshaiShow(){
				this.shaiShow = true;
			},
			checkboxChange: function(e) {
				this.selectOption.priceList = []
				for(let i = 0; i< e.detail.value.length;i++){
					let arr = e.detail.value[i].split("-");
					for(let j = 0;j<arr.length;j++){
						this.selectOption.priceList.push(arr[j])
					}
				}
				
			},
			shai() {
				this.pageSize = 1;
				this.getData();
				this.cancal();
			},
			toggleOrder() {
				this.pageSize = 1;
				if (this.directionShow == 2) {
					this.directionShow = 1;
					this.selectOption.order = false;
					this.getData();
				} else if (this.directionShow == 1) {
					this.directionShow = 0;
					this.selectOption.order = true;
					this.getData();
				} else {
					this.directionShow = 2;
					this.selectOption.order = null;
					this.getData();
				}
			},
			// 获取选择的地区
			handleGetRegion(region) {
				this.region = region
			},
			// 获取选择的地区
			handleGetRegion1(region) {
				this.region1 = region
			},
			getMaxPageSize(){
				let that = this;
				uni.request({
					url:getApp().globalData.team+"countTeamInforByOptions",
					data: {
						departure: this.selectOption.departure,
						destination: this.selectOption.destination,
						order: this.selectOption.order,
						priceList: this.selectOption.priceList
					},
					method:"POST",
					success(res) {
						that.maxPageSize = parseInt(res.data/10+1);
						
						
					}
				})
			},
			getData() {
				let that = this;
				uni.request({
					url: getApp().globalData.team + "listTeamInforByOption/"+this.pageSize,
					data: {
						departure: this.selectOption.departure,
						destination: this.selectOption.destination,
						order: this.selectOption.order,
						priceList: this.selectOption.priceList
					},
					method: "POST",
					success(res) {
						that.dataList = res.data;
						console.log(that.dataList)
					}
				})
			},
			async getpushData(){
				let that = this;
				uni.request({
					url: getApp().globalData.team + "listTeamInforByOption/"+this.pageSize,
					data: {
						departure: this.selectOption.departure,
						destination: this.selectOption.destination,
						order: this.selectOption.order,
						priceList: this.selectOption.priceList
					},
					method: "POST",
					success(res) {
						that.pushData = res.data
						console.log(that.pushData)
					}
				})
			}
		},
		onShow() {
			this.getData();
			this.getMaxPageSize();
		},
		onPullDownRefresh() {
			this.pageSize = 1;
			this.getData();
			this.getMaxPageSize();
			uni.stopPullDownRefresh();
		},
		onReachBottom(){
			if(this.pageSize >= this.maxPageSize){
					return;
			}else{
				this.pageSize++;
				this.getpushData();
				let that = this;
				let a = setInterval(function(){ 
					if(that.pushData.length > 0){
						for (let i = 0; i < that.pushData.length; i++) {
							that.dataList.push(
								that.pushData[i]
							);
						}
						clearInterval(a)
					}else{
						console.log("aaaa")
					}
				},200)
				
			}
		}
	}
</script>

<style>
	.shai {
		padding: 4px 10px;
		background: #666666;
		color: white;
		font-size: 16px;
		display: flex;
		justify-content: space-between;
	}

	.shai>view {
		margin: 0 10px;
	}

	.top_pop {
		position: fixed;
		top: 40%;
		left: 50%;
		padding: 10px;
		background: white;
		width: 80%;
		transform: translate(-50%);
		z-index: 999;
		border-radius: 4px;
		box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
	}
	.top_pop>view:nth-child(1){
		display: flex;
		justify-content: space-between;
	}
	.top_pop>view:nth-child(1)>text{
		cursor: pointer;
	}
</style>

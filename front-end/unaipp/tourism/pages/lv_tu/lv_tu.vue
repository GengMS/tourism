<template>
	<view>
		
		<button type="default" @click="uploadImg()">上传我的照片</button>
		<view v-for="(item,index) in imgList">
			<text>{{index}}</text>
			<view class="imgList_geng">
				<view class="" v-for="(item1,index1) in item"  @click="preview(index, index1)">
					<view class="delete" @click.stop="delImg(index,index1)">
						X
					</view>
					<image  :src="item1.img_url" mode=""></image>
				</view>
				
			</view>
			
		</view>
		
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				imgList:[],
				imgListKeys:[],
				urls:[],
				delShow:-1
			}
		},
		methods: {
			delImg(index,index1){
				this.delShow = index1
				let that = this;
				uni.request({
					url:getApp().globalData.lv_tu+"delImg/"+this.imgList[index][index1].i_id,
					method:"POST",
					success(res) {
						if(res.data){
							that.getImgList();
							that.updateImgUrl();
						}else{
							uni.showToast({
								title: '删除错误',
								image: '/static/close.png',
								duration: 2000
							});
						}
					},
					fail() {
						uni.showToast({
							title: '删除错误',
							image: '/static/close.png',
							duration: 2000
						});
					}
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
								if(uploadFileRes.data != "error"){
									uni.request({
										url:getApp().globalData.lv_tu+"saveImg/"+uploadFileRes.data.replace(/\//g,"^")+"/"+getApp().globalData.user.uId,
										method:"POST",
										success(res) {
											
											if(res.data) {
												// that.imgList = null;
												that.getImgList();
												that.updateImgUrl();
											}
										}
									})
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
								console.log(res)
							}
						});
					}
				});
			},
			updateImgUrl(){
				for (let i = 0; i < this.imgListKeys.length; i++) {
					let key = this.imgListKeys[i]
					for (let i1 = 0; i1 < this.imgList[key].length; i1++) {
						this.imgList[key][i1].img_url = this.imgList[key][i1].img_url.replace(/\^/g,"/")
						console.log(this.imgList[key][i1])
					}
				}
			},
			getImgList(){
				let that = this;
				uni.request({
					url:getApp().globalData.lv_tu+"listImgByDate/"+getApp().globalData.user.uId,
					method:"POST",
					success(res) {
						console.log(res.data)
						that.imgList = res.data;
						that.imgListKeys = Object.keys(res.data);
						that.updateImgUrl()
						
					}
				})
			},
			preview(index,index1){
				this.urls = [];
				this.urls.push(this.imgList[index][index1].img_url);
				console.log(this.urls)
				let that = this;
				uni.previewImage({
					urls: that.urls
				})
			}
		},
		onShow() {
			this.getImgList();
			this.updateImgUrl();
		}
	}
</script>

<style>
.imgList_geng{
	display: flex;
	flex-wrap: wrap;
}
.imgList_geng>view{
	max-width: 33%;
	width: 33%;
	height: 100px;
	position: relative;
}
.imgList_geng>view>image{
	width: 100%;
	height: 100%;
}

.imgList_geng .delete{
	position: absolute;
	right: 2px;
	top: 2px;
	color: white;
	z-index: 999;
}
</style>

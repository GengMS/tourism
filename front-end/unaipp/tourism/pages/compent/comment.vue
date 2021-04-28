<template>
	<view class="comment_content">
		<view class="">
			<image :src="commentData.imgUrl" mode=""></image>
			{{commentData.name}}
		</view>
		<view class="">
			{{commentData.content}}
		</view>
	</view>
</template>

<script>
	export default {
		props:["commentData"],
		data() {
			return {
				
			}
		},
		methods: {
			
		}
	}
</script>

<style scoped>
	.comment_content{
		margin: 20px 0;
		background: rgba(0, 0, 0, 0.04);
		box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
		padding: 10px;
	}
.comment_content>view:nth-child(1){
	display: flex;
	align-items: center;
}
.comment_content>view:nth-child(1)>image{
	border-radius: 4px;
	height: 40px;
	width: 40px;
}
</style>

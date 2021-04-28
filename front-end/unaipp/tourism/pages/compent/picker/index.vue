<template>
	<view style="height: 100px;">
		<pick-regions :defaultRegion="defaultRegionCode" @getRegion="handleGetRegion">
            <h2>点击选择省市区</h2>
        </pick-regions>
        <h3>{{regionName}}</h3>
	</view>
</template>

<script>
    import pickRegions from '@/components/pick-regions/pick-regions.vue'
	export default {
        components:{ pickRegions },
        data(){
            return {
                region:[],
                defaultRegion:['广东省','广州市','番禺区'],
                defaultRegionCode:'440113'
            }
        },
        computed:{
            regionName(){
                // 转为字符串
                return this.region.map(item=>item.name).join('-')
            }
        },
        methods:{
            // 获取选择的地区
            handleGetRegion(region){
                this.region = region
				console.log(this.regionName)
            }
        }
	}
</script>

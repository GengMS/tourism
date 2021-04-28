<template>
  <div class="TeamInfor">
    <div class="f1">
      <div>
        <img :src="item.fileList[0]" alt="" />
        <div></div>
      </div>

      <div>
        <div class="title">{{ item.introduce }}</div>
        <div>出发地：{{ item.departure }}</div>
        <div>目的地：{{ item.destination }}</div>
        <div>
          <h3>￥{{ item.price }}</h3>
          <button class="button" type="success" @click="tiao">点击预定</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ["item"],
  methods: {
    tiao() {
		uni.setStorage({
			key:"teamInfor",
			data: this.item,
			success() {
				uni.navigateTo({
					url:"../teamInfor/teamInfor"
				})
			}
		})
		
    },
  },
};
</script>

<style scoped>
.TeamInfor:hover .title {
  text-decoration: underline;
}
.TeamInfor {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  padding: 10px;
  border-radius: 4px;
  width: 100%;
  max-width: 100%;
  box-sizing: border-box;
}
.TeamInfor > .f1 {
  display: flex;
}
.TeamInfor > .f1 > div:nth-child(1) {
  margin-right: 10px;
  position: relative;
}
.TeamInfor > .f1 img {
  width: 120px;
  height: 120px;
}
.TeamInfor .title {
  overflow: hidden;
  height: 40px;
  line-height: 40px;
  font-size: 26px;
  word-break:break-all;      
  
  word-wrap:break-word;   
  font-weight: bold;
}
.TeamInfor > .f1 > div:nth-child(2) > div:last-child {
  display: flex;
  margin-top: 10px;
}
.TeamInfor > .f1 > div:nth-child(2) > div:last-child > .button {
  margin-left: 40px;
}
</style>
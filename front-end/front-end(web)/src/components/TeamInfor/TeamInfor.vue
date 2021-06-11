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
          <el-button class="button" type="success" @click="tiao"
            >点击预定</el-button
          >
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
      this.$router.push({
        path: "/TeamInforPage",
        query: {
          item: JSON.stringify(this.item),
        },
      });
    },
  },
};
</script>

<style scoped>
.TeamInfor:hover .title {
  text-decoration: underline;
}
.TeamInfor .title {
  
  overflow: hidden;

}
.TeamInfor {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  padding: 10px;
  border-radius: 4px;
  max-width: 100%;
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
  height: 40px;
  line-height: 40px;
  font-size: 30px;
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
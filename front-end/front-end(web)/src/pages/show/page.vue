<template>
  <div class="show" :style="{ height: height }">
    <div class="show_container show_top">
      <div class="show_top_f2">
        <img :src="userData.imgUrl" alt="" />
        <div>
          <h3>{{ userData.name }}</h3>
          <p>{{ userData.theSay }}</p>
        </div>
      </div>
    </div>
    <div class="show_container show_f2">
      <vueWaterfallEasy :imgsArr="imgsArr"> </vueWaterfallEasy>
    </div>
  </div>
</template>

<script>
import vueWaterfallEasy from "vue-waterfall-easy";
export default {
  data() {
    return {
      height: "",
      imgsArr: [
        
      ],
      userData: "",
    };
  },
  methods: {
    getData() {
      this.imgsArr = this.imgsArr;
    },
  },
  mounted() {
    this.getData();
    let a = document.documentElement.clientHeight - 140;
    this.height = a + "px";
    let id = this.$route.params.id;
    this.axios
      .post(this.$root.loginUrl + "getUserInfor/" + id)
      .then((res) => {
        this.userData = res.data;
        this.userData.imgUrl = this.userData.imgUrl.replaceAll("^", "/");

        let that = this;
        this.axios
          .post(this.$root.lv_tu + "listImg/" + that.$cookies.get("uId"))
          .then((res) => {
            let data = res.data;
            data.forEach((element) => {
              console.log(element);
              let result = element.img_url.replaceAll("^", "/");
              that.imgsArr.push({
                src: result,
                herf: result,
              });
            });
          })
          .catch((err) => {
            console.error(err);
          });
      })
      .catch((err) => {
        console.error(err);
      });
  },
  components: {
    vueWaterfallEasy,
  },
};
</script>

<style>
.show_container {
  width: 80%;
  margin: 0 auto;
}
@media screen and (max-width: 480px) {
  .show_container {
    width: 100%;
  }
}
.show {
  width: 100%;
  box-sizing: border-box;
}
.show_top {
  height: 140px;
  background: rgba(255, 255, 255, 0.171);
  padding: 20px;
  border-radius: 4px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}
.show_f2 {
  height: 100%;
}
.vue-waterfall-easy-container img {
  transition: all 0.8s;
}
.vue-waterfall-easy-container img:hover {
  transform: scale(1.2);
}
.vue-waterfall-easy-container .img-box {
  overflow: hidden;
}
.show_top_f2 {
  display: flex;
  justify-content: space-between;
}
.show_top_f2>img{
  height: 100px;
  width: 100px;
}
</style>
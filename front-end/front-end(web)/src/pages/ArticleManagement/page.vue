<template>
  <div class="AricleManagement">
    <h2>文章管理</h2>
    <label class="aricle_search">
      <el-input
        placeholder="请输入文章id"
        v-model="dongId"
        type="number"
      ></el-input>
      <el-button @click="search">
        <i class="el-icon-search"></i>
      </el-button>
    </label>
    <hr />
    <div class="infor" v-show="dongInforShow">
      <i @dblclick="delDong" class="el-icon-close"></i>
      <div class="dong_imgUrl">
        <img :src="item.imgUrl" alt="" />
        <h3>{{ item.userName }}</h3>
      </div>
      <div class="dong_title">
        {{ giveTitle(index) }}
      </div>
      <div class="dongtai_img_div">
        <img
          v-for="(item1, index1) in item.content"
          :key="index1"
          :src="item1.content"
          v-if="!(item1.type == '标题')"
          alt=""
        />
      </div>
      <div v-if="item.sight.length > 0" class="dong_tai_sight">
        <i class="el-icon-location">{{ item.sight }}</i>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dongId: "",
      item: {
        dId: "",
        uId: "",
        type: "",
        dotCount: "",
        commentsCount: "",
        sight: "",
        userName: "",
        imgUrl: "",
        goDot: "",
        content: [],
      },
      dongInforShow: false,
    };
  },
  methods: {
    giveTitle(index) {
      for (let i = 0; i < this.item.content.length; i++) {
        if (this.item.content[i].type == "标题") {
          var title = this.item.content[i].content;
          return title;
        }
      }
    },
    delDong() {
      this.axios
        .post(this.$root.dong_tai + "dong/del/" + this.item.dId)
        .then((res) => {
          if (res.data) {
              this.dongInforShow = false;
            this.$message({
              message: "删除成功",
              type: "success",
            });
          }
        })
        .catch((err) => {
          console.error(err);
        });
    },
    search() {
      if (this.dongId <= 0) {
        this.$message.error("id错误，检查后重试");
        return;
      }
      this.axios
        .post(this.$root.dong_tai + "getDong/" + this.dongId)
        .then((res) => {
          this.item = res.data;
          this.item.imgUrl = this.item.imgUrl.replaceAll("^", "/");
          this.dongInforShow = true;
          console.log(this.item);
        })
        .catch((err) => {
          console.error(err);
        });
    },
  },
};
</script>

<style scoped>
.infor {
  width: 100%;
  background: white;
  padding: 10px;
  border-radius: 4px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  position: relative;
}
.infor > i:nth-child(1) {
  position: absolute;
  right: 10px;
  top: 10px;
  cursor: pointer;
}
.AricleManagement {
  padding: 20px;
}
.aricle_search {
  display: flex;
  align-items: center;
}
.dong_id {
  font-size: 10px;
  color: grey;
}
.dong_tran {
  overflow: scroll;
  overflow-y: hidden;
  overflow-x: auto;
}
.dong_tran::-webkit-scrollbar {
  width: 4px;
}
.dong_tran::-webkit-scrollbar-thumb {
  border-radius: 10px;
  -webkit-box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  background: rgba(0, 0, 0, 0.2);
}
.dong_tran::-webkit-scrollbar-track {
  -webkit-box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  border-radius: 0;
  background: rgba(0, 0, 0, 0.1);
}
.dong_pageion {
  display: flex;
  margin-top: 30px;
  border-top: 2px solid white;
}
.dong_pageion > div {
  min-width: 30px;
  min-height: 30px;
  width: 30px;
  height: 30px;
  text-align: center;
  line-height: 30px;
  margin: 10px;
  background: white;
  border-radius: 4px;
  cursor: pointer;
}
.dong_pageion > .active {
  background: violet;
}
.dong_tai_sight {
  color: rgb(39, 38, 38);
  font-size: 14px;
  margin: 4px 0;
}
.dong_tai_i > i {
  cursor: pointer;
}
body {
  overflow-y: unset;
}
.dong_title {
  font-size: 26px;
}
.dongtai {
  background: url("../../assets/CoUBYGBhNV-AN-SPADHuD9JYNGM647.png");
  background-position: center;
  overflow: scroll;
  overflow-x: unset;
}
.dong_imgUrl {
  display: flex;
  align-items: center;
}
.dong_imgUrl img {
  height: 30px;
  width: 30px;
  border-radius: 4px;
}
.f2 {
  margin-top: 20px;
  margin-bottom: 20px;
  display: flex;
  background: rgba(255, 255, 255, 0.363);
  padding: 10px;
  border-radius: 8px;
}
.dongtai_left {
  width: 80%;
  padding-right: 10px;
}
.dongtai_right {
  width: 20%;
}
.dongtai_img_div {
}
.dongtai_img_div > img {
  max-height: 120px;
  height: 120px;
  height: 100%;
  margin-right: 10px;
}
.wenzhang {
  display: flex;
  position: relative;
}
.wenzhang > div:nth-child(1) {
  width: 80%;
}
.wenzhang > div:nth-child(2) {
  width: 20%;
}
.wenzhang > div:nth-child(2) > img {
  max-height: 100%;
  max-width: 100%;
}
.wenzhang_title {
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
}
.wenzhang_user {
  position: absolute;
  bottom: 0px;
  left: 0px;
}
.geng_card {
  width: 100%;
  height: 80px;
  border-radius: 8px;
  background: red;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  text-align: center;
  line-height: 80px;
  color: white;
  font-weight: bold;
  cursor: pointer;
  margin-top: 10px;
}
.dongtaijia {
  font-size: 30px;

  background: white;
  border-radius: 4px;
  color: black;
  position: fixed;
  right: 5%;
  bottom: 20px;
  transition: all 0.6s;
}
.dongtaijia > .el-icon-plus {
  transition: all 0.6s;
}
.dongtaijia:hover > .el-icon-plus {
  transform: rotate(180deg);
}
.dongtaijia:hover > div {
  opacity: 1;
}

.dongtaijia > div {
  transition: all 0.8s;
  opacity: 0;
  cursor: pointer;
}

.dongtaijia > div > .el-icon-edit:nth-child(1) {
  position: absolute;
  top: -40px;
  left: -40px;
  font-size: 13px;
  background: white;
  height: 40px;
  width: 40px;
  border-radius: 50%;
  text-align: center;
  line-height: 40px;
}
.dongtaijia > div > .el-icon-edit:nth-child(2) {
  position: absolute;
  top: 10px;
  left: -50px;
  font-size: 13px;
  background: white;
  height: 40px;
  width: 40px;
  border-radius: 50%;
  text-align: center;
  line-height: 40px;
}
</style>
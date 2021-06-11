<template>
  <div class="dongtai" :style="{ height: height }">
    <top></top>
    <div class="cotainer f2">
      <div class="dongtai_left">
        <h1>{{ title }}</h1>
        <div v-for="(item, index) in dataList" :key="index">
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
          
          <div class="dong_id">
            动态id:{{item.dId}}
          </div>
          <div class="dong_tai_i">
            <i
              class="el-icon-thumb"
              v-show="!item.goDot"
              @click="increDot(index)"
              >{{ item.dotCount }}</i
            >
            <i
              class="el-icon-thumb"
              style="color: orange"
              v-show="item.goDot"
              @click="dcrDot(index)"
              >{{ item.dotCount }}</i
            >
            &nbsp;
            <i class="el-icon-chat-line-round" @click="goPage(index)">{{
              item.commentsCount
            }}</i>
          </div>
          <hr />
        </div>

       
      
       
        <div class="dong_tran">
          <div class="dong_pageion">
            <div
              v-for="item in countDong"
              :class="[actIndex == item ? 'active' : '']"
              @click="goOtherPage(item)"
              :key="item"
            >
              {{ item }}
            </div>
          </div>
        </div>
      </div>
      <div class="dongtai_right">
        <h2>热门景点</h2>
        <hr />
        <div class="geng_card" @click="goNEWst" :style="{background: zuiBackImg}">
          最新动态
        </div>
        <div
          v-for="(item, index) in sightsList"
          :key="index"
          :style="{ background: backImgList[index] }"
          @click="tiao(item)"
          class="geng_card"
        >
          {{ item }}
        </div>
      </div>
    </div>
    <div class="dongtaijia">
      <div>
        <!-- <i class="el-icon-edit">文章</i> -->
        <i class="el-icon-edit" @click="showDong">动态</i>
      </div>

      <i class="el-icon-plus"></i>
    </div>
    <dongTai v-if="dongTaiShow"></dongTai>
  </div>
</template>

<script>
import dongTai from "@/components/DongTai/page";
import top from "@/components/Top/page";
export default {
  components: {
    top,
    dongTai,
  },
  data() {
    return {
      
      actIndex: 1,
      title: "最新动态",
      height: "",
      zuiBackImg:  "url(" + require("@/assets/CoUBYGBkI-uAbH2oAC9KSsmQjNE706.png") + ")",
      dongTaiShow: false,
      dataList: [],
      dotShow: true,
      sightsList: [],
      backImgList: [
        "url(" + require("@/assets/re3.jpeg") + ")",
        "url(" + require("@/assets/re2.jpeg") + ")",
        "url(" + require("@/assets/re1.jpeg") + ")",
      ],
      countDong: 0,
      biao: null,
    };
  },
  methods: {
    getReMaxPage(){
      this.axios.post(this.$root.dong_tai+"countDong/"+this.title)
      .then(res => {
        this.countDong = parseInt(res.data/10+1); 
        console.log(this.countDong)
      })
      .catch(err => {
        console.error(err); 
      })
    },
    showDong() {
      this.dongTaiShow = true;
    },
    goNEWst(){
      this.title = "最新动态"
      this.biao = null;
      this.actIndex = 1;
      this.flesh()
      let that = this;
      this.axios
          .post(this.$root.dong_tai + "countDong")
          .then((res) => {
            that.countDong = Math.trunc(res.data / 10) + 1;
            console.log(that.countDong);
          })
          .catch((err) => {
            console.error(err);
          });
    },
    goOtherPage(item) {
      this.actIndex = item;
      if (this.biao != null) {
        this.axios
          .post(
            this.$root.dong_tai +
              "listDongBySight/" +
              this.$cookies.get("uId") +
              "/" +
              this.biao +
              "/" +
              this.actIndex
          )
          .then((res) => {
            this.dataList = res.data;
            this.dataList.forEach((element) => {
              element.content.forEach((element1) => {
                if (element1.type == "图片") {
                  element1.content.replaceAll("^", "/");
                }
              });
            });

            this.dataList.forEach((element) => {
              element.imgUrl = element.imgUrl.replaceAll("^", "/");
            });
          });
      } else {
        this.flesh();
      }
    },
    tiao(sight) {
      this.title = sight;
      this.actIndex = 1;
      this.axios
        .post(
          this.$root.dong_tai +
            "listDongBySight/" +
            this.$cookies.get("uId") +
            "/" +
            sight +
            "/" +
            this.actIndex
        )
        .then((res) => {
          this.biao = sight;
          this.dataList = res.data;
          this.dataList.forEach((element) => {
            element.content.forEach((element1) => {
              if (element1.type == "图片") {
                element1.content.replaceAll("^", "/");
              }
            });
          });

          this.dataList.forEach((element) => {
            element.imgUrl = element.imgUrl.replaceAll("^", "/");
          });
          this.getReMaxPage();
        })
        .catch((err) => {
          console.error(err);
        });
    },
    giveTitle(index) {
      for (let i = 0; i < this.dataList[index].content.length; i++) {
        if (this.dataList[index].content[i].type == "标题") {
          var title = this.dataList[index].content[i].content;
          return title;
        }
      }
    },
    increDot(index) {
      this.axios
        .post(
          this.$root.dong_tai +
            "/increDot/" +
            this.dataList[index].dId +
            "/" +
            this.$cookies.get("uId")
        )
        .then((res) => {
          if (res.data) {
            this.dataList[index].dotCount++;
            this.dataList[index].goDot = true;
          }
        })
        .catch((err) => {
          console.error(err);
        });
    },
    dcrDot(index) {
      this.axios
        .post(
          this.$root.dong_tai +
            "/decDot/" +
            this.dataList[index].dId +
            "/" +
            this.$cookies.get("uId")
        )
        .then((res) => {
          if (res.data) {
            this.dataList[index].dotCount--;
            this.dataList[index].goDot = false;
          }
        })
        .catch((err) => {
          console.error(err);
        });
    },
    goPage(index) {
      let a = JSON.stringify(this.dataList[index]);
      this.$router.push({ path: "/dongtaiPage", query: { artcle: a } });
    },
    flesh() {
      this.axios
        .post(
          this.$root.dong_tai +
            "dong/listDong/" +
            this.$cookies.get("uId") +
            "/" +
            this.actIndex
        )
        .then((res) => {
          this.dataList = res.data;
          this.dataList.forEach((element) => {
            element.content.forEach((element1) => {
              if (element1.type == "图片") {
                element1.content.replaceAll("^", "/");
              }
            });
          });

          this.dataList.forEach((element) => {
            element.imgUrl = element.imgUrl.replaceAll("^", "/");
          });
        })

        .catch((err) => {
          console.error(err);
        });
    },
  },
  beforeMount() {
    this.axios
      .post(this.$root.dong_tai + "sights")
      .then((res) => {
        this.sightsList = res.data;
        let that = this;
        this.axios
          .post(this.$root.dong_tai + "countDong")
          .then((res) => {
            that.countDong = Math.trunc(res.data / 10) + 1;
            console.log(that.countDong);
          })
          .catch((err) => {
            console.error(err);
          });
      })
      .catch((err) => {
        console.error(err);
      });
  },
  mounted() {
    let a = document.documentElement.clientHeight;
    this.height = a + "px";
    this.flesh();
  },
};
</script>

<style scoped>
.dong_id{
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
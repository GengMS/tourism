<template>
  <div>
    <div class="top">
      <div class="top_container">
        <div class="top_left">
          <h2>通了旅游</h2>
          <h3>
            <router-link tag="a" to="/tours">跟团游</router-link>
          </h3>
          <h3>
            <router-link tag="a" to="/lvtu">我的旅图</router-link>
          </h3>
          <h3>
            <router-link tag="a" to="/dongtai">旅态</router-link>
          </h3>
        </div>
        <div class="top_right">
          <span v-show="!loginIsShow" class="login_and_show">
            <el-avatar :src="imgUrl"></el-avatar>,
            {{ name }}
            <div>
              <div @click="inforShow = true">修改信息</div>
              <hr />
              <div @click="toLogin">退出</div>
            </div>
          </span>
          <infor
            v-if="inforShow"
            :name="name"
            :imageUrl="'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png'"
          ></infor>
          <span v-show="loginIsShow">
            <router-link tag="span" to="/registy">注册</router-link>
            <span> | </span>
            <router-link tag="span" to="/login">登录</router-link>
          </span>
        </div>
      </div>
      <div class="f2">
        <el-carousel :style="{ height: height }">
          <el-carousel-item v-for="(item, index) in dataList" :key="index">
            <a href="" @click.prevent="tiao(index)" class="index_title">
              {{ item.title }}
            </a>
           
            <img :src="item.imgUrl" alt="" />
          </el-carousel-item>
        </el-carousel>
      </div>
    </div>
  </div>
</template>

<script>
import infor from "@/components/inforManage/page";
export default {
  components: {
    infor,
  },
  data() {
    return {
      imgData: [
        "https://b1-q.mafengwo.net/s15/M00/0F/5F/CoUBGV28HDuALpzxABR490kDN0M39.jpeg",
        "https://p1-q.mafengwo.net/s18/M00/F7/ED/CoUBYGBltqiAAEKXACgIIPDwhDs155.png?imageView2%2F2%2Fw%2F1920%2Fq%2F90%2Fformat%2Fjpeg",
      ],
      height: "",
      loginIsShow: true,
      name: "",
      inforShow: false,
      imgUrl:
        "https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png",
      dataList: [
         {
          title:"欢迎您",
          imgUrl:"https://p1-q.mafengwo.net/s18/M00/F7/ED/CoUBYGBltqiAAEKXACgIIPDwhDs155.png?imageView2%2F2%2Fw%2F1920%2Fq%2F90%2Fformat%2Fjpeg"
        }
      ],
      inforData: [
       
      ],
    };
  },
  mounted() {
   
    let a = document.documentElement.clientHeight;
    this.height = a + "px";
    if (this.$cookies.get("uId") == null) {
      this.loginIsShow = true;
    } else {
      let that = this;
      this.loginIsShow = false;
      if (this.$cookies.get("infor") == 0) {
        this.name = this.$cookies.get("name");
      } else {
        this.name = this.$cookies.get("name");
        that.imgUrl = this.$cookies.get("imgUrl").replaceAll("^", "/");
      }
    }
    this.getData();
  },
  methods: {
   
    tiao(index) {
      
      if(this.inforData.length <= 0){
         return;
      }
       this.$router.push({
        path: "/TeamInforPage",
        query: {
          item: JSON.stringify(this.inforData[index]),
        },
      });
    },
    toLogin() {
      this.$router.push({ path: "/login" });
    },
    getData() {
      
      this.axios
        .post(this.$root.team + "listHomePageShow")
        .then((res) => {
          if(res.data.length<=0){

          }else{
             this.dataList = res.data;
             this.getInforData();
          }
         
        })
        .catch((err) => {
          console.error(err);
        });
    },
    getInforData() {
      this.dataList.forEach((element) => {
        this.axios
          .post(this.$root.team + "getTeamInfor/" + element.tId)
          .then((res) => {
            this.inforData.push(res.data);
            console.log(this.inforData);
          })
          .catch((err) => {
            console.error(err);
          });
      });
    },
  },
};
</script>

<style >
.f2 {
}
.top {
  height: 80px;
  position: relative;
  width: 100%;
}
.top_container {
  color: white;
  width: 86%;
  margin: 0 auto;
  display: flex;
  height: 100%;
  align-items: center;
  justify-content: space-between;
  position: absolute;
  top: 0px;
  left: 50%;
  transform: translateX(-50%);
  z-index: 299;
}
.top_right > span:nth-child(1),
.top_right > span:nth-child(3) {
  color: orange;
  cursor: pointer;
}
.top_left {
  display: flex;
  align-items: center;
}
.top_left * {
  margin-right: 20px;
}
.f2 > img {
  height: 100%;
}
.el-carousel__container {
  height: 800px;
}
.el-carousel__container img {
  height: 100%;
  width: 100%;
}
.index_title {
  position: absolute;
  left: 10%;
  top: 140px;
  z-index: 99999999;
  color: white;
  font-size: 40px;
}
.el-carousel {
  overflow: hidden;
}
.login_and_show {
  display: flex;
  align-items: center;
  position: relative;
}
.login_and_show > div {
  position: absolute;
  top: 0px;
  left: 0px;
  z-index: -99999;
  width: 100%;
  height: 80px;
  background: rgb(251, 250, 250);
  border-radius: 4px;
  transition: all 0.6s ease-out;
  visibility: hidden;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  color: orange;
  text-align: center;
  padding: 6px;
}
.login_and_show > div > div {
  height: 34px;
  line-height: 34px;
  cursor: pointer;
}
.login_and_show:hover > div {
  top: 60px;
  visibility: visible;
}
</style>
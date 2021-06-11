<template>
  <div class="top">
    <div class="top_container">
      <div class="top_left">
        <router-link tag="h2" to="/">通了旅游</router-link>

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
        
        <div v-if="!loginIsShow" style="display:flex; align-items:center">
          <!-- <i class="el-icon-bell" style="margin-right:10px;cursor: pointer;"></i> -->
          <div class="login_and_show">
            <el-avatar
            :src="imgUrl"
          ></el-avatar
          >,
          {{ name }}
          <div>
            <div @click="inforShow = true">修改信息</div>
            <hr />
            <div @click="toLogin">退出</div>
          </div>
          </div>
          
        </div>
        <infor
          v-show="inforShow"
          :name="name"
          :imageUrl="imgUrl"
        ></infor>
        <div v-if="loginIsShow">
          <router-link tag="span" to="/registy">注册</router-link>
          <span> | </span>
          <router-link tag="span" to="/login">登录</router-link>
        </div>
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
      loginIsShow: true,
      name: "",
      inforShow: false,
      imgUrl:"https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
    };
  },
  mounted() {
    if (
      this.$cookies.get("uId").length == 0 ||
      this.$cookies.get("uId") == null
    ) {
      this.loginIsShow = true;
    } else {
      let that = this;
      this.loginIsShow = false;
      if (this.$cookies.get("infor") == 0) {
        this.name = this.$cookies.get("name");
      }else{
        this.name = this.$cookies.get("name");
        that.imgUrl = this.$cookies.get("imgUrl").replaceAll("^","/")
        console.log(this.imgUrl)
      }
    }
  },
  methods: {
    toLogin() {
      this.$router.push({ path: "/login" });
    },
  },
};
</script>

<style scoped>
.top {
  height: 80px;
  position: relative;
  width: 100%;
  background: #ffffff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
}
.top_container {
  color: gray;
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
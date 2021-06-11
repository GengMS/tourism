<template>
  <div class="user-login">
    <div
      class="user-login-bg"
      :style="{ 'background-image': `url(${backgroundImage})` }"
    ></div>
    <div class="content-wrapper">
      <h2 class="slogan">
        通了旅游 <br />
        欢迎您
      </h2>
      <div class="form-container">
        <h4 class="form-title">登录</h4>
        <el-form ref="form" :model="user" label-width="0">
          <div class="form-items">
            <el-row class="form-item">
              <el-col>
                <el-form-item
                  prop="username"
                  :rules="[
                    { required: true, message: '会员名/邮箱/手机号不能为空' },
                  ]"
                >
                  <div class="form-line">
                    <i class="el-icon-edit-outline input-icon"></i>
                    <el-input
                      placeholder="邮箱"
                      v-model="user.username"
                    ></el-input>
                  </div>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row class="form-item">
              <el-col>
                <el-form-item
                  prop="password"
                  :rules="[{ required: true, message: '密码不能为空' }]"
                >
                  <div class="form-line">
                    <i class="el-icon-service input-icon"></i>
                    <el-input
                      type="password"
                      placeholder="密码"
                      v-model="user.password"
                    ></el-input>
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row class="form-item">
              <el-button
                type="primary"
                class="submit-btn"
                size="small"
                @click="submitBtn"
              >
                登 录
              </el-button>
            </el-row>
          </div>
          <el-row class="tips">
            <router-link to="/registy" tag="a" class="link"
              >立即注册</router-link
            >

            <span class="line">|</span>
            <router-link to="/forgetPasswd" tag="a" class="link"
              >忘记密码</router-link
            >
          </el-row>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
import BasicContainer from "@vue-materials/basic-container";
const backgroundImage = require("../../assets/CoUBYGBii_CAZY8sACBYq-4zEog798.png");
export default {
  components: { BasicContainer },
  name: "UserLogin",

  data() {
    return {
      backgroundImage: backgroundImage,
      user: {
        username: "",
        password: "",
      },
    };
  },

  created() {},

  methods: {
    submitBtn() {
      if (this.user.username.length == 0 || this.user.username.length == 0) {
        this.$message.error("账号或密码不能为空");
        return;
      }
      this.axios
        .get(
          this.$root.loginUrl +
            "login/" +
            this.user.username +
            "/" +
            this.user.password
        )
        .then((res) => {
          if (res.data.length == 0 || res.data == null) {
            this.$message.error("登录失败，账号或密码错误");
          } else {
            console.log(res.data);
            if (res.data.infor == 0) {
              this.$cookies.set("name", res.data.email);
              this.$cookies.set("uId", res.data.uId);
              this.$cookies.set("identity", res.data.identity);
              this.$cookies.remove("imgUrl");
              this.$cookies.remove("qian");
              this.$cookies.set("infor", 0);
            } else {
              this.$cookies.set("uId", res.data.uId);
              this.$cookies.set("identity", res.data.identity);
              this.$cookies.set("infor", 1);
              this.axios
                .post(this.$root.loginUrl + "getUserInfor/" + res.data.uId)
                .then((res) => {
                  this.$cookies.set("name", res.data.name);
                  this.$cookies.set("imgUrl", res.data.imgUrl);
                  this.$cookies.set("qian", res.data.theSay);
                })
                .catch((err) => {
                  console.error(err);
                });
            }

            this.$message({
              message: "登录成功",
              type: "success",
            });
            setTimeout(() => {
              this.$router.push({ path: "/" });
            }, 1000);
            
          }
        })
        .catch((err) => {
          console.error(err);
          this.$message.error("登录失败，账号或密码错误");
        });
    },
  },
};
</script>

<style lang="scss" scoped>
@import "./UserLogin.scss";
</style>

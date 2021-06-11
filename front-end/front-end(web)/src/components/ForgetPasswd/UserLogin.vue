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
        <h4 class="form-title">忘记密码</h4>
        <el-form ref="form" :model="user" label-width="0">
          <div class="form-items">
            <el-row class="form-item">
              <el-col>
                <el-form-item
                  prop="username"
                  :rules="[{ required: true, message: '邮箱不能为空' }]"
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
            <el-row class="form-item form-item-geng">
              <el-col>
                <el-input
                  type="text"
                  placeholder="验证码"
                  v-model="mailCode"
                ></el-input>
                <el-button @click="getCodeRequest" :disabled="disabled">{{
                  num
                }}</el-button>
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
                修改密码
              </el-button>
            </el-row>
          </div>
            <el-row class="tips">
            <router-link to="/login" tag="a" class="link">返回登录页</router-link>
            
            
             
          </el-row>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
import BasicContainer from "@vue-materials/basic-container";
const backgroundImage = require("../../assets/CoUBYGBkI-uAbH2oAC9KSsmQjNE706.png");
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
      mailCode: "",
      num: "登录",
      disabled: false,
    };
  },

  created() {
    if (
      this.$cookies.get("forget") == null ||
      this.$cookies.get("forget") <= 0 ||
      this.$cookies.get("forget") == 60
    ) {
      this.$cookies.set("forget", 60);
      this.disabled = false;
      this.num = "获取";
    } else if (
      this.$cookies.get("forget") < 60 &&
      this.$cookies.get("forget") > 0
    ) {
      this.getCode();
    }
  },

  methods: {
    submitBtn() {
      if (
        this.user.username.length == 0 ||
        this.user.password.length != 8 ||
        this.mailCode.length != 4
      ) {
        this.$message.error("格式错误，请检查后注册");
        return;
      }
      this.axios
        .post(
          this.$root.loginUrl +
            "/updatePasswd/" +
            this.user.username +
            "/" +
            this.user.password +
            "/" +
            this.mailCode
        )
        .then((res) => {
          if (res.data) {
            this.$message({
              message: "修改成功",
              type: "success",
            });
          }
          console.log(res.data);
        })
        .catch((err) => {
          console.error(err);
        });
    },
    getCodeRequest() {
      var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
      if (!reg.test(this.user.username)) {
        this.$message.error("邮箱格式错误");
        return;
      }
       this.getCode();
      this.axios
        .post(this.$root.loginUrl + "/getMailCode/" + this.user.username)
        .then((res) => {
          if (res.data) {
            this.$message({
              message: "发送成功,验证码两分钟内有效",
              type: "success",
            });
           
          } else {
            this.$message.error("发送失败");
          }
        })
        .catch((err) => {
          console.error(err);
          this.$message.error("发送失败，请检查网络");
        });
    },
    getCode() {
      let a = setInterval(() => {
        if (this.$cookies.get("forget") <= 0) {
          this.$cookies.set("forget", 60);
          this.disabled = false;
          this.num = "获取";
          clearInterval(a);
        } else {
          this.disabled = true;
          this.$cookies.set("forget", this.$cookies.get("forget") - 1);
          this.num = this.$cookies.get("forget");
        }
      }, 1000);
    },
  },
};
</script>

<style lang="scss" scoped>
@import "./UserLogin.scss";
.form-item-geng {
  margin-bottom: 10px;
}
</style>

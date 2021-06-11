<template>
  <div class="noticeManage">
    <h1>通知管理</h1>
    <hr />
    要发送到的地址<small>(多个地址之间用逗号隔开)</small>
    <el-input type="text" v-model="emailAddres"></el-input>
    或全选<el-switch
      v-model="allSelect"
      active-color="#13ce66"
      inactive-color="#ff4949"
      active-value="true"
      inactive-value="false"
    >
    </el-switch>
    <hr />
    <h3>所要发送主题</h3>
    <el-input type="text" v-model="theme"></el-input>
    <h3>所要发送的内容</h3>
    <el-input type="textarea" v-model="content"></el-input>
    <el-button type="success" @click="send()">提交</el-button>
    <el-button type="warning" @click="clear()">清空</el-button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      emailAddres: "",
      allSelect: false,
      theme: "",
      content: "",
    };
  },
  methods: {
      clear(){
          this.emailAddres = "";
          this.allSelect = false;
          this.theme = "";
          this.content ="";
      },
    send() {
      this.axios({
        method: "post",
        url: this.$root.team + "notice",
        data: {
          addres: this.emailAddres,
          allSelect: this.allSelect,
          theme: this.theme,
          content: this.content,
        },
      }).then((response) => {
          console.log(response)
        })
        .catch((response) => {
          console.log(response);
        });
    },
  },
};
</script>

<style>
.noticeManage {
  padding: 20px;
}
</style>
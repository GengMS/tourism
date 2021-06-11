<template>
  <div class="homePageInforManage">
    <h2>首页信息修改</h2>
    <hr />
    <div class="homePageInfor">
      <div v-for="(item, index) in dataList" :key="index" class="homePageInforItem">
        <img :src="item.imgUrl" alt="" />
        <div class="title">
          <div>{{ item.title }}</div>
          <div>{{ item.tId }}</div>
        </div>
        <i class="el-icon-delete" @click="delPageShow(item.id)"></i>
        <div class="time">
          <div>{{ item.saveTime }}</div>
          <div>{{ item.liveTime }}(m)</div>
        </div>
      </div>
    </div>
    标题
    <el-input v-model="title" maxlength="10"></el-input>
    上传预览图:
    <el-upload
      class="avatar-uploader"
      action="http://localhost:81/upload/"
      :show-file-list="false"
      :on-success="handleAvatarSuccess"
      :before-upload="beforeAvatarUpload"
    >
      <img v-if="imgUrlShow" :src="imgUrl" class="avatar" />
      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
    <div>
      旅游团信息id:
      <el-input-number :min="min" v-model="tId"></el-input-number>
    </div>
    <div style="margin-top: 10px">
      设置展示时间(分钟)
      <el-input-number
        :min="timeMin"
        :step="1"
        :step-strictly="true"
        v-model="time"
        controls-position="right"
      ></el-input-number>
    </div>
    <el-button type="success" @click="send()">提交</el-button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      title: "",
      imgUrl: "",
      imgUrlShow: false,
      tId: 1,
      min: 1,
      timeMin: 1,
      time: 1,
      dataList: [],
    };
  },

  methods: {
    delPageShow(id){
        console.log(id)
        this.axios.post(this.$root.team+"delHomePageShow",id)
        .then(res => {
            if(res.data){
                this.getPageShowData();
            }
        })
        .catch(err => {
            console.error(err); 
        })
    },
    getPageShowData() {
      console.log("-------");
      this.axios
        .post(this.$root.team + "listHomePageShow")
        .then((res) => {
          this.dataList = res.data;
          console.log(this.dataList);
        })
        .catch((err) => {
          console.error(err);
        });
    },
    send() {
      console.log(
        this.title + "," + this.imgUrl + "," + this.tId + "," + this.time
      );
      this.axios
        .post(this.$root.team + "updateHomePageShow", {
          title: this.title,
          imgUrl: this.imgUrl,
          tId: this.tId,
          time: this.time,
        })
        .then((res) => {
          if (res.data) {
              this.getPageShowData();
            this.$message({
              message: "提交成功",
              type: "success",
            });
          } else {
            this.$message.error("提交错误，请检查信息后重试");
          }
        })
        .catch((err) => {
          console.error(err);
          this.$message.error("提交错误，请检查信息后重试");
        });
    },
    handleAvatarSuccess(res, file) {
      this.imgUrl = res;
      this.imgUrlShow = true;
      console.log(this.imgUrl);
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === "image/jpeg";
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error("上传头像图片只能是 JPG 格式!");
      }
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 2MB!");
      }
      return isJPG && isLt2M;
    },
  },
  mounted() {
    console.log("+++++++++++");
    this.getPageShowData();
  },
};
</script>

<style scoped>
.homePageInfor{
    display: flex;
    height: 80px;
}
.homePageInforItem{
    margin: 5px 10px;
    max-width: 140px;
    max-height: 100%;
    position: relative;
}
.homePageInforItem:hover>i{
    visibility: unset;
}
.homePageInforItem>i{
    position: absolute;
    text-align: center;
    top: 40%;
    visibility: hidden;
    left: 40%;
    color: white;
    font-weight: bold;
    cursor: pointer;
}
.homePageInforItem .title{
    font-size: 10px;
    position: absolute;
    top: 2px;
    left: 2px;
    font-weight: bold;
    color: orange;
}
.homePageInforItem .time{
    font-size: 10px;
    position: absolute;
    bottom: 2px;
    right: 2px;
    font-weight: bold;
    color: orange;
    text-align: right;
}
.homePageInforItem img{
    width: 100%;
    height: 100%;
}
.homePageInforManage {
  padding: 20px;
}
.avatar-uploader .el-upload {
  border: 1px dashed black;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.el-upload {
  border: 1px dashed black;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 534px;
  height: 356px;
  display: block;
}
</style>
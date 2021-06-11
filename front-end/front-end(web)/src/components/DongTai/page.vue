<template>
  <div class="dong_tai">
    <h3>发布动态</h3>
    <el-input
      type="textarea"
      maxlength="50"
      placeholder="请输入动态内容"
      v-model="textarea"
    >
    </el-input>
    <div class="dong_tai_imgList">
      <el-upload
        class="avatar-uploader"
        action="http://localhost:81/upload/"
        :show-file-list="false"
        :on-success="handleAvatarSuccess"
        :before-upload="beforeAvatarUpload"
      >
        <img v-if="imageUrl" :src="imageUrl" class="avatar" />
        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
      </el-upload>
      <div
        v-for="(item, index) in imgList"
        :key="index"
        class="dong_tai_upload_imgList"
      >
        <img :src="item" alt="" />
        <i class="el-icon-close" @click="delImg"></i>
      </div>
    </div>
    <div>
      <span class="dong_tai_sight"> 所在景点：</span>

      <el-input
        type="text"
        maxlength="10"
        v-model.trim="sight"
        style="width: 140px"
      ></el-input>
    </div>
    <div>
      
    </div>
    <div>
      <el-button type="success" @click="send">发送 </el-button>
      <el-button type="info" @click="cancel">取消</el-button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogImageUrl: "",
      dialogVisible: false,
      textarea: "",
      imageUrl: "",
      imgList: [],
      sight: "",
    };
  },
  methods: {
    cancel() {
      this.$parent.dongTaiShow = false;
    },
    handleAvatarSuccess(res, file) {
      console.log(res);
      this.imgList.push(res);
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
      if (this.imgList.length >= 4) {
        console.log("sdsf");
        this.$message.error("上传图片数已达上限");
        return false;
      }
      return isJPG && isLt2M;
    },
    send() {
      if (this.textarea.length == 0) {
        this.$message.error("标题不能为空呦");
      } else {
        this.axios
          .post(this.$root.dong_tai + "dong/upload", {
            type: 0,
            uId: parseInt(this.$cookies.get("uId")),
            title: this.textarea,
            imgList: this.imgList,
            sight: this.sight,
          })
          .then((res) => {
            if (res.data) {
              this.$message({
                message: "提交成功",
                type: "success",
              });
              this.cancel();
            }else{
              this.$message.error("提交错误")
            }
          })
          .catch((err) => {
            console.error(err);
          });
      }
    },
    delImg(index) {
      this.imgList.splice(index, 1);
    },
  },
};
</script>

<style scoped>
.dong_tai_sight {
  color: white;
}
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  width: 148px;
  height: 148px;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 148px;
  height: 148px;
  line-height: 148px !important;
  text-align: center;
}
.avatar {
  width: 148px;
  height: 148px;
  display: block;
}
.dong_tai {
  position: fixed;
  width: 900px;
  top: 26%;
  left: 50%;
  transform: translateX(-50%);
  background: rgba(0, 0, 0, 0.5);
  padding: 20px;
  box-sizing: border-box;
  border-radius: 4px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  border: 1px dashed whitesmoke;
}
.dong_tai > h3 {
  color: white;
}
.dong_tai_upload_imgList {
  display: inline-block;
  position: relative;
}
.dong_tai_upload_imgList > i {
  position: absolute;
  right: 4px;
  top: 4px;
  color: white;
  cursor: pointer;
}
.dong_tai_imgList {
  display: flex;
  flex-wrap: wrap;
  width: 100%;
  max-width: 100%;
}
.dong_tai_imgList img {
  width: 148px;
  height: 148px;
}
</style>
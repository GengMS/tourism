<template>
  <div class="infor">
    <div class="infor_f1">
      <el-upload
        class="avatar-uploader"
        action="http://localhost:81/upload/"
        :show-file-list="false"
        :on-success="handleAvatarSuccess"
        :before-upload="beforeAvatarUpload"
      >
        <img v-if="imageUrl" :src="infor.imgUrl" class="avatar" />
        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
      </el-upload>

      <div>
        <el-input type="text" v-model="infor.name" maxlength="10"></el-input>
      </div>
    </div>
    <div>
      <el-input
        type="textarea"
        autosize
        placeholder="我的签名"
        v-model="infor.theSay"
        minlength="4"
        maxlength="50"
      >
      </el-input>
    </div>
    <div>
      <el-button size="small" type="success" @click="send()"> 修改 </el-button>
      <el-button size="small" type="primary" @click="show">取消</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "infor",
  props: ["imageUrl", "name"],
  data() {
    return {
      infor: {
        uId: "",
        theSay: "",
        imgUrl: "",
        name: "",
      },
    };
  },
  methods: {
    send() {
      if (this.infor.name.length < 4) {
        this.$message.error("名字长度不能少于4位");
        return;
      } else if (this.infor.name.match("[//,?]")) {
        this.$message.error("名字中不能包含特殊字符（/,?）");
        return;
      }
      this.infor.uId = this.$cookies.get("uId");
      let imgUrl1 = this.infor.imgUrl;
      this.infor.imgUrl = this.infor.imgUrl.replaceAll("/", "^");
      let infor = JSON.stringify(this.infor);
      
      let that = this;
      this.axios
        .post(this.$root.loginUrl + "updateUserInfor/" + infor)
        .then((res) => {
          console.log(res);
          if (res.data) {
            
            //改，因为没有修改数据会被判别为空，然后导致数据失效
            this.$cookies.set("name", that.infor.name);
            this.$cookies.set("imgUrl", imgUrl1);
            this.$cookies.set("infor", 1);
            this.$cookies.set("qian", this.infor.theSay);
            this.$parent.imgUrl = imgUrl1;
            this.$parent.name = that.infor.name
             //改，因为没有修改数据会被判别为空，然后导致数据失效
            this.$message({
              message: "修改 成功",
              type: "success",
            });
            this.$parent.inforShow = false;
          } else {
            this.$message.error("修改失败");
          }
        })
        .catch((err) => {
          that.infor.imgUrl = this.$cookies.get("imgUrl").replaceAll("%","/");
          this.$message.error("修改失败");
          console.error(err);
        });
    },
    show() {
      this.$parent.inforShow = false;
    },
    handleAvatarSuccess(res, file) {
      console.log(res);
      this.infor.imgUrl = res;
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
    if (this.$cookies.isKey("qian")) {
      this.infor.theSay = this.$cookies.get("qian");
    }
    if (this.$cookies.isKey("imgUrl")) {
      this.infor.imgUrl = this.$cookies.get("imgUrl").replaceAll("^","/");
    }else{
      
      this.infor.imgUrl = this.imageUrl
    }
    if(this.$cookies.isKey("name")) {
      this.infor.name = this.$cookies.get("name")
    }
  },
};
</script>

<style>
.infor_f1 {
  display: flex;
  align-items: center;
}
.infor {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  position: fixed;
  left: 50%;
  top: 50%;
  transform: translate(-50%);
  padding: 10px;
  border-radius: 4px;
  background: white;
}
.infor > div {
  margin-top: 10px;
}
.infor > div:nth-child(3) {
  display: flex;
  justify-content: center;
}
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 50px;
  height: 50px;
  line-height: 50px;
  text-align: center;
}
.infor .avatar {
  width: 50px !important;
  height: 50px !important;
  display: block !important;
}
</style>
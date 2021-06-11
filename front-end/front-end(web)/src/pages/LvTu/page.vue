<template>
  <div>
    <top></top>
    <div class="lvtu" :style="{ height: height }">
      <div class="lvtu_left">
        <div class="lvtu_left_logo">旅图</div>
        <div class="lvtu_upload">
          <el-upload
            class="avatar-uploader"
            action="http://localhost:81/upload"
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload"
          >
            <img v-if="imgUrl" :src="imgUrl" class="avatar" />
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            <h5>上传我的图片</h5>
          </el-upload>
        </div>
        <div class="lvtu_left_bottom">
          <a tag="a" @click="tiao" class="go_show"
            >查看我的图片墙
            <br />
            <span>可以把你的图片墙链接分享给你的好友呦</span>
          </a>
        </div>
      </div>
      <div class="lvtu_right">
        <div v-for="(item, index) in imgList" :key="index">
          <h3>{{ index }}</h3>

          <div class="lv_tu_imgList">
            <div v-for="(item1, index1) in item" :key="index1">
              <i class="el-icon-close" @click="delImg(item1.i_id)"></i>
              <vue-viewer
                :thumb="item1.img_url.replaceAll('^', '/')"
                :full="item1.img_url.replaceAll('^', '/')"
              >
              </vue-viewer>
            </div>
          </div>
          <hr />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import top from "@/components/Top/page";
export default {
  components: {
    top,
  },
  data() {
    return {
      imgUrl: "",
      height: "",
      imgList: "",
      imgListKeys: "",
    };
  },
  beforeMount() {
    let a = document.documentElement.clientHeight - 80;
    this.height = a + "px";
  },
  mounted() {
    this.search();
  },
  methods: {
    tiao() {
      this.$router.push({ path: `/show/${this.$cookies.get("uId")}` });
    },
    delImg(id) {
      this.axios
        .post(this.$root.lv_tu + "delImg/" + id)
        .then((res) => {
          if (res.data) {
            this.search();
          }
        })
        .catch((err) => {
          console.error(err);
        });
    },
    search() {
      this.axios
        .post(this.$root.lv_tu + "listImgByDate/" + this.$cookies.get("uId"))
        .then((res) => {
          console.log(res.data);
          this.imgList = res.data;
          this.imgListKeys = Object.keys(res.data);

          console.log(this.imgListKeys);
        })
        .catch((err) => {
          console.error(err);
        });
    },
    handleAvatarSuccess(res, file) {
      this.imgUrl = res;
      let imageUrl = res.replaceAll("/", "^");
      this.axios
        .post(
          this.$root.lv_tu +
            "saveImg/" +
            imageUrl +
            "/" +
            this.$cookies.get("uId")
        )
        .then((res) => {
          this.search();
          console.log(res.data);
        })
        .catch((err) => {
          console.error(err);
        });
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
};
</script>

<style>
.lvtu {
  display: flex;
  height: 100%;
}
.lvtu_left {
  position: relative;
  width: 20%;
  padding: 10px;
}
.lvtu_right {
  width: 80%;
  border-left: 1px solid black;
  border-radius: 4px;
  padding: 16px;
}
.lvtu_left_logo {
  font-family: "Courier New", Courier, monospace;
  color: orange;
  font-weight: bold;
  font-style: oblique;
  text-align: center;
  font-size: 30px;
}
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader img {
  width: 178px !important;
  height: 178px !important;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px !important;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
.lvtu_upload {
  display: flex;
  justify-content: center;
  margin: 20px 0;
}
.lvtu_left_bottom {
  position: absolute;
  bottom: 10px;
  left: 10px;
  width: 100%;
}
.lv_tu_imgList {
  display: flex;
}

.lv_tu_imgList > div {
  display: flex;
  align-items: center;
  position: relative;
}
.lv_tu_imgList > div:hover > i {
  visibility: visible;
}
.lv_tu_imgList > div > i {
  position: absolute;
  visibility: hidden;
  top: 0px;
  right: 10px;
  cursor: pointer;
  color: white;
}
.lv_tu_imgList img {
  width: 140px;
  margin-right: 10px;
  border-radius: 4px;
}
.go_show {
  font-size: 14px;
  text-align: center;
}
.go_show > span {
  font-size: 8px;
  color: gray;
}
</style>
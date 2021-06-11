<template>
  <div class="phoneNum">
    <div class="f1">
      <h2>旅游团预定用户手机</h2>
      <i class="el-icon-document" @click="downloadFile('test')">下载Excel</i>
    </div>

    <hr />
    <div>
      <div class="geng_head">
        <div>手机号</div>
        <div>日期</div>
        <div>手机号</div>
        <div>日期</div>
        <div>手机号</div>
        <div>日期</div>
        <div>手机号</div>
        <div>日期</div>
      </div>
      <div class="geng_body">
        <div v-for="(item, index) in dataList" :key="index">
          <div>{{ item.phoneNum }}</div>
          <div>{{ item.date }}</div>
        </div>
      </div>
      <hr />
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dataList: [],
    };
  },
  methods: {
    // url 向后台请求的接口 ，fileName 下载赋予的文件名
    downloadFile(fileName) {
      this.axios
        .get(this.$root.team + "phoneNumExcel/download", {
          responseType: "arraybuffer",
          ContentType: "application/vnd.ms-excel",
        })
        .then((res) => {
          //   let data = res.data;
          //   if (!data) {
          //     return;
          //   }
          //   let url = window.URL.createObjectURL(new Blob([data]));
          //   let link = document.createElement("a");
          //   link.style.display = "none";
          //   link.href = url;
          //   link.download = fileName;
          //   document.body.appendChild(link);
          //   link.click();
          //   window.URL.revokeObjectURL(link.href);
          let blob = new Blob([res.data], { type: "application/xlsx" });
          let url = window.URL.createObjectURL(blob);
          const link = document.createElement("a"); // 创建a标签
          link.href = url;
          link.download = "download.xlsx"; // 重命名文件
          link.click();
          URL.revokeObjectURL(url);
        })
        .catch((err) => {});
      // this.axios({
      //     method:'get',
      //     url: this.$root.team+"phoneNumExcel/download",
      //    "responseType": 'blob',

      // })
    },
  },
  beforeMount() {
    this.axios
      .post(this.$root.team + "listPhoneNum")
      .then((res) => {
        this.dataList = res.data;
        console.log(this.dataList);
        console.log("-------------");
      })
      .catch((err) => {
        console.error(err);
      });
  },
};
</script>

<style>
.f1 {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.f1 > i {
  cursor: pointer;
}
.phoneNum {
  padding: 20px;
}
.geng_head {
  display: flex;
}
.geng_head > div {
  width: 12.5%;
  text-align: center;
  height: 30px;
  font-size: 20px;
  font-weight: bold;
}
.geng_body {
  display: flex;
  flex-wrap: wrap;
}
.geng_body > div {
  width: 25%;
  display: flex;

  min-width: 25%;
}
.geng_body > div > div {
  width: 50%;
  height: 26px;
  font-size: 16px;
  text-align: center;
  line-height: 26px;
}
</style>
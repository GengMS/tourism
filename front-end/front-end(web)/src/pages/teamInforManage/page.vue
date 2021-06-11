<template>
  <div class="AricleManagement">
    <h2>旅游团信息管理</h2>
    <label class="aricle_search">
      <el-input
        placeholder="请输入旅游团信息id"
        type="number"
        v-model="tId"
      ></el-input>
      <el-button @click="getTeamInfor()">
        <i class="el-icon-search"></i>
      </el-button>
    </label>
    <hr />
    <div>
      <div v-if="show" class="InforReview">
        <team-infor :item="itemData"></team-infor>
        <div  @dblclick.stop="delTeamInfor">
             <el-tooltip
          class="item"
          effect="dark"
          content="双击以删除"
          placement="top"
        >
          <i class="el-icon-close" ></i>
        </el-tooltip>
        </div>
       
      </div>
    </div>
  </div>
</template>

<script>
import TeamInfor from "../../components/TeamInfor/TeamInfor.vue";
export default {
  components: {
    TeamInfor,
  },

  data() {
    return {
      tId: "",
      itemData: {},
      show: false,
    };
  },
  methods: {
    getTeamInfor() {
      this.axios
        .post(this.$root.team + "getTeamInfor/" + this.tId)
        .then((res) => {
          if (res.data.length <= 0) {
            this.$message.error("无该信息");
            this.show = false;
            return;
          }
          this.itemData = res.data;
          console.log(this.itemData);
          this.show = true;
        })
        .catch((err) => {
          console.error(err);
        });
    },
    delTeamInfor() {
        console.log("sdfs")
      this.axios
        .post(this.$root.team + "delTeamInfor/" + this.tId)
        .then((res) => {
          if (res.data) {
            this.$message({
              message: "删除成功",
              type: "success",
            });
            this.show = false;
          }else{
              this.$message.error("删除失败")
          }
        })
        .catch((err) => {
            this.$message.error("删除失败")
          console.error(err);
        });
    },
  },
  mounted() {},
};
</script>

<style scoped>
.AricleManagement {
  padding: 20px;
}
.aricle_search {
  display: flex;
  align-items: center;
}
.InforReview {
  position: relative;
}
.InforReview>div:nth-child(2) {
  position: absolute;
  right: 10px;
  top: 4px;
  cursor: pointer;
  z-index: 9999999;
}
</style>
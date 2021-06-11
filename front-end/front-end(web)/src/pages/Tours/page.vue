<template>
  <div>
    <top></top>
    <div class="cotainer f2">
      <div>
        <div>出发地</div>
        <el-cascader
          size="large"
          :options="options"
          v-model="departure"
          @change="handleChange1"
        >
        </el-cascader>
      </div>
      <div>======></div>
      <div>
        <div>目的地</div>
        <el-cascader
          size="large"
          :options="options"
          v-model="destination"
          @change="handleChange"
        >
        </el-cascader>
      </div>
    </div>
    <div class="shai_table cotainer">
      <!-- <div>
        出发日期:
        <el-checkbox-group v-model="goDate">
          <el-checkbox label="不限"></el-checkbox>

          <el-checkbox
            v-for="item in goDateSelectList"
            :key="item"
            :label="item"
          ></el-checkbox>
        </el-checkbox-group>
      </div>
      <hr /> -->
      <div>
        价格区间:

        <el-checkbox-group v-model="priceList">
          <el-checkbox
            v-for="item in priceSelectList"
            :key="item"
            :label="item.first + '-' + item.last"
          ></el-checkbox>
        </el-checkbox-group>
        <button @click="send">查询</button>
      </div>
    </div>
    <div class="cotainer f3">
      <a href="">综合排序</a>
     
     
      <hr />
      <br />
      <team-infor
        v-for="(item, index) in dataList"
        :key="index"
        :item="item"
      ></team-infor>
      <el-pagination
        layout="prev, pager, next"
        @current-change="handleCurrentChange"
        :total="maxPageSize"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
import top from "@/components/Top/page";
import { regionData } from "element-china-area-data";
import { CodeToText } from "element-china-area-data";
// 根据下标分别获取省市区 console.log('CodeToText' + this.CodeToText[value[0]]); } } }
import TeamInfor from "../../components/TeamInfor/TeamInfor.vue";
export default {
  components: {
    top,
    TeamInfor,
  },
  data() {
    return {
      options: regionData,
      selectedOptions: [],
      priceSelectList: [],
      departure: "",
      destination: "",
      price: [],
      dataList: [],
      maxPageSize: 0,
      priceList: [],
      selectOption: {
        departure: null,
        destination: null,
        drop:null,
        priceList: [],
      },
    };
  },
  methods: {
    
    send() {
      this.selectOption.priceList = [];
      let list = [];
      this.priceList.forEach((element) => {
        let a = element.split("-");
        a.forEach((element1) => {
          list.push(element1);
        });
      });
      this.selectOption.priceList = list;
      this.getMaxPageSize();
      this.getData(1);
    },
    getMaxPageSize(val) {
      if (
        this.selectOption.destination == null &&
        this.selectOption.departure == null &&
        this.selectOption.priceList.length == 0
      ) {
        console.log("-----------")
        this.axios
          .post(this.$root.team + "countTeamInfor")
          .then((res) => {
            this.maxPageSize = res.data
            console.log("-----------")
            console.log(this.maxPageSize);
          })
          .catch((err) => {
            console.error(err);
          });
      } else {
        
        this.axios
          .post(this.$root.team + "countTeamInforByOptions", {
            departure: this.selectOption.departure,
            destination: this.selectOption.destination,
            drop:this.selectOption.drop,
            priceList: this.selectOption.priceList,
          })
          .then((res) => {
            this.maxPageSize = res.data 
          })
          .catch((err) => {
            console.error(err);
          });
      }
    },
    handleCurrentChange(val) {
      this.getData(val);
    },
    handleChange1(value) {
      this.selectOption.departure =
        CodeToText[this.departure[0]] +
        "-" +
        CodeToText[this.departure[1]] +
        "-" +
        CodeToText[this.departure[2]];
      console.log(this.selectOption);
    },
    handleChange(value) {
      this.selectOption.destination =
        CodeToText[this.destination[0]] +
        "-" +
        CodeToText[this.destination[1]] +
        "-" +
        CodeToText[this.destination[2]];
      console.log(this.selectOption);
    },
    getData(pageIndex) {
      this.axios
        .post(this.$root.team + "listTeamInforByOption/" + pageIndex, {
          departure: this.selectOption.departure,
          destination: this.selectOption.destination,
          drop:this.selectOption.drop,
          priceList: this.selectOption.priceList,
        })
        .then((res) => {
          this.dataList = res.data
          console.log(this.dataList)
        })
        .catch((err) => {
          console.error(err);
        });
    },
  },
  mounted() {
    this.axios
      .post(this.$root.team + "listTeamInfor/" + 1)
      .then((res) => {
        this.dataList = res.data;
         this.getMaxPageSize();
         console.log(this.maxPageSize)
      })
      .catch((err) => {
        console.error(err);
      });
  },
  beforeMount() {
    this.priceSelectList.push({
      first: 1024,
      last: 2000,
    });
    this.priceSelectList.push({
      first: 2000,
      last: 3000,
    });
    this.priceSelectList.push({
      first: 3000,
      last: 13880,
    });
  },
};
</script>

<style scoped>
.f2 {
  border: 1px solid orange;
  border-radius: 3px;
  margin-top: 10px;
  margin-bottom: 10px;
  padding: 2px;
  display: flex;
  justify-content: space-around;
  align-items: center;
  background: orange;
}
.f2 > div:nth-child(1),
.f2 > div:nth-child(3) {
  display: flex;
  align-items: center;
}
.shai_table {
  border: grey 1px solid;
  border-radius: 4px;
}
.shai_table > div {
  padding: 10px 0;
}
.f3 * {
  margin-top: 10px;
  margin-bottom: 10px;
  color: grey;
  font-size: 13px;
}
</style>
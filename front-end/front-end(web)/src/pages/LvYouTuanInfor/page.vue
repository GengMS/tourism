<template>
  <div class="lvYouTuanInfor">
    <h2>旅游团信息发布</h2>
    <label>
      标题:
      <el-input v-model="teamInfor.introduce" maxlength="50"></el-input>
      商品图片:
      <el-upload
        class="upload-demo"
        action="http://localhost:81/upload"
        :on-remove="handleRemove"
        :on-success="handleAvatarSuccess"
        :before-upload="beforeAvatarUpload"
        list-type="picture"
      >
        <el-button size="small" type="primary">点击上传</el-button>
        <div slot="tip" class="el-upload__tip">
          只能上传jpg/png文件，且不超过500kb
        </div>
      </el-upload>
    </label>
    <label>
      价格:
      <el-input-number v-model="teamInfor.price"></el-input-number>
    </label>
    <br>
    <br>
    <div>
       <label>
      出发地:
      <el-cascader
        size="large"
        :options="options"
        v-model="selectedOptions"
        @change="handleChange1"
      >
      </el-cascader>
    </label>
     <label>
      目的地:
      <el-cascader
        size="large"
        :options="options"
        v-model="selectedOptions2"
        @change="handleChange2"
      >
      </el-cascader>
    </label>
    </div>
   
    <br>
    <br>
    <label>
        路径介绍:
      <el-steps direction="vertical">
          <label v-for="(item,index) in teamInfor.buZhou" :key="index" >
               <el-step :title="'步骤'+(index+1)"  :description="teamInfor.buZhou[index]"></el-step>
               <el-input type="text" v-model="teamInfor.buZhou[index]" @keyup.enter.native="addBu"></el-input>
          </label>
      </el-steps>
    </label>
    <hr>
    <label>
        旅游提供商:
        <el-input v-model="teamInfor.provider" maxlength="50"></el-input>
    </label>
    <el-button type="success" @click="send">
        提交
    </el-button>

  </div>
</template>

<script>
import { regionData } from "element-china-area-data";
import { CodeToText } from "element-china-area-data";
export default {
  data() {
    return {
     
      options: regionData,
      selectedOptions: [],
      selectedOptions2: [],
     
      teamInfor:{
        introduce:"",
        fileList: [],
        price:0,
        departure:"",
        destination:"",
         buZhou:[""],
         provider:""
      }
    };
  },
  methods: {
    send(){
      if(this.teamInfor.introduce.length == 0 || this.teamInfor.fileList.length ==0 || this.teamInfor.price <=0|| this.teamInfor.departure.length<=0|| this.teamInfor.destination.length ==0 || this.teamInfor.buZhou.length ==0 || this.teamInfor.provider.length ==0){
        this.$message.error("输入框为空或格式错误")
        return;
      }
      let teamInfor = JSON.stringify(this.teamInfor)
      this.axios.post(this.$root.team+"uploadTeamInfor",{
         introduce:this.teamInfor.introduce,
        fileList: this.teamInfor.fileList,
        price:this.teamInfor.price,
        departure: this.teamInfor.departure,
        destination: this.teamInfor.destination,
         buZhou: this.teamInfor.buZhou,
         provider: this.teamInfor.provider
      })
      .then(res => {
        if(res.data){
           this.$message({
          message: '发布成功',
          type: 'success'
        });
        }
      })
      .catch(err => {
        console.error(err); 
      })
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    handleAvatarSuccess(res, file) {
      console.log(this.teamInfor.fileList.push(res));
    },
    beforeAvatarUpload() {
      if (this.teamInfor.fileList.length >= 3) {
        console.log(this.teamInfor.fileList.length + "length-------");
        this.$message.error("只能上传三张图片");
        return false;
      }
    },
    handleChange1(value) {
      console.log(value);
      this.teamInfor.departure = CodeToText[value[0]]+"-"+CodeToText[value[1]]+"-"+CodeToText[value[2]]
    },
     handleChange2(value) {
      console.log(value);
      this.teamInfor.destination = CodeToText[value[0]]+"-"+CodeToText[value[1]]+"-"+CodeToText[value[2]]
    },
    addBu(){
      
        if(this.teamInfor.buZhou.length>=7){
            this.$message.error("步骤最多为7条");
        }else{
            this.teamInfor.buZhou.push("")
        }
       
        
    }
  },
};
</script>

<style>
.lvYouTuanInfor {
  padding: 20px;
}
</style>
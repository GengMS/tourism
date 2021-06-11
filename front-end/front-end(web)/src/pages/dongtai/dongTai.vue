<template>
  <div>
    <top></top>
    <div class="dongTaiPageBody">
      <div class="dongTaiPageCon">
        <div class="f1">
          <el-avatar :src="artcle.imgUrl"></el-avatar>
          {{ artcle.userName }}
        </div>
        <div class="f2">
          <h3>{{ giveTitle() }}</h3>
          <div class="dongtai_img_div">
            <img
              v-for="(item1, index1) in artcle.content"
              :key="index1"
              :src="item1.content"
              v-if="!(item1.type == '标题')"
              alt=""
            />
          </div>
          <div v-if="artcle.sight.length > 0" class="dong_tai_sight">
            <i class="el-icon-location">{{ artcle.sight }}</i>
          </div>
          <div class="dong_tai_i">
            <i class="el-icon-thumb" v-show="!artcle.goDot" @click="increDot">{{
              artcle.dotCount
            }}</i>
            <i
              class="el-icon-thumb"
              style="color: orange"
              v-show="artcle.goDot"
              @click="dcrDot"
              >{{ artcle.dotCount }}</i
            >
            &nbsp;
            <i class="el-icon-chat-line-round">{{ artcle.commentsCount }}</i>
          </div>
        </div>
        <div class="f3">
          <div>
            <el-input
              type="textarea"
              :rows="2"
              maxlength="150"
              placeholder="请输入内容"
              v-model="commentContent"
            >
            </el-input>
            <div style="text-align:right;">
                <el-button type="success" @click="send()">评论</el-button>
            </div>
            
          </div>
          <div
            class="comment_item"
            v-for="(item, index) in commentList"
            :key="index"
          >
            <div class="comment_item_top">
              <el-avatar :src="item.imgUrl"></el-avatar>
              {{ item.name }}
            </div>
            <div>
              {{ item.content }}
            </div>
          </div>
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
      artcle: "",
      commentList: [],
      commentContent:""
    };
  },
  mounted() {
    this.artcle = JSON.parse(this.$route.query.artcle);
    this.axios
      .post(this.$root.dong_tai + "comment/list/" + this.artcle.dId)
      .then((res) => {
        this.commentList = res.data;
        console.log(this.commentList);
        this.commentList.forEach((element) => {
          element.imgUrl = element.imgUrl.replaceAll("^", "/");
        });
        this.artcle.commentsCount = this.commentList.length
      })
      .catch((err) => {
        console.error(err);
      });
  },
  methods: {
    send(){
        this.axios.post(this.$root.dong_tai+"uploadComments/"+this.artcle.dId+"/"+this.$cookies.get("uId")+"/"+this.commentContent)
        .then(res => {
            if(res.data){
                
                this.artcle.commentsCount++;
                let data = {
                    uId:this.$cookies.get("uId"),
                    name: this.$cookies.get("name"),
                    imgUrl : this.$cookies.get("imgUrl").replaceAll("^","/"),
                    content: this.commentContent
                }
                this.commentList.unshift(data)
                this.commentContent = ""
            }else{
                this.$message.error("评论内容请不要携带特殊字符")
            }
        })
        .catch(err => {
            console.error(err); 
            this.$message.error("评论内容请不要携带特殊字符")
        })
    },
    giveTitle() {
      for (let i = 0; i < this.artcle.content.length; i++) {
        if (this.artcle.content[i].type == "标题") {
          var title = this.artcle.content[i].content;
          return title;
        }
      }
    },
    increDot() {
      this.axios
        .post(
          this.$root.dong_tai +
            "/increDot/" +
            this.artcle.dId +
            "/" +
            this.$cookies.get("uId")
        )
        .then((res) => {
          if (res.data) {
            this.artcle.dotCount++;
            this.artcle.goDot = true;
          }
        })
        .catch((err) => {
          console.error(err);
        });
    },
    dcrDot() {
      this.axios
        .post(
          this.$root.dong_tai +
            "/decDot/" +
            this.artcle.dId +
            "/" +
            this.$cookies.get("uId")
        )
        .then((res) => {
          if (res.data) {
            this.artcle.dotCount--;
            this.artcle.goDot = false;
          }
        })
        .catch((err) => {
          console.error(err);
        });
    },
  },
};
</script>

<style scoped>
.dong_tai_sight {
  color: rgb(39, 38, 38);
  font-size: 14px;
  margin: 4px 0;
}
.dong_tai_i > i {
  cursor: pointer;
}
.dongtai_img_div > img {
  max-height: 120px;
  height: 120px;
  height: 100%;
  margin-right: 10px;
}
.dongTaiPageBody {
  background: rgb(250, 250, 250);
}
.dongTaiPageCon {
  width: 80%;
  margin: 0 auto;
  padding-top: 20px;
  padding-bottom: 20px;
}
.f1 {
  display: flex;
  align-items: center;
  background: white;
  border-radius: 4px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  padding: 10px;
}
.comment_item_top {
  display: flex;
  align-items: center;
}
.comment_item {
  background: white;
  border-radius: 4px;
  padding: 10px;
  margin-top: 14px;
}
.f2 {
  background: white;
  border-radius: 4px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  padding: 10px;
  margin-top: 10px;
}
</style>
(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-a38dd70a"],{4814:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"homePageInforManage"},[i("h2",[t._v("首页信息修改")]),i("hr"),i("div",{staticClass:"homePageInfor"},t._l(t.dataList,(function(e,s){return i("div",{key:s,staticClass:"homePageInforItem"},[i("img",{attrs:{src:e.imgUrl,alt:""}}),i("div",{staticClass:"title"},[i("div",[t._v(t._s(e.title))]),i("div",[t._v(t._s(e.tId))])]),i("i",{staticClass:"el-icon-delete",on:{click:function(i){return t.delPageShow(e.id)}}}),i("div",{staticClass:"time"},[i("div",[t._v(t._s(e.saveTime))]),i("div",[t._v(t._s(e.liveTime)+"(m)")])])])})),0),t._v("\n  标题\n  "),i("el-input",{attrs:{maxlength:"10"},model:{value:t.title,callback:function(e){t.title=e},expression:"title"}}),t._v("\n  上传预览图:\n  "),i("el-upload",{staticClass:"avatar-uploader",attrs:{action:"http://localhost:81/upload/","show-file-list":!1,"on-success":t.handleAvatarSuccess,"before-upload":t.beforeAvatarUpload}},[t.imgUrlShow?i("img",{staticClass:"avatar",attrs:{src:t.imgUrl}}):i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})]),i("div",[t._v("\n    旅游团信息id:\n    "),i("el-input-number",{attrs:{min:t.min},model:{value:t.tId,callback:function(e){t.tId=e},expression:"tId"}})],1),i("div",{staticStyle:{"margin-top":"10px"}},[t._v("\n    设置展示时间(分钟)\n    "),i("el-input-number",{attrs:{min:t.timeMin,step:1,"step-strictly":!0,"controls-position":"right"},model:{value:t.time,callback:function(e){t.time=e},expression:"time"}})],1),i("el-button",{attrs:{type:"success"},on:{click:function(e){return t.send()}}},[t._v("提交")])],1)},a=[],o={data:function(){return{title:"",imgUrl:"",imgUrlShow:!1,tId:1,min:1,timeMin:1,time:1,dataList:[]}},methods:{delPageShow:function(t){var e=this;console.log(t),this.axios.post(this.$root.team+"delHomePageShow",t).then((function(t){t.data&&e.getPageShowData()})).catch((function(t){console.error(t)}))},getPageShowData:function(){var t=this;console.log("-------"),this.axios.post(this.$root.team+"listHomePageShow").then((function(e){t.dataList=e.data,console.log(t.dataList)})).catch((function(t){console.error(t)}))},send:function(){var t=this;console.log(this.title+","+this.imgUrl+","+this.tId+","+this.time),this.axios.post(this.$root.team+"updateHomePageShow",{title:this.title,imgUrl:this.imgUrl,tId:this.tId,time:this.time}).then((function(e){e.data?(t.getPageShowData(),t.$message({message:"提交成功",type:"success"})):t.$message.error("提交错误，请检查信息后重试")})).catch((function(e){console.error(e),t.$message.error("提交错误，请检查信息后重试")}))},handleAvatarSuccess:function(t,e){this.imgUrl=t,this.imgUrlShow=!0,console.log(this.imgUrl)},beforeAvatarUpload:function(t){var e="image/jpeg"===t.type,i=t.size/1024/1024<2;return e||this.$message.error("上传头像图片只能是 JPG 格式!"),i||this.$message.error("上传头像图片大小不能超过 2MB!"),e&&i}},mounted:function(){console.log("+++++++++++"),this.getPageShowData()}},n=o,l=(i("ba89"),i("2877")),r=Object(l["a"])(n,s,a,!1,null,"2da8929e",null);e["default"]=r.exports},"4b9d":function(t,e,i){},ba89:function(t,e,i){"use strict";i("4b9d")}}]);
//# sourceMappingURL=chunk-a38dd70a.067fc93c.js.map
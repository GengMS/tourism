(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-402e9b0b"],{"113a":function(e,t,n){},9720:function(e,t,n){"use strict";n("113a")},feb3:function(e,t,n){"use strict";n.r(t);var o=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"lvYouTuanInfor"},[n("h2",[e._v("旅游团信息发布")]),n("label",[e._v("\n    标题:\n    "),n("el-input",{attrs:{maxlength:"50"},model:{value:e.teamInfor.introduce,callback:function(t){e.$set(e.teamInfor,"introduce",t)},expression:"teamInfor.introduce"}}),e._v("\n    商品图片:\n    "),n("el-upload",{staticClass:"upload-demo",attrs:{action:"http://localhost:81/upload","on-remove":e.handleRemove,"on-success":e.handleAvatarSuccess,"before-upload":e.beforeAvatarUpload,"list-type":"picture"}},[n("el-button",{attrs:{size:"small",type:"primary"}},[e._v("点击上传")]),n("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[e._v("\n        只能上传jpg/png文件，且不超过500kb\n      ")])],1)],1),n("label",[e._v("\n    价格:\n    "),n("el-input-number",{model:{value:e.teamInfor.price,callback:function(t){e.$set(e.teamInfor,"price",t)},expression:"teamInfor.price"}})],1),n("br"),n("br"),n("div",[n("label",[e._v("\n    出发地:\n    "),n("el-cascader",{attrs:{size:"large",options:e.options},on:{change:e.handleChange1},model:{value:e.selectedOptions,callback:function(t){e.selectedOptions=t},expression:"selectedOptions"}})],1),n("label",[e._v("\n    目的地:\n    "),n("el-cascader",{attrs:{size:"large",options:e.options},on:{change:e.handleChange2},model:{value:e.selectedOptions2,callback:function(t){e.selectedOptions2=t},expression:"selectedOptions2"}})],1)]),n("br"),n("br"),n("label",[e._v("\n      路径介绍:\n    "),n("el-steps",{attrs:{direction:"vertical"}},e._l(e.teamInfor.buZhou,(function(t,o){return n("label",{key:o},[n("el-step",{attrs:{title:"步骤"+(o+1),description:e.teamInfor.buZhou[o]}}),n("el-input",{attrs:{type:"text"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.addBu(t)}},model:{value:e.teamInfor.buZhou[o],callback:function(t){e.$set(e.teamInfor.buZhou,o,t)},expression:"teamInfor.buZhou[index]"}})],1)})),0)],1),n("hr"),n("label",[e._v("\n      旅游提供商:\n      "),n("el-input",{attrs:{maxlength:"50"},model:{value:e.teamInfor.provider,callback:function(t){e.$set(e.teamInfor,"provider",t)},expression:"teamInfor.provider"}})],1),n("el-button",{attrs:{type:"success"},on:{click:e.send}},[e._v("\n      提交\n  ")])],1)},a=[],s=n("ef6c"),i={data:function(){return{options:s["regionData"],selectedOptions:[],selectedOptions2:[],teamInfor:{introduce:"",fileList:[],price:0,departure:"",destination:"",buZhou:[""],provider:""}}},methods:{send:function(){var e=this;if(0==this.teamInfor.introduce.length||0==this.teamInfor.fileList.length||this.teamInfor.price<=0||this.teamInfor.departure.length<=0||0==this.teamInfor.destination.length||0==this.teamInfor.buZhou.length||0==this.teamInfor.provider.length)this.$message.error("输入框为空或格式错误");else{JSON.stringify(this.teamInfor);this.axios.post(this.$root.team+"uploadTeamInfor",{introduce:this.teamInfor.introduce,fileList:this.teamInfor.fileList,price:this.teamInfor.price,departure:this.teamInfor.departure,destination:this.teamInfor.destination,buZhou:this.teamInfor.buZhou,provider:this.teamInfor.provider}).then((function(t){t.data&&e.$message({message:"发布成功",type:"success"})})).catch((function(e){console.error(e)}))}},handleRemove:function(e,t){console.log(e,t)},handlePreview:function(e){console.log(e)},handleAvatarSuccess:function(e,t){console.log(this.teamInfor.fileList.push(e))},beforeAvatarUpload:function(){if(this.teamInfor.fileList.length>=3)return console.log(this.teamInfor.fileList.length+"length-------"),this.$message.error("只能上传三张图片"),!1},handleChange1:function(e){console.log(e),this.teamInfor.departure=s["CodeToText"][e[0]]+"-"+s["CodeToText"][e[1]]+"-"+s["CodeToText"][e[2]]},handleChange2:function(e){console.log(e),this.teamInfor.destination=s["CodeToText"][e[0]]+"-"+s["CodeToText"][e[1]]+"-"+s["CodeToText"][e[2]]},addBu:function(){this.teamInfor.buZhou.length>=7?this.$message.error("步骤最多为7条"):this.teamInfor.buZhou.push("")}}},r=i,l=(n("9720"),n("2877")),u=Object(l["a"])(r,o,a,!1,null,null,null);t["default"]=u.exports}}]);
//# sourceMappingURL=chunk-402e9b0b.f7899b2d.js.map
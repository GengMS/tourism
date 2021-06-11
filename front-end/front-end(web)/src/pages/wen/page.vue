<template>
  <div>
    <el-card style="height: 610px;">
      <quill-editor v-model="content" ref="myQuillEditor" style="height: 500px;" :options="editorOption">
      </quill-editor>
    </el-card>
  </div>
</template>

<script>
  import { quillEditor } from 'vue-quill-editor'
  import 'quill/dist/quill.core.css'
  import 'quill/dist/quill.snow.css'
  import 'quill/dist/quill.bubble.css'

	export default {
	  name: "ActicleInfo",
	  components: {
	    quillEditor
	  },
    data() {
      return {
        content: null,
        editorOption: {}
      }
    },
    watch: {
        content:function(val){
            console.log(val)
        }
    },
    mounted () {
        setTimeout(() => {
            console.log(this.content)
        }, 5000);
    }
  }

</script>

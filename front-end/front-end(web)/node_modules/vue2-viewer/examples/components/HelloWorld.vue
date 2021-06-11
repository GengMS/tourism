<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>单张图</h2>
    <vue-viewer style="display: inline-block"
      :thumb="image"
      title='单张图实例'
      :full="image">
    </vue-viewer>
    <h2>多张图</h2>
    <vue-viewer multiple
      :thumb="imageList"
      :title='multiTitles'
      list-ul-class="image-list"
      :full="imageList">
      <template slot-scope="target">
        <span class="icon-remove" @click.stop="onRemove(target.index)" style="">&times;</span>
      </template>
    </vue-viewer>
  </div>
</template>

<script>
export default {
  name: 'viewer-demo',
  data() {
    return {
      msg: 'vue2-viewer-demo',
      image: '/images/girl.jpg',
      imageList: [
        // eslint-disable-next-line max-len
        '/images/girl.jpg',
        '/images/girl2.jpg',
        '/images/girl3.jpg'
      ],
      multiTitles: ['多图1', '多图2']
    };
  },
  methods: {
    onRemove(index) {
      alert(index);
    }
  }
};
</script>

<style>
.image-list{
  margin: 0; padding: 0
}
.image-list li {
  display: inline-block;
  margin: 0 10px;
  list-style: none;
  position: relative;
}
.image-list li img {
  box-shadow: 0 0 5px #333;
}
.icon-remove{
  width: 20px; height:20px;
  text-align: center; line-height: 20px;
  background:#f33;
  position:absolute; top:-10px; right:-10px;
  border-radius: 10px;
  cursor: pointer;
  color:#fff;
}
a {
  color: #42b983;
}
</style>

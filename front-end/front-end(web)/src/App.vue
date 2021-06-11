<template>
  <router-view/>
</template>
<script>
export default {
  provide(){
      return{
        reload:this.reload
      }
    },
}
</script>

<style>
  .cotainer {
  width: 80%;
  margin: 0 auto;
  min-width: 1200px;
}
</style>

import Vue from 'vue';
import App from './App.vue';

Vue.config.productionTip = false;
import ImageViewer from '../packages';
// import ImageViewer from '../lib/vue2-viewer.umd';
// import ImageViewer from 'vue2-viewer';
Vue.use(ImageViewer);
new Vue({
  render: h => h(App),
}).$mount('#app');

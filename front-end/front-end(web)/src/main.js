import Vue from 'vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import 'normalize.css/normalize.css';
import './styles/index.scss';
import App from './App.vue';
import router from './router';
import VueCookies from 'vue-cookies'

import axios from 'axios'
import VueAxios from 'vue-axios'

import ImageViewer from 'vue2-viewer';
Vue.use(ImageViewer);
Vue.use(VueAxios, axios)
Vue.use(VueCookies)
Vue.use(ElementUI);
router.beforeEach((to, from, next) => {
  
  console.log(to.path.indexOf("dashboard"))
  if(to.path == "/lvtu" || to.path == "/dongtai"){
    if(VueCookies.get("uId") == null || VueCookies.get("uId").length == 0){
      next("/login");
    }else{
      next()
    } 
  }
  else if(to.path.indexOf("dashboard") >= 1){
    
    if(VueCookies.get("identity") == 0 || VueCookies.get("identity").length == 0){
      
      next("/login");
    }else{
      next()
    }
  }
  else{
    next();
  }
 
})
Vue.config.productionTip = false;

new Vue({
  router,
  render: h => h(App),
  data () {
    return {
      loginUrl:"http://localhost:81/",
      lv_tu:"http://localhost:82/",
      dong_tai:"http://localhost:83/",
      team:"http://localhost:84/"
    }
  }
}).$mount('#app');

import VueViewer from './viewer/index.vue';
let obj = {};
obj.install = function(Vue) {
  Vue.component(VueViewer.name, VueViewer);
};
export {
  VueViewer
};
export default obj.install;
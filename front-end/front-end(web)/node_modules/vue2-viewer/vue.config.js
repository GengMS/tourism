const path = require('path');
function resolve(dir) {
  return path.join(__dirname, dir);
}
module.exports = {
  // 将 examples 目录添加为新的页面
  publicPath: '/vue2-viewer/dist',
  pages: {
    index: {
      // page 的入口
      entry: 'examples/main.js',
      // 模板来源
      template: 'public/index.html',
      // 输出文件名
      filename: 'index.html'
    }
  },
  css: {
    extract: false
  },
  chainWebpack: config => {
    config.resolve.alias
      .set('@', resolve('examples'))
      .set('vue$', 'vue/dist/vue.esm.js');
  },
};
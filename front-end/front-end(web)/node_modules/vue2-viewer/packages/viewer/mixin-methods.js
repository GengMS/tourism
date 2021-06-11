/* eslint-disable no-nested-ternary */
export default {
  methods: {
    /**
     * 全屏显示
     * @param {Object} el 要全屏显示的dom节点
     */
    fullScreen(el) {
      const isFullscreen=document.fullScreen||document.mozFullScreen||document.webkitIsFullScreen;
      if (!isFullscreen) { // 进入全屏,多重短路表达式
        (el.requestFullscreen&&el.requestFullscreen())||
        (el.mozRequestFullScreen&&el.mozRequestFullScreen())||
        (el.webkitRequestFullscreen&&el.webkitRequestFullscreen())||(el.msRequestFullscreen&&el.msRequestFullscreen());
      } else {	// 退出全屏,三目运算符
        document.exitFullscreen?document.exitFullscreen():
          document.mozCancelFullScreen?document.mozCancelFullScreen():
            document.webkitExitFullscreen?document.webkitExitFullscreen():'';
      }
    },
    /**
     * 重置大图的状态
     * @param {*} index
     */
    resetFullImageStatus(index) {
      this.$data.listActiveIndex = index;
      var img = this.$refs['fullImage'];
      if (!img) return false;
      img.style.display = 'none';
      setTimeout(() => {
        let fullImageSizeAry = this.getImgNaturalStyle(img);
        this.$data.fullImageWidth = fullImageSizeAry[0];
        this.$data.fullImageHeight = fullImageSizeAry[1];
        img.style.display = '';
      }, 300);
    },
    /**
     * 显示大图，如果是多图需要指定显示的图片的序号
     * @param {Number} index
     */
    showFullViewer(index) {
      this.$data.fullViewerVisible = true;
      this.resetFullImageStatus(index);
    },
    switchActiveIndex(index) {
      this.resetFullImageStatus(index);
    },
    hideFullViewer() {
      this.$data.fullViewerVisible = false;
    },
    /**
     * 放大
     */
    zoomIn() {
      this.$data.fullViewZoom += 0.1;
    },
    /**
     * 缩小
     */
    zoomOut() {
      this.$data.fullViewZoom -= 0.1;
    },
    /**
     * 大图鼠标滚轮
     */
    toggleZoomFullImage(obj) {
      // const zoom = parseInt(obj.style.zoom,10)||100;
      if (this.$data.animateTimer) {
        clearTimeout(this.$data.animateTimer);
        this.$data.animateTimer = null;
      }
      obj.target.classList.remove('animate-transform');
      const zoom = obj.wheelDelta / 12;
      if (zoom > 0) {
        this.$data.fullViewZoom += 0.1;
      } else if (this.$data.fullViewZoom > 1) {
        this.$data.fullViewZoom -= 0.1;
      }
      this.$data.animateTimer = setTimeout(() => {
        obj.target.classList.add('animate-transform');
      }, 400);
    },
    /**
     * 重置大小
     */
    resetFullImageSize() {
      this.$data.fullViewZoom = 1;
    },
    /**
     * 获取src指向的图片的宽高尺寸
     */
    getImgNaturalStyle(img, callback) {
      var nWidth, nHeight;
      if (img.naturalWidth) { // 现代浏览器
        nWidth = img.naturalWidth;
        nHeight = img.naturalHeight;
      } else {  // IE6/7/8
        var image = new Image();
        image.src = img.src;
        image.onload = function() {
          callback(image.width, image.height);
        };
      }
      return [nWidth, nHeight];
    },
    /**
     * 拖拽大图
     */
    mouseMove(e) {
      e.preventDefault();
      this.$data.fullImageMoveX += e.movementX;
      this.$data.fullImageMoveY += e.movementY;
    },
    /**
     * 重置大图的状态
     */
    resetFullImage() {
      this.$data.fullViewZoom = 1;
      this.$data.fullImageMoveX = 0;
      this.$data.fullImageMoveY = 0;
      this.$data.fullImageMoveX = 0;
      this.$data.fullImageMoveY = 0;
      this.$data.fullImageRotateX = 0;
      this.$data.fullImageScaleX = 0;
      this.$data.fullImageScaleY = 0;
    },
    /**
     * 水平方向上逆时针旋转
     */
    fullImageRotateLeft() {
      this.$data.fullImageRotateX -= 90;
    },
    /**
     * 水平方向上顺时针旋转
     */
    fullImageRotateRight() {
      this.$data.fullImageRotateX += 90;
    },
    /**
     * 水平方向翻转
     */
    toggleFullImageScaleX() {
      this.$data.fullImageScaleX = this.$data.fullImageScaleX === 0 ? -1 : 0;
    },
    /**
     * 垂直方向翻转
     */
    toggleFullImageScaleY() {
      this.$data.fullImageScaleY = this.$data.fullImageScaleY === 0 ? -1 : 0;
    },
    prev() {
      if (this.$data.listActiveIndex >= 1) {
        this.resetFullImage();
        this.switchActiveIndex(this.$data.listActiveIndex - 1);
      }
    },
    next() {
      if (this.$data.listActiveIndex < this.thumb.length - 1) {
        this.resetFullImage();
        this.switchActiveIndex(this.$data.listActiveIndex + 1);
      }
    },
    handleFullScreenChange() {
      const isFullscreen = document.fullScreen||document.mozFullScreen||document.webkitIsFullScreen;
      if (!isFullscreen && this.$data.fullPlayTimer) {
        clearInterval(this.$data.fullPlayTimer);
        this.$data.fullPlayTimer = null;
      }
    },
    /**
     * 监听全屏状态的变化
     */
    addFullScreenListener() {
      document.addEventListener('fullscreenchange', () => {
        this.handleFullScreenChange();
      });
      document.addEventListener('mozfullscreenchange', () => {
        this.handleFullScreenChange();
      });
      document.addEventListener('webkitfullscreenchange', () => {
        this.handleFullScreenChange();
      });
      document.addEventListener('msfullscreenchange', () => {
        this.handleFullScreenChange();
      });
    },
    /**
     * 点击播放按钮进入全拼播放
     */
    fullScreenPlay() {
      this.fullScreen(this.$el.querySelector('.full-image'));
      this.$data.fullPlayTimer = setInterval(() => {
        const currIndex = this.$data.listActiveIndex;
        if (currIndex >= this.thumb.length - 1) {
          this.$data.listActiveIndex = 0;
        } else {
          this.$data.listActiveIndex = currIndex + 1;
        }
        this.switchActiveIndex(this.$data.listActiveIndex);
      }, 2000);
    }
  }
};

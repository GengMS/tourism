<template>
  <span>
    <template v-if="Array.isArray(thumb)">
      <ul :class="listUlClass">
        <li v-for="(img, index) in thumb" :key="index" style="position:relative">
          <img width="100" height="80" @click="showFullViewer(index)"
            :src="img" alt=""/>
          <slot :index="index"></slot>
        </li>
      </ul>
    </template>
    <template v-else>
      <img width="100" height="80" @click="showFullViewer"
      :src="thumb" alt="">
    </template>
    <transition name="fade"
      enter-active-class="fadeIn"
      leave-active-class="fadeOut">
      <div v-show="fullViewerVisible" class="viewer-container viewer-backdrop viewer-fixed viewer-fade viewer-transition viewer-in"
        touch-action="none" style="z-index: 2015;">
        <div class="viewer-canvas" data-viewer-action="hide">
          <img ref="fullImage" @mousewheel="toggleZoomFullImage"
            :src="Array.isArray(full) ? full[listActiveIndex] : full"
            id="full-image" alt="" class="viewer-move full-image animate-transform"
            :style="fullImageStyle" />
        </div>
        <div class="viewer-footer">
          <div class="viewer-title">
          {{multiple ? title[listActiveIndex] || '-' : title}} ({{fullImageWidth}} &times; {{fullImageHeight}})
          </div>
          <div class="viewer-toolbar">
            <ul>
              <li role="button" class="viewer-zoom-in" @click="zoomIn" data-viewer-action="zoom-in"></li>
              <li role="button" class="viewer-zoom-out" @click="zoomOut" data-viewer-action="zoom-out"></li>
              <li role="button" class="viewer-one-to-one" @click="resetFullImageSize" data-viewer-action="one-to-one"></li>
              <li role="button" class="viewer-reset" @click="resetFullImage" data-viewer-action="reset"></li>
              <li role="button" class="viewer-prev" @click="prev" v-if="multiple" data-viewer-action="prev"></li>
              <li role="button" class="viewer-play viewer-large" @click="fullScreenPlay" v-if="multiple" data-viewer-action="play"></li>
              <li role="button" class="viewer-next" @click="next" v-if="multiple" data-viewer-action="next"></li>
              <li role="button" class="viewer-rotate-left" @click="fullImageRotateLeft" data-viewer-action="rotate-left"></li>
              <li role="button" class="viewer-rotate-right" @click="fullImageRotateRight" data-viewer-action="rotate-right"></li>
              <li role="button" class="viewer-flip-horizontal" @click="toggleFullImageScaleX" data-viewer-action="flip-horizontal"></li>
              <li role="button" class="viewer-flip-vertical" @click="toggleFullImageScaleY" data-viewer-action="flip-vertical"></li>
            </ul>
          </div>
          <div class="viewer-navbar" v-show="multiple">
            <ul v-if="multiple" class="viewer-list viewer-transition" :style="listStyle">
              <li v-for="(item, index) in thumb"
                :key="index"
                @click="switchActiveIndex(index)"
                :class="{'viewer-active': listActiveIndex === index}">
                <img :src="item" role="button" data-viewer-action="view" data-index="0"
                  data-original-url="images/tibet-1.jpg" alt="Cuo Na Lake" data-filled="true"
                  style="width: 50px; height: 50px; transform: translateX(-10px);" />
              </li>
            </ul>
          </div>
        </div>
        <div class="viewer-tooltip viewer-show viewer-fade viewer-transition">
          1%
        </div>
        <div role="button" @click="hideFullViewer" class="viewer-button viewer-close" data-viewer-action="mix"></div>
        <div class="viewer-player"></div>
      </div>
    </transition>
  </span>
</template>
<script>
import MxinMethods from './mixin-methods';
require('vue2-animate/dist/vue2-animate.min.css');
export default {
  name: 'vue-viewer',
  mixins: [MxinMethods],
  data() {
    return {
      animateTimer: null,
      fullPlayTimer: null,
      fullViewerVisible: false,
      fullViewZoom: 1,
      fullImageWidth: 0,
      fullImageHeight: 0,
      fullImageMoveX: 0,
      fullImageMoveY: 0,
      fullImageRotateX: 0,
      fullImageRotateY: 0,
      fullImageScaleX: 0,
      fullImageScaleY: 0,
      listActiveIndex: 0
    };
  },
  props: {
    thumb: {
      required: true,
    },
    full: {
      required: false,
    },
    multiple: {
      type: Boolean,
      default: false
    },
    listUlClass: {
      type: String,
      required: false
    },
    title: {
      required: false,
      default: '-'
    }
  },
  computed: {
    fullImageMarginLeft() {
      return 0 - this.$data.fullImageWidth / 2 + this.$data.fullImageMoveX;
    },
    fullImageMarginTop() {
      return 0 - this.$data.fullImageHeight / 2 - 87 + this.$data.fullImageMoveY;
    },
    // 大图样式
    fullImageStyle() {
      return {
        // eslint-disable-next-line max-len
        transform: `scale(${this.$data.fullViewZoom}) rotate(${this.$data.fullImageRotateX}deg) ${this.$data.fullImageScaleX === 0 ? '' : 'scaleX(' + -1 + ')' } ${this.$data.fullImageScaleY === 0 ? '' : 'scaleY(' + -1 + ')' }`,
        width: this.$data.fullImageWidth + 'px',
        height: this.$data.fullImageHeight + 'px',
        'margin-left': this.fullImageMarginLeft + 'px',
        'margin-top': this.fullImageMarginTop + 'px',
        position: 'absolute',
        left: '50%', top: '50%'
      };
    },
    // 列表的宽度
    listStyle() {
      return {
        width: Array.isArray(this.thumb) ? this.thumb.length * 31 + 'px' : 0,
        marginLeft: document.body.clientWidth / 2 - (this.$data.listActiveIndex + 1) * 31 + 'px'
      };
    }
  },
  methods: {},
  mounted() {
    this.resetFullImage();
    this.addFullScreenListener();
    this.$refs['fullImage'].addEventListener('mousedown', () => {
      document.body.addEventListener('mousemove', this.mouseMove);
    });
    this.$refs['fullImage'].addEventListener('mouseup', () => {
      document.body.removeEventListener('mousemove', this.mouseMove);
    });
  }
};
</script>
<style src="./style.css" scoped></style>

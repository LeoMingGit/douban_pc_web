<template>
  <div class="home-container">
    <div class="left-content">
      <div class="now-play play-section">
          <h2 class="title">好评榜</h2>
          <div class="section-bottom" v-if="nowplayList && nowplayList.length">
            <slider>
              <mitem v-for="item in nowplayList" :itemData="item" :key="item.id" /> 
            </slider>
          </div>
      </div>
      <div class="recent-play play-section">
          <h2 class="title">历年好评作品（2019）</h2>
          <div class="section-bottom" v-if="recentplayList.filter(movie => movie.year === 2019) && recentplayList.filter(movie => movie.year === 2019).length">
            <slider>
                 <mitem v-for="(_item,_index) in recentplayList.filter(movie => movie.year === 2019).sort((a, b) => b.goodCount - a.goodCount)" :itemData="_item" :key="_item.id" /> 
             </slider>
          </div>
      </div>
      <div class="recent-play play-section">
          <h2 class="title">历年好评作品（2018）</h2>
          <div class="section-bottom" v-if="recentplayList.filter(movie => movie.year === 2018) && recentplayList.filter(movie => movie.year === 2018).length">
            <slider>
                 <mitem v-for="(_item,_index) in recentplayList.filter(movie => movie.year === 2018).sort((a, b) => b.goodCount - a.goodCount)" :itemData="_item" :key="_item.id" /> 
             </slider>
          </div>
      </div>
      <div class="recent-play play-section">
          <h2 class="title">历年好评作品（2017）</h2>
          <div class="section-bottom" v-if="recentplayList.filter(movie => movie.year === 2017) && recentplayList.filter(movie => movie.year === 2017).length">
            <slider>
                 <mitem v-for="(_item,_index) in recentplayList.filter(movie => movie.year === 2017).sort((a, b) => b.goodCount - a.goodCount)" :itemData="_item" :key="_item.id" /> 
             </slider>
          </div>
      </div>
      <div class="recent-play play-section">
          <h2 class="title">历年好评作品（2016）</h2>
          <div class="section-bottom" v-if="recentplayList.filter(movie => movie.year === 2016) && recentplayList.filter(movie => movie.year === 2016).length">
            <slider>
                 <mitem v-for="(_item,_index) in recentplayList.filter(movie => movie.year === 2016).sort((a, b) => b.goodCount - a.goodCount)" :itemData="_item" :key="_item.id" /> 
             </slider>
          </div>
      </div>
      <div class="recent-play play-section">
          <h2 class="title">历年好评作品（2015）</h2>
          <div class="section-bottom" v-if="recentplayList.filter(movie => movie.year === 2015) && recentplayList.filter(movie => movie.year === 2015).length">
            <slider>
                 <mitem v-for="(_item,_index) in recentplayList.filter(movie => movie.year === 2015).sort((a, b) => b.goodCount - a.goodCount)" :itemData="_item" :key="_item.id" /> 
             </slider>
          </div>
      </div>
    </div>

  </div>
</template>

<script>
  import mitem from '@/components/mitem/mitem.vue'
  import slider from '@/components/slider/slider.vue'
  import {reactive,ref,computed} from 'vue'
  
  import service from '@/utils/service'
  import Vuex from 'vuex'
  import configapi from '@/utils/configapi'
  import { useStore } from 'vuex'
  import { getTop } from '../../api/film';
  /**
   * 首页页面组件
   */
  export default {
    // 定义静态方法
    asyncData({store}) {
      return store.dispatch('getHomeMovieData')
    },
    name: 'home',// 组件的名称，尽量和文件名一致
    components: {
      mitem,
      slider
    },
    setup(){
      const store = useStore()
      // 从store获取数据
      let nowplayList = ref([]);
      let recentplayList = ref([]);
      let rankList = ref([]);

      return {
        nowplayList,
        recentplayList,
        rankList
      }
    },
    mounted: function() {
      this.dotgetTop();
    },
    methods: {
      dotgetTop() {
        var me = this;
        getTop().then(res => {
          if (res.status === 200) {
              debugger
             me.nowplayList=res.data.nowplayList;
             me.recentplayList=res.data.recentplayList;
             me.rankList=res.data.rankList;

          }
        }).catch(err => {
          console.log(err);
        })
      }
   }
  }
</script>
<style scoped lang="less">
  .home-container {
    display: flex;
  }
  .left-content {
    width: 705px;
  }
  .right-content {
    width: 300px;
    margin-left: 20px;
  }

  .title {
    font-size: 16px;;
    color: #111;
    padding-bottom: 10px;
    border-bottom: 1px solid #eaeaea;
    margin-bottom: 18px;
  }
  .now-play {
    min-height: 344px;
  }
  .recent-play {
    min-height: 365px;
  }
  .play-section {
    padding: 15px;
  }
  .recent-item {
    display: inline-block;
    width: 675px;
    white-space: normal;
  }
  .top-rank {
    margin-top: 68px;
  }
  .rank-item {
    padding: 7px 0;
    border-bottom: 1px solid #eaeaea;
    font-size: 13px;
    margin-bottom: 5px;
  }
  .rank-link {
    margin-left: 7px;
  }
  .coopt,.fans {
    margin-top: 50px;
  }
  .fans-list {
    display: flex;
  }
  .fans-item {
    text-align: center;
    margin-right: 20px;
  }
  .fans-img {
    width:40px;
    height: 40px;
    background-size: cover;
    margin-bottom: 10px;

    &.weibo {
      background-image: url('./imgs/home_weibo@2x.jpg');
    }
    &.weixin {
      background-image: url('./imgs/home_weixin@2x.jpg');
    }
    &.zhihu {
      border-radius: 3px;
      background-image: url('./imgs/home_zhihu@2x.jpg');
    }
  }
</style>

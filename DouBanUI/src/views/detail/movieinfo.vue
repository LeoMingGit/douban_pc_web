<template>
  <div class="movie-info"  v-if="detailData.movieId">
    <h1 class="title">{{detailData.movieName}}<span class="year">（{{detailData.year}}）</span></h1>
    <div class="desc-content" >
      <img class="mv-img" :src="detailData.picUrl" />
      <div class="mv-desc">
        <p>类型: <span class="it">{{detailData.genre}}</span></p>
        <p>标签: <span class="it">{{detailData.tags}}</span></p>
        <p>制片国家/地区: <span class="it">{{detailData.country}}</span></p>        
      </div>
      <div class="mv-rank">
        <div class="rank-title">豆瓣评分</div>
        <div class="rank-score">
          <div class="score"><strong class="num">{{detailData.average}}</strong></div>
          <div class="score-star">
            <rankstar :score="detailData.average" class="rankstar"/>
            <div class="score-comment"><a href="#">{{detailData.ratingPeople}}</a>人评价</div>
            <div class="score-comment"><a href="#">{{detailData.goodRateStr}}</a>&nbsp; 好评率</div>
            <div class="score-comment"><a href="#">{{detailData.goodCount}}</a>&nbsp; 好评数</div>
          </div>
        </div>
      </div>
    </div>
    <div class="intro">
      <h2 class="intro-title">
        {{detailData.movieName}}的剧情简介· · · · · ·
      </h2>
      <div style="text-indent:20px;">
        {{detailData.summary}}
      </div>
    </div>
  </div>
</template>

<script>
  import {ref,onMounted, reactive,computed} from 'vue'
  import rankstar from '@/components/rankstar/rankstar.vue'
  import Vuex from 'vuex'
  import {useRoute} from 'vue-router'
  import { getMovieDetailById } from '../../api/film'
  /**
   * 待办事项页面组件
   */
  export default {
    name: 'movieinfo',// 组件的名称，尽量和文件名一致
    components: {
      rankstar 
    },
    props: {
      movieId: {
        type: [Number, String],
        required: true
      }
    },
    mounted() {
      this.dotgetMovieDetailById();
    },
    setup(){
      const store = Vuex.useStore()
      let detailData = ref({})
      let actors = reactive({
        orgin:[],
        short:[],
        isShowMore: true
      })
      let rate = reactive({
        list:[],
        betterList:[]
      })
      const route = useRoute()
      const expand = ()=>{
        actors.short = actors.orgin
        actors.isShowMore = false
      }
      
      return {
        detailData,
        actors,
        expand,
        rate
      }
    },
    methods:{
      dotgetMovieDetailById() {
        var me = this;
        getMovieDetailById(this.movieId).then(res => {
          if (res.status === 200) {
             me.detailData=res.data;
            }
         }).catch(err => {
            console.log(err);
         })
      }
    }
  }
</script>
<style scoped lang="less">

  .title {
    font-size: 26px;
    font-weight: bold;
    color: #494949;
    .year {
      color: #888;
    }
  }
  .desc-content {
    display: flex;
    margin-top: 13px;
  }
  .mv-img {
    width: 135px;
    height: 200px;
  }
  .mv-desc {
    font-size: 13px;
    margin-left:15px;
    max-width: 333px;
    margin-right: 15px;
    p {
      margin: 2px 0;
      color: #666;
      .it {
        color: #111;
      }
    }
  }
  .more-actors {
    color: #aaa;
    cursor: pointer;
    &:hover {
      color: #fff;
      background: #aaa;
    }
  }
  .mv-rank {
    width: 155px;
    margin: 2px 0 0 0;
    padding: 0 0 0 15px;
    border-left: 1px solid #eaeaea;
    color: #9b9b9b;
    
  }
  .rank-score {
    margin-top: 5px;
    display: flex;
    .num {
      color: #494949;
      padding: 0;
      font-size: 28px;
    }
  }
  .score-star {
    margin-left: 10px;
    padding-top: 5px;
    .rankstar {
      transform: scale(1.3);
      transform-origin: 0 0;
    }
  }
  .score-comment {
    margin-top: 7px;
  }
  .rate-item {
    display: flex;
  }
  .wline {
    height: 10px;
    margin: 1px 4px;
    background-color: #ffd596;
    falign-self: center;
  }
  .better-content {
    position: relative;
    padding: 15px 0;
    border-top: 1px solid #eaeaea;
    color: #9b9b9b;
    margin-top: 20px;
  }
  .better-item {
    margin-top: 1px;
  }
  .intro-title {
    margin: 24px 0 12px 0;
    font-size: 16px;
    color: #007722;
  }
  .comment-link {
    font-size: 13px;
  }
</style>

<template>
  <div class="search-container">
    <h1 class="page-title">搜索：{{$route.query.searchText}}</h1>
    <div class="search-result">
      <div v-if="currentFilms.length == 0">暂无搜索数据</div>
      <div class="item-content" v-for="item in currentFilms">
        <img :src="item.picUrl" class="item-img" />
        <div class="left-content">
          <router-link :to="'/detail?id='+item.movieId"  class="title">{{item.movieName}}</router-link>
          <div class="rank-content">
            <rankstar :score="item.average" class="rank-star"></rankstar>
            <div class="score-text">{{item.average}}</div>
          </div>
          <div class="place">{{item.genre}}</div>
        </div>
      </div>
    </div>
    
  </div>
</template>

<script>
  import {reactive,ref,computed,onMounted,watch} from 'vue'
  
  import service from '@/utils/service'
  import Vuex from 'vuex'
  import {useRoute} from 'vue-router'
  import moment from 'moment'
  import rankstar from '@/components/rankstar/rankstar.vue'
  import configapi from '@/utils/configapi'
  import { getMoviesByKeyword } from '../../api/film';

  /**
   * 待办事项页面组件
   */
  export default {
    name: 'search',// 组件的名称，尽量和文件名一致
    components:{
      rankstar
    },
    setup(){
      const currentPage = ref(1);
      const pageSize = ref(10);
      const total = ref(1);
      const currentFilms = ref([]);

      let movieData = ref({})
      let content = ref('')
      let searchList = reactive({
        list:[]
      })
      const route = useRoute()
      let searchText = computed(() => route.query.searchText);
      onMounted(async ()=>{

      })
      
      return {
        searchList,
        currentPage,
        pageSize,
        total,
        currentFilms,
        searchText,
      }
    },
    computed: {

    },
    mounted: function() {

       this.dotGetMoviesByKeyword();
    },
    methods: {
      dotGetMoviesByKeyword() {
        const data = {
          pageIndex: this.currentPage,
          pageSize: this.pageSize,
          keyword: this.searchText
        };
        var me = this;
        getMoviesByKeyword(data).then(res => {
          if (res.status === 200) {
            me.currentFilms = res.data.rows;
            me.total = res.data.total;
          }
        }).catch(err => {
          console.log(err);
        })
      }
    
   }
  }
</script>
<style scoped lang="less">
  .search-container {
    
    // width: 790px;
    margin: 0 auto;
  }
  .page-title {
    margin-top: 25px;
    font-size: 25px;
    font-weight: bold;
    margin-bottom: 30px;
    padding: 0;
    color: #494949;
  }
  .item-content {
    display: flex;
    padding: 10px;;
    .item-img {
      width: 48px;
      height: 69px;
      margin-right: 15px;
    }
    .title {
      font-size: 14px;
    }
    .rank-content {
      display: flex;
    }
    .rank-star {
      margin-top: 3px;
      margin-right: 3px;
    }
    .score-text {
      color: #e09015;
    }
  }
  

</style>

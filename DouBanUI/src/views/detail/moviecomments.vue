<template>
  <div class="movie-comments" v-if="currentComments.length">
    <h2 class="intro-title">
      {{title}}的影评· · · · ·
    </h2>
    <ul class="top-tab tabs clearfix">
      <li :class="{ 'selected': activeTab === 2 }">
        <a href="javascript:;" @click="selectTab(2)"><span>全部&nbsp; &nbsp;</span></a>
      </li>
      <li :class="{ 'selected': activeTab === 1 }">
        <a href="javascript:;" @click="selectTab(1)"><span>好评&nbsp;&nbsp; </span></a>
      </li>
      <li :class="{ 'selected': activeTab === 0 }">
        <a href="javascript:;" @click="selectTab(0)"><span>差评&nbsp;&nbsp; </span></a>
      </li>
    </ul>
    <div class="scroll-wrap">
      <div class="comment-item" v-for="item in currentComments||[]">
        <div class="top-content">
          <img class="avatar" src="https://img1.doubanio.com/icon/up1939857-118.jpg"/>
          <span class="nickname">{{item.personname}}</span>
          <svg v-if="1==item.islike" t="1702894179634" class="svg1" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4234" width="200" height="200"><path d="M832 364.8h-147.2s19.2-64 32-179.2c6.4-57.6-38.4-115.2-102.4-121.6h-12.8c-51.2 0-83.2 32-102.4 76.8l-38.4 96c-32 64-57.6 102.4-76.8 115.2-25.6 12.8-121.6 12.8-128 12.8H128c-38.4 0-64 25.6-64 57.6v480c0 32 25.6 57.6 64 57.6h646.4c96 0 121.6-64 134.4-153.6l51.2-307.2c6.4-70.4-6.4-134.4-128-134.4z m-576 537.6H128V422.4h128v480z m640-409.6l-51.2 307.2c-12.8 57.6-12.8 102.4-76.8 102.4H320V422.4c44.8 0 70.4-6.4 89.6-19.2 32-12.8 64-64 108.8-147.2 25.6-64 38.4-96 44.8-102.4 6.4-19.2 19.2-32 44.8-32h6.4c32 0 44.8 32 44.8 51.2-12.8 102.4-32 166.4-32 166.4l-25.6 83.2h243.2c19.2 0 32 0 44.8 12.8 12.8 12.8 6.4 38.4 6.4 57.6z" p-id="4235" fill="#1296db"></path></svg>
          <svg v-if="1!=item.islike" t="1702894350329" class="svg2" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="8098" width="200" height="200"><path d="M1022.4 580.8L928 176c-6.4-30.4-35.2-128-169.6-128H488c-14.4 0-24 11.2-24 24S473.6 96 488 96h270.4c91.2 0 115.2 54.4 121.6 88v3.2l94.4 403.2c-1.6 40-33.6 70.4-73.6 70.4H712c-19.2 0-36.8 8-49.6 22.4-12.8 14.4-17.6 33.6-16 52.8l9.6 76.8c6.4 49.6-20.8 96-62.4 110.4-27.2 9.6-54.4 6.4-78.4-6.4-24-12.8-41.6-36.8-48-62.4-3.2-14.4-12.8-33.6-17.6-41.6l-16-30.4c-24-44.8-75.2-104-115.2-139.2-16-14.4-24-33.6-24-54.4V46.4H148.8c-67.2 0-121.6 54.4-121.6 121.6v364.8c0 67.2 54.4 121.6 121.6 121.6h118.4c4.8 8 11.2 16 19.2 24 35.2 32 83.2 86.4 104 126.4l16 30.4c4.8 9.6 11.2 22.4 12.8 30.4 9.6 40 36.8 75.2 72 94.4 36.8 19.2 78.4 22.4 118.4 9.6 64-22.4 104-91.2 96-163.2l-9.6-76.8c-1.6-6.4 1.6-11.2 4.8-14.4 1.6-1.6 6.4-6.4 12.8-6.4h188.8c67.2 0 121.6-54.4 121.6-121.6l-1.6-6.4z m-777.6 24h-96c-40 0-73.6-32-73.6-73.6V168C75.2 128 108.8 96 148.8 96h97.6v508.8z" fill="#1296db" p-id="8099"></path></svg>
        </div>
        <div class="content three-line">{{item.info}}</div>
      </div>
    </div>
  </div>
</template>

<script>
  import {ref,onMounted,computed, reactive} from 'vue'
  import service from '@/utils/service'
  import rankstar from '@/components/rankstar/rankstar.vue'
  import Vuex from 'vuex'
  import {useRoute} from 'vue-router'
  import { getCommentsByMovieId ,getMovieDetailById} from '../../api/film'

  /**
   * 待办事项页面组件
   */
  export default {
    name: 'moviecomments',// 组件的名称，尽量和文件名一致
    components: {
      rankstar
    },
    props: {
      movieId: {
        type: [Number, String],
        required: true
      }
    },
    setup(){
      const currentPage = ref(1);
      const pageSize = ref(99999);
      const total = ref(1);
      const currentComments = ref([]);
      const store = Vuex.useStore()
      const title =ref("");
      var  activeTab =ref(2);
      const incommentList = computed(() => store.state.commentList);
      let detailData = reactive({
        list:[]
      })
      const route = useRoute()
      let id = computed(() => route.query.id);
      onMounted(async () => {
        let data = await service.get(configapi.comments(id.value),{
          start:0,
          count:20
        })
        detailData.list = incommentList.value.concat(data.reviews || [])
      });
      return {
        detailData,
        title,
        currentComments,
        activeTab,
        currentPage,
        pageSize,
      }
    },
    mounted() {
       this.dotgetMovieDetailById();
       this.dotgetCommentsByMovieId();
    },
    methods:{
      dotgetMovieDetailById() {
        var me = this;
        getMovieDetailById(this.movieId).then(res => {
          if (res.status === 200) {
              me.title =res.data.movieName;
          }
         }).catch(err => {
          console.log(err);
        })
      },
      dotgetCommentsByMovieId() {
        const data = {
          movieId:this.movieId,
          type :this.activeTab,
          current: this.currentPage,
          size: this.pageSize,
        };
        var me = this;
        getCommentsByMovieId(data).then(res => {
          if (res.status === 200) {
             me.currentComments=res.data.rows;
          }
        }).catch(err => {
          console.log(err);
        })
      },
       selectTab(tabIndex) {
        this.activeTab = tabIndex;
        this.dotgetCommentsByMovieId();
       },
    }
  }
</script>
<style scoped lang="less">

  .intro-title {
    margin: 24px 0 12px 0;
    font-size: 16px;
    color: #007722;
  }
  .top-content {
    display: flex;
    align-items: center;
    .avatar {
      width: 24px;
      height: 24px;
    }
    .nickname {
      font-size: 13px;
      margin-left: 10px;
      color: #37a;
      margin-right: 10px;;
    }
    .time {
      font-size: 13px;
      margin-left: 10px;
      color: #999;
    }
  }
  .comment-item {
    padding: 20px 0px;
    position: relative;
    border-top: 0.5px solid #ddd;
    margin-bottom: 5px;
  }
  .rankstar {
    display: flex;
    align-items: center;
  }
  .rank-text {
    margin-right: 3px;
  }
  .content {
    margin-top: 10px;
    color: #666;
    font-size: 13px;
    line-height: 1.5;
  }
.top-tab.tabs {
  padding-bottom: 9px;
  border-bottom: 1px solid #eee;
}
.top-tab {
    font-size: 13px;
    color: #37a;
}
.top-tab>li {
    float: left;
}
li {
    display: list-item;
    text-align: -webkit-match-parent;
}
ul, ol {
    list-style: none;
}
.selected{
  a:link{
    color: black;
    text-decoration: none;
  }
}
.svg1 {
  width:30px;
  height:15px;
}
.svg2 {
  margin-top:2px;
  width:30px;
  height:15px;
}
</style>

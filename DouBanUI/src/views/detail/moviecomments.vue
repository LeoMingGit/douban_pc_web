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
  import configapi from '@/utils/configapi'
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
          pageIndex: this.currentPage,
          pageSize: this.pageSize,
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
        debugger
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
</style>

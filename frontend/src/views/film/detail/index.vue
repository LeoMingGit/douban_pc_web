<template>
 <div>
      <div class="subject clearfix subjectwrap">
        <h1>
          <span>{{ film.movieName }}</span>
        </h1>
        <div class="movie-container">
          <img :src="film.picUrl" alt="瞒天过海" title="点击看更多海报" class="movie-poster" />
        </div>
        <div class="info">
          <div class="flex-item">
            <span class="pl">类型:</span> <span>{{ film.genre }}</span>
          </div>
          <div class="flex-item">
            <span class="pl">标签:</span> <span>{{ film.tags }}</span>
          </div>
          <div class="flex-item">
            <span class="pl">制片国家/地区:</span>{{ film.country }}
          </div>
          <div class="summary">
            {{ film.summary }}
          </div>
        </div>
      </div>
      <div class="commentParent">
        <div v-for="(item, index) in commentList" class="commentList">
             <el-row>
               <el-col :span="4">
                <div class="comment-left inline-div ">
                   <img src="../../../assets/avatar.jpg" class="avatar"/>
                   <div class="nickname">{{ item.nickName }}</div>
                </div>
               </el-col>
               <el-col :span="20">
                <div class="comment-right inline-div ">
                   <div class="comment">{{ item.comment }} </div>
                 </div>
               </el-col>
             </el-row>
              <div class="content">


               </div>
            </div>
       </div>
 </div>

</template>


<script>

export default {
  name:"FilmCellDetail",
  data() {
    return {
      film: "",
      commentList:[
         {nickName:"某物ddd",comment:"我看了，觉得片子没他写的这么好而已。写的是真好，比片子还好。"},
         {nickName:"某物某物某物某物",comment:"我看了，觉得片子没他写的这么好而已。写的是真好，比片子还好。"},
         {nickName:"某物某物某物",comment:"我看了，觉得片子没他写的这么好而已。写的是真好，比片子还好。"},
         {nickName:"某物",comment:"我看了，觉得片子没他写的这么好而已。写的是真好，比片子还好。"},
         {nickName:"某物",comment:"我看了，觉得片子没他写的这么好而已。写的是真好，比片子还好。"},
         {nickName:"某物",comment:"我看了，觉得片子没他写的这么好而已。写的是真好，比片子还好。"},
         {nickName:"某物",comment:"我看了，觉得片子没他写的这么好而已。写的是真好，比片子还好。"},
         {nickName:"某物",comment:"我看了，觉得片子没他写的这么好而已。写的是真好，比片子还好。"},
         {nickName:"某物",comment:"我看了，觉得片子没他写的这么好而已。写的是真好，比片子还好。"},

      ]
    };
  },
  computed: {
    displayAverage() {
      return this.film && this.film.average ? this.film.average : 0;
    },
    displayRatingPeople() {
      return this.film && this.film.ratingPeople ? this.film.ratingPeople : 0;
   }
  },
  created() {
     this.film = this.$route.params.film;

  },
  methods: {}
};
</script>

<style>
.movie-container {
  text-align: center;
  /* float: left; */
  margin: 3px 12px 0 32px;
  /* max-width: 155px; */
  overflow: hidden;
}

.movie-title {
  display: block;
  margin-bottom: 10px;
}

.movie-poster {
  width: 135px;
  height: 191px;
}
.info {
  float: left;
  /* max-width: 333px; */
  margin-left: 16px;
  margin-top: 46px;
 }
 .clearfix{
  clear:both;
  }
 .clearfix::after {
  content: "";
  display: table;
  clear: both;
}
 .subjectwrap {
    position: none;
    float: none;
    width: auto;
}
/* .subject {
    width: 500px;
} */
.pl {
    font: 12px Arial, Helvetica, sans-serif;
    line-height: 150%;
    color: #666666;
}
.attrs{
  font: 12px Arial, Helvetica, sans-serif;
    line-height: 150%;
    color: #666666;
}

.summary{
  padding: 11px 18px;
  text-align: left;
}
.commentParent{
  margin-top: 40px;

 }
.commentList {
  margin-top: 20px;
  margin-bottom: 20px;
  text-align: left;
}
.avatar {
  width: 50px;
  height: 50px;
  border-radius: 50%;
}
.inline-div {
  display: inline-block;
}
.comment-left{
  margin-left: 17px;
}
.comment-right {
  flex-grow: 1;
  margin-left: 10px;
  margin-top: -30px;
}
.comment{
  min-height: 58.7px;
  padding-top: 46px;

}
.nickname{
  color: #999;
  font-size: 14px;
  margin-left: 3px;
}
</style>

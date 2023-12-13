<template>
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

  <!--电影总结-->
</template>


<script>
export default {
  name:"FilmCellDetail",
  data() {
    return {
      film: "",
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
  display: block;
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
</style>

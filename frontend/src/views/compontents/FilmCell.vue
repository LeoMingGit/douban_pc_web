<template>
  <div class="FilmCell" style="margin-left:3rem;margin-right:4rem">
    <p class="ul"></p>
    <el-row>
      <!--左侧-->
      <el-col :span="4">
        <a title="" class="nbg" href="javascript:void(0)" @click="Describe">
          <img width="85" alt="" :src="film.picUrl">
        </a>
      </el-col>
      <!--右侧-->
      <el-col :span="12" class="el-col-right">
        <!--电影名称-->
        <el-row>
          <a title="" class="nbg" href="javascript:void(0)" @click="Describe">
            <p style="font-size:16px;">{{ film.movieName }}</p>
          </a>
        </el-row>
        <!--评分-->
        <el-row>
          <el-col :span="10">
            <el-rate v-model="film.average / 2" disabled text-color="#ff9900"></el-rate>
          </el-col>
          <el-col :span="2">
            <span class="pl" style="float: left;color:#E09015">{{ displayAverage }}分</span>
          </el-col>
          <el-col :span="7">
            <span class="pl" style="float: left;margin-left:1rem;">({{ displayRatingPeople }}人评价)</span>
          </el-col>

        </el-row>
        <!--类型-->
        <el-row>
          <div class="pl" style="color:#909399">{{ film.genres }}</div>
        </el-row>
        <!--演员导演-->
        <el-row>
          <div class="pl" style="color:#909399">{{ film.tags }}</div>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<script>
	export default {
		name: 'FilmCell',
    props: {
      film: {
        type: Object,
        default: () => ({})
      }
    },
    computed: {
    displayAverage() {
      return this.film && this.film.average ? this.film.average : 0;
    },
    displayRatingPeople() {
      return this.film && this.film.ratingPeople ? this.film.ratingPeople : 0;
    }
  },
		data() {
			return {
			};
		},
		created(){
		},
		methods: {
			Describe() {
				this.$parent.getDescribe(this.film)
			},
		}
	}
</script>
<style scoped>
	.ul {
		border-bottom: 1px dashed #DDDDDD;
		line-height: 100%;
		clear: both;
	}

	tr {
		display: table-row;
		vertical-align: inherit;
		border-color: inherit;
	}

	.pl2 {
		font: 16px Arial, Helvetica, sans-serif;
		line-height: 150%;
		color: #666666;
	}

	/* .pl {
		white-space: normal;
		font-size: 13px;
	} */

	.clearfix {
		display: block;
	}


	a {
		cursor: pointer;
		color: #37a;
		text-decoration: none;
	}

	.rating_nums {
		padding-left: 0;
	}

	.rating_nums,
	.rating_num {
		color: #e09015;
		font-size: 15px;
		padding: 0 3px;
	}

	.pl {
		font: 15px Arial, Helvetica, sans-serif;
		line-height: 150%;
		color: #666666;
	}
.el-col-right {
  text-align: left;
}
</style>

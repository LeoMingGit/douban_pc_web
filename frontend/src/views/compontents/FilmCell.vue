<template>
  <div class="FilmCell" style="margin-left:3rem;margin-right:4rem">
    <p class="ul"></p>
      <el-row>
        <!--左侧-->
        <el-col :span="4">
          <a title="" class="nbg" href="javascript:void(0)" @click="Describe">
            <img width="85" alt="" :src="film.poster" :onerror="logo">
          </a>
        </el-col>
        <!--右侧-->
        <el-col :span="12" class="el-col-right">
          <!--电影名称-->
          <el-row>
               <a title="" class="nbg" href="javascript:void(0)" @click="Describe"><p style="font-size:16px;">{{ film.title }}</p></a>
          </el-row>
          <!--评分-->
          <el-row>
            <el-col :span="10" >
                <el-rate  v-model="film.rating.average / 2" disabled
                    text-color="#ff9900"></el-rate>
              </el-col>
              <el-col :span="2">
                <span class="pl" style="float: left;color:#E09015">{{ film.rating.average ?
                  film.rating.average : 0 }}分</span>
              </el-col>
              <el-col :span="6"> <span class="pl" style="float: left;margin-left:1rem;">({{ film.rating.rating_people
                == '' ?
                0 : film.rating.rating_people }}人评价)</span></el-col>
          </el-row>
          <!--类型-->
          <el-row>
             <div class="pl" style="color:#909399">{{ genres }}</div>
          </el-row>
         <!--演员导演-->
          <el-row>
              <div class="pl" style="color:#909399">{{ directors }}</div>
          </el-row>
        </el-col>
      </el-row>
  </div>
</template>

<script>
	export default {
		name: 'FilmCell',
		props: ['films'],
		data() {
			return {
				film: JSON.parse(this.films),
				logo: 'this.src="' + require('../../assets/timg.jpg') + '"',
				directors: '',
				genres:''
			}; //重新赋值？
		},
		watch: {
			films(newValue, oldValue) {
				this.film = JSON.parse(newValue) //监听
			}
		},
		created(){
			for (var i = 0, len = this.film.directors.length; i < len; i++) {
				if (len <= 5) {
					if (i == 0) {
						this.directors += this.film.directors[i]['name']
					} else {
						this.directors += '/' + this.film.directors[i]['name']
					}
				} else {
					if (i == 0) {
						this.directors += this.film.directors[i]['name']
					} else if (i < 5) {
						this.directors += '/' + this.film.directors[i]['name']
					} else if (i == 5) {
						this.directors += '/更多...'
						break
					}
				}
			}
			for (var i = 0, len = this.film.genres.length; i < len; i++) {
				if (len <= 5) {
					if (i == 0) {
						this.genres += this.film.genres[i]
					} else {
						this.genres += '/' + this.film.genres[i]
					}
				} else {
					if (i == 0) {
						this.genres += this.film.genres[i]
					} else if (i < 5) {
						this.genres += '/' + this.film.genres[i]
					} else if (i == 5) {
						this.genres += '/更多...'
						break
					}
				}
			}
		},
		methods: {
			Describe() {
				this.$parent.getDescribe(this.film, this.film._id)
			},
		}
	}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
	/* @import '../static/css/cell_template.css' */
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

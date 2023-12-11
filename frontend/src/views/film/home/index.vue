<template>
  <div class="films">
    <!-- 搜索栏 -->
    <nav>
      <el-row>
        <el-col :span="5" :offset="10">
          <el-input
            style="float:right"
            v-model="keyword"
            placeholder="请输入电影名"
            @keyup.enter.native="searchBytitle"
          ></el-input>
        </el-col>
        <el-col :span="6">
          <el-button
            style="float:left;margin-left:1rem"
            icon="el-icon-search"
            circle
            @click="searchBytitle"
          ></el-button>
        </el-col>
      </el-row>
    </nav>
    <!-- 电影列表 -->
    <FilmCell v-for="item in currentFilms" :key="item.movieId" :film="item" @click="getDescribe()"></FilmCell>
    <!-- 分页器 -->
    <el-pagination
      style="margin-top: 1rem;"
      @current-change="handleCurrentChange"
      :page-size="10"
      :current-page="currentPage"
      background
      layout="prev, pager, next"
      :total="total"
    ></el-pagination>
  </div>
</template>
<script>
import axios from "axios";
import FilmCell from "../../compontents/FilmCell.vue";
import { getMoviesByKeyword } from '../../../api/film';
export default {
  name: "App",
  components: {
    FilmCell
  },
  data() {
    return {
      keyword: "",
      currentPage: 1,
      pageSize:20,
      total: 0,
      currentFilms: [],
    };
  },
  created: function() {},
  mounted: function() {
    //初始化电影列表数据
    this.initData();
  },
  methods: {
    handleCurrentChange(val) {
      this.currentPage = val;

    },
    getDescribe(film, id) {
      this.$router.push({
        name: "Describe",
        params: {
          id: id,
          film: film
        }
      });
    },
    searchBytitle() {

    },
    initData() {
       const data = {
        pageIndex:this.currentPage,
        pageSize:this.pageSize,
        keyword :this.keyword
      };
      var me=this;
      getMoviesByKeyword(data).then(res => {
         if(res.status===200){
          // debugger
          me.currentFilms =res.data.rows;
          me.total =res.data.total;
        }
      }).catch(err => {
        console.log(err);
      })
    }

  }
};
</script>

<style>
.films {
  padding-left: 50px;
  padding-right: 50px;
}
.nav-search .inp input {
  background: #fff;

  width: 96%;
  margin: 0;
  text-align: left;
  height: 30px;
  padding-left: 10px;
  height: 28px\9;
  line-height: 28px\9;
  outline: none;
}
</style>

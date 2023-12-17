package com.step.template.main.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.step.template.main.entity.Movies;
import com.step.template.main.page.PagingDto;
import com.step.template.main.service.MoviesService;
import com.step.template.main.mapper.MoviesMapper;
import com.step.template.main.vo.MovieDetailVO;
import com.step.template.main.vo.MovieItem;
import com.step.template.main.vo.MovieListVO;
import com.step.template.main.vo.MovieVO;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
* @author 李响
* @description 针对表【movies】的数据库操作Service实现
* @createDate 2023-12-16 23:03:45
*/
@Service
public class MoviesServiceImpl extends ServiceImpl<MoviesMapper, Movies>
    implements MoviesService{

    @Resource
    private MoviesMapper moviesMapper;

    /**
     *
     * @param keyword
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public  PagingDto<MovieVO> getMoviesByKeywordPaginated(String keyword, long pageIndex, long pageSize) {
        QueryWrapper<Movies> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(keyword)) {
            queryWrapper.like("name", keyword);
        }
        Page<Movies> page = new Page<>(pageIndex, pageSize);
        IPage<Movies> moviesPage = moviesMapper.selectPage(page, queryWrapper);
        List<MovieVO> list = new ArrayList<>();
        for (Movies movie : moviesPage.getRecords()) {
            MovieVO movieVO = new MovieVO();
            movieVO.setAverage(movie.getRating());
            movieVO.setRatingPeople(movie.getRatingsum());
            movieVO.setGenre(movie.getGenre());
            movieVO.setPicUrl(movie.getImg());
            movieVO.setMovieId(movie.getId());
            movieVO.setMovieName(movie.getName() + " (" + movie.getYear() + ")");
            movieVO.setTags(formatTags(movie.getTags()));
            movieVO.setCountry(movie.getCountry());
            movieVO.setDescribe(movieVO.getCountry()+movieVO.getTags());
            list.add(movieVO);
        }
        long totalSize = calculateTotalSize(moviesPage.getTotal(), pageSize);
        PagingDto<MovieVO> pagingDto = new PagingDto<MovieVO>(moviesPage.getTotal(), list, totalSize, pageIndex, pageSize);
        return pagingDto;
     }

    /**
     *
     * @param id
     * @return
     */
     @Override
     public MovieDetailVO getMovieDetailById(Integer id) {
         QueryWrapper<Movies> queryWrapper = new QueryWrapper<>();
         queryWrapper.eq("id", id);
         Movies movie= moviesMapper.selectOne(queryWrapper);
         MovieDetailVO movieVO = new MovieDetailVO();
         movieVO.setAverage(movie.getRating());
         movieVO.setRatingPeople(movie.getRatingsum());
         movieVO.setGenre(movie.getGenre());
         movieVO.setPicUrl(movie.getImg());
         movieVO.setMovieId(movie.getId());
         movieVO.setMovieName(movie.getName());
         movieVO.setTags(formatTags(movie.getTags()));
         movieVO.setCountry(movie.getCountry());
         movieVO.setDescribe(movieVO.getCountry()+movieVO.getTags());
         movieVO.setSummary(movie.getSummary());
         movieVO.setYear(movie.getYear());
         return  movieVO;
    }

    @Override
    public MovieListVO GetTopRankMovies(){

        MovieListVO result =new MovieListVO();
        List<MovieItem> topRankMovies =  convertToMovieItem(getTopMoviesToday(10));
        List<MovieItem> NowplayList =  convertToMovieItem(getTopMovies(10));
        List<MovieItem> RecentplayList =  convertToMovieItem(getTopMoviesLast5Years(10));


        result.setRankList(topRankMovies); //年度作品
        result.setNowplayList(NowplayList);//好评榜
        result.setRecentplayList(RecentplayList); //5年内好评

        return  result;
    }

    public List<Movies> getTopMovies(int limit) {
        QueryWrapper<Movies> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("rating");
        wrapper.last("LIMIT 10");
        return moviesMapper.selectList(wrapper);
    }

    public List<Movies> getTopMoviesToday(int limit) {
        LocalDate currentDate = LocalDate.now();
        int currentYear = Year.from(currentDate).getValue();
        Integer currentYeaer =Integer.valueOf(currentYear);
        QueryWrapper<Movies> wrapper = new QueryWrapper<>();
        wrapper.eq("year", currentYeaer);
        wrapper.orderByDesc("rating");
        wrapper.last("LIMIT " + limit);
        return moviesMapper.selectList(wrapper);
    }

    public List<Movies> getTopMoviesLast5Years(int limit) {

        LocalDate currentDate = LocalDate.now();
        int currentYear = Year.from(currentDate).getValue();
        Integer currentYeaer =Integer.valueOf(currentYear);
        Integer last5Year =currentYeaer-5;
        QueryWrapper<Movies> wrapper = new QueryWrapper<>();
        wrapper.between("year", last5Year, currentDate);
        wrapper.orderByDesc("rating");
        wrapper.last("LIMIT " + limit);

        return moviesMapper.selectList(wrapper);
    }


    /**
     *
     * @param moviesList
     * @return
     */
    public List<MovieItem> convertToMovieItem(List<Movies> moviesList) {
        List<MovieItem> topMovies = new ArrayList<>();

        for (Movies movies : moviesList) {
            MovieItem movieItem = new MovieItem();
            movieItem.setId(movies.getId());
            movieItem.setTitle(movies.getName());
            movieItem.setCoverUrl(movies.getImg());
            movieItem.setRating(movies.getRating());
            topMovies.add(movieItem);
        }
        return topMovies;
    }


     private static String formatTags(String tagsJson) {
         try {
             // 解析JSON数组
             JSONArray jsonArray = JSONArray.parseArray(tagsJson);

             // 将JSON数组中的元素转换为字符串数组
             String[] tagsArray = jsonArray.toArray(new String[0]);

             // 使用String.join拼接标签
             return String.join("/", tagsArray);
         } catch (JSONException e) {
             // 捕获JSONException，并进行相应的处理
             System.err.println("Error: Unable to parse JSON.");
             return "";
         }
     }

     private long calculateTotalSize(long total, long pageSize) {
         // Calculate total size based on total and pageSize
         return (long) Math.ceil((double) total / pageSize);
     }
}





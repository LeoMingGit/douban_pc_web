package com.douban.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douban.dto.MovieVO;
import com.douban.dto.PagingDto;
import com.douban.mapper.MoviesMapper;
import com.douban.model.Comments;
import com.douban.model.Movies;
import com.douban.service.CommentsService;
import com.douban.service.MoviesService;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.DeleteProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    private MoviesService moviesService;

    @Autowired
    private CommentsService commentsService;

    @ApiOperation("获取所有电影信息")
    @RequestMapping(value = "/GetAllMovies", method = RequestMethod.GET)
    @ResponseBody
    public String GetAllMovies() {
        System.out.println("----- getAllMovies method test ------");
        List<Movies> movieList = moviesService.getAllMovies();
        movieList.forEach(System.out::println);

        String jsonString = JSON.toJSONString(movieList);
        System.out.println(jsonString);
        return jsonString;
    }


    @ApiOperation("根据关键字获取电影信息（分页）")
    @GetMapping("/getMoviesByKeyword")
    public PagingDto<MovieVO> getMoviesByKeyword(
            @RequestParam(defaultValue = "1") long pageIndex,
            @RequestParam(defaultValue = "10") long pageSize,
            @RequestParam(required = false) String keyword
    ) {
        System.out.println("----- getMoviesByKeyword method test ------");
        Page<Movies> page = new Page<>(pageIndex, pageSize);
        IPage<Movies> moviesPage = moviesService.getMoviesByKeywordPaginated(page, keyword);
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
            movieVO.setSummary(movie.getSummary());
            movieVO.setCountry(movie.getCountry());
            list.add(movieVO);
        }
        long totalSize = calculateTotalSize(moviesPage.getTotal(), pageSize);

        PagingDto<MovieVO> pagingDto = new PagingDto<MovieVO>(moviesPage.getTotal(), list, totalSize, pageIndex, pageSize);

        return pagingDto;
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

    @GetMapping("/findByMovieId")
    public IPage<Comments> findByMovieId(
            @RequestParam Integer movieId,
            @RequestParam(defaultValue = "1") long pageIndex,
            @RequestParam(defaultValue = "10") long pageSize) {
        Page<Comments> page = new Page<>(pageIndex, pageSize);

        return commentsService.findByMovieId(movieId,page);
    }
}

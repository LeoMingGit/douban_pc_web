package com.douban.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douban.mapper.MoviesMapper;
import com.douban.model.Movies;
import com.douban.service.MoviesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    private MoviesService moviesService;

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
    public IPage<Movies> getMoviesByKeyword(
            @RequestParam(defaultValue = "1") long pageIndex,
            @RequestParam(defaultValue = "10") long pageSize,
            @RequestParam(required = false) String keyword
    ) {
        System.out.println("----- getMoviesByKeyword method test ------");
        Page<Movies> page = new Page<>(pageIndex, pageSize);

        return moviesService.getMoviesByKeywordPaginated(page, keyword);
    }

 }

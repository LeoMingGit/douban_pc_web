package com.douban.controller;

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

        // Assuming selectAll method in MovieMapper retrieves all movies from the database
        List<Movies> movieList = moviesService.getAllMovies();
        movieList.forEach(System.out::println);

        String jsonString = JSON.toJSONString(movieList);
        System.out.println(jsonString);
        return jsonString;
    }

    // You can add more methods to handle different movie-related operations (e.g., add, update, delete).
}

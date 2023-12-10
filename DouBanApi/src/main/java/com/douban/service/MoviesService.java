package com.douban.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douban.model.Movies;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 李响
* @description 针对表【movies】的数据库操作Service
* @createDate 2023-12-10 17:50:07
*/
public interface MoviesService extends IService<Movies> {
    List<Movies> getAllMovies();
    IPage<Movies> getMoviesByKeywordPaginated(Page<Movies> page, String keyword);
}

package com.step.template.main.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
 import com.baomidou.mybatisplus.extension.service.IService;
import com.step.template.main.entity.Movies;
import com.step.template.main.page.PagingDto;
import com.step.template.main.vo.MovieDetailVO;
import com.step.template.main.vo.MovieListVO;
import com.step.template.main.vo.MovieVO;

import java.util.List;

/**
* @author 李响
* @description 针对表【movies】的数据库操作Service
* @createDate 2023-12-16 23:03:45
*/
public interface MoviesService extends IService<Movies> {

    PagingDto<MovieVO> getMoviesByKeywordPaginated(String keyword, long pageIndex, long pageSize);

    MovieDetailVO getMovieDetailById(Integer id);

    MovieListVO GetTopRankMovies();
}

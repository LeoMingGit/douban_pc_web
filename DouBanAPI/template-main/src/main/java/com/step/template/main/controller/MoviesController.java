package com.step.template.main.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.step.template.main.entity.Comments;
import com.step.template.main.entity.Movies;
import com.step.template.main.page.PagingDto;
import com.step.template.main.service.CommentsService;
import com.step.template.main.service.MoviesService;
import com.step.template.main.vo.MovieDetailVO;
import com.step.template.main.vo.MovieListVO;
import com.step.template.main.vo.MovieVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @Autowired
    private CommentsService commentsService;


    @ApiOperation("根据关键字获取电影信息（分页）")
    @GetMapping("/getMoviesByKeyword")
    public PagingDto<MovieVO> getMoviesByKeyword(
            @RequestParam(defaultValue = "1") long pageIndex,
            @RequestParam(defaultValue = "10") long pageSize,
            @RequestParam(required = false) String keyword
    ) {
        PagingDto<MovieVO> pagingDto = moviesService.getMoviesByKeywordPaginated(keyword, pageIndex,pageSize);
        return pagingDto;
    }


    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/detail")
    public MovieDetailVO gettMovieDetail(@RequestParam Integer id) {
        MovieDetailVO detail = moviesService.getMovieDetailById(id);
        return  detail;
    }

    /**
     * 获取年度电影
     * @return
     */
    @GetMapping("/top")
    public MovieListVO top() {
        return moviesService.GetTopRankMovies();
    }


    /**
     *
     * @param movieId
     *  @param type 0 1 2
     * @param current
     * @param size
     * @return
     */
    @GetMapping("/getCommentsByMovieId")
    public PagingDto<Comments> getCommentsByMovieId(@RequestParam Integer movieId,
                                                    @RequestParam Integer type,
                                                    @RequestParam(defaultValue = "1") Integer current,
                                                    @RequestParam(defaultValue = "10") Integer size) {
        Page<Comments> page = new Page<>(current, size);
        return commentsService.findByMovieId(movieId,type, page);
    }




}

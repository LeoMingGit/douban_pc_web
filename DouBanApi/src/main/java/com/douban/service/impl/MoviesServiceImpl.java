package com.douban.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.douban.model.Movies;
import com.douban.service.MoviesService;
import com.douban.mapper.MoviesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 李响
* @description 针对表【movies】的数据库操作Service实现
* @createDate 2023-12-10 17:50:07
*/
@Service
public class MoviesServiceImpl extends ServiceImpl<MoviesMapper, Movies>
    implements MoviesService{

    @Resource
    private MoviesMapper moviesMapper;

    @Override
    public List<Movies> getAllMovies() {
        System.out.println("----- getAllMovies method test ------");
        return moviesMapper.selectList(null); // MyBatis Plus selectList method
    }
}





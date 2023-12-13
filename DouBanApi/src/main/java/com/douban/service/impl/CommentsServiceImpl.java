package com.douban.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.douban.model.Comments;
import com.douban.model.Movies;
import com.douban.service.CommentsService;
import com.douban.mapper.CommentsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author 李响
* @description 针对表【comments】的数据库操作Service实现
* @createDate 2023-12-13 20:53:30
*/
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments>
    implements CommentsService{

    @Resource
    private  CommentsMapper commentsMapper;

    @Override

    public IPage<Comments> findByMovieId(Integer movieId, Page<Comments> page) {
        QueryWrapper<Comments> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("movieId", movieId);
        return commentsMapper.selectPage(page, queryWrapper);
    }
}





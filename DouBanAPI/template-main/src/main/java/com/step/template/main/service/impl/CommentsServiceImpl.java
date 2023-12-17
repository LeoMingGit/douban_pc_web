package com.step.template.main.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.step.template.main.entity.Comments;
import com.step.template.main.page.PagingDto;
import com.step.template.main.service.CommentsService;
import com.step.template.main.mapper.CommentsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author 李响
* @description 针对表【comments】的数据库操作Service实现
* @createDate 2023-12-17 00:17:18
*/
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments>
    implements CommentsService{

    @Resource
    private  CommentsMapper commentsMapper;


    @Override
    public PagingDto<Comments> findByMovieId(Integer movieId,Integer type, Page<Comments> page) {
        QueryWrapper<Comments> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("movieId", movieId);
        if(!type.equals(2)){
            queryWrapper.eq("islike", type);
        }
        IPage<Comments> commentsPage = commentsMapper.selectPage(page, queryWrapper);
        return convertToPagingDto(commentsPage);
    }

    private PagingDto<Comments> convertToPagingDto(IPage<Comments> commentsPage) {
        return new PagingDto<>(
                commentsPage.getTotal(),
                commentsPage.getRecords(),
                Math.ceil((double) commentsPage.getTotal() / commentsPage.getSize()),
                commentsPage.getCurrent(),
                commentsPage.getSize()
        );
    }
}





package com.douban.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.douban.model.Comments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 李响
* @description 针对表【comments】的数据库操作Mapper
* @createDate 2023-12-13 20:53:30
* @Entity com.douban.model.Comments
*/
public interface CommentsMapper extends BaseMapper<Comments> {

    IPage<Comments> findByMovieId(Integer movieId,long current, long size);
}





package com.douban.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douban.model.Comments;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
* @author 李响
* @description 针对表【comments】的数据库操作Service
* @createDate 2023-12-13 20:53:30
*/
public interface CommentsService extends IService<Comments> {

    IPage<Comments>  findByMovieId(Integer movieId, Page<Comments> page);

}

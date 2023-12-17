package com.step.template.main.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.step.template.main.entity.Comments;
import com.baomidou.mybatisplus.extension.service.IService;
import com.step.template.main.page.PagingDto;

/**
* @author 李响
* @description 针对表【comments】的数据库操作Service
* @createDate 2023-12-17 00:17:18
*/
public interface CommentsService extends IService<Comments> {

      PagingDto<Comments> findByMovieId(Integer movieId, Page<Comments> page);

}

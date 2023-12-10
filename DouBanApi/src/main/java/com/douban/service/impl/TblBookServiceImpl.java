package com.douban.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.douban.service.TblBookService;
import com.douban.model.TblBook;
import com.douban.mapper.TblBookMapper;
import org.springframework.stereotype.Service;

/**
* @author 李响
* @description 针对表【tbl_book】的数据库操作Service实现
* @createDate 2023-05-07 15:51:53
*/
@Service
public class TblBookServiceImpl extends ServiceImpl<TblBookMapper, TblBook>
    implements TblBookService {

}





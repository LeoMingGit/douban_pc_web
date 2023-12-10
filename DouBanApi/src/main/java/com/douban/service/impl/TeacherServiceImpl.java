package com.douban.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.douban.mapper.TeacherMapper;
import com.douban.model.Teacher;
import com.douban.service.TeacherService;
import org.springframework.stereotype.Service;

/**
* @author 李响
* @description 针对表【teacher】的数据库操作Service实现
* @createDate 2023-05-07 16:20:08
*/
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
    implements TeacherService{

}





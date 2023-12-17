package com.step.template.main.mapper;

import com.step.template.main.entity.Movies;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author 李响
* @description 针对表【movies】的数据库操作Mapper
* @createDate 2023-12-16 23:03:45
* @Entity com.step.template.main.entity.Movies
*/
public interface MoviesMapper extends BaseMapper<Movies> {


    @Select({
            "SELECT * FROM movies WHERE year = 2023 ORDER BY goodRate DESC LIMIT 5",
            "UNION",
            "SELECT * FROM movies WHERE year = 2022 ORDER BY goodRate DESC LIMIT 5",
            "UNION",
            "SELECT * FROM movies WHERE year = 2021 ORDER BY goodRate DESC LIMIT 5",
            "UNION",
            "SELECT * FROM movies WHERE year = 2020 ORDER BY goodRate DESC LIMIT 5",
            "UNION",
            "SELECT * FROM movies WHERE year = 2019 ORDER BY goodRate DESC LIMIT 5",
            "UNION",
            "SELECT * FROM movies WHERE year = 2018 ORDER BY goodRate DESC LIMIT 5",
            "ORDER BY year DESC, goodRate DESC LIMIT 25"
    })
    List<Movies> getTopMovies();

    @Select("${nativeSql}")
    List<Movies> executeNativeSql(@Param("nativeSql") String nativeSql);
}





package com.douban.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName movies
 */
@TableName(value ="movies")
@Data
public class Movies implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer year;

    /**
     * 
     */
    private Double rating;

    /**
     * 
     */
    private Integer ratingsum;

    /**
     * 
     */
    private String img;

    /**
     * 
     */
    private String tags;

    /**
     * 
     */
    private String summary;

    /**
     * 
     */
    private String genre;

    /**
     * 
     */
    private String country;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
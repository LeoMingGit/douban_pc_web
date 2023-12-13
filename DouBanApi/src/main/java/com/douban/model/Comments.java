package com.douban.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName comments
 */
@TableName(value ="comments")
@Data
public class Comments implements Serializable {
    /**
     * 
     */
    private String personname;

    /**
     * 
     */
    private Integer movieid;

    /**
     * 
     */
    private String info;

    /**
     * 
     */
    private Integer islike;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
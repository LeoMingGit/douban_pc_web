package com.step.template.main.entity;

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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Comments other = (Comments) that;
        return (this.getPersonname() == null ? other.getPersonname() == null : this.getPersonname().equals(other.getPersonname()))
            && (this.getMovieid() == null ? other.getMovieid() == null : this.getMovieid().equals(other.getMovieid()))
            && (this.getInfo() == null ? other.getInfo() == null : this.getInfo().equals(other.getInfo()))
            && (this.getIslike() == null ? other.getIslike() == null : this.getIslike().equals(other.getIslike()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPersonname() == null) ? 0 : getPersonname().hashCode());
        result = prime * result + ((getMovieid() == null) ? 0 : getMovieid().hashCode());
        result = prime * result + ((getInfo() == null) ? 0 : getInfo().hashCode());
        result = prime * result + ((getIslike() == null) ? 0 : getIslike().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", personname=").append(personname);
        sb.append(", movieid=").append(movieid);
        sb.append(", info=").append(info);
        sb.append(", islike=").append(islike);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
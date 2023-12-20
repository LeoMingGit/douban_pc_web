package com.step.template.main.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName top_movies_view5
 */
@TableName(value ="top_movies_view5")
@Data
public class TopMoviesView5 implements Serializable {
    /**
     * 
     */
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
    private String img;

    /**
     * 
     */
    private Integer goodcount;

    /**
     * 
     */
    private Double goodrate;

    /**
     * 
     */
    private Double rating;

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
        TopMoviesView5 other = (TopMoviesView5) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
            && (this.getGoodcount() == null ? other.getGoodcount() == null : this.getGoodcount().equals(other.getGoodcount()))
            && (this.getGoodrate() == null ? other.getGoodrate() == null : this.getGoodrate().equals(other.getGoodrate()))
            && (this.getRating() == null ? other.getRating() == null : this.getRating().equals(other.getRating()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getGoodcount() == null) ? 0 : getGoodcount().hashCode());
        result = prime * result + ((getGoodrate() == null) ? 0 : getGoodrate().hashCode());
        result = prime * result + ((getRating() == null) ? 0 : getRating().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", year=").append(year);
        sb.append(", img=").append(img);
        sb.append(", goodcount=").append(goodcount);
        sb.append(", goodrate=").append(goodrate);
        sb.append(", rating=").append(rating);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
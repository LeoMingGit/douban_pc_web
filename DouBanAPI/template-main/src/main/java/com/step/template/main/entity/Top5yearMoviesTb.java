package com.step.template.main.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName top5year_movies_tb
 */
@TableName(value ="top5year_movies_tb")
@Data
public class Top5yearMoviesTb implements Serializable {
    /**
     * 
     */
    private Integer movieid;

    /**
     * 
     */
    private Long totalcount2;

    /**
     * 
     */
    private Long likecount2;

    /**
     * 
     */
    private BigDecimal goodrate2;

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

    /**
     * 
     */
    private Double goodrate;

    /**
     * 
     */
    private Integer goodcount;

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
        Top5yearMoviesTb other = (Top5yearMoviesTb) that;
        return (this.getMovieid() == null ? other.getMovieid() == null : this.getMovieid().equals(other.getMovieid()))
            && (this.getTotalcount2() == null ? other.getTotalcount2() == null : this.getTotalcount2().equals(other.getTotalcount2()))
            && (this.getLikecount2() == null ? other.getLikecount2() == null : this.getLikecount2().equals(other.getLikecount2()))
            && (this.getGoodrate2() == null ? other.getGoodrate2() == null : this.getGoodrate2().equals(other.getGoodrate2()))
            && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getRating() == null ? other.getRating() == null : this.getRating().equals(other.getRating()))
            && (this.getRatingsum() == null ? other.getRatingsum() == null : this.getRatingsum().equals(other.getRatingsum()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
            && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()))
            && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()))
            && (this.getGenre() == null ? other.getGenre() == null : this.getGenre().equals(other.getGenre()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getGoodrate() == null ? other.getGoodrate() == null : this.getGoodrate().equals(other.getGoodrate()))
            && (this.getGoodcount() == null ? other.getGoodcount() == null : this.getGoodcount().equals(other.getGoodcount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMovieid() == null) ? 0 : getMovieid().hashCode());
        result = prime * result + ((getTotalcount2() == null) ? 0 : getTotalcount2().hashCode());
        result = prime * result + ((getLikecount2() == null) ? 0 : getLikecount2().hashCode());
        result = prime * result + ((getGoodrate2() == null) ? 0 : getGoodrate2().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getRating() == null) ? 0 : getRating().hashCode());
        result = prime * result + ((getRatingsum() == null) ? 0 : getRatingsum().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getTags() == null) ? 0 : getTags().hashCode());
        result = prime * result + ((getSummary() == null) ? 0 : getSummary().hashCode());
        result = prime * result + ((getGenre() == null) ? 0 : getGenre().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getGoodrate() == null) ? 0 : getGoodrate().hashCode());
        result = prime * result + ((getGoodcount() == null) ? 0 : getGoodcount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", movieid=").append(movieid);
        sb.append(", totalcount2=").append(totalcount2);
        sb.append(", likecount2=").append(likecount2);
        sb.append(", goodrate2=").append(goodrate2);
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", year=").append(year);
        sb.append(", rating=").append(rating);
        sb.append(", ratingsum=").append(ratingsum);
        sb.append(", img=").append(img);
        sb.append(", tags=").append(tags);
        sb.append(", summary=").append(summary);
        sb.append(", genre=").append(genre);
        sb.append(", country=").append(country);
        sb.append(", goodrate=").append(goodrate);
        sb.append(", goodcount=").append(goodcount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.douban.dto;

import lombok.Data;

import java.util.List;

@Data
public class MovieVO {
    private double average;
    private int ratingPeople;
    private String genre;
    private String tags;
    private String picUrl;
    private int movieId;
    private String movieName;
    private  String summary;
    private  String country;


}

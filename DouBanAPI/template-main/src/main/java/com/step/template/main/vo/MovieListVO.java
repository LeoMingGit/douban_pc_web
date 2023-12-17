package com.step.template.main.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import java.util.List;

public class MovieListVO {
    private List<MovieItem> nowplayList;
    private List<MovieItem> recentplayList;
    private List<MovieItem> rankList;

    public MovieListVO() {
        // No-args constructor
    }

    public MovieListVO(List<MovieItem> nowplayList, List<MovieItem> recentplayList, List<MovieItem> rankList) {
        this.nowplayList = nowplayList;
        this.recentplayList = recentplayList;
        this.rankList = rankList;
    }

    public List<MovieItem> getNowplayList() {
        return nowplayList;
    }

    public void setNowplayList(List<MovieItem> nowplayList) {
        this.nowplayList = nowplayList;
    }

    public List<MovieItem> getRecentplayList() {
        return recentplayList;
    }

    public void setRecentplayList(List<MovieItem> recentplayList) {
        this.recentplayList = recentplayList;
    }

    public List<MovieItem> getRankList() {
        return rankList;
    }

    public void setRankList(List<MovieItem> rankList) {
        this.rankList = rankList;
    }
}

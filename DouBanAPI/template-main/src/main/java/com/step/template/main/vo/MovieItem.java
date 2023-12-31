package com.step.template.main.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieItem {
    private String coverUrl;
    private String title;
    private Double rating; // Assuming rating is a double
    private Integer id; // Assuming id is a long
    private  String goodRateStr;
    private Long goodCount;
    private  Integer year;
}
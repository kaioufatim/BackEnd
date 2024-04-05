package com.last.project.dto;

import lombok.Data;

import java.util.Date;
@Data
public class ReviewDto {
    private Long id;
    private Date reviewDate;
    private  String review;
    private Long rating;
    private Long userId;
    private Long projectId;
    private String entrepreneurName;
    private String projectName;
    private Long PropositionId;

}

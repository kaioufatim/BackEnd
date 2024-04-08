package com.last.project.dto;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProjectDto {
    private Long id;
    private String domaineName;
    private String description;
    private String projectName;
    private MultipartFile img;
    private  byte[] returnedImg;
    private Long userId;
    private String creatorName;

}

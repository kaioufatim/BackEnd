package com.last.project.entities;

import com.last.project.dto.ProjectDto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String domaineName;
    private String description;
    private String projectName;
    @Lob
    @Column(columnDefinition = "longblob")
    private  byte[] img;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public ProjectDto getProjectDto(){
        ProjectDto projectDto =new ProjectDto();
        projectDto.setId(id);
        projectDto.setDomaineName(domaineName);
        projectDto.setDescription(description);
        projectDto.setCreatorName(user.getName());
        projectDto.setReturnedImg(img);
        return projectDto;
    }
}
package com.last.project.entities;

import com.last.project.dto.ProjectDto;
import lombok.Data;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "projects")
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String domaineName;
    private String description;
    private String projectName;
//    @Lob
//    @Column(columnDefinition = "longblob")
//    private  byte[] img;
    @Column(columnDefinition = "bytea")
    private byte[] img;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public ProjectDto getProjectDto(){
        ProjectDto projectDto =new ProjectDto();
        projectDto.setDomaineName(domaineName);
        projectDto.setDescription(description);
        projectDto.setCreatorName(user.getName());
        projectDto.setReturnedImg(img);
        return projectDto;
    }
}

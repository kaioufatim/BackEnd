package com.last.project.services.createur;

import com.last.project.dto.ProjectDto;
import com.last.project.entities.Project;
import com.last.project.entities.User;
import com.last.project.repositories.ProjectRepository;
import com.last.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class CreateurServiceImp implements CreateurService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepository;
    public boolean postProject(Long userId, ProjectDto projectDto) throws IOException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()){
            Project project= new Project();
            project.setDomaineName(project.getDomaineName());
            project.setDescription(projectDto.getDescription());
            project.setImg(projectDto.getImg().getBytes());
            project.setUser(optionalUser.get());
            projectRepository.save(project);

        }
        return false;
    }

}

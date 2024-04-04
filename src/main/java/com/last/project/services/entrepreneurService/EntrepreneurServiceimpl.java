package com.last.project.services.entrepreneurService;

import com.last.project.dto.ProjectDetailsEntrepreneur;
import com.last.project.dto.ProjectDto;
import com.last.project.dto.PropositionDto;
import com.last.project.entities.Project;
import com.last.project.entities.Proposition;
import com.last.project.entities.User;
import com.last.project.enums.ReviewStatus;
import com.last.project.repositories.ProjectRepository;
import com.last.project.repositories.PropositionRepository;
import com.last.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntrepreneurServiceimpl implements EntrepreneurService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private PropositionRepository propositionRepository;
    @Autowired
    private UserRepository userRepository;
    public List<ProjectDto> getAllProject(){
        return projectRepository.findAll().stream().map(Project::getProjectDto).collect(Collectors.toList());
    }
    public List<ProjectDto> searshProjectByName(String name){
        return projectRepository.findAllByProjectNameContaining(name).stream().map(Project::getProjectDto).collect(Collectors.toList());
    }
    public List<ProjectDto> searshProjectDomaineName(String name){
        return projectRepository.findAllByDomaineNameContainingIgnoreCase(name).stream().map(Project::getProjectDto).collect(Collectors.toList());
    }
    public boolean saveProposition(PropositionDto propositionDto){
        Optional<Project> optionalProject = projectRepository.findById(propositionDto.getProjectId());
        Optional<User> optionalUser = userRepository.findById(propositionDto.getUserId());
        if(optionalUser.isPresent() && optionalProject.isPresent()){
            Proposition proposition = new Proposition();
            proposition.setPropositionDate(propositionDto.getPropositionDate());
            proposition.setPropositionStatus(propositionDto.getPropositionStatus());
            proposition.setProject(optionalProject.get());
            proposition.setCreateur(optionalProject.get().getUser());
            proposition.setReviewStatus(ReviewStatus.FALSE);
            propositionRepository.save(proposition);
            return true;
        }
        return false;
    }
    public ProjectDetailsEntrepreneur getPrjectDetailsById(Long projectId){
        Optional <Project> optionalProject=projectRepository.findById(projectId);
        ProjectDetailsEntrepreneur projectDetailsEntrepreneur= new ProjectDetailsEntrepreneur();
        if (optionalProject.isPresent()){
            projectDetailsEntrepreneur.setProjectDto(optionalProject.get().getProjectDto());
        }
        return projectDetailsEntrepreneur;
    }




}

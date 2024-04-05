package com.last.project.services.entrepreneurService;

import com.last.project.dto.ProjectDetailsEntrepreneurDto;
import com.last.project.dto.ProjectDto;
import com.last.project.dto.PropositionDto;
import com.last.project.dto.ReviewDto;
import com.last.project.entities.Project;
import com.last.project.entities.Proposition;
import com.last.project.entities.Review;
import com.last.project.entities.User;
import com.last.project.enums.ReviewStatus;
import com.last.project.repositories.ProjectRepository;
import com.last.project.repositories.PropositionRepository;
import com.last.project.repositories.ReviewRepository;
import com.last.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    @Autowired
    private ReviewRepository reviewRepository;
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
    public ProjectDetailsEntrepreneurDto getPrjectDetailsById(Long projectId){
        Optional <Project> optionalProject=projectRepository.findById(projectId);
        ProjectDetailsEntrepreneurDto projectDetailsEntrepreneur= new ProjectDetailsEntrepreneurDto();
        if (optionalProject.isPresent()){
            projectDetailsEntrepreneur.setProjectDto(optionalProject.get().getProjectDto());
            List<Review> reviewList = reviewRepository.findAllByProjectId(projectId);
            projectDetailsEntrepreneur.setReviewDtoList(reviewList.stream().map(Review :: getDto).collect(Collectors.toList()));
        }
        return projectDetailsEntrepreneur;
    }
    public List<PropositionDto>getAllPrppositionByUserId(Long userId){
        return  propositionRepository.findAllByUserId(userId).stream().map(Proposition ::getPropositionDto).collect(Collectors.toList());
    }

    public Boolean giveReview(ReviewDto reviewDto){
        Optional<User> optionalUser=userRepository.findById(reviewDto.getUserId());
        Optional<Proposition> optionalProposition= propositionRepository.findById(reviewDto.getPropositionId());
        if (optionalUser.isPresent() && optionalProposition.isPresent()){
            Review review = new Review();
            review.setReviewDate(new Date());
            review.setReview(reviewDto.getReview());
            review.setRating(review.getRating());

            review.setUser(optionalUser.get());
            review.setProject(optionalProposition.get().getProject());
            reviewRepository.save(review);
             Proposition proposition= optionalProposition.get();
             proposition.setReviewStatus(ReviewStatus.TRUE);

             propositionRepository.save(proposition);
             return true;


        }
        return false;
    }





}

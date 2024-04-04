package com.last.project.services.entrepreneurService;

import com.last.project.dto.ProjectDetailsEntrepreneur;
import com.last.project.dto.ProjectDto;
import com.last.project.dto.PropositionDto;

import java.util.List;

public interface EntrepreneurService {
    List<ProjectDto> getAllProject();
    List<ProjectDto> searshProjectByName(String name);
    List<ProjectDto> searshProjectDomaineName(String name);
    boolean saveProposition(PropositionDto propositionDto);
    public ProjectDetailsEntrepreneur getPrjectDetailsById(Long projectId);
}

package com.last.project.controllers;

import com.last.project.dto.PropositionDto;
import com.last.project.services.entrepreneurService.EntrepreneurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entrepreneur")
public class EntrepreneurController {
    @Autowired
    private EntrepreneurService entrepreneurService;
    @GetMapping("/projects")
    public ResponseEntity<?> getAllProject(){
        return ResponseEntity.ok(entrepreneurService.getAllProject());
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<?> searchByProjectName(@PathVariable String name){
        return ResponseEntity.ok(entrepreneurService.searshProjectByName(name));
    }
    @GetMapping("/searchDomaine/{domainename}")
    public ResponseEntity<?> searchByDomaineName(@PathVariable String domainename){
        return ResponseEntity.ok(entrepreneurService.searshProjectDomaineName(domainename));
    }
    @PostMapping("/proposition-service")
    public ResponseEntity<?> createProposition(@RequestBody PropositionDto propositionDto){
        boolean success = entrepreneurService.saveProposition(propositionDto);
        if (success){
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/project/{projectId}")
    public ResponseEntity<?> getDetailsByProjectId(@PathVariable Long projectId){
        return ResponseEntity.ok(entrepreneurService.getPrjectDetailsById(projectId));
    }
}

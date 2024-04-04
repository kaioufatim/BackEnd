package com.last.project.repositories;

import com.last.project.entities.Proposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropositionRepository extends JpaRepository<Proposition,Long> {
    List<Proposition> findAllByCreateurId(Long createurId);

}
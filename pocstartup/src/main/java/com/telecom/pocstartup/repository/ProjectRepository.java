package com.telecom.pocstartup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.pocstartup.domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>{

}

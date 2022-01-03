package com.telecom.pocstartup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.pocstartup.domain.WorkTime;

@Repository
public interface WorkTimeRepository extends JpaRepository<WorkTime,Long>{

}

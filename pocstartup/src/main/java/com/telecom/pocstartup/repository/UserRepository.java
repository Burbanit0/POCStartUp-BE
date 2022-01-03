package com.telecom.pocstartup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telecom.pocstartup.domain.Project;
import com.telecom.pocstartup.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}

package com.telecom.pocstartup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.pocstartup.domain.GroupUser;

public interface GroupRepository extends JpaRepository<GroupUser,Long>{

}

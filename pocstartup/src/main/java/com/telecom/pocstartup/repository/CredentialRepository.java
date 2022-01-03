package com.telecom.pocstartup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.pocstartup.domain.Credential;

@Repository
public interface CredentialRepository extends JpaRepository<Credential,Long>{

}

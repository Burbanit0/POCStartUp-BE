package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Credential;

@Repository
public interface CredentialRepository extends JpaRepository<Credential,Long>{

}

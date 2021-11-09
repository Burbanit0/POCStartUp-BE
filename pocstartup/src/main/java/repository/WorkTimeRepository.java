package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.WorkTime;

@Repository
public interface WorkTimeRepository extends JpaRepository<WorkTime,Long>{

}
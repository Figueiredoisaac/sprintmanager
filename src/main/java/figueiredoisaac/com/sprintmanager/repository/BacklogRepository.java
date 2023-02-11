package figueiredoisaac.com.sprintmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import figueiredoisaac.com.sprintmanager.model.Backlog;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog, Long> {

}
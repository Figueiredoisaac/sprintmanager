package figueiredoisaac.com.sprintmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import figueiredoisaac.com.sprintmanager.model.Sprint;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {
}

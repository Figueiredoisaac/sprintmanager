package figueiredoisaac.com.sprintmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import figueiredoisaac.com.sprintmanager.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}

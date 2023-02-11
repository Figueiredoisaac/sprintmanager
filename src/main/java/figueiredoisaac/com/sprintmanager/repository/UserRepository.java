package figueiredoisaac.com.sprintmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import figueiredoisaac.com.sprintmanager.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
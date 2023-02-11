package figueiredoisaac.com.sprintmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import figueiredoisaac.com.sprintmanager.model.User;
import figueiredoisaac.com.sprintmanager.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
	    return userRepository.findAll();
	}

	public Optional<User> findByUsername(String username) {
	    return userRepository.findById(username);
	}

	public User save(User user) {
	    return userRepository.save(user);
	}

	public void deleteByUsername(String username) {
	    userRepository.deleteById(username);
	}
}

package figueiredoisaac.com.sprintmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import figueiredoisaac.com.sprintmanager.model.Sprint;
import figueiredoisaac.com.sprintmanager.repository.SprintRepository;

@Service
	public class SprintService {

	  @Autowired
	  private final SprintRepository sprintRepository;
	  
	  private SprintService(SprintRepository sprintRepository) {
	    this.sprintRepository = sprintRepository;
	  }

	  public List<Sprint> findAll() {
	    return sprintRepository.findAll();
	  }

	  public Sprint findById(Long id) {
	    return sprintRepository.findById(id).orElse(null);
	  }

	  public Sprint save(Sprint sprint) {
	    return sprintRepository.save(sprint);
	  }

	  public void deleteById(Long id) {
	    sprintRepository.deleteById(id);
	  }
	}

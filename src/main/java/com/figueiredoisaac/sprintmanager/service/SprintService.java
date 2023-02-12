package com.figueiredoisaac.sprintmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.figueiredoisaac.sprintmanager.model.Sprint;
import com.figueiredoisaac.sprintmanager.repository.SprintRepository;

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

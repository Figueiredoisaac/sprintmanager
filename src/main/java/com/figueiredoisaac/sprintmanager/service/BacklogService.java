package com.figueiredoisaac.sprintmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.figueiredoisaac.sprintmanager.model.Backlog;
import com.figueiredoisaac.sprintmanager.repository.BacklogRepository;

@Service
public class BacklogService {

  @Autowired
  private final BacklogRepository backlogRepository;
  
  private BacklogService(BacklogRepository backlogRepository) {
		this.backlogRepository = backlogRepository;
	}

  public List<Backlog> findAll() {
    return backlogRepository.findAll();
  }

  public Backlog findById(Long id) {
    return backlogRepository.findById(id).orElse(null);
  }

  public Backlog save(Backlog backlog) {
    return backlogRepository.save(backlog);
  }

  public void deleteById(Long id) {
    backlogRepository.deleteById(id);
  }
}
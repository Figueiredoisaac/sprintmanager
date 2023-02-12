package com.figueiredoisaac.sprintmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.figueiredoisaac.sprintmanager.model.Backlog;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog, Long> {

}
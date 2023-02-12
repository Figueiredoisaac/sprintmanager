package com.figueiredoisaac.sprintmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.figueiredoisaac.sprintmanager.model.Sprint;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {
}

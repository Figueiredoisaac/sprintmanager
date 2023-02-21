package com.figueiredoisaac.sprintmanager.dto;

import java.util.Date;

import com.figueiredoisaac.sprintmanager.model.Sprint;

public class SprintDTO {
	
	private String name;
	private Date dtBegin;
	private Date dtEnd;
	private String description;
	private Boolean status;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDtBegin() {
		return dtBegin;
	}
	public void setDtBegin(Date dtBegin) {
		this.dtBegin = dtBegin;
	}
	public Date getDtEnd() {
		return dtEnd;
	}
	public void setDtEnd(Date dtEnd) {
		this.dtEnd = dtEnd;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public Sprint toSprint() {
		Sprint sprint = new Sprint();
		sprint.setName(this.name);
		sprint.setDtBegin(this.dtBegin);
		sprint.setDtEnd(this.dtEnd);
		sprint.setDescription(this.description);
		sprint.setStatus(this.status);
		return sprint;
	}
}

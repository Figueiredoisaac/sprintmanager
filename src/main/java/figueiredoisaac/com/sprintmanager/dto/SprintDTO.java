package figueiredoisaac.com.sprintmanager.dto;

import java.util.Date;
import java.util.List;

import figueiredoisaac.com.sprintmanager.model.Backlog;
import figueiredoisaac.com.sprintmanager.model.Sprint;

public class SprintDTO {
	
	private Long id;
	private String name;
	private Date dtBegin;
	private Date dtEnd;
	private String description;
	private Boolean status;
	private List<Backlog> backlogs;
	
	public SprintDTO(Sprint sprint) {
		this.id = sprint.getId();
		this.name = sprint.getName();
		this.dtBegin = sprint.getDtBegin();
		this.dtEnd = sprint.getDtEnd();
		this.description = sprint.getDescription();
		this.status = sprint.getStatus();
		this.backlogs = sprint.getBacklogs();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public List<Backlog> getBacklogs() {
		return backlogs;
	}
	public void setBacklogs(List<Backlog> backlogs) {
		this.backlogs = backlogs;
	}
	
	public Sprint toSprint() {
		Sprint sprint = new Sprint();
		sprint.setId(this.id);
		sprint.setName(this.name);
		sprint.setDtBegin(this.dtBegin);
		sprint.setDtEnd(this.dtEnd);
		sprint.setDescription(this.description);
		sprint.setStatus(this.status);
		sprint.setBacklogs(this.backlogs);
		return sprint;
	}
}

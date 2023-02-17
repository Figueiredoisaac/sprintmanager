package com.figueiredoisaac.sprintmanager.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table (name="Sprints")
public class Sprint {
	
		@Id
		@Basic(optional = false)
		@Column(unique=true, nullable = false)
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(nullable = false)
		private String name;
		private Date dtBegin;
	    private Date dtEnd;
	    private String description;
	    private Boolean status;
	    
	    @ManyToMany (mappedBy="sprints")
	    private List<Backlog> backlogs;
	    
	    
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
		public void addBacklog(Backlog backlog) {
			this.backlogs.add(backlog);
		}
		
	    
	    
		
}

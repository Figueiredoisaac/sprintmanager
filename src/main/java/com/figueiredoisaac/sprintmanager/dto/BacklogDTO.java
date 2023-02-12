package com.figueiredoisaac.sprintmanager.dto;

import com.figueiredoisaac.sprintmanager.model.Backlog;

public class BacklogDTO {
    private Long id;
    private String name;
    private Long valor;
    private Long gut;
    private String userStory;
    
    public BacklogDTO( ) {}

    public BacklogDTO(Long id, String name, Long valor, Long gut, String userStory) {
		this.id = id;
		this.name = name;
		this.valor = valor;
		this.gut = gut;
		this.userStory = userStory;
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

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Long getGut() {
        return gut;
    }

    public void setGut(Long gut) {
        this.gut = gut;
    }

    public String getUserStory() {
        return userStory;
    }

    public void setUserStory(String userStory) {
        this.userStory = userStory;
    }
    
    public Backlog toBacklog() {
		Backlog backlog = new Backlog();
		backlog.setId(id);
		backlog.setName(name);
		backlog.setValor(valor);
		backlog.setGut(gut);
		backlog.setUserStory(userStory);
		
		
		return backlog;
	}
}

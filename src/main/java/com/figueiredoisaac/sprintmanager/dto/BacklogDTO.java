package com.figueiredoisaac.sprintmanager.dto;

import com.figueiredoisaac.sprintmanager.model.Backlog;

public class BacklogDTO {
    private String name;
    private Long valor;
    private Long gut;
    private String userStory;
    

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
		backlog.setName(name);
		backlog.setValor(valor);
		backlog.setGut(gut);
		backlog.setUserStory(userStory);
		
		
		return backlog;
	}
}

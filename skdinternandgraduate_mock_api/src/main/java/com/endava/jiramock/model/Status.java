package com.endava.jiramock.model;

import javax.persistence.*;

@Entity
public class Status {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;

    @ManyToOne
    private Project project;

    public Status() {
    }

    public Status(String name, String description, Project project) {
        this.name = name;
        this.description = description;
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

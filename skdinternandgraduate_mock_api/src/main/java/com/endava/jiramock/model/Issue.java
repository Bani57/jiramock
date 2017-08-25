package com.endava.jiramock.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Issue {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    @ManyToOne
    private Project project;
    @ManyToOne
    private Priority priority;
    @ManyToOne
    private Status status;
    private Date created_date;

    public Issue() {
    }

    public Issue(String name, String description, Project project, Priority priority, Status status, Date created_date) {
        this.name = name;
        this.description = description;
        this.project = project;
        this.priority = priority;
        this.status = status;
        this.created_date = created_date;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }
}

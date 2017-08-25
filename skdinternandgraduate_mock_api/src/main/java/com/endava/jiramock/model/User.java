package com.endava.jiramock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class User implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private Date last_request_time;


    @ManyToMany
    private List<Project> projects;

    public User() {
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public User(String username, String password, Date last_request_time, List<Project> projects) {

        this.username = username;
        this.password = password;
        this.last_request_time = last_request_time;
        this.projects = projects;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLast_request_time() {
        return last_request_time;
    }

    public void setLast_request_time(Date last_request_time) {
        this.last_request_time = last_request_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return (id != null ? id.equals(user.id) : user.id == null) && (username != null ? username.equals(user.username) : user.username == null) && (password != null ? password.equals(user.password) : user.password == null) && (last_request_time != null ? last_request_time.equals(user.last_request_time) : user.last_request_time == null) && (projects != null ? projects.equals(user.projects) : user.projects == null);
    }

}

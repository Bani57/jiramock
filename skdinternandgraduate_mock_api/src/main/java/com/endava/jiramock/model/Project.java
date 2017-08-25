package com.endava.jiramock.model;

import javax.persistence.*;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private String description;


    public Project() {
    }

    public Project(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

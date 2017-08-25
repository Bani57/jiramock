package com.endava.jiramock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Priority {

    @Id
    @GeneratedValue
    private Integer id;
    private String color;
    private String description;
    private String name;

    public Priority() {
    }

    public Priority(String color, String description, String name) {
        this.color = color;
        this.description = description;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Priority priority = (Priority) o;

        return (id != null ? id.equals(priority.id) : priority.id == null) && (color != null ? color.equals(priority.color) : priority.color == null) && (description != null ? description.equals(priority.description) : priority.description == null) && (name != null ? name.equals(priority.name) : priority.name == null);
    }

}

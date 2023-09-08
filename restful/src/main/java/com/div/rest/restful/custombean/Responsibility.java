package com.div.rest.restful.custombean;

import org.springframework.stereotype.Component;

@Component
public class Responsibility {
    private int id;
    private String description;

    public Responsibility() {
    }

    public Responsibility(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Responsibility{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}

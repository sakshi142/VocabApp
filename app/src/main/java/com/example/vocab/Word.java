package com.example.vocab;

import java.io.Serializable;

public class Word implements Serializable {
    private String name;
    private String adjective;
    private String description;

    public Word() {
    }

    public Word(String name, String adjective, String description) {
        this.name = name;
        this.adjective = adjective;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdjective() {
        return adjective;
    }

    public void setAdjective(String adjective) {
        this.adjective = adjective;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Word{" +
                "name='" + name + '\'' +
                ", adjective='" + adjective + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}



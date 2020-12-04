package ru.sapteh.model;

import java.util.HashSet;
import java.util.Set;

public class Provider {
    private Long id;
    private String name;
    private Set<Item> items = new HashSet<Item>();
    // Getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Set<Item> getItems() {
        return items;
    }
    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public String toString(){
        return String.format("Provider[id = %d, name = %s]", getId(), getName());
    }
}

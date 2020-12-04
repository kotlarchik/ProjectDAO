package ru.sapteh.model;

import java.util.HashSet;
import java.util.Set;

public class WareHouse {
    public static final String TABLE_NAME = "warehouses";
    public static final String ID_COLUMN = "id";
    public static final String ADDRESS_COLUMN = "address";
    // Polya
    private Long id;
    private String address;
    private Set<Item> items = new HashSet<Item>();
    // Getters
    public Long getId(){
        return id;
    }
    public String getAddress(){
        return address;
    }
    public Set<Item> getItems(){
        return items;
    }
    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public String toString(){
        return String.format("Warehouse [id = %d, address = %s]", getId(), getAddress());
    }
}

package ru.sapteh.dao;

import ru.sapteh.model.Item;

import java.util.List;

public interface ItemDao {
    String SQL_FIND_ALL = String.format("SELECT * FROM %s = ?", Item.TABLE_NAME);
    String SQL_FIND_ID = String.format("SELECT * FROM %s = ? WHERE id %s = ?", Item.TABLE_NAME, Item.ID_COLUMN);
    String SQL_INSERT = String.format("INSERT INTO %s (%s, %s) VALUES (?, ?)", Item.TABLE_NAME, Item.NAME_COLUMN, Item.ID_COLUMN);
    String SQL_UPDATE = String.format("UPDATE %s SET %s = ? WHERE %s = ?", Item.TABLE_NAME, Item.NAME_COLUMN, Item.ID_COLUMN);
    String SQL_DELETE = String.format("DELETE FROM %s WHERE %s = ?",  Item.TABLE_NAME, Item.ID_COLUMN);

    List<Item> findAll();
    Item findById(Long id);
    void insert (Item item);
    void update(Item item);
    void delete(Item item);
}
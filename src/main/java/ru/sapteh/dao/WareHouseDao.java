package ru.sapteh.dao;

import ru.sapteh.model.WareHouse;
import java.util.List;

public interface WareHouseDao {
    String SQL_FIND_ALL = "SELECT * FROM" + WareHouse.TABLE_NAME;
    String SQL_FIND_ID = "SELECT * FROM" + WareHouse.ID_COLUMN + " = ?";
    String SQL_INSERT = "INSERT INTO" + WareHouse.TABLE_NAME + "(" + WareHouse.ADDRESS_COLUMN + ")" + "VALUES (?)";
    String SQL_UPDATE = String.format("UPDATE %s SET %s = ? WHERE %s = ?", WareHouse.TABLE_NAME, WareHouse.ADDRESS_COLUMN, WareHouse.ID_COLUMN);
    String SQL_DELETE = String.format("DELETE FROM %d WHERE = ?",  WareHouse.TABLE_NAME, WareHouse.ID_COLUMN);

    List<WareHouse> findAll();
    WareHouse findById(Long id);
    void insert (WareHouse wareHouse);
    void update(WareHouse wareHouse);
    void delete(WareHouse wareHouse);
}
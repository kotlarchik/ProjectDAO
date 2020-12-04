package ru.sapteh.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sapteh.DataSource;
import ru.sapteh.dao.WareHouseDao;
import ru.sapteh.model.WareHouse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class WareHouseDaoImpl implements WareHouseDao {

    @Autowired
    private DataSource dataSource;

    public List<WareHouse> findAll() {
        List<WareHouse> list = new ArrayList<WareHouse>();
        Connection connection = null;
        WareHouse wareHouse = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                wareHouse = new WareHouse();
                wareHouse.setId(1, "id");
                wareHouse.setAddress(result.getString("address"));
                list.add(wareHouse);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            dataSource.closeConnection(connection);
        }
        return list;
    }

    public WareHouse findById(Long id) {
        Connection connection = null;
        WareHouse wareHouse = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, wareHouse.getAddress());
            statement.executeQuery();
            ResultSet result = statement.getGeneratedKeys();

            while(result.next()){
                wareHouse = new WareHouse();
                wareHouse.setId(result.getLong("id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            dataSource.closeConnection(connection);
        } return wareHouse;
    }

    public void insert(WareHouse wareHouse) {
        Connection connection = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, wareHouse.getAddress());
            ResultSet result = statement.getGeneratedKeys();
            int s = statement.executeUpdate();
            if(s == 1){
                wareHouse.setId(result.getLong(1));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            dataSource.closeConnection(connection);
        }
    }

    public void update(WareHouse wareHouse) {

    }

    public void delete(WareHouse wareHouse) {

    }
}


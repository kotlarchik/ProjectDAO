package ru.sapteh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private String url;
    private String login;
    private String password;
    // Getters
    public String getUrl() {
        return url;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    // Setters
    public void setUrl(String url) {
        this.url = url;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, login, password);
    }
    public void closeConnection(Connection connection){
        if (connection == null) return;
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
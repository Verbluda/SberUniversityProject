package com.homework_hairzamanova.SpringLibraryProject.dbexample.dao;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Component
public class UserDAO {
    private final Connection connection;

    private final String ADD_NEW_USER_QUERY = "insert into users(surname, name, birthday, phone, email, books) values (?, ?, ?, ?, ?, ?);";
    private final String BOOKS_SELECT_BY_USER_PHONE_QUERY = "select books from users where phone = ?;";

    public UserDAO(Connection connection) {
        this.connection = connection;
    }
    public void addNewUser(String surname, String name, Date birthday, String phone, String email, String[] books) throws SQLException {
        //String surname, String name, String birthday, String phone, String email, String books
        PreparedStatement selectQuery = connection.prepareStatement(ADD_NEW_USER_QUERY);
        selectQuery.setString(1, surname);
        selectQuery.setString(2, name);
        selectQuery.setDate(3, new java.sql.Date(birthday.getTime()));
        selectQuery.setString(4, phone);
        selectQuery.setString(5, email);
        selectQuery.setArray(6, connection.createArrayOf("text", books));
        selectQuery.execute();
    }
    public String[] findBooksByUserPhone(String userPhone) throws SQLException {
        PreparedStatement selectQuery = connection.prepareStatement(BOOKS_SELECT_BY_USER_PHONE_QUERY);
        selectQuery.setString(1, userPhone);
        ResultSet resultSet = selectQuery.executeQuery();
        while (resultSet.next()) {
            String[] listOfBooks = (String[]) resultSet.getArray("books").getArray();
            return listOfBooks;
        }
        return null;
    }
}

package com.homework_hairzamanova.SpringLibraryProject.dbexample.dao;

import com.homework_hairzamanova.SpringLibraryProject.dbexample.model.Book;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookDAO {
    private final Connection connection;
    private final String BOOK_SELECT_BY_ID_QUERY = "select * from books where title = ?";

    public BookDAO(Connection connection) {
        this.connection = connection;
    }
    public List<Book> findBooksByTitle(String[] titles) throws SQLException {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < titles.length; i++)
        {
            PreparedStatement selectQuery = connection.prepareStatement(BOOK_SELECT_BY_ID_QUERY);
            selectQuery.setString(1, titles[i]);
            ResultSet resultSet = selectQuery.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setAuthor(resultSet.getString("author"));
                book.setTitle(resultSet.getString("title"));
                book.setDateAdded(resultSet.getDate("date_added"));
                books.add(book);
            }
        }
        return books;
    }
}

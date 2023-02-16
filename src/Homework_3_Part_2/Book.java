package Homework_3_Part_2;

import java.util.Objects;

public class Book {
    private String author;
    private String title;
    private boolean isBorrowed;

    public Book() {}
    public Book(String author, String title) {
        this.author = author;
        this.title = title;
        isBorrowed = false;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.getAuthor()) && Objects.equals(title, book.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }

    @Override
    public String toString() {
        return (author != null && title != null) ? author + " - " + title : "В библиотеке нет такой книги";
    }
}

package Homework_3_Part_2;

import java.util.ArrayList;
import java.util.Objects;

public class Book {
    private String author;
    private String title;
    private boolean isBorrowed;
    private Visitor bookHolder;
    private ArrayList<Integer> rating = new ArrayList<>();

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

    public Visitor getBookHolder() {
        return bookHolder;
    }

    public void setBookHolder(Visitor bookHolder) {
        this.bookHolder = bookHolder;
    }

    public double getRating() {
        int sum = 0;
        int i = 0;
        for (; i < rating.size() - 1; i++) {
            sum += rating.get(i);
        }
        return ((double) sum / i);
    }

    public void setRating(int rating) {
        this.rating.add(rating);
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
        return (author != null && title != null) ? author + " - " + title : "Нет такой книги";
    }
}

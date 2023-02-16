package Homework_3_Part_2;

import java.util.ArrayList;
import java.util.Objects;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        } else {
            System.out.println("Книга \"" + book.getTitle() + "\", которую написал " + book.getAuthor() + ", уже есть в нашей библиотеке. " +
                    "В нашей библиотеке все книги представлены только в единственной эксземпляре.");
        }
    }

    public Book getBookByTitle(String title) {
        Book searchedBook = new Book();
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                searchedBook = b;
            }
        }
        return searchedBook;
    }

    public ArrayList<Book> getBooksByAuthor(String author) {
        ArrayList<Book> booksByAuthor = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().equals(author)) {
                booksByAuthor.add(b);
            }
        }
        return booksByAuthor;
    }
    public void removeBook(String title) {
        if (this.getBookByTitle(title).equals(new Book())) {
            System.out.println("Не получилось удалить, в библиотеке пока нет такой книги");
        } else {
            if (!this.getBookByTitle(title).isBorrowed()) {
                books.remove(this.getBookByTitle(title));
            } else {
                System.out.println("Книгу взял на время один из читатей, удалить её не получилось");
            }
        }
    }

    @Override
    public String toString() {
        String result = "В нашей библиотеке представлены книги (автор - название): \n";
        for (Book b : books) {
            result += b.toString() + "\n";
        }
        return result;
    }
}



package Homework_3_Part_2;

import java.util.ArrayList;
import java.util.Objects;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    private int visitorCount;
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

    public void borrowTheBookByTitle(String title, Visitor visitor) {
        Book book = this.getBookByTitle(title);
        if (books.contains(book) && !book.isBorrowed() && !visitor.equals(new Visitor()) && !visitor.isHoldingTheBook()) {
            if (visitor.getId() == null) {
                visitorCount++;
                visitor.setId(visitorCount);
            }
            book.setBorrowed(true);
            book.setBookHolder(visitor);
            visitor.setHoldingTheBook(true);
            visitor.setBook(book);
        } else if (!books.contains(book)) {
            System.out.println("Такой книги пока нет в библиотеке, мы не можем выдать её читателю на руки.");
        } else if (visitor.equals(new Visitor())) {
            System.out.println("Вы ещё не записались в нашу библиотеку, оформите читательский билет, чтобы брать книги");
        } else if (books.contains(book) && book.isBorrowed()) {
            System.out.println("Книга сейчас у другого читателя библиотеке, вы сможете одолжить её позже, когда он её вернет");
        } else if (!visitor.equals(new Visitor())) {
            System.out.println("Чтобы взять новую книгу, верните ту, что одалживали в прошлый раз");
        }
    }

    public void returnTheBook(String title, Visitor visitor, int rating) {
        Book book = this.getBookByTitle(title);
        if (book.getBookHolder().equals(visitor)) {
            if (rating > 0 && rating < 11) {
                book.setRating(rating);
                book.setBorrowed(false);
                book.setBookHolder(new Visitor());
                visitor.setHoldingTheBook(false);
                visitor.setBook(new Book());
            } else {
                System.out.println("Книгу можно оценить по 10-бальной шкале, введите свою оценку корректно");
            }
        } else {
            System.out.println("Эту книгу брал другой читатель, он должен вернуть её лично, вы не можете вернуть её вместо него");
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



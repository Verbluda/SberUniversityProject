package Homework_3_Part_2;

import java.util.Objects;

public class Visitor {
    private String name;
    private String surname;
    private Integer id;
    private Book book;
    private boolean isHoldingTheBook;
    public Visitor() {}
    public Visitor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isHoldingTheBook() {
        return isHoldingTheBook;
    }

    public void setHoldingTheBook(boolean holdingTheBook) {
        isHoldingTheBook = holdingTheBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitor visitor = (Visitor) o;
        return Objects.equals(name, visitor.getName()) &&
                Objects.equals(surname, visitor.getSurname()) &&
                Objects.equals(id, visitor.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, id);
    }

    @Override
    public String toString() {
        return (name != null && surname != null) ? name + " " + surname : "Нет такого читателя";
    }
}

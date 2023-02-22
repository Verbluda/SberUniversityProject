package Homework_3_Part_2;

import org.w3c.dom.ls.LSOutput;

public class TestLibrary {
    public static void main(String[] args) {
        Book book5 = new Book("Горький", "Мать"); //создаем одну книгу для теста (чтобы поменять статус на "взяли")
        Library library = new Library(); //создаем библиотеку и начинаем добавлять книги
        library.addBook(new Book("Толстой", "Война и мир"));
        library.addBook(new Book("Толстой", "Каренина"));
        library.addBook(new Book("Толстой", "Каренина")); //не добавляется книгу, которая уже есть
        library.addBook(new Book("Толстой", "Филипок"));
        library.addBook(new Book("Булгаков", "Мастер и Маргарита"));
        library.addBook(book5); //добавляем книгу, для которой сделаем статус "взяли"
        book5.setBorrowed(true); //меняем статус для теста
        System.out.println();

        System.out.println(library); //выводим сформировавшуюся библиотеку
        System.out.println();

        library.removeBook("Каренина"); //удаляется книга по названию
        library.removeBook("А зори здесь тихие..."); //книга не удаляется, нет такой книги в библиотеке
        library.removeBook("Мать"); //книга не удаляется, так как ее кто-то взял, и она недоступна
        System.out.println(library); //выводим библиотеку после удаления

        System.out.println(library.getBookByTitle("Карета")); //пытаемся получить по названию не добавленную книгу - нет такой книги
        System.out.println(library.getBookByTitle("Филипок")); //получаем книгу по названию
        System.out.println(library.getBooksByAuthor("Толстой")); //получаем список книг по автору

        Visitor ivanov = new Visitor("Иван", "Иванов");//создаем читателя 1
        System.out.println(ivanov.getId());
        library.borrowTheBookByTitle("Карета", ivanov);//не получается выдать несуществующую книгу
        library.borrowTheBookByTitle("Филипок", ivanov);//одалживаем ему книгу
        System.out.println(ivanov.getId());
        System.out.println(ivanov.getBook());
        library.borrowTheBookByTitle("Мастер и Маргарита", ivanov);//не получается выдать вторую книгу
        Visitor petrov = new Visitor();//не оформленный читатель
        library.borrowTheBookByTitle("Мастер и Маргарита", petrov);//не получается выдать книгу неоформленному читателю
        petrov.setName("Петр");
        petrov.setSurname("Петров");
        library.borrowTheBookByTitle("Филипок", petrov);//не получается одолжить уже одолженную книгу

        library.returnTheBook("Филипок", petrov, 4);//другой посетитель не может вернуть одолженную книгу
        System.out.println(library.getBookByTitle("Филипок").getBookHolder());
        System.out.println(library.getBookByTitle("Филипок").isBorrowed());
        System.out.println(ivanov.getBook());
        System.out.println(ivanov.isHoldingTheBook());
        library.returnTheBook("Филипок", ivanov, 3);
        System.out.println(library.getBookByTitle("Филипок").getBookHolder());
        System.out.println(library.getBookByTitle("Филипок").isBorrowed());
        System.out.println(ivanov.getBook());
        System.out.println(ivanov.isHoldingTheBook());

        library.borrowTheBookByTitle("Филипок", petrov);
        library.returnTheBook("Филипок", petrov, 5);
        System.out.println(library.getBookByTitle("Филипок").getRating());
    }
}

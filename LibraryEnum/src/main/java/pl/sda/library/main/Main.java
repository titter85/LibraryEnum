package pl.sda.library.main;

import pl.sda.library.Book;
import pl.sda.library.Library;
import pl.sda.library.Reader;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book(0, "Pan Lodowego Ogrodu", "Jarosław Grzędowicz", 545, 2012);
        Book b2 = new Book(1, "Kroniki Czarnej Kompanii", "Glen Cook", 920, 2009);
        Book b3 = new Book(2, "Kroniki Jakuba Wędrowycza", "Andrzej Pilipiuk", 296, 2011);
        Book b4 = new Book(3, "Ciemność Płonie", "Jakub Ćwiek", 312, 2008);
        Book b5 = new Book(4, "Szeptucha", "Katarzyna Berenika Miszczuk", 352, 2016);
        Book b6 = new Book(5, "Narrenturm", "Andrzej Sapkowski", 593, 2002);
        Book b7 = new Book(6, "Alice's Adventures in Wonderland", "Lewis Carroll", 320, 1865);

        Library library = new Library();

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addBook(b4);
        library.addBook(b5);
        library.addBook(b6);
        library.addBook(b7);

        Book longestBook = library.getLongestBook();
        Book shortestBook = library.getShortestBook();
        Book oldestBook = library.getOldestBook();
        Book youngestBook = library.getYoungestBook();

        System.out.println("--------------------------------------------------------------------");
        System.out.println("The longest book: " + longestBook.getFullInformation());
        System.out.println("The shortest book: " + shortestBook.getFullInformation());
        System.out.println("The oldest book: " + oldestBook.getFullInformation());
        System.out.println("The youngest book: " + youngestBook.getFullInformation());
        System.out.println("--------------------------------------------------------------------");

        Reader reader = new Reader(0, "Michał");
        library.registerReader(reader);

        library.borrowBook("Alice's Adventures in Wonderland", reader);

        System.out.println("All books:");
        library.getBooks().forEach(b -> System.out.println(b.getFullInformation()));
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Available books:");
        library.getAvailableBooks().forEach(b -> System.out.println(b.getFullInformation()));
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Unavailable books:");
        library.getUnavailableBooks().forEach(b -> System.out.println(b.getFullInformation()));
        System.out.println("--------------------------------------------------------------------");

        library.removeBook(b1);

        System.out.println("All books:");
        library.getBooks().forEach(b -> System.out.println(b.getFullInformation()));
        System.out.println("--------------------------------------------------------------------");
    }
}
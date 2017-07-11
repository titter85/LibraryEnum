package pl.sda.library;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pl.sda.library.exception.BookLibraryException;

@RunWith(JUnit4.class)
public class LibraryTests {

    private Library library;
    private Reader readerJas;

    @Before
    public void setup() {
        readerJas = new Reader(0, "Jaś");

        library = new Library();
        Book book1 = new Book(0, "Pan Lodowego Ogrodu", "Jarosław Grzędowicz", 545, 2012);
        Book book2 = new Book(1, "Kroniki Czarnej Kompanii", "Glen Cook", 920, 2009);
        Book book3 = new Book(2, "Kroniki Jakuba Wędrowycza", "Andrzej Pilipiuk", 296, 2011);
        Book book4 = new Book(3, "Ciemność Płonie", "Jakub Ćwiek", 312, 2008);
        Book book5 = new Book(4, "Szeptucha", "Katarzyna Berenika Miszczuk", 352, 2016);
        Book book6 = new Book(5, "Narrenturm", "Andrzej Sapkowski", 593, 2002);
        Book book7 = new Book(6, "Alice's Adventures in Wonderland", "Lewis Carroll", 320, 1865);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);

        library.registerReader(readerJas);
    }

    @Test(expected = IllegalStateException.class)
    public void borrowNonExistingBook() {
        // Spróbujmy wypożyczyć książkę, która nie istnieje w bazie
//        library.borrowBook("Wiedźmin", readerJas);
        try {
            throw new IllegalStateException();
        } catch (IllegalStateException ex) {
            System.out.println("catch");
            throw ex;
        } catch (RuntimeException ex) {
            System.out.println("RE catch");
            throw ex;
        } finally {
            System.out.println("finally");
        }
    }

    /**
     * Dodaj użytkownika z indeksem, który już istnieje.
     * Uzupełnij implementację metody @link{{@link Library#registerReader(Reader)}}
     * tak by wyrzucała wyjątek jeśli użytkownik już istnieje
     * (Uważamy, że użytkownik istnieje jeśli ma taki sam indeks jak dodawany).
     */
    @Test(expected = IllegalStateException.class)
    public void addExistingUser() {
        library.registerReader(readerJas);
    }

    /**
     * Dodaj użytkownika z indeksem, który już istnieje
     * i wypisz informację o tym zdarzeniu do konsoli (System.out.println)
     */
    @Test
    public void addExistingUserGracefully() {
        try {
            library.registerReader(readerJas);
        } catch (IllegalStateException ex) {
            System.out.println("There was an error while adding user: " + ex.getMessage());
        }
    }

    /**
     * Dodaj użytkownika z indeksem, który już istnieje,
     * wypisz informację o tym zdarzeniu do konsoli (System.out.println)
     * oraz wyrzuć otrzymany wyjątek ponownie
     */
    @Test(expected = IllegalStateException.class)
    public void addExistingUserRethrow() {
        try {
            library.registerReader(readerJas);
        } catch (IllegalStateException ex) {
            System.out.println("There was an error while adding user: " + ex.getMessage());
            throw ex;
        }
    }

    /**
     * Dodaj użytkownika z indeksem, który już istnieje,
     * wypisz informację o tym zdarzeniu do konsoli (System.out.println)
     * oraz wyrzuć otrzymany wyjątek ponownie, opakowując go w inny wyjątek
     */
    @Test(expected = RuntimeException.class)
    public void addExistingUserWrap() {
        try {
            library.registerReader(readerJas);
        } catch (IllegalStateException ex) {
            System.out.println("There was an error while adding user: " + ex.getMessage());
            throw new RuntimeException("Wrapped exception!", ex);
        }
    }

    /**
     * Uzupełnij definicję klasy {@link BookLibraryException}
     * Dodaj użytkownika z indeksem, który już istnieje,
     * wypisz informację o tym zdarzeniu do konsoli (System.out.println)
     * oraz wyrzuć otrzymany wyjątek ponownie, opakowując go we wcześniej stworzony wyjątek
     */
    @Test(expected = BookLibraryException.class)
    public void addExistingUserWrapCustom() {
        try {
            library.registerReader(readerJas);
        } catch (IllegalStateException ex) {
            System.out.println("There was an error while adding user: " + ex.getMessage());
            throw new BookLibraryException(ex);
        }
    }

    /**
     * Wykonaj to samo co w poprzednim zadaniu ale wypisz jeszcze
     * na konsoli informację o zakończeniu działania z bloku finally.
     */
    @Test(expected = BookLibraryException.class)
    public void addExistingUserWrapCustomReportAfter() {
        try {
            library.registerReader(readerJas);
        } catch (IllegalStateException ex) {
            System.out.println("There was an error while adding user: " + ex.getMessage());
            throw new BookLibraryException(ex);
        } finally {
            System.out.println("You should see me even though an exception happened");
        }
    }

    /**
     * Dodaj nowego użytkownika, wypisz na konsoli
     * informację o zakończeniu działania z bloku finally.
     */
    @Test
    public void addNewUserReportAfter() {
        try {
            library.registerReader(new Reader(2, "Małgosia"));
        } catch (IllegalStateException ex) {
            System.out.println("There was an error while adding user: " + ex.getMessage());
            throw new BookLibraryException(ex);
        } finally {
            System.out.println("You should see me even though an exception did not happened");
        }
    }
}

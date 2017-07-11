package pl.sda.library.exception;


/**
 * Swoje własne wyjątki definiujemy dziedzicząc po klasach
 * {@link RuntimeException}, {@link Exception} lub {@link Error} lub ich klasach pochodnych.
 * <p><p><p>
 * Uzupełnij definicję tej klasy tak, by posiadała jeszcze jeden konstruktor
 * przyjmujący obiekt Throwable i wywołujący konstruktor z klasy RuntimeException(String, Throwable)
 * z twoim własnym tekstem wiadomości
 */
public class BookLibraryException extends RuntimeException {
    public BookLibraryException(String msg, Throwable ex) {
        super(msg, ex);
    }

    public BookLibraryException(Throwable ex) {
        super("Problem using book library, more details below", ex);
    }
}

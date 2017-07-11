package pl.sda.library;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SuppressWarnings("Duplicates")
public class Library {

    private final List<Book> books = new ArrayList<>();
    private final List<Reader> readers = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        Book bookToRemove = findBook(b -> b.index == book.index);
        books.remove(bookToRemove);
    }

    public void registerReader(Reader reader) {
        Optional<Reader> existingReader = readers.stream()
                .filter(it -> it.index == reader.index)
                .findFirst();

        if (existingReader.isPresent()) {
            throw new IllegalStateException("Cannot add new reader with the same index!");
        }

        readers.add(reader);
    }

    public void borrowBook(String title, Reader borrowingReader) {
        Optional<Reader> reader = readers.stream()
                .filter(r -> r.index == borrowingReader.index)
                .findFirst();

        if (!reader.isPresent()) {
            throw new IllegalStateException("The reader is not registered in the library");
        } else {
            Book book = findBook(b -> b.title.equals(title) && b.isAvailable);
            book.isAvailable = false;
            reader.get().addBook(book);
        }
    }

    public Book getOldestBook() {
        if (books.isEmpty()) {
            throw new IllegalStateException("There are no books in the Library");
        }

        return books.stream()
                .min(Comparator.comparingInt(b -> b.year))
                .get();
    }

    public Book getYoungestBook() {
        if (books.isEmpty()) {
            throw new IllegalStateException("There are no books in the Library");
        }

        return books.stream()
                .max(Comparator.comparingInt(b -> b.year))
                .get();
    }

    public Book getLongestBook() {
        if (books.isEmpty()) {
            throw new IllegalStateException("There are no books in the Library");
        }

        return books.stream()
                .max(Comparator.comparingInt(b -> b.pages))
                .get();
    }

    public Book getShortestBook() {
        if (books.isEmpty()) {
            throw new IllegalStateException("There are no books in the Library");
        }

        return books.stream()
                .min(Comparator.comparingInt(b -> b.pages))
                .get();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getAvailableBooks() {
        return books.stream()
                .filter(b -> b.isAvailable)
                .collect(Collectors.toList());
    }

    public List<Book> getUnavailableBooks() {
        return books.stream()
                .filter(b -> !b.isAvailable)
                .collect(Collectors.toList());
    }

    private Book findBook(Predicate<Book> predicate) {
        Optional<Book> book = books.stream()
                .filter(predicate)
                .findFirst();

        if (!book.isPresent()) {
            throw new IllegalStateException("Can't find the book!");
        }

        return book.get();
    }
}
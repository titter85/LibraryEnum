package pl.sda.library;

import java.util.ArrayList;
import java.util.List;

public class Reader {
    public final int index;
    public final String name;

    private final List<Book> borrowedBooks = new ArrayList<>();

    public Reader(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public void addBook(Book book) {
        borrowedBooks.add(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reader reader = (Reader) o;

        if (index != reader.index) return false;
        if (!name.equals(reader.name)) return false;
        return borrowedBooks.equals(reader.borrowedBooks);
    }

    @Override
    public int hashCode() {
        int result = index;
        result = 31 * result + name.hashCode();
        result = 31 * result + borrowedBooks.hashCode();
        return result;
    }
}
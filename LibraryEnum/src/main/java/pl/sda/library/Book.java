package pl.sda.library;

public class Book {

    public final int index;
    public final String title;
    public final String author;
    public final int pages;
    public final int year;

    public boolean isAvailable = true;

    public Book(int index, String title, String author, int pages, int year) {
        this.index = index;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = year;
    }

    public String getFullInformation() {
        return "Index: " + index + ", Title: " + title + ", Author: " + author + ", Year: " + year + ", Pages: " + pages + ", IsAvailable: " + isAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (index != book.index) return false;
        if (pages != book.pages) return false;
        if (year != book.year) return false;
        if (isAvailable != book.isAvailable) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        return author != null ? author.equals(book.author) : book.author == null;
    }

    @Override
    public int hashCode() {
        int result = index;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + pages;
        result = 31 * result + year;
        result = 31 * result + (isAvailable ? 1 : 0);
        return result;
    }
}
package LibraryManagementSystem.repository;

import LibraryManagementSystem.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private final List<Book> books=new ArrayList<>();
    public void add(Book book) {
        books.add(book);
    }
    public void remove(Book book) {
        books.remove(book);
    }
    public List<Book> getAllBooks() {
        return books;
    }
    public  Book getBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}

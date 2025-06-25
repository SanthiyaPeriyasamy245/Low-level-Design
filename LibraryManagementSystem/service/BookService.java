package LibraryManagementSystem.service;

import LibraryManagementSystem.repository.BookRepository;
import LibraryManagementSystem.model.Book;

import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public boolean addBook(String title, String author, String genre) {
        if (bookRepository.getBookByTitle(title) == null) {
            Book book = new Book(title, author, genre);
            book.setAvailable(true);
            bookRepository.add(book);
            return true;
        }
        return false;
    }
    public boolean updateBook(String oldTitle, String newTitle, String newAuthor, String newGenre) {
        Book book = bookRepository.getBookByTitle(oldTitle);
        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            book.setGenre(newGenre);
            return true;
        }
        return false;
    }
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
    public  Book getBookByTitle(String title) {
        return bookRepository.getBookByTitle(title);
    }
    public boolean removeBook(String title) {
        Book book = bookRepository.getBookByTitle(title);
        if (book != null) {
            bookRepository.remove(book);
            return true;
        }
        return false;
    }
}

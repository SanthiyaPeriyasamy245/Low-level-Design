package LibraryManagementSystem.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Member {
   private String userName;
   private List<Book> borrowedBooks=new ArrayList<>();

    public Member(String userName) {
        this.userName = userName;
    }
    public boolean borrowBook(Book book) {
        if(book.isAvailable() && borrowedBooks.size()<5) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            book.setBorrowDate(LocalDate.now());
            return true;
        }
        return false;
    }
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailable(true);
            book.setBorrowDate(null);
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public String toString() {
        return "Member{" +
                "userName='" + userName + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}

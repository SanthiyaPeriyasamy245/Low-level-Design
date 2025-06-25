package LibraryManagementSystem;

import LibraryManagementSystem.repository.BookRepository;
import LibraryManagementSystem.repository.MemberRepository;
import LibraryManagementSystem.controller.LibraryController;
import LibraryManagementSystem.service.BookService;
import LibraryManagementSystem.service.MemberService;

public class Main {

    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        MemberRepository memberRepository = new MemberRepository();
        MemberService memberService = new MemberService(memberRepository);
        BookService bookService = new BookService(bookRepository);
        LibraryController controller= new LibraryController(bookService, memberService);
        controller.run();
    }
}

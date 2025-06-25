package LibraryManagementSystem.service;

import LibraryManagementSystem.repository.MemberRepository;
import LibraryManagementSystem.model.Book;
import LibraryManagementSystem.model.Member;

import java.util.List;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member login(String userName) {
        return memberRepository.findOrCreate(userName);
    }

    public boolean borrowBook(Member member, Book book) {
        return member.borrowBook(book);
    }

    public void returnBook(Member member, Book book) {
        member.returnBook(book);
    }


    public List<Member> getAllMembers() {
        return memberRepository.getAllMembers();
    }
}
package LibraryManagementSystem.repository;

import LibraryManagementSystem.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    private final List<Member> members=new ArrayList<>();

    Member member=null;
    public Member findOrCreate(String user)
    {
        for (Member member : members) {
            if (member.getUserName().equalsIgnoreCase(user)) {
                return member;
            }
        }
        member = new Member(user);
        members.add(member);
        return member;
    }
    public List<Member> getAllMembers() {
        return members;
    }
}

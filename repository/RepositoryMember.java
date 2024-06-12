package repository;

import java.util.ArrayList;
import java.util.List;

import model.Member;

public class RepositoryMember {
    public static List<Member> getAllMembers(){
        Member member1 = new Member("M-001", "Risman", "Bandung");
        Member member2 = new Member("M-002", "Budi", "Bandung");
        Member member3 = new Member("M-003", "Resti", "Kab. Bandung");

        List<Member> memberList = new ArrayList<>();
        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);

        return memberList;
    }
}

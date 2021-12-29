package ch13;

public class MemberHashSetTest {

    public static void main(String[] args) {
        MemberHashSet memberHashSet = new MemberHashSet();

        Member memberL = new Member(1001, "Lee");
        Member memberK = new Member(1002, "Kim");
        Member memberC = new Member(1003, "Choi");

        memberHashSet.addMember(memberL);
        memberHashSet.addMember(memberK);
        memberHashSet.addMember(memberC);

        memberHashSet.showAllMember();

//        Id 중복
        Member memberP = new Member(1003, "Park");
        memberHashSet.addMember(memberP);
        memberHashSet.showAllMember();

    }
}

package ch11;

public class MemberArrayListTest {

    public static void main(String[] args) {
        MemberArrayList memberArrayList = new MemberArrayList();

        Member memberL = new Member(1001, "Lee");
        Member memberK = new Member(1002, "Kim");
        Member memberC = new Member(1003, "Choi");
        Member memberP = new Member(1004, "Park");


        memberArrayList.addMember(memberL);
        memberArrayList.addMember(memberK);
        memberArrayList.addMember(memberC);
        memberArrayList.addMember(memberP);

        memberArrayList.showAllMember();
        memberArrayList.removeMember(memberK.getMemberId());
        memberArrayList.showAllMember();

    }
}

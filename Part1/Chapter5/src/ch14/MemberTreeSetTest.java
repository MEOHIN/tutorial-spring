package ch14;

import java.util.Comparator;
import java.util.TreeSet;


public class MemberTreeSetTest {

    public static void main(String[] args) {

//        TreeSet<String> set = new TreeSet<String>();
//
//        set.add("Lee");
//        set.add("Kim");
//        set.add("Park");
//
//        System.out.println(set);


        MemberTreeSet memberTreeSet = new MemberTreeSet();
/*
        Member memberP = new Member(1004, "Park");
        Member memberL = new Member(1001, "Lee");
        Member memberK = new Member(1002, "Kim");
        Member memberC = new Member(1003, "Choi");

        memberTreeSet.addMember(memberP);
        memberTreeSet.addMember(memberL);
        memberTreeSet.addMember(memberK);
        memberTreeSet.addMember(memberC);

        memberTreeSet.showAllMember();

//        memberTreeSet.showAllMember();
*/

        TreeSet<String> set = new TreeSet<String>(new MyCompare());
        set.add("Park");
        set.add("Kim");
        set.add("Lee");

        System.out.println(set);
    }
}

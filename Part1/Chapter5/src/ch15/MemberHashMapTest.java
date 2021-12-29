package ch15;

import java.util.HashMap;

public class MemberHashMapTest {

    public static void main(String[] args) {

        MemberHashMap memberHashMap = new MemberHashMap();

        Member memberP = new Member(1004, "Park");
        Member memberL = new Member(1001, "Lee");
        Member memberK = new Member(1002, "Kim");
        Member memberC = new Member(1003, "Choi");

        memberHashMap.addMember(memberP);
        memberHashMap.addMember(memberL);
        memberHashMap.addMember(memberK);
        memberHashMap.addMember(memberC);

        memberHashMap.showAllMember();

        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(1001, "K");
        hashMap.put(1002, "L");
        hashMap.put(1003, "P");
        hashMap.put(1004, "H");

        System.out.println(hashMap);

    }
}

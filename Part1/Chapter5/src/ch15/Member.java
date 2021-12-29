package ch15;

import java.util.Comparator;

public class Member implements Comparator<Member> {

    private int memberId;       // 회원 ID
    private String memberName;  // 회원 이름

    public Member(int memberId, String memberName){     // 생성자

        this.memberId = memberId;
        this.memberName = memberName;
    }

    public Member() {}

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public int hashCode() {
        return memberId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member){
            Member member = (Member) obj;
            if (this.memberId == member.memberId){
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return (memberName + " 회원님의 ID는 " + memberId + "입니다.");
    }

///**     implements Comparable
//*       compareTo: 새로 들어가는 element인데, tree에서 적절한 자리를 잡을 때까지 기존의 tree를 구성하는 요소들 하나씩 비교
//*/
//    @Override
//    public int compareTo(Member member) {
//
////        if (this.memberId > member.memberId){
////            return -1;
////        }
////        else if (this.memberId < member.memberId){
////            return 1;
////        }
////        else {
////            return 0;
////        }
//
//        return (this.memberId - member.memberId);
//
//    }

    /**     implements Comparator
     *      기존에 이미 Comparable 구현된 경우 Comparator로 비교하는 방식을 다시 구현할 때 활용
     */
    @Override
    public int compare(Member member1, Member member2) {
        return (member1.memberId - member2.memberId);
    }

}

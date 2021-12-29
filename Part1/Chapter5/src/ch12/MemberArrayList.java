package ch12;

/**     Iterator
 *      컬렉션 프레임뭐크에 저장된 요소들을 하나씩차례로 참조하는 것
 *      순서가 있는 List 인터페이스는 Iterator를 사용하지 않고 get(i) 메서드를 활용
 *      Set 인터페이스의 경우 get(i) 메서드가 제공되지 않으므로 Iterator를 활용하여 객체를 순회
 *      모든 컬렉션에 대해 Iterator 할 수 있다.
 */

import java.util.ArrayList;
import java.util.Iterator;

public class MemberArrayList {

    private ArrayList<Member> arrayList;

    public MemberArrayList(){
        arrayList = new ArrayList<>();
    }

    public MemberArrayList(int size){
        arrayList = new ArrayList<>(size);
    }

    public void addMember(Member member){
        arrayList.add(member);
    }

    public boolean removeMember(int memberId){

//        for (int i=0; i<arrayList.size(); i++){
//            Member member = arrayList.get(i);
//
//            int tempId = member.getMemberId();
//            if (tempId == memberId){
//                arrayList.remove(i);
//                return true;
//            }
//        }

        Iterator<Member> ir = arrayList.iterator();
        while (ir.hasNext()){
            Member member = ir.next();

            int tempId = member.getMemberId();
            if (tempId == memberId){
                arrayList.remove(member);
                return true;
            }
        }

        System.out.println(memberId + "가 존재하지 않습니다.");
        return false;
    }

    public void showAllMember(){

        for (Member member : arrayList){
            System.out.println(member);
        }
        System.out.println();
    }
}

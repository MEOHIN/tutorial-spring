# Cascade
- 하나의 객체에서 다음 객체로 영속성을 흘려보내준다는 의미
- 연관관계가 있는 경우 설정할 수 있다.
- default 는 빈 배열이다: 어떤 영속성도 전이시키지 않는다.

## Cascade type
1. ALL
2. PERSIST
3. MERGE
4. REMOVE
   - cascade 는 상위 객체가 remove action 을 취하면 포함하고 있는 객체의 해당 영속성 이벤트를 전파해서 하위 entity 까지 remove 한다.
   - orphan removal (고아 제거) : 연관관계가 없는 entity 제거
     - setter 를 통해서 null 을 주입하면 연관관계가 끊어진다.
     - 연관관계가 끊어진 상태에서는 remove 이벤트가 발생하지 않는다.
       - `orphanRemoval = true` 고아 객체를 사라지게 할 때
       - `orphanRemoval = false` 는 객체를 살려둘 때
   - soft delete
     - 탈퇴한 회원정보 삭제같은 특별한 경우를 제외하면 일반적으로 delete 쿼리를 이용해 DB 데이터를 삭제하는 경우는 거의 없고, flag 를 활용해서 지웠다고 인식하는 방식을 사용한다.
     - entity 에 @Where 를 사용하여 탈퇴한 계정이 로그인 하는 것과 같은 사이드 이팩트 방지
       - 데이터베이스에는 값이 존재하지만, 로직상에는 출력되지 않도록 deleted 갑을 flag 값으로 처리
5. REFRESH
6. DETACH
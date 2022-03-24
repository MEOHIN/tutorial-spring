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
5. REFRESH
6. DETACH
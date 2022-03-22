# Cascade
- 하나의 객체에서 다음 객체로 영속성을 흘려보내준다는 의미
- 연관관계가 있는 경우 설정할 수 있다.
- default 는 빈 배열이다: 어떤 영속성도 전이시키지 않는다.

## Cascade type
1. ALL
2. PERSIST
3. MERGE
4. REMOVE
5. REFRESH
6. DETACH
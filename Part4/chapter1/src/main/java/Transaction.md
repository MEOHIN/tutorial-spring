# Transaction
DB 의 명령어들의 논리적인 묶음
물건을 구매하는 행위란? 결제 행위 + 물건 구입하는 행위 가 동시에 일어나고 이 두 행위가 한 번에 일어나야하는데, 이를 하나의 트랜잭션이라고 한다.

## ACID
- A : 원자성
    - 부분적인 성공을 허용하지 않는다. all or nothing
- C : 일관성
    - 데이터간의 정확성을 맞춘다.
        - 내가 송금하려면 내 계좌 잔액도 0보다 커야하고 성공을 했으면 0 또는 0 이상의 잔액이 있어야한다.
        - 내 돈을 송금받은 사람의 계좌 잔액은 0 보다 커야한다.
- I : 독립성
    - 트랜젝션 내의 데이터 조작은 다른 트랜젝션으로부터 독립성을 가진다.
    - 아래와 같은 문제를 방지하기 위해서다.
        1. 내가 친구에게 송금을 하는 경우, 친구 통장에 돈이 입금된 후에 내 통장에서 돈이 차감된다.
        2. 그런데 내 통장에서 돈이 차감되기전에 친구 통장에서 돈이 인출됐다.
        3. 내 통장에서 금액을 차감하는 과정에 오류가 발생해서 원자성에 근거하여 송금을 취소하려는데, 이미 친구 통장은 인출이 발생했다.
        4. 이 때 친구 통장에 문제가 발생한다.
- D : 지속성
    - 데이터는 영구적으로 보관된다.
    - 내가 친구의 통장으로 송금한 내역이 시간이 지나도 남아 있다.

## JPA 에서 Transaction 을 설정하는 방법
@Transactional 을 사용한다.
- JPA 에서 트랜젝션의 시작과 끝은 각 메소드의 처음과 끝이다.

### Transaction 의 잘못된 사용
1. checked exception 사용
   - checked exception 이란?
     - RuntimeException 의 상위 exception 이다.
     - throws Exception 을 사용하여 명시적으로 exception 처리를 해줘야 한다.
2. private 메소드 또는 Bean 클래 내부로 호출되는 메소드에 @Transactional 사용
    - spring container 는 bean 으로 진입할 때 Annotation 을 처리하도록 돼있다.
   - bean 내부에서 메소드가 호출될 경우 @Transactional 이 있다하더라도 무시된다.

### @Transactional ; springframework 가 제공
1. isolation : 트랜젝션 격리
   - java 에서 제공하는 @Transactional 에는 isolation 을 지원하지 않는다.
   - 트랜젝션 격리: 동시에 발생하는 트랜젝션 간의 데이터 접근을 어떤 방식으로 정리할 지 정리하는 것
   - 단계에 따라 격리수준은 레벨 0 부터 레벨 3 까지 있고, 레벨 3에 가까울 수록 격리 단계가 강력해지고 데이터 정확성을 보장하는 대신 동시처리 수행 성능이 저하된다.
     1. DEFAULT: DB default 격리단계
        - mysql 은 default 격리단계가 REPEATABLE_READ 단계다.
     2. READ_UNCOMMITTED : 레벨 0
        - dirty read 가 발생하여 데이터가 중간에 틀어지는 문제가 발생한다.
        - 데이터의 정확성을 해치므로 일반적으로는 잘 사용하지 않는다.
     3. READ_COMMITTED : 레벨 1
        - 커밋된 데이터만 읽어온다.
     4. REPEATABLE_READ : 레벨 2
        - 트랜잭션 내에서 반복적으로 조회하더라도 항상 같은 값을 리턴한다.
        - UNREPEATABLE_READ: update 또는 insert 작업을 하지 않았지만, 트랜잭션 내에서 단지 값을 반복적으로 조회했을 뿐인데도 값이 중간에 변경되는 경우
        - phantom read: 데이터가 안 보이는 데 처리
     5. SERIALIZABLE : 레벨 3
        - 커밋이 일어나지 않은 트랜젝션이 존재하게되면 락을 통해서 웨이팅을 하고, 커밋이 실행되어야만 추가적인 로직을 실행한다.
2. propagation
   - java 에서 제공하는 @Transactional 은 전파 (propagation) 타입이다.

### Transaction 전파 (propagation) 속성
현재 트랜젝션과 또 다른 클래스의 메소드의 트랜젝션 간의 처리에 대해 교통정리하는 것
1. REQUIRED
   - 트랜젝션을 선언만 하고 아무런 propagation 속성을 취하지 않을 경우의 default 는 REQUIRED 전파 상태를 가진다.
   - 기존 사용하던 트랜젝션이 있다면 그 트랜젝션을 사용하고, 없다면 새로운 트랜젝션을 생성해서 사용하겠다는 의미
2. SUPPORTS
3. MANDATORY
4. REQUIRES_NEW
5. NOT_SUPPORTED
6. NEVER
7. NESTED
# Persistence Context ( 영속성 맥락 )
## Context 란?
- 프레임워크에서 컨테이너들이 관리하고 있는것
- Spring Context: Spring 의 Bean 들을 모두 로딩/관리 하는 모든 일련의 작업

## Persistence 란?
- 사라지지 않고 지속적으로 접근할 수 있다
- 보통 메모리에 존재하는 데이터는 서비스가 종료되면 사라진다. 그런 데이터를 사라지지 않고 지속적으로 처리하는 방법은 File 로 저장하거나 DB 에 저장하는 것
- JPA ( Java Persistence API ) : 데이터를 영속화 하는데에 사용하는 컨테이너 = 영속성 컨테이터
- 실제 영속성 컨텍스트에 가장 주체적인 역할을 하는 클래스는 Entity manager 라는 Bean

###### 영속성 컨텍스트 설정은 Persistence xml 이라는 File 을 META-INF 라는 디렉토리 하위에 생성해서 사용한다.
- 이렇게 설정한 것은 실제로 LocalContainerEntityManagerFactoryBean 의 setPersistenceXmlLocation 이라고 지정하도록 돼 있다.
  - Persistence xml 을 로딩해서 Persistence Context 의 설정을 사용한다.
- 지금까지는 build.gradle 에 'org.springframework.boot:spring-boot-starter-data-jpa' 의존성을 추가했기 때문에 영속성 컨텍스트를 신경쓰지 않고도 JPA 를 활용할 수 있었다.

### dialect 란?
- entity 나 repository 에서 사용하는 orm 을 실제로는 DB query 로 변환해서 jdbc 를 통해 전달하도록 돼있다. 그 사이에 실제 java 언어에서 사용하는 getter, setter, save 등을 특정한 DB query 로 변환하기 위해서 어떤 query 로 변경할 지 정하는 것이 dialect 다.

### ddl
```yaml
generate-ddl: true  # 자동으로 entity 에서 활용하는 테이블들을 생성하는 opt 이다. default 는 false 다.
hibernate:
  ddl-auto: create-drop
```

#### generate-ddl 와 hibernate:ddl-auto 차이
- test 를 활용하는 h2 DB 의 경우엔, 별다른 설정없이 기본적으로 generate-ddl 을 다 처리해주므로 설정할 필요가 없다. 
- 운영 DB 의 경우 자동화된 ddl 구문을 사용하는 것은 위험성이 있기때문에 실제로는 false 와 none 의 조합으로 다 막아버린다.

##### generate-ddl
- yml 계층에서 볼 수 있는 것 처럼, jpa 하위 속성이다.
- JPA 는 interface 에 대한 정의이고, 실제 구현체는 별도로 존재한다. 즉 generate-ddl 옵션은 구현체와 상관없이 자동화된 ddl 을 사용할 수 있도록 설정하는 값이다. = 범용적인 옵션이다.
- Spring 공서 문서에 따르면, generate-ddl 보다 hibernate:ddl-auto 옵션이 좀 더 세밀한 옵션이므로 둘의 설정이 어긋날 경우 generate-ddl 옵션을 무시히고 ddl-auto 을 우선적으로 사용한다.

##### hibernate:ddl-auto
- generate-ddl 에 비해, hibernate 에서 제공하는 좀 더 세밀한 옵션이다.

##### Spring 문서에 따르면, embedded DB 를 사용하면 default 로 ddl-auto: create-drop 으로 동작한다.
- h2 DB 는 embedded DB 의 일종이라서 따로 설정을 하지 않아도 ddl-auto: create-drop 으로 동작한다.

- initialization-mode: always 설정으로 스키마.sql 과 ddl-auto 와 충돌할 시, initialization-mode: always 가 우선시 적용되고 ddl-auto 는 무시된다.

## Entity 캐시
### Entity manager
- 영속성 컨텍스 안에서 entity 는 생성되고 조회되고 지워진다.
- 영속성 컨텍스 안에서 가장 중요한 역할을 하는 것이 entity manager 라는 객체다.
- entity manager 는 JPA 에서 정의하고 있는 interface 중 하나다: query 할 수 있도록 메소드에 정의가 들어있다.
- entity manager 의 실제 구현체를 Bean 으로 등록하고 있기 때문에 Autowired 를 이용해 사용할 수 있다.
- entity manager 는 entity 를 처리하는 과정에서 캐시를 사용한다.
  - save 메서드를 실행시키는 시점에 DB 에 반영되지 않는다.
    - 사용하는 영속성 컨텍스트와 실제 DB 사이에 데이터 갭이 발생한다.

- 기존에 사용했던 쿼리 메소드인 Simple JPA Repository 는 직접적으로 entity manager 를 사용하지 않아도 되도록 힌 번 더 래핑해서 쉽게사용할 수 있도록 spring 에서 제공한다.
  - 실제로는 Simple JPA Repository 와 같은 메소드도 entity manager 를 통해서 실행된다.
  - 만약 Spring Data JPA 에서 제공하지 않는 기능을 사용하거나, 성능적인 이슈와 같은 특별한 이유로 별도로 커스터마이징이 필요한 경우엔 entity manager 를 직접 받아서 처리하면 된다.
- entity manager 는 Hibernate 에서 제공하는 SessionImpl 구현체를 사용하는데, 이 SessionImpl 도 entity manager 를 구현하는 방식으로 돼있다.
  - Hibernate 에서는 entity manager 를 Session 이라고 부른다.

### entity cache
- 조회시에 진짜 DB 에 쿼리를 조회하지 않고, 영속성 컨텍스트 내에 존재하는 entity cache 에서 직접처리한다.
  - 따로 cache 설정을 하지 않았지만, 영속성 컨텍스트 내에서 자동으로 entity 에 대해서 cache 처리하는 것을 일반적으로 JPA 의 1차 cache 라고 한다.
  - 1차 캐시는 map 의 형태로 만들어 진다. key 는 id 값, value 는 해당 entity 가 들어있다.
    - id 로 조회하면 영속성 컨텍스트 내에 존재하는 1차 캐시에 entity 있는지 확인해보고 있으면 DB 조회없이 바로 값을 리턴
    - 1차 캐시일 때 entity 가 존재하지 않는다면, 실제 쿼리 DB 에 조회해서 1차 캐시에 저장하고 리턴한다.
    - 하나의 트랜젝션 안에서 동작을 할 땐 1차 캐시가 동작함에 따라 JPA 조회 성능이 저하를 방지한다.
- 영속성 컨텍스트가 존재함에 따라 JPA 특징 지연 쓰기가 발생한다.
- 영속성 컨텍스트 내에서 entity manager 가 자체적으로 entity 상태를 merge 하고 최종적으로 DB에 반영해야하는 내용에 대해서만 쿼리가 실행된다.

#### flush()
- 영속성 컨텍스트에 쌓여있는 데이터는 entity manager 가 자체적으로 DB 에 영속화를 해주지만, 사실은 개발자가 의도한 타입의 DB 영속화가 일어나지 않는다.
- 개발자가 원하는 시기에 DB 에 영속화를 해주기 위해 flush 메소드를 사용
  - 영속성 cache 에 쌓여서 아직 반영되지 않는 entity 변경을 해당 메서드 실행시점에 모두 DB 에 반영
- flush 를 남발하면 영속성 cache 의 장점을 무효화할 수 있으므로 적절히 사용
  - data history 가 계속 쌓이는 문제 발생

### 영속성 cache 에 있는 query 가 DB 에 반영되는 시점
1. Transaction 이 종료되어 해당 쿼리가 커밋되는 시점에 auto flush 가 발생하고 DB 에 데이터가 반영된다.
2. 개발자가 작성한 flush 메소드가 실행되는 시점에 DB 에 반영
3. jpql 쿼리가 실행될 때 복잡한 조건의 쿼리가 실행되면 auto flush 가 발생하고 DB 에 데이터가 반영한다.
   - 안

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
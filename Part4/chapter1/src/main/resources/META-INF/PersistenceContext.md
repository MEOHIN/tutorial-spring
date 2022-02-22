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
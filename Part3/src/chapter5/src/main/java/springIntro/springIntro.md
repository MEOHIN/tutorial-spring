# Spring
- 테스트 용의성
- 느슨한 결합

##### POJO
1. IoC / DI : 의존 관계 주입
2. AOP : 관점 중심 프로그램
3. PSA : 이식 가능한 추상화
    - 내가 만든 클래스가 얼마나 잘 추상적으로 장성했는가.
    - 내가 만든 인터페이스가 다른 곳에서 잘 활용할 수 있는가.
---
#### IoC ( Inversion of Control)
스프링에선느 일반적인 Java 객체를 new 로 생성하여 개발자가 관리하지 않고, Spring Container 에 모두 맡긴다.
- 제어의 객체 관리의 권한이 개발자에서 프레임워크로 넘어감 = 제어의 역전
---
#### DI ( Dependency Injection )
외부에서 사용하는 객체를 주입받음
장점
- 의존성으로 부터 격리시켜 코드 테스트에 용이
- 불가능한 상황을 Mock 와 같은 기술을 통해, 안정적으로 테스트 가능
- 코드를 확장하거나 변경할 때 영향을 최소화; 추상화
- 순환 참조를 막을 수 있음
    - 순환참조: 내가 나를 참조하는 경우, 내가 참조한 객체가 다시 나를 참조하는 경
---
#### AOP ( Aspect Oriented Programming )
**관점지향 프로그램**   
스프링 어플리케이션은 대부분 MVC 웹 애플리케이션을 사용   
MVC (모델-뷰-컨트롤러) 웹 애플리케이션
###### MVC: 사용자 인터페이스, 데이터 및 논리 제어를 구현하는데 사용되는 디자인 패턴   
- Web Layer
    - REST API 를 제공
    - 클라이턴트 중심의 로직을 적용
        - response 내려주기
        - http status 바꿔주기
- Business Layer : 서비스
    - 내부 정책에 따른 logic 을 개발 ; 주로 개발하는 부
- Data Layer : repository 로 연결
    - 데이터 베이스 및 외부와의 연동 처리

**횡단 관심**   
A사 B사 C사 메소드들을 작성할 때, 공통한 기능이 들어갈 수 있다.
- Method Parameter Log: method input 이 동일한 경우
- 실행시간 Log: 데이터베이스와 통신하는 로이 동일한 경우 실행시간이 얼마나 걸렸는지
- Parameter Encode: 암호화를 해야하는 경
                             
AOP 는 반복되는 메소드 또는 로직들을 한곳으로 몰아서 코딩할 수 있도록 해준다.
주요 Annotation
- @Aspect         : AOP 를 정의하는 Class에 할당
- @Pointcut       : AOP 를 적용 시킬 지점을 설정
- @Before         : 메소드 실행하기 이전
- @After          : 메소드 성공적으로 실행 후, 예외가 발생되더라도 실행
- @AfterReturnin  : 메소드 호출 성공 실행시 (Not Throws)
- @AfterThrowing  : 메소드 호출 실패 예회 발생 (Throws)
- @Around         : Before / after 모두 제어

---

#### Object Mapper
- 특정 객체를가 있으면, JSON 형태로 바꾸거나 TEXT 형태가 있으 객체로 바꾸려는 경우 활용
- 스프링이 request body 에 들어 있는 json 데이터가 object 로 바뀌고
내가 생성한 객체 또는 클래스가 어떠한 json 형태로 바뀌는지 확인하기 위해 활용
- JSON 노드 자체를 컨트롤

---

**TIP**
gradle dependency 는 추가하는 방법
1. maven repository 에서 필요한 것을 검색 및 선택
2. 타인이 가장 많이 찾는 버전 선택
3. gradle 선택 후, 복사하고 gradle 파일에 붙여넣기
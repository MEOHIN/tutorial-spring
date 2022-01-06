# Filter
- Web Application 에서 관리되는 영역
- Spring Boot Framework 에서 Client 로 부터 오는 요청/응답에 대해 최초/최종 단계의 위치에 존재
- 요청/응답의 정보를 변경
- Spring 에 의해서 데이터가 변환되기 전의 순수한 Client 의 요청(request body)/응답(response body) 값을 확인

**유일하게 ServletResponse 의 객체를 변환**할 수 있다.
#### ServletResponse 란?
#### 서블릿이란?
- 클라이언트의 요청을 처리하고, 그 결과를 반환하는 Servlet 클래스의 구현 규칙을 지킨 자바 웹 프로그래밍 기술
- 자바를 사용해서 웹페이지를 동적으로 생성하는 서버측 프로그램
- 웹 서버의 성능을 향상하기 위해 사용되는 자바 클래스의 일종
- 자바 코드 안에 HTML 을 포함하고 있다.

### Filter 주 활용
- Spring Framework 에서는 request /response 의 Logic 용도로 활용
- 인증과 관련된 Logic 들을 처리
- 선/후 처리 함으로써, Service business logic 과 분 

### Spring MVC request life cycle
Request 들어옴 -> Filter -> DispatchServlet -> HandlerInterceptor -> AOP 동작 -> HandlerInterceptor -> DispatchServlet -> Filter -> Response 보냄

## sample code
- Filter 에서 client 가 보낸 request body 가 어떤 것이 들어있는지 기록

#### Error message 확인
java.lang.IllegalStateException: getReader() has already been called for this request
커서 단위로 읽어가기 때문에 한 번만 읽을 수 있다. 하나를 읽을 때마다 커서도 하나씩 뒤로 이동하는데, 커서는 앞으로 가지 못한다.
만약 용 를 이용해서 한 번이라도 읽었다면 Client 요청에 대한 것을 더 이상 읽을 수 없다.
해결 방법: ContentCachingRequestWrapper 처럼 여러번 읽을 수게 해주는 클래스를 사용
ContentCachingRequestWrapper: 몇 번이라도 다시 읽을 수 있게 해줌
response body 로도 받으려면, ContentCachingRequestWrapper 의 copyBodyToResponse 메소드 이용
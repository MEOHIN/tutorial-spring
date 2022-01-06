# Filter
- Web Application 에서 관리되는 영역
- Spring Boot Framework 에서 Client 로 부터 오는 요청/응답에 대해 최초/최종 단계의 위치에 존재
- 요청/응답의 정보를 변경
- Spring 에 의해서 데이터가 변환되기 전의 순수한 Client 의 요청(request body)/응답(response body) 값을 확인

**유일하게 SevletResponse 의 객체를 변환**할 수 있다.

### Filter 주 활용
- Spring Framework 에서는 request /response 의 Logic 용도로 활용
- 인증과 관련된 Logic 들을 처리
- 선/후 처리 함으로써, Service business logic 과 분리
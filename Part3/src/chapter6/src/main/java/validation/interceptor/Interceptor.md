# Interceptor
- Filter 와 유사한 형태로 존재하지만, 차이점은 Spring Context 에 등록된다. 즉, Spring 기능을 활용할 수 있다.
- 이미 Controller mapping 이 이루어졌기 때문에 다음에 어떤 method 를 사용하는 지에 대한 정보를 가지고 있을 수 있다.
- AOP 와 유사한 기능을 제공할 수 있다.
- 주로 **인증 단계**를 처리
- Logging 하는 데에 사용
- 선/후 처리 함으로써, Service business logic 과 분리
# Exception 처리
Web Apllicaion 의 입장에서 봤을 때, 에럭 ㅏ났을 때 내려줄 방법이 많지 않다.
1. 에러페이지
2. 4XX Error 또는 5XX Error
3. Client 가 200 외 처리를 못 할땐, 200을 내려주고 별도 message 를 전달

- @ControllerAdvice
- @ExceptionHandler
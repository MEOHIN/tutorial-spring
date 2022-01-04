# Validation

JAVA 에서 null 값에 대해 접근하려고 할 때, null point exception 이 발생
Validation : null point exception 을 미리 검증하는 과정

### Validation 단점
- 코드가 길어질 수 있음
- 서비스 로직과 분리가 필요
- 재사용의 한계
- 로직이 변경돼야 하는 부분이 발생

위의 단점들을 처리하기 위해 Spring 에서는 일관된 Validation 이 존재, 어노테이션 기반으로 제공


### Custom Validation
1. AssertTrue / False 와 같은 method 지정을 통해서 Custom Logic 적용 가능
2. ConstraintValidation 을 적용하여 재사용이 가능한 Custom Logic 적용 가능
package ch3;

//  @FunctionalInterface: 해당 인터페이스는 메서드를 2개이상 선언하면 안된다는 것을 컴파일러에게 설명
@FunctionalInterface
public interface Add {

//    메서는 1개만 생성할 수 있다: 람다식을 구현할 때 어떤 메서드인지 모호해지기 때문
    public int add(int x, int y);
}

package ch7;

/**     제네릭 프로그래밍
 *      제네릭 자료형: 클래서에서 사용하는 변수의 자료형이 여러개지만, 그 기능(메서드)은 동일한 경우 클래스의 자료형을 특정하지 않고 추후 해당 클래스를 사용할 때 지정할 수 있도록 선언
 *      실제 사용되는 자료형의 변환은 컴파일러에 의해 검증되므로 안정적인 프로그래밍 방식
 */
// <> : 다이아몬드 연산자
// <T> : Generic 타입으로 쓰겠다는 선언
public class GenericPrinter<T> {

    private  T material;

    public T getMaterial() {
        return material;
    }

    public void setMaterial(T material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return material.toString();
    }
}

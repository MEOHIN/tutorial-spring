package ch8;

/**     제네릭 자료형을 사용할 때의 장점이자 문제점
 *      어떤 자료형이든 들어올 수 있다. = 무작위로 자료형이 들어올 수 있다.
 *      예: 3D 프린터 재료로 '증류수'는 들어올 수 없게 하고 싶은 경우에 사용
 *      이 점을 해결하기 위해 T 위치에 들어올 수 있는 자료형을 제안해줄 수 있다.
 */
// <T extends Material> : T에 대한 제한을 둠
public class GenericPrinter<T extends Material> {

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

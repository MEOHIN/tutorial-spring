package ch7.noGenericPrograming;

// 제네릭 프로그래밍을 하지 않는 경우
public class Powder_ThreeDPrinter {

    private Powder material;

    public Powder getMaterial() {
        return material;
    }

    public void setMaterial(Powder material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "재료는 powder 입니다.";
    }
}

package ch7.noGenericPrograming;

public class Plastic_ThreeDPrinter {

    private Plastic material;

    public Plastic getMaterial() {
        return material;
    }

    public void setMaterial(Plastic material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "재료는 Plastic 입니다.";
    }
}

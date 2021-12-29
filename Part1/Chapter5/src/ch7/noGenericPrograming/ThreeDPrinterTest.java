package ch7.noGenericPrograming;

public class ThreeDPrinterTest {

    public static void main(String[] args) {

        Powder powder = new Powder();
        Object_ThreeDPrinter printer = new Object_ThreeDPrinter();


        printer.setMaterial(powder);
        Powder p = (Powder)printer.getMaterial();
    }
}

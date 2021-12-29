package ch8;

import ch7.GenericPrinter;
import ch7.noGenericPrograming.Powder;

public class GenericPrinterTest {

    public static void main(String[] args) {

        Powder powder = new Powder();
        ch7.GenericPrinter<Powder> powderPrinter = new GenericPrinter<>();
        powderPrinter.setMaterial(powder);

        Powder p = powderPrinter.getMaterial();
        System.out.println(powderPrinter.toString());
    }
}

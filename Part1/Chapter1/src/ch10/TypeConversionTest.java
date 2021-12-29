package ch10;

public class TypeConversionTest {

    public static void main(String[] args) {

////        byte bNum = 125;
////        int iNum =bNum;
////
////        System.out.println(iNum);
//
//        int iNum = 255;
////        int를 사용해야하지만, 강제적으로 타입을 지정하고 싶을 때
//        byte bNum = (byte)iNum;
//
//        System.out.println(bNum);
//
//        double dNum = 3.14;
//        int iNum2 = (int)dNum;
//
//        System.out.println(iNum2);

        double dNum = 1.2;
        float fNum = 0.9f;

        int iNum1 = (int)dNum + (int)fNum;
        int iNum2 = (int)(dNum + fNum);

        System.out.println(iNum1);
        System.out.println(iNum2);
    }
}

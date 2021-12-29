package ch9;

public class ArrayIndexException {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        try {
            for (int i = 0; i <= 5; i++) {
                System.out.println(arr[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
//            toString은 '예외 full name: 예외 메세지'로 구성된다.
            System.out.println(e.toString());
        }

        System.out.println("here!");

        for (int i = 0; i <= 5; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("here!");

    }
}

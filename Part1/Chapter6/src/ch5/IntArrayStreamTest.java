package ch5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class IntArrayStreamTest {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};

        for (int num : arr){
            System.out.println(num);
        }


//        System.out.println("================동일==============");
//        Arrays.stream(arr).forEach(n->System.out.println(n));
//
//        IntStream is = Arrays.stream(arr);

//        위 주석처리된 코드와 동일
        System.out.println();
        IntStream is = Arrays.stream(arr);
        is.forEach(n->System.out.println(n));

//        스트림은 1번만 사용가능함.
//        int sum = is.sum();
//        System.out.println(sum);

//        스트림을 다시 사용하고 싶은 경우, 스트림을 다시 생성 = 스트림 메서드를 한 번 더 호출
        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);
    }
}

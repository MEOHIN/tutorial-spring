package ch09;

public class LocalVariableInter {

    public static void main(String[] args) {

        var i = 10;
        var j = 10.0;
        var str = "test";

        System.out.println(i);
        System.out.println(j);
        System.out.println(str);

        var str2 = str;
        System.out.println(str2);

        str = "hello";
//        처음 str 을 선언할 때 스트링인 "test"로 선언했다면,
//        같은 스트링으로 값을 바꿔서 선언하는 건 가능하지만
//        스트링 이외의 데이터타입으로 선언하는 건 불가능
//        str = 3;
    }
}

package ch18;
/*
싱글톤 패턴: 프로그램에서 인스턴스가 단 1개만 생성되야 하는 경우 사용
클래스에 대해서 인스턴스가 여러개인 상황은 일반적이지만
인스턴는 여러 멤버변수를 갖는 것이 문제가 되는 경우가 있다.: 날짜, 회사(사원은 여러명이더라도 회사는 1개)
 */
public class Company {

    private static Company instance = new Company();
    private Company(){

    }

    public static Company getInstance(){

        if (instance == null){
            instance = new Company();
        }

        return instance;
    }
}

package ch4;

public class StudentTest {

    public static void main(String[] args) {

//        Student 1개를 생성해라 -> 이렇게 생성된 객체를 인스턴스 라고 한다. -> 인스턴스는 heap(동적 메모리)에 할당됨
//        studentLee 를 참조 변수라고 한다. -> stack에 할
//        Student: 데이터타입이고 이 데이터가 잡는 사이즈는 Student 클래스의 크기를 대략적으로 잡는다
//        new: 생성자
        Student studentLee = new Student();

        studentLee.studentId = 12345;
        studentLee.setStudentName("Lee");
        studentLee.address = "서울 강남구";

        studentLee.showStudentInfo();

        Student studentKim = new Student();

        studentKim.studentId = 54321;
        studentKim.setStudentName("Kim");
        studentKim.address = "경기도 성남시";

        studentKim.showStudentInfo();

//        참조값 (가상 주소값)
        System.out.println(studentLee);
        System.out.println(studentKim);
    }
}


// Student 클래스를 삭제하고 StudentTest 클래스를 기반으로 혼자 Student 클래스를 코딩해보면 객체지향에 대해 좀 더 이해할 수 있다.
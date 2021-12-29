package ch6;

public class Student {

    public int studentNum;
    public String studentName;
    public int grade;

//    클래스에 생자가 없는 경우에 컴파일러가 생성자 코드를 넣어준다.
//    필요하다면 생성자 직접 생성
//    public Student(){
//
//        System.out.println("student 생성");
//    }

//    클래스에 생성자가 있는데 기본 생성자를 쓰고 싶은경우
    public Student(){}

    public Student(int studentNum, String studentName, int grade) {

        this.studentNum = studentNum;
        this.studentName = studentName;
        this.grade = grade;
    }

    public String showStudentInfo(){

        return studentName + "학생의 학번은 " + studentNum + " 이고 " + grade + " 학년 입니다.";
    }
}

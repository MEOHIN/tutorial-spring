package ch11;
/**
 * Constructor 에서는 throws 하지 않는다.
 * 그럼에도 exception 이 발생할 수 있는데,
 * 사용장 졍의 exception 클래스에서 일반 Exception이 아닌 IllegalArgumentException 를 extends 하면
 * Throws 하지 않아도 exception 핸들링을 할 수 있다.
*/
public class Student {

    private String studentName;
    MyLogger myLogger = MyLogger.getLogger();

    public Student(String studentName){

        if(studentName == null){

            throw new StudentNameFormatException("name must not be null");
        }
        if( studentName.split(" ").length > 3)
            throw new StudentNameFormatException("이름이 너무 길어요");

        this.studentName = studentName;
    }


    public String getStudentName() {

        myLogger.fine("begin getStudentName()");

        return studentName;
    }
}

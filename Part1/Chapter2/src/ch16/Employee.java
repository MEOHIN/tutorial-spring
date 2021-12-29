package ch16;
/*
static 변수: 여러 인스턴스에서 공통으로 사용하는 변수. 기준값이 필요한 경우 사용.
            처음 프로그램이 메모리에 로딩될 때 메모리를 할당. 인스턴스가 생성될 때 만들어지는 변수가 아님
            클래스 변수 또는 정적변수라고 함
    예: 학생의 학번, 카드사의 카드번호
 */

public class Employee {

    private static int serialNum = 1000;

    private int employeeId;
    private String employeeName;
    private String department;


    //    constructor
    public Employee(){
        serialNum++;
//        serialNum은 증가하면서, 멤버변수에 복사해서 사원들이 다 다른 번호를 갖도록 함
        employeeId = serialNum;
    }

//    static 메스드 안에서는 일반 멤버변수(예: employeeName)을 사용할 수 없다.
//      이유: 해당 static 메서드가 호출됐을 때 해당 읿반 멤버변수가 없을 수 있기 때문. static 변수가 메모리에 할당되는 시점을 생각해보면 이해하기 쉬움
    public static int getSerialNum() {
        return serialNum;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

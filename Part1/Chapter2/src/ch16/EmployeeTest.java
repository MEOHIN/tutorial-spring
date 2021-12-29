package ch16;

public class EmployeeTest {

    public static void main(String[] args) {

        Employee employee1 = new Employee();

        employee1.setEmployeeName("이순신");

//        인스턴스 생성과 무관하게 단독으로 바로 호출될 수 있다.
        System.out.println(Employee.getSerialNum());

        Employee employee2 = new Employee();

        employee2.setEmployeeName("홍길동");

        System.out.println(employee1.getEmployeeName() + "님의 사번은 " + employee1.getEmployeeId());
        System.out.println(employee2.getEmployeeName() + "님의 사번은 " + employee2.getEmployeeId());
    }
}

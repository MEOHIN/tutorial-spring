package ch12;

public class Person {

    String name;
    int age;

    public Person(){
//        this 는 객체 자
//        first constructor 가 돼야 한다.
        this("no name", 1);
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void showPerson(){
        System.out.println(name + "," + age);
    }

    public Person getPerson(){
        return this;
    }

    public static void main(String[] args) {

        Person person = new Person();
        person.showPerson();

//        메서드 내부에서 사용하는 this 값
        System.out.println(person);

//        참조변수(=인스턴스의 변수) 값
        Person person2 = person.getPerson();
        System.out.println(person2);
    }
}

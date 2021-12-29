package ch17;

import java.io.*;

class Person1 implements Serializable {
    String name;
    String job;

    public Person1() {
    }

    public Person1(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return name + "," + job;
    }
}


public class SerializationTest {

    public static void main(String[] args) {

        Person1 personL = new Person1("LEE", "대표이사");
        Person1 personK = new Person1("KIM", "차장");

        try (FileOutputStream fos = new FileOutputStream("serial.txt");
             ObjectOutputStream ois = new ObjectOutputStream(fos)) {

            ois.writeObject(personL);
            ois.writeObject(personK);

        } catch (IOException e) {
            System.out.println(e);
        }

        try (FileInputStream fos = new FileInputStream("serial.txt");
             ObjectInputStream ois = new ObjectInputStream(fos)) {

            Person1 pLee = (Person1)ois.readObject();
            Person1 pKim = (Person1)ois.readObject();

            System.out.println(pLee);
            System.out.println(pKim);

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}

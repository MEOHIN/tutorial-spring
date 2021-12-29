package ch17;

import java.io.*;

class Person2 implements Externalizable {
    String name;
    String job;

    public Person2() {
    }

    public Person2(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return name + "," + job;
    }

    @Override
    public void writeExternal(ObjectOutput obj) throws IOException {

        obj.writeUTF(name);
//        obj.writeUTF(job);
    }

    @Override
    public void readExternal(ObjectInput obj) throws IOException, ClassNotFoundException {

        name = obj.readUTF();
//        job = obj.readUTF();
    }
}


public class ExternalizableTest {

    public static void main(String[] args) {

        Person2 personL = new Person2("LEE", "대표이사");
        Person2 personK = new Person2("KIM", "차장");

        try (FileOutputStream fos = new FileOutputStream("serial.txt");
             ObjectOutputStream ois = new ObjectOutputStream(fos)) {

            ois.writeObject(personL);
            ois.writeObject(personK);

        } catch (IOException e) {
            System.out.println(e);
        }

        try (FileInputStream fos = new FileInputStream("serial.txt");
             ObjectInputStream ois = new ObjectInputStream(fos)) {

            Person2 pLee = (Person2)ois.readObject();
            Person2 pKim = (Person2)ois.readObject();

            System.out.println(pLee);
            System.out.println(pKim);

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}

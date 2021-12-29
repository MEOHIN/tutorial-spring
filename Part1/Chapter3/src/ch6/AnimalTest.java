package ch6;
/*
다형성: if-else 구문이 과도하게 사용되는 대신 코드를 깔끔하게 사용 가능하다.
 */

import java.util.ArrayList;

class Animal{

    public void move(){

        System.out.println("동물이 움직입니다.");
    }

    public void eat(){
        System.out.println("동물이 음식을 먹습니다.");
    }
}

class Human extends Animal{

    @Override
    public void move() {
        System.out.println("사람이 두 발로 걷습니다.");
    }

    public void readBook(){
        System.out.println("사람이 독서를 합니다.");

    }
}

class Lion extends Animal{

    @Override
    public void move() {
        System.out.println("호랑이가 네 발로 니다.");
    }

    public void hunting(){
        System.out.println("호랑이가 사냥을 합니다.");

    }
}

class Eagle extends Animal{

    @Override
    public void move() {
        System.out.println("독수리가 날개를 폅니다.");
    }

    public void hunting(){
        System.out.println("독수리 양 날개를 펄럭입니다.");

    }
}

public class AnimalTest {

    public static void main(String[] args) {

        Animal hAnimal = new Human();
        Animal lAnimal = new Lion();
        Animal eAnimal = new Eagle();

//        AnimalTest test = new AnimalTest();
//        test.moveAnimal(hAnimal);
//        test.moveAnimal(lAnimal);
//        test.moveAnimal(eAnimal);

        ArrayList<Animal> animalList = new ArrayList<>();
        animalList.add(hAnimal);
        animalList.add(lAnimal);
        animalList.add(eAnimal);

        for (Animal animal : animalList){
            animal.move();
        }
    }

    public void moveAnimal(Animal animal){
        animal.move();
    }
}

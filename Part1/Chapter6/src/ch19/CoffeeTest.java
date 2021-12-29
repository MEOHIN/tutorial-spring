package ch19;

public class CoffeeTest {

    public static void main(String[] args) {

        System.out.print("에티오피아 커피 추출: ");
        Coffee ethiopiaCoffee = new EthiopiaEspresso();
        ethiopiaCoffee.brewing();
        System.out.println();

        System.out.print("에티오피아 라떼: ");
        Coffee ethiopiaLatte = new Latte(new EthiopiaEspresso());
        ethiopiaLatte.brewing();

        System.out.print("에티오피아 아메리카노: ");
        Coffee ethiopiaAmericano = new Americano(new EthiopiaEspresso());
        ethiopiaAmericano.brewing();

        System.out.print("에티오피아 모카: ");
        Coffee ethiopiaMocha = new Mocha(new Latte(new EthiopiaEspresso()));
        ethiopiaMocha.brewing();

        System.out.print("케냐 커피 추출: ");
        Coffee kenyaCoffee = new KenyaEspresso();
        kenyaCoffee.brewing();
        System.out.println();

    }
}

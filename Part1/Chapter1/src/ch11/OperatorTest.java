package ch11;

public class OperatorTest {

    public static void main(String[] args) {

        int gameScore1 = 150;
//        ++: 항이 끝나기 전에 +1
//        gameScore += 1 과 gameScore = gameScore + 1 과 ++gameScore 의 값은 같지만, 언제 연산되는 지가 다
        int lastScore1 = ++gameScore1;

        int gameScore2 = 150;
        int lastScore2 = gameScore2++;

        int gameScore3 = 150;
        int lastScore3 = --gameScore3;

        int gameScore4 = 150;
        int lastScore4 = gameScore4--;

        System.out.println(lastScore1);
        System.out.println(gameScore1);

        System.out.println(lastScore2);
        System.out.println(gameScore2);

        System.out.println(lastScore3);
        System.out.println(gameScore3);

        System.out.println(lastScore4);
        System.out.println(gameScore4);
    }
}

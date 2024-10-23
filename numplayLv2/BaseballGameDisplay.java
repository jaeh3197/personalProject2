package numplay.numplayLv2;

import java.util.Scanner;

public class BaseballGameDisplay {
    public void displayHint(int strike, int ball) {
        Scanner sc = new Scanner(System.in);

        //play 가 끝날 때마다 반복
        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요!!");
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");

            int number = sc.nextInt();

            //1을 입력할 경우 새로운 BaseballGame 생성
            if (number == 1) {
                System.out.println("< 게임을 시작합니다 >");
                BaseballGame baseballGame = new BaseballGame();
                baseballGame.play();
            }

            //3을 입력할 경우 프로그램 종료
            else if (number == 3) {
                System.exit(0);
            }
        }
    }
}

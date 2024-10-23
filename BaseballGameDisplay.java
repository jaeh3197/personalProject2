package numplay;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BaseballGameDisplay {
    //게임 횟수와 시도 횟수를 전역 변수로 선언
    int playNum;
    int tryNum;

    //게임 횟수와 시도 횟수를 짝지어 주기 위해 Map 사용
    Map<Integer,Integer> recordNums = new HashMap<>();

    public void displayHint(int strike, int ball) {
        Scanner sc = new Scanner(System.in);

        //play 가 끝날 때마다 반복
        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요!!");
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");

            //원하는 번호 입력
            int number = sc.nextInt();

            //1을 입력할 경우 새로운 BaseballGame 생성
            if (number == 1) {
                System.out.println("< 게임을 시작합니다 >");

                //게임을 할 때마다 새로운 객체 생성
                BaseballGame baseballGame = new BaseballGame();

                //게임 횟수와 시도 횟수를 변수에 저장
                tryNum = baseballGame.play();
                playNum ++;
                recordNums.put(playNum, tryNum);
            }

            //게임 기록 보기
            else if (number == 2) {
                System.out.println("< 게임 기록 보기 >");
                record(recordNums);
            }

            //3을 입력할 경우 프로그램 종료
            else if (number == 3) {
                System.exit(0);
            }


        }
    }

    //게임 기록 통계 구현
    private void record (Map<Integer,Integer> recordNums) {

        //게임 횟수와 시도 횟수 차례대로 출력
        for (int i = 1; i <= recordNums.size(); i++) {
            System.out.println(i + "번째 게임 : 시도 횟수 - " + recordNums.get(i));
        }
    }
}

package numplay;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BaseballGameDisplay {

    //게임 횟수와 시도 횟수를 전역 변수로 선언
    int playNum;
    int tryNum;

    //난이도 설정을 위한 변수 선언
    String digitNum = "3";
    //객체 선언
    BaseballGame baseballGame;

    //게임 횟수와 시도 횟수를 짝지어 주기 위해 Map 사용
    Map<Integer, Integer> recordNums = new HashMap<>();

    public void displayHint() {
        Scanner sc = new Scanner(System.in);

        //play 가 끝날 때마다 반복
        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요!!");
            System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");

            //원하는 번호 입력
            String selectNum = sc.next();

            //난이도 설정 구현
            if (selectNum.equals("0")) {
                while (true) {
                    //난이도 입력
                    System.out.println("설정하고자 하는 자리수를 입력하세요.");
                    digitNum = sc.next();

                    //3, 4, 5 이외의 값은 오류 메시지 출력
                    if (digitNum.equals("3") || digitNum.equals("4") || digitNum.equals("5")) {
                        break;
                    } else {
                        System.out.println("올바른 숫자를 입력해주세요!!");
                    }
                }

                //난이도 설정 후 게임 시작
                System.out.println(digitNum + "자리수 난이도로 설정되었습니다.");
                System.out.println();
                startGame();
            }

            //1을 입력할 경우 새로운 BaseballGame 생성
            else if (selectNum.equals("1")) {
                startGame();
            }

            //게임 기록 보기
            else if (selectNum.equals("2")) {
                System.out.println("< 게임 기록 보기 >");
                record(recordNums);
            }

            //3을 입력할 경우 프로그램 종료
            else if (selectNum.equals("3")) {
                //종료시 안내 문구 출력
                System.out.println("< 숫자 야구 게임을 종료합니다 >");
                System.exit(0);
            }

            //예외값 입력 시 오류 메시지 출력
            else {
                System.out.println("올바른 숫자를 입력해주세요!!");
            }
        }
    }

    //게임 기록 통계 구현
    private void record(Map<Integer, Integer> recordNums) {

        //게임 횟수와 시도 횟수 차례대로 출력
        for (int i = 1; i <= recordNums.size(); i++) {
            System.out.println(i + "번째 게임 : 시도 횟수 - " + recordNums.get(i));
            System.out.println();
        }
    }

    private void startGame() {
        System.out.println("< 게임을 시작합니다 >");

        //게임을 할 때마다 새로운 객체 생성
        baseballGame = new BaseballGame(digitNum);

        //게임 횟수와 시도 횟수를 변수에 저장
        tryNum = baseballGame.play();
        playNum++;
        recordNums.put(playNum, tryNum);
    }
}

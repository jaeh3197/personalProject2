package numplay;

import java.util.*;
import java.util.regex.Pattern;

public class BaseballGame {

    //입력값이 유효한지 검사하기 위해 전역변수 선언
    String input;
    //리스트를 전역변수로 선언
    ArrayList<Integer> correctNum;
    ArrayList<Integer> inputNum;

    //객체 생성시 정답을 만들도록 함
    public BaseballGame() {
        //Random 클래스로 난수 생성
        Random rand = new Random();
        //난수를 중복없이 저장 할 객체 생성
        Set<Integer> randNum = new HashSet<>();
        //while 문 종료를 위한 변수 선언
        boolean run = true;

        while (run) {
            //1~9 사이의 숫자만 생성하여 저장
            randNum.add(rand.nextInt(9) + 1);

            //3개의 숫자가 저장될 시 종료
            switch (randNum.size()) {
                case 3:
                    run = false;
                    break;
            }
        }

        //랜덤하게 섞기 위하여 Hashset 을 ArrayList 로 형변환
        correctNum = new ArrayList<>(randNum);
        //요소를 랜던하게 섞음
        Collections.shuffle(correctNum);
        System.out.println(correctNum);
    }

    public int play() {
        Scanner sc = new Scanner(System.in);

        //시도하는 횟수를 저장하기 위해 변수 선언
        int tryNum = 0;

        while (true) {

            //입력한 값을 배열로 저장하기 위해 변수 선언
            inputNum = new ArrayList<>();
            Set<Integer> hashNum = new LinkedHashSet<>();

            //게임 진행 횟수 증가
            tryNum++;

            //입력 값을 문자형으로 저장
            System.out.println("숫자를 입력해주세요! : ");
            input = sc.next();

            //문자를 숫자로 변환하여 숫자로 저장
            for (int i = 0; i < input.length(); i++) {
                hashNum.add((int) input.charAt(i) - '0');
            }
            inputNum = new ArrayList<>(hashNum);

            //입력값이 유효하지 않을 경우 문자열 출력
            if (!validateInput(input)) {
                System.out.println("올바르지 않은 입력값입니다.");
                System.out.println();
            }

            //스트라이크 개수가 3개일 경우 정답 출력
            else if (countStrike(inputNum, correctNum) == 3) {
                System.out.println("정답입니다!!");
                System.out.println();
                break;
            }

            //숫자와 자리 둘다 다른 경우
            else if (countStrike(inputNum, correctNum) == 0 && countBall(inputNum, correctNum) == 0) {
                System.out.println("아웃");
                System.out.println();
            }

            //스트라이크 개수가 3개가 아닐 경우 힌트 출력
            else {
                System.out.println(countStrike(inputNum, correctNum) + "스트라이크 " + countBall(inputNum, correctNum) + "볼");
                System.out.println();
            }
        }
        System.out.println(tryNum + "번 시도하셨습니다!");
        return tryNum;
    }

    //입력 받은 값 유효성 검사
    protected boolean validateInput(String input) {
        return Pattern.matches("^[1-9]*$", input) && inputNum.size() == 3;
    }

    //스트라이크 개수 계산
    private int countStrike(List<Integer> inputNum, List<Integer> correctNum) {
        int count = 0;
        for (int i = 0; i < inputNum.size(); i++) {
            if (inputNum.get(i) == correctNum.get(i)) {
                count++;
            }
        }
        return count;
    }

    //볼 개수 계산
    private int countBall(List<Integer> inputNum, List<Integer> correctNum) {
        int strike;
        strike = countStrike(inputNum, correctNum);
        inputNum.retainAll(correctNum);
        return inputNum.size() - strike;
    }
}
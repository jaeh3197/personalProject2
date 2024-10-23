package numplay;

import java.util.*;

public class BaseballGame {
    //리스트를 전역변수로 선언
    ArrayList<Integer> correctNum;
    ArrayList<Integer> inputNum;

    //객체 생성시 정답을 만들도록 함
    public BaseballGame() {
        //Random 클래스로 난수 생성
        Random rand = new Random();
        //난수를 중복없이 저장 할 객체 생성
        Set<Integer> hashNum = new HashSet<>();
        //while 문 종료를 위한 변수 선언
        boolean run = true;

        while (run) {
            //1~9 사이의 숫자만 생성하여 저장
            int ranNum = rand.nextInt(9) + 1;
            hashNum.add(ranNum);

            //3개의 숫자가 저장될 시 종료
            switch (hashNum.size()) {
                case 3:
                    run = false;
                    break;
            }
        }

        //랜덤하게 섞기 위하여 Hashset 을 ArrayList 로 형변환
        correctNum = new ArrayList<>(hashNum);
        //요소를 랜던하게 섞음
        Collections.shuffle(correctNum);
        System.out.println(correctNum);
    }

    public int play() {
        Scanner sc = new Scanner(System.in);
        //입력 받은 값을 저장
        int input;
        int tryNum = 0;

        //각 자릿수를 배열로 저장하기 위해 변수 선언
        int remainNum;
        inputNum = new ArrayList<>();

        //
        while (true) {
            //게임 진행 횟수 증가
            tryNum ++;

            try {
                System.out.println("숫자를 입력해주세요! : ");
                input = sc.nextInt();

                //나머지를 이용하여 각 자릿수를 배열로 저장
                while (input > 0) {
                    remainNum = input % 10;
                    inputNum.add(remainNum);
                    input = input / 10;
                }
                //입력된 순서를 유지하기 위해 reverse 사용
                Collections.reverse(inputNum);

                //배열에 같은 값이 있을 경우 정제된 문자열 출력
                if (inputNum.size() != inputNum.stream().distinct().count()) {
                    System.out.println("올바르지 않은 입력값입니다!!");
                    inputNum.clear();

                    //입력받은 값이 세자리가 아닐 경우 정제된 문자 출력
                } else if (inputNum.size() != 3 || inputNum.contains(0)) {
                    System.out.println("올바르지 않은 입력값입니다!!");
                    inputNum.clear();

                }//스트라이크 개수가 3개일 경우 정답 출력
                else if (countStrike(inputNum,correctNum) == 3){
                    System.out.println("정답입니다!!");
                    break;
                }
                //숫자와 자리 둘다 다른 경우
                else if (countStrike(inputNum,correctNum) == 0 && countBall(inputNum,correctNum) == 0) {
                    System.out.println("아웃");
                    inputNum.clear();
                }
                //스트라이크 개수가 3개가 아닐 경우 힌트 출력
                else {
                    System.out.println(countStrike(inputNum,correctNum) + "스트라이크");
                    System.out.println(countBall(inputNum,correctNum) + "볼");
                    inputNum.clear();
                }

                //숫자가 아닌 값을 입력할 경우 예외처리
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("올바르지 않은 입력값입니다!!");
            }
        }
        System.out.println(inputNum);
        return tryNum;
    }

    protected boolean validateInput(String input) {
        return false;
    }

    //스트라이크 개수 계산
    private int countStrike(List<Integer>inputNum, List<Integer>correctNum) {
        int count = 0;
        for (int i = 0; i < inputNum.size(); i++) {
            if (inputNum.get(i) == correctNum.get(i)) {
                count++;
            }
        }
        return count;
    }

    //볼 개수 계산
    private int countBall(List<Integer>inputNum, List<Integer>correctNum) {
        int strike;
        strike = countStrike(inputNum,correctNum);
        inputNum.retainAll(correctNum);
        return inputNum.size() - strike;
    }
}
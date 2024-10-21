package numplay;

import java.util.*;

public class BaseballGame {
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
        ArrayList<Integer> correctNum = new ArrayList<>(hashNum);
        //요소를 랜던하게 섞음
        Collections.shuffle(correctNum);
        System.out.println(correctNum);
    }

    public int play() {
        Scanner sc = new Scanner(System.in);
        //입력 받은 값을 저장
        int input = 0;
        //각 자릿수를 배열로 저장하기 위해 변수 선언
        int remainNum = 0;
        ArrayList<Integer> inputNum = new ArrayList<>();

        while (true) {

            System.out.println("숫자를 입력해주세요! : ");
            input = sc.nextInt();

            //나머지를 이용하여 각 자릿수를 배열로 저장
            while (input > 0) {
                remainNum = input % 10;
                inputNum.add(remainNum);
                input = input / 10;
            }
            break;
        }
        //입력된 순서를 유지하기 위해 reverse 사용
        Collections.reverse(inputNum);
        System.out.println(inputNum);
        return input;
    }
}
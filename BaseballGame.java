package numplay;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BaseballGame {
        //객체 생성시 정답을 만들도록 함
        public BaseballGame() {
            //Random 클래스로 난수 생성
            Random rand = new Random();
            //난수를 중복없이 저장 할 객체 생성
            Set<Integer> correctNum = new HashSet<>();
            //while 문 종료를 위한 변수 선언
            boolean run = true;

            while (run) {
                //1~9 사이의 숫자만 생성하여 저장
                int ranNum = rand.nextInt(9) + 1;
                correctNum.add(ranNum);

                //3개의 숫자가 저장될 시 종료
                switch (correctNum.size()) {
                    case 3:
                        run = false;
                        break;
                }
            }
            System.out.println(correctNum);
        }
}
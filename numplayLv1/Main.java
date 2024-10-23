package numplay.numplayLv1;

import numplay.BaseballGame;

public class Main {
    public static void main(String[] args) {
        //객체 생성 & 게임 시작
        numplay.BaseballGame game = new BaseballGame();

        System.out.println(game.play());
    }
}

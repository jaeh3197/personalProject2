package numplay;

public class Main {
    public static void main(String[] args) {
        //객체 생성 & 게임 시작
        BaseballGame game = new BaseballGame();

        System.out.println(game.play());
    }
}

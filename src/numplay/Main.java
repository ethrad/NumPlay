package numplay;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        BaseballGame baseball = new BaseballGame();
        while (true) {
            int round = baseball.play();
            System.out.println(round + "회 진행했습니다.\n");
            baseball.setAnswer();
        }
    }
}

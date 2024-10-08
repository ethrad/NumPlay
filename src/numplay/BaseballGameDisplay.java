package numplay;

import java.util.List;

public class BaseballGameDisplay {
    public void displayHint(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("아웃\n");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크\n");
        } else if (strike == 0) {
            System.out.println(ball + "볼\n");
        } else {
            System.out.println(strike + "스트라이크 " + ball + "볼\n");
        }
    }

    public void printRecord(List<Integer> records) {
        for (int i = 0; i < records.size(); i++) {
            System.out.println((i + 1) + "번째 게임 : 시도 횟수 - " + records.get(i));
        }
    }
}

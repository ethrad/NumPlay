package numplay;

public class BaseballGameDisplay {
    public boolean displayHint(int strike, int ball) {
        if (strike == 3) {
            System.out.println("정답입니다!\n");
            return true;
        } else if (strike == 0 && ball == 0) {
            System.out.println("아웃\n");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크\n");
        } else if (strike == 0) {
            System.out.println(ball + "볼\n");
        } else {
            System.out.println(strike + "스트라이크 " + ball + "볼\n");
        }
        return false;
    }
}

package numplay;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BaseballGame baseball = new BaseballGame();
        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            String input = sc.nextLine();

            switch (input) {
                case "1":
                    int round = baseball.play();
                    System.out.println(round + "회 진행했습니다.\n");
                    break;

                case "2":
                    break;

                case "3":
                    return;

                default:
                    System.out.println("올바른 숫자를 입력해주세요.");
            }
        }
    }
}

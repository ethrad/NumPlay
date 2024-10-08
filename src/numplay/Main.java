package numplay;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BaseballGame baseball = new BaseballGame();
        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            String input = sc.nextLine();

            switch (input) {
                case "0":
                    System.out.println();
                    System.out.println("설정하고자 하는 자리수를 입력하세요.");

                    try {
                        int level = Integer.parseInt(sc.nextLine());
                        if (3 <= level && level <= 5) {
                            baseball.setLevel(level);

                            System.out.println(level + "자리수 난이도로 설정되었습니다.");
                            System.out.println();
                            System.out.println("< 게임을 시작합니다 >");

                            baseball.play();
                        } else {
                            System.out.println("올바른 숫자를 입력해주세요!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("올바른 숫자를 입력해주세요!");
                    }

                    System.out.println();
                    break;

                case "1":
                    System.out.println();
                    System.out.println("< 게임을 시작합니다 >");

                    baseball.play();

                    System.out.println();
                    break;

                case "2":
                    System.out.println();
                    System.out.println("< 게임 기록 보기 >");

                    baseball.viewRecords();

                    System.out.println();
                    break;

                case "3":
                    System.out.println();
                    System.out.println("< 숫자 야구 게임을 종료합니다 >");
                    return;

                default:
                    System.out.println();
                    System.out.println("올바른 숫자를 입력해주세요!");
                    System.out.println();
            }
        }
    }
}

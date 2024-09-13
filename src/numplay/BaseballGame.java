package numplay;

import java.util.*;

public class BaseballGame {
    private Integer[] answer = new Integer[3];

    public BaseballGame() {
        /*  정답 숫자 생성하기  */
        // 1~9 사이의 숫자를 리스트에 저장
        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            digits.add(i);
        }

        // 리스트를 섞기
        Collections.shuffle(digits);

        // 앞에 있는 숫자로 3자리 수 만들기
        answer[0] = digits.get(0);
        answer[1] = digits.get(1);
        answer[2] = digits.get(2);
    }

    public int play() {
        /*  정답을 맞추기 위해 숫자를 입력하기  */
        System.out.println("< 게임을 시작합니다 >");

        Scanner scanner = new Scanner(System.in);
        Set<Integer> input = new LinkedHashSet<>(); // 유저 입력을 넣는다

        // 올바른 입력을 받을 때까지 반복
        while (true) {
            System.out.println("숫자를 입력하세요");
            String tempInput = scanner.nextLine();
            boolean isValidInput = true; // 올바른 입력인지 확인

            for (char c : tempInput.toCharArray()) {
                // 중복된 숫자가 있다면 올바르지 않은 입력이기 때문에 멈춘다
                if (!input.add(Character.getNumericValue(c))) {
                    isValidInput = false;
                    break;
                }
            }

            // 올바른 입력이면 while문 밖으로 나간다
            if (isValidInput) {
                break;
            }

            System.out.println("중복되지 않는 숫자를 입력하세요");
            input.clear();
        }

        return 0;
    }

    protected boolean validateInput(String input) {

    }

    private int countStrike(String input) {

    }

    private int countBall(String input) {

    }

}

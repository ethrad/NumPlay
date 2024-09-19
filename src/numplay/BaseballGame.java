package numplay;

import java.util.*;

public class BaseballGame {
    private int round = 1;
    private String answer;

    public BaseballGame() {
        setAnswer();
    }

    public void setAnswer() {
        answer = "";

        // 1~9 사이의 숫자를 리스트에 저장
        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            digits.add(i);
        }

        // 리스트를 섞기
        Collections.shuffle(digits);

        // 앞에 있는 숫자로 3자리 수 만들기
        answer += String.valueOf(digits.get(0));
        answer += String.valueOf(digits.get(1));
        answer += String.valueOf(digits.get(2));
    }

    public int play() {
        System.out.println("< 게임을 시작합니다 >");

        while (true) {
            /*  정답을 맞추기 위해 숫자를 입력하기  */
            Scanner scanner = new Scanner(System.in);
            String input = "";
            boolean isValidInput = false;

            // 올바른 입력을 받을 때까지 반복
            while (!isValidInput) {
                System.out.println("숫자를 입력하세요");
                input = scanner.nextLine();
                // 올바른 입력인지 확인
                isValidInput = validateInput(input);
            }

            int strike = countStrike(input);
            int ball = countBall(input);

            BaseballGameDisplay display = new BaseballGameDisplay();
            boolean isCorrect = display.displayHint(strike, ball);
            if (isCorrect) {
                break;
            }
        }

        return round++;
    }

    protected boolean validateInput(String input) {
        // 길이가 3 이하인지
        if (input.length() != 3) {
            System.out.println("올바르지 않은 입력값입니다.\n");
            return false;
        }

        // 1-9 사이의 숫자로 구성되어 있는지
        String regex = "^[1-9]+$";
        if (!input.matches(regex)) {
            System.out.println("올바르지 않은 입력값입니다.\n");
            return false;
        }

        Set<Integer> inputSet = new LinkedHashSet<>();

        // 중복되는 숫자가 있는지
        for (char c : input.toCharArray()) {
            if (!inputSet.add(Character.getNumericValue(c))) {
                System.out.println("올바르지 않은 입력값입니다.\n");
                return false;
            }
        }

        return true;
    }

    private int countStrike(String input) {
        int strike = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == answer.charAt(i)) {
                strike++;
            }
        }

        return strike;
    }

    private int countBall(String input) {
        int ball = 0;

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                if (i == j) {
                    continue;
                }
                if (input.charAt(i) == answer.charAt(j)) {
                    ball++;
                    break;
                }
            }
        }

        return ball;
    }

}

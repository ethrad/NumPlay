package numplay;

import java.util.*;

public class BaseballGame {
    private int level = 3;
    private int round = 0;
    private int tryNum;

    private List<Integer> records;

    private String answer;

    public BaseballGame() {
        records = new ArrayList<>();
        resetGame();
    }

    public void setLevel(int level) {
        this.level = level;
        resetGame();
    }

    public void resetGame() {
        answer = "";
        tryNum = 0;

        // 1~9 사이의 숫자를 리스트에 저장
        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            digits.add(i);
        }

        // 리스트를 섞기
        Collections.shuffle(digits);

        // 앞 숫자부터 뽑아서 정답 만들기
        for (int i = 0; i < level; i++) {
            answer += String.valueOf(digits.get(i));
        }
    }

    public void play() {
        System.out.println(answer);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            tryNum++;

            String input = "";

            // 올바른 입력을 받을 때까지 반복
            while (true) {
                System.out.println("숫자를 입력하세요");
                input = scanner.nextLine();
                // 올바른 입력인지 확인
                boolean isValidInput = validateInput(input);

                if (isValidInput) {
                    break;
                } else {
                    System.out.println("올바르지 않은 입력값입니다.\n");
                }
            }

            int strike = countStrike(input);
            int ball = countBall(input);

            // 정답이라면 게임 끝내기
            if (strike == level) {
                System.out.println("정답입니다!\n");
                records.add(tryNum);
                round++;
                resetGame();
                break;
            }

            // 정답이 아니라면 힌트 출력
            BaseballGameDisplay display = new BaseballGameDisplay();
            display.displayHint(strike, ball);
        }
    }

    protected boolean validateInput(String input) {
        // 길이가 올바른지
        if (input.length() != level) {
            return false;
        }

        // 1-9 사이의 숫자로 구성되어 있는지
        String regex = "^[1-9]+$";
        if (!input.matches(regex)) {
            return false;
        }

        Set<Integer> inputSet = new LinkedHashSet<>();

        // 중복되는 숫자가 있는지
        for (char c : input.toCharArray()) {
            if (!inputSet.add(Character.getNumericValue(c))) {
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

    public void viewRecords() {
        BaseballGameDisplay display = new BaseballGameDisplay();
        display.printRecord(records);
    }
}

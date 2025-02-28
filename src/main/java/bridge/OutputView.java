package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void startGameMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public String errorMessage(String message) {
        return "[ERROR] " + message;
    }

    public void printMap(List<String> userInputResult) {
        upDown(userInputResult, true);
        upDown(userInputResult, false);
        System.out.println(" ");
    }

    public void upDown(List<String> userInputResult, boolean up) {
        System.out.print("[ ");
        for (int i = 0; i < userInputResult.size(); i++) {
            System.out.print(printUpDown(userInputResult.get(i), up));
            if (i != userInputResult.size() - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println(" ]");
    }

    public String printUpDown(String userInputResult, boolean up) {
        if ((up && userInputResult.equals("U") || (!up && userInputResult.equals("D")))) {
            return "O";
        }
        if ((up && userInputResult.equals("UF") || (!up && userInputResult.equals("DF")))) {
            return "X";
        }
        return " ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int count, List<String> inputHistory, boolean isSuccess) {
        System.out.println("최종 게임 결과");
        printMap(inputHistory);
        System.out.println("게임 성공 여부: " + isSuccess(isSuccess));
        System.out.println("총 시도한 횟수: " + count);
    }

    public String isSuccess(boolean isSuccess) {
        if (isSuccess) {
            return "성공";
        }
        return "실패";
    }
}

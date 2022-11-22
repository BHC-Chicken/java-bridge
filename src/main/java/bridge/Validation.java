package bridge;

import camp.nextstep.edu.missionutils.Console;

public class Validation {
    public int validationNumber(int bridgeSize) {
        if (bridgeSize >= 3 && bridgeSize <= 20) {
            return bridgeSize;
        }
        throw new IllegalArgumentException("다리의 길이는 3이상 20이하 입니다.");
    }
    
    public boolean validationMoving(String exit) {
        if (!(exit.equals("U") || exit.equals("D"))) {
            throw new IllegalArgumentException("U또는 D만 입력해주세요.");
        }
        return true;
    }
}

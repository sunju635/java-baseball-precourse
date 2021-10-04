package baseball.common.exception;

import baseball.common.exception.code.GameErrorCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExceptionChecker {
    private static final String NUMBER_REG_EXP = "^[0-9]+$";

    public void checkInputNumberFormat(String numbers) throws GameException {
        if(!numbers.matches(NUMBER_REG_EXP)) {
            throw new GameException(GameErrorCode.NUMBER_WRONG_FORMAT);
        }
    }

    public void checkInputNumberLength(String numbers) throws GameException {
        if(numbers.length() != 3) {
            throw new GameException(GameErrorCode.NUMBER_LENGTH);
        }
    }

    public void checkInputNumberDuplicated(String numbers) throws GameException {
        String[] numbersArray = numbers.split("");
        Set<String> numberSet = new HashSet<>(Arrays.asList(numbers.split("")));
        if(numberSet.size() < 3) {
            throw new GameException(GameErrorCode.NUMBER_DUPLICATED);
        }
    }

    public void checkInputNumberRange(int number) throws GameException {
        if(number > 9 || number < 1) {
            throw new GameException(GameErrorCode.NUMBER_RANGE);
        }
    }

    public void checkGameRestartNumber(String gameStartResponse) throws  GameException {
        if(!"1".equals(gameStartResponse) && !"2".equals(gameStartResponse)) {
            throw new GameException(GameErrorCode.GAME_RESTART_WRONG_NUMBER);
        }
    }

    /**
     * 입력에 대한 예외 처리 대상
     * <p>
     * 1. 입력 포맷
     * 2. 숫자 개수 3개 미만, 초과
     * 3. 중복 숫자
     * </p>
     *
     * @param numbers 사용자가 입력한 숫자
     * @throws GameException Game 관련 전역 Exception 처리.
     */
    public void checkInputNumbers(String numbers) throws GameException {
        checkInputNumberFormat(numbers);
        checkInputNumberLength(numbers);
        checkInputNumberDuplicated(numbers);
    }
}

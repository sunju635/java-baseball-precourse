package baseball.common.exception;

import baseball.common.exception.code.GameErrorCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExceptionChecker {
    private static final String NUMBER_REG_EXP = "^[0-9]+$";
    private static final int ATTACK_NUMBER_LENGTH = 3;
    private static final int NUMBER_MAX_RANGE = 9;
    private static final int NUMBER_MIN_RANGE = 1;
    private static final String GAME_RESTART_RESPONSE_YES = "1";
    private static final String GAME_RESTART_RESPONSE_NO = "2";

    public void checkInputNumberFormat(String numbers) throws GameException {
        if(!numbers.matches(NUMBER_REG_EXP)) {
            throw new GameException(GameErrorCode.NUMBER_WRONG_FORMAT);
        }
    }

    public void checkInputNumberLength(String numbers) throws GameException {
        if(numbers.length() != ATTACK_NUMBER_LENGTH) {
            throw new GameException(GameErrorCode.NUMBER_LENGTH);
        }
    }

    public void checkInputNumberDuplicated(String numbers) throws GameException {
        Set<String> numberSet = new HashSet<>(Arrays.asList(numbers.split("")));
        if(numberSet.size() < ATTACK_NUMBER_LENGTH) {
            throw new GameException(GameErrorCode.NUMBER_DUPLICATED);
        }
    }

    public void checkInputNumberRange(int number) throws GameException {
        if(number > NUMBER_MAX_RANGE || number < NUMBER_MIN_RANGE) {
            throw new GameException(GameErrorCode.NUMBER_RANGE);
        }
    }

    public void checkGameRestartNumber(String gameRestartResponse) throws  GameException {
        if(!GAME_RESTART_RESPONSE_YES.equals(gameRestartResponse) && !GAME_RESTART_RESPONSE_NO.equals(gameRestartResponse)) {
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

package baseball.common.exception;

import baseball.common.exception.code.GameErrorCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 정선주
 * @version 1.0
 * @since 1.0
 */
public class ExceptionChecker {
    private static final String NUMBER_REG_EXP = "^[0-9]+$";
    private static final int ATTACK_NUMBER_LENGTH = 3;
    private static final int NUMBER_MAX_RANGE = 9;
    private static final int NUMBER_MIN_RANGE = 1;
    private static final String GAME_RESTART_RESPONSE_YES = "1";
    private static final String GAME_RESTART_RESPONSE_NO = "2";

    /**
     * 사용자가 입력한 숫자의 포맷 체크
     * <p>
     * 숫자 이외의 문자 입력 불가
     * </p>
     *
     * @param numbers 사용자가 입력한 숫자
     * @throws GameException 숫자 이외의 문자 입력 시 발생
     */
    public void checkInputNumberFormat(String numbers) throws GameException {
        if(!numbers.matches(NUMBER_REG_EXP)) {
            throw new GameException(GameErrorCode.NUMBER_WRONG_FORMAT);
        }
    }

    /**
     * 사용자가 입력한 숫자의 길이 체크
     * <p>
     * ATTACK_NUMBER_LENGTH 길이의 숫자만 가능
     * </p>
     *
     * @param numbers 사용자가 입력한 숫자
     * @throws GameException ATTACK_NUMBER_LENGTH 길이 초과, 미만 입력 시 발생
     */
    public void checkInputNumberLength(String numbers) throws GameException {
        if(numbers.length() != ATTACK_NUMBER_LENGTH) {
            throw new GameException(GameErrorCode.NUMBER_LENGTH);
        }
    }

    /**
     * 사용자가 입력한 숫자 중복 체크
     * <p>
     * 중복된 숫자 입력 불가
     * </p>
     *
     * @param numbers 사용자가 입력한 숫자
     * @throws GameException 중복된 숫자 입력 시 발생
     */
    public void checkInputNumberDuplicated(String numbers) throws GameException {
        Set<String> numberSet = new HashSet<>(Arrays.asList(numbers.split("")));
        if(numberSet.size() < ATTACK_NUMBER_LENGTH) {
            throw new GameException(GameErrorCode.NUMBER_DUPLICATED);
        }
    }

    /**
     * 사용자가 입력한 숫자 범위 체크
     * <p>
     * NUMBER_MAX_RANGE, NUMBER_MIN_RANGE 사이 숫자만 가능
     * </p>
     *
     * @param number 사용자가 입력한 숫자
     * @throws GameException NUMBER_MAX_RANGE, NUMBER_MIN_RANGE 사이 이외의 숫자 입력 시 발생
     */
    public void checkInputNumberRange(int number) throws GameException {
        if(number > NUMBER_MAX_RANGE || number < NUMBER_MIN_RANGE) {
            throw new GameException(GameErrorCode.NUMBER_RANGE);
        }
    }

    /**
     * 게임 재시작 여부 응답 체크
     * <p>
     * 게임 재시작 여부는 GAME_RESTART_RESPONSE_YES, GAME_RESTART_RESPONSE_NO 두 가지로 응답 가능
     * </p>
     *
     * @param gameRestartResponse 사용자가 입력한 재시작 여부 응답
     * @throws GameException GAME_RESTART_RESPONSE_YES, GAME_RESTART_RESPONSE_NO 이외의 문자 입력 시 발생
     */
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

package baseball.domain;

import baseball.common.constants.GameResult;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 정선주
 * @version 1.0
 * @since 1.0
 */
public class GameNumbers {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    List<Number> gameNumbers;

    public GameNumbers(int length) {
        generateGameNumbers(length);
    }

    public GameNumbers(List<Number> gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    /**
     * 정해진 길이의 랜덤한 NUMBER 리스트를 생성한다.
     * <p>
     * 중복되지 않은 랜덤한 NUMBER 리스트를 생성한다.
     * </p>
     *
     * @param length 생성할 NUMBER 리스트 길이
     */
    private void generateGameNumbers(int length) {
        this.gameNumbers = new ArrayList<>();
        Number number;
        for(int i =0; i < length; i++) {
            this.gameNumbers.add(generateNumber());
        }
    }

    private Number generateNumber() {
        Number number = new Number(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        if(isDuplicated(number)) { // 중복된 숫자가 생성된 경우 다시 생성 할 수 있도록 한다.
            return generateNumber();
        }

        return number;
    }

    private boolean isDuplicated(Number number) {
        return this.gameNumbers.contains(number);
    }

    /**
     * 사용자 입력값과 컴퓨터가 생성한 값을 비교하여 게임 결과를 생성한다.
     * <p>
     * 낫싱의 경우 GameResults에 아무 값도 들어가지 않는다.
     * </p>
     *
     * @param attackNumbers 사용자가 입력한 공격 숫자
     * @return 게임 결과 (GameResult, 개수)
     */
    public GameResults attack(AttackNumbers attackNumbers) {
        GameResults gameResults = new GameResults();
        List<Number> attackNumberList = attackNumbers.getAttackNumbers();

        for(int i = 0; i < attackNumberList.size(); i++) {
            GameResult gameResult = getResult(attackNumberList.get(i), i);
            if(gameResult != null) {
                gameResults.put(gameResult);
            }
        }

        return gameResults;
    }

    /**
     * 사용자가 입력한 숫자 단건과 컴퓨터가 생성한 값을 비교하여 결과를 생성한다.
     * <p>
     * STRIKE, BALL 여부를 체크한다.
     * </p>
     *
     * @param number 사용자가 입력한 공격 숫자 단건
     * @param index 사용자 입력 숫자의 인덱스
     * @return 게임 결과 STRIKE or BALL
     */
    private GameResult getResult(Number number, int index) {
        if(isStrike(number, index)) {
            return GameResult.STRIKE;
        }
        if(isContains(number)) {
            return GameResult.BALL;
        }

        return null;
    }

    private boolean isStrike(Number number, int index) {
        if((this.gameNumbers.get(index)).equals(number)) {
            return true;
        }
        return false;
    }

    private boolean isContains(Number number) {
        if((this.gameNumbers.contains(number))) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "GameNumbers{" +
                "gameNumbers=" + gameNumbers +
                '}';
    }
}

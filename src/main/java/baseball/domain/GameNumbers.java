package baseball.domain;

import baseball.common.constants.GameResult;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

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

    private void generateGameNumbers(int length) {
        this.gameNumbers = new ArrayList<>();
        Number number;
        for(int i =0; i < length; i++) {
            this.gameNumbers.add(generateNumber());
        }
    }

    private Number generateNumber() {
        Number number = new Number(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        if(isDuplicated(number)) {
            return generateNumber();
        }

        return number;
    }

    private boolean isDuplicated(Number number) {
        return this.gameNumbers.contains(number);
    }

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

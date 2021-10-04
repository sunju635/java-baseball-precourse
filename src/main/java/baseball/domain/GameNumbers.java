package baseball.domain;

import baseball.common.constants.GameResult;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameNumbers {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    List<Number> gameNumbers;

    public GameNumbers(int length) {
        this.gameNumbers = generateGameNumber(length);
    }

    public GameNumbers(List<Number> gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    private List<Number> generateGameNumber(int length) {
        List<Number> gameNumber = new ArrayList<>();
        for(int i =0; i < length; i++) {
            gameNumber.add(new Number(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE)));
        }

        return gameNumber;
    }

    public Map<GameResult, Integer> attack(AttackNumbers attackNumbers) {
        Map<GameResult, Integer> result = new HashMap<>();
        List<Number> attackNumberList = attackNumbers.getAttackNumbers();

        for(int i = 0; i < attackNumberList.size(); i++) {
            GameResult gameResult = getResult(attackNumberList.get(i), i);
            if(gameResult != null) {
                result.put(gameResult, countGameResult(gameResult, result));
            }
        }

        return result;
    }

    private GameResult getResult(Number number, int index) {
        if((this.gameNumbers.get(index)).equals(number)) {
            return GameResult.STRIKE;
        }
        if((this.gameNumbers.contains(number))) {
            return GameResult.BALL;
        }

        return null;
    }

    private int countGameResult(GameResult gameResult, Map<GameResult, Integer> result) {
        return result.get(gameResult) == null ? 1 : result.get(gameResult) + 1;
    }

    @Override
    public String toString() {
        return "GameNumbers{" +
                "gameNumbers=" + gameNumbers +
                '}';
    }
}

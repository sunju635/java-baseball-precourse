package baseball.domain;

import baseball.common.constants.GameResult;

import java.util.HashMap;
import java.util.Map;

public class GameResults {

    Map<GameResult, Integer> gameResults;


    public GameResults() {
        this.gameResults = new HashMap<>();
    }

    public boolean isSuccess() {
        return this.gameResults.get(GameResult.STRIKE) == 3 ? true : false;
    }

    public boolean isNothing() {
        return this.gameResults.size() == 0 ? true : false;
    }
}

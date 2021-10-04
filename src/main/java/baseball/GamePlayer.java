package baseball;

import baseball.common.constants.GameResult;
import baseball.domain.AttackNumbers;
import baseball.domain.GameNumbers;

import java.util.HashMap;
import java.util.Map;

public class GamePlayer {
    private static final int GAME_NUMBER_LENGTH = 3;

    public void play(AttackNumbers lottoNumbers) {
        GameNumbers gameNumbers = new GameNumbers(GAME_NUMBER_LENGTH);

    }

    protected Map<GameResult, Integer> getGameResult(AttackNumbers lottoNumbers, GameNumbers gameNumbers) {
        Map<GameResult, Integer> result = new HashMap<>();

        return result;
    }
}

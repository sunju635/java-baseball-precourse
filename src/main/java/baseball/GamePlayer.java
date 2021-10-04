package baseball;

import baseball.common.exception.GameException;
import baseball.domain.AttackNumbers;
import baseball.domain.GameNumbers;
import baseball.domain.GameResults;


public class GamePlayer {
    private static final int GAME_NUMBER_LENGTH = 3;
    private GameNumbers gameNumbers;

    public GamePlayer() {
        gameNumbers = new GameNumbers(GAME_NUMBER_LENGTH);
    }

    public GameResults play(String numbers) throws GameException {
        /*TODO
        *  테스트를 위한 로그 코드로 삭제해야함*/
        System.out.println(gameNumbers);
        AttackNumbers attackNumbers = new AttackNumbers(numbers);
        GameResults gameResults = gameNumbers.attack(attackNumbers);
        gameResults.sort();
        return gameResults;
    }
}

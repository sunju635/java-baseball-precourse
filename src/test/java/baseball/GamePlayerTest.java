package baseball;

import baseball.common.constants.GameResult;
import baseball.common.exception.GameException;
import baseball.domain.AttackNumbers;
import baseball.domain.GameNumber;
import baseball.domain.GameNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GamePlayerTest {
    private GamePlayer gamePlayer;
    private Map<GameResult, Integer> result;

    @BeforeEach
    void setUp() {
        gamePlayer = new GamePlayer();
        result = new HashMap<>();
    }

    @Test
    void 낫싱() throws GameException {
        AttackNumbers attackNumbers = new AttackNumbers("123");
        GameNumbers gameNumbers = new GameNumbers(Arrays.asList(new GameNumber(4), new GameNumber(5), new GameNumber(6)));
        result = gamePlayer.getGameResult(attackNumbers, gameNumbers);

        assertThat(result.get(GameResult.NOTHING)).isEqualTo(3);
        assertThat(result.get(GameResult.BALL)).isEqualTo(0);
        assertThat(result.get(GameResult.STRIKE)).isEqualTo(0);
    }

    @Test
    void 볼() throws GameException {
        AttackNumbers attackNumbers = new AttackNumbers("123");
        GameNumbers gameNumbers = new GameNumbers(Arrays.asList(new GameNumber(3), new GameNumber(1), new GameNumber(2)));
        gamePlayer.getGameResult(attackNumbers, gameNumbers);
        result = gamePlayer.getGameResult(attackNumbers, gameNumbers);

        assertThat(result.get(GameResult.NOTHING)).isEqualTo(0);
        assertThat(result.get(GameResult.BALL)).isEqualTo(3);
        assertThat(result.get(GameResult.STRIKE)).isEqualTo(0);
    }

    @Test
    void 스트라이크() throws GameException {
        AttackNumbers attackNumbers = new AttackNumbers("123");
        GameNumbers gameNumbers = new GameNumbers(Arrays.asList(new GameNumber(1), new GameNumber(2), new GameNumber(3)));
        gamePlayer.getGameResult(attackNumbers, gameNumbers);
        result = gamePlayer.getGameResult(attackNumbers, gameNumbers);

        assertThat(result.get(GameResult.NOTHING)).isEqualTo(0);
        assertThat(result.get(GameResult.BALL)).isEqualTo(0);
        assertThat(result.get(GameResult.STRIKE)).isEqualTo(3);
    }

    @Test
    void 스트라이크_볼_낫싱() throws GameException {
        AttackNumbers attackNumbers = new AttackNumbers("123");
        GameNumbers gameNumbers = new GameNumbers(Arrays.asList(new GameNumber(1), new GameNumber(3), new GameNumber(4)));
        gamePlayer.getGameResult(attackNumbers, gameNumbers);
        result = gamePlayer.getGameResult(attackNumbers, gameNumbers);

        assertThat(result.get(GameResult.NOTHING)).isEqualTo(1);
        assertThat(result.get(GameResult.BALL)).isEqualTo(1);
        assertThat(result.get(GameResult.STRIKE)).isEqualTo(1);
    }
}

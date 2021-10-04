package baseball.domain;

import baseball.GamePlayer;
import baseball.common.constants.GameResult;
import baseball.common.exception.GameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GameNumbersTest {
    private GamePlayer gamePlayer;
    private GameResults result;

    @BeforeEach
    void setUp() {
        gamePlayer = new GamePlayer();
        result = new GameResults();
    }

    @Test
    void 낫싱() throws GameException {
        AttackNumbers attackNumbers = new AttackNumbers("123");
        GameNumbers gameNumbers = new GameNumbers(Arrays.asList(new Number(4), new Number(5), new Number(6)));
        result = gameNumbers.attack(attackNumbers);

        assertThat(result.get(GameResult.NOTHING)).isEqualTo(null);
    }

    @Test
    void 볼() throws GameException {
        AttackNumbers attackNumbers = new AttackNumbers("123");
        GameNumbers gameNumbers = new GameNumbers(Arrays.asList(new Number(3), new Number(1), new Number(2)));
        result = gameNumbers.attack(attackNumbers);

        assertThat(result.get(GameResult.BALL)).isEqualTo(3);
    }

    @Test
    void 스트라이크() throws GameException {
        AttackNumbers attackNumbers = new AttackNumbers("123");
        GameNumbers gameNumbers = new GameNumbers(Arrays.asList(new Number(1), new Number(2), new Number(3)));
        result = gameNumbers.attack(attackNumbers);

        assertThat(result.get(GameResult.STRIKE)).isEqualTo(3);
    }

    @Test
    void 스트라이크_볼_낫싱() throws GameException {
        AttackNumbers attackNumbers = new AttackNumbers("123");
        GameNumbers gameNumbers = new GameNumbers(Arrays.asList(new Number(1), new Number(3), new Number(4)));
        result = gameNumbers.attack(attackNumbers);

        assertThat(result.get(GameResult.BALL)).isEqualTo(1);
        assertThat(result.get(GameResult.STRIKE)).isEqualTo(1);
    }
}
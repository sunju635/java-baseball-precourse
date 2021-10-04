package baseball.domain;

import baseball.common.constants.GameResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultsTest {
    @Test
    void 성공_여부() {
        GameResults gameResults = new GameResults();
        gameResults.put(GameResult.STRIKE);
        gameResults.put(GameResult.STRIKE);
        gameResults.put(GameResult.STRIKE);

        assertThat(gameResults.isSuccess()).isEqualTo(true);
    }

    @Test
    void 낫싱_여부() {
        GameResults gameResults = new GameResults();

        assertThat(gameResults.isNothing()).isEqualTo(true);
    }
}

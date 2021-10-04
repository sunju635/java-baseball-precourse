package baseball.domain;

import baseball.common.exception.GameException;
import baseball.common.exception.code.GameErrorCode;
import baseball.domain.AttackNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AttackNumberTest {

    @Test
    void 입력숫자_범위() {
        assertThatExceptionOfType(GameException.class).isThrownBy(
                () -> {
                    new AttackNumber("0");
                    new AttackNumber("-1");
                    new AttackNumber("10");
                }
        ).withMessageContaining(GameErrorCode.NUMBER_RANGE.getErrorMessage());
    }
}

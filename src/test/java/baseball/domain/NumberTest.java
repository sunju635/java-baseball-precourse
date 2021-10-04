package baseball.domain;

import baseball.common.exception.GameException;
import baseball.common.exception.code.GameErrorCode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NumberTest {

    @Test
    void 입력숫자_범위() {
        assertThatExceptionOfType(GameException.class).isThrownBy(
                () -> {
                    new Number("0");
                    new Number("-1");
                    new Number("10");
                }
        ).withMessageContaining(GameErrorCode.NUMBER_RANGE.getErrorMessage());
    }
}

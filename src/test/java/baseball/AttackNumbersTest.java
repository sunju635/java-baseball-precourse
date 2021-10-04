package baseball;

import baseball.common.exception.GameException;
import baseball.common.exception.code.GameErrorCode;
import baseball.domain.AttackNumbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AttackNumbersTest {

    @Test
    void 입력숫자_포멧() {
        assertThatExceptionOfType(GameException.class).isThrownBy(
                () -> {
                    new AttackNumbers("-123");
                    new AttackNumbers("a23");
                    new AttackNumbers("1+23");
                }
        ).withMessageContaining(GameErrorCode.NUMBER_WRONG_FORMAT.getErrorMessage());
    }

    @Test
    void 입력숫자_개수() {
        assertThatExceptionOfType(GameException.class).isThrownBy(
                () -> {
                    new AttackNumbers("1234");
                    new AttackNumbers("12");
                }
        ).withMessageContaining(GameErrorCode.NUMBER_LENGTH.getErrorMessage());
    }

    @Test
    void 입력숫자_중복() {
        assertThatExceptionOfType(GameException.class).isThrownBy(
                () -> {
                    new AttackNumbers("112");
                    new AttackNumbers("122");
                    new AttackNumbers("111");
                }
        ).withMessageContaining(GameErrorCode.NUMBER_DUPLICATED.getErrorMessage());
    }
}

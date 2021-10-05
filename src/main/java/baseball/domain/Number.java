package baseball.domain;

import baseball.common.exception.ExceptionChecker;
import baseball.common.exception.GameException;

import java.util.Objects;

/**
 * @author 정선주
 * @version 1.0
 * @since 1.0
 */
public class Number {
    private int number;

    public Number(String number) throws GameException {
        int parsedNumber = Integer.parseInt(number);
        new ExceptionChecker().checkInputNumberRange(parsedNumber);

        this.number = parsedNumber;
    }

    public Number(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

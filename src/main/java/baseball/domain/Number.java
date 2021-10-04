package baseball.domain;

import baseball.common.exception.ExceptionChecker;
import baseball.common.exception.GameException;

public class Number {
    private int number;

    public Number(String number) throws GameException {
        ExceptionChecker exceptionChecker = new ExceptionChecker();

        int parsedNumber = Integer.parseInt(number);
        exceptionChecker.checkInputNumberRange(parsedNumber);

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
}

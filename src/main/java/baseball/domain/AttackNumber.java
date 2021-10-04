package baseball.domain;

import baseball.common.exception.ExceptionChecker;
import baseball.common.exception.GameException;

public class AttackNumber {
    private int attackNumber;

    public AttackNumber(String number) throws GameException {
        ExceptionChecker exceptionChecker = new ExceptionChecker();

        int parsedNumber = Integer.parseInt(number);
        exceptionChecker.checkInputNumberRange(parsedNumber);

        this.attackNumber = parsedNumber;
    }

    @Override
    public String toString() {
        return "AttackNumber{" +
                "attackNumber=" + attackNumber +
                '}';
    }
}

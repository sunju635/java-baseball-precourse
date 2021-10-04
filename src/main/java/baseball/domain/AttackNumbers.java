package baseball.domain;

import baseball.common.exception.ExceptionChecker;
import baseball.common.exception.GameException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AttackNumbers {

    private List<Number> attackNumbers;

    public AttackNumbers(String numbers) throws GameException {
        ExceptionChecker exceptionChecker = new ExceptionChecker();
        exceptionChecker.checkInputNumbers(numbers);

        this.attackNumbers = new ArrayList<>();

        List<String> numberList = Arrays.asList(numbers.split(""));
        for(String number : numberList) {
            this.attackNumbers.add(new Number(number));
        }
    }

    public List<Number> getAttackNumbers() {
        return Collections.unmodifiableList(this.attackNumbers);
    }

    @Override
    public String toString() {
        return "AttackNumbers{" +
                "attackNumbers=" + attackNumbers +
                '}';
    }
}

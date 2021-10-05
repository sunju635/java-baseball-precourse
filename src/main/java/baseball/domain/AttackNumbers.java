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
        new ExceptionChecker().checkInputNumbers(numbers);
        this.attackNumbers = convertToList(numbers);
    }

    private List<Number> convertToList(String numbers) throws GameException {
        List<String> numberList = Arrays.asList(numbers.split(""));
        List<Number> resultList = new ArrayList<>();
        for(String number : numberList) {
            resultList.add(new Number(number));
        }

        return resultList;
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

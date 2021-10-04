package baseball.domain;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameNumbers {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    List<GameNumber> gameNumbers;

    public GameNumbers(int length) {
        this.gameNumbers = generateGameNumber(length);
    }

    private List<GameNumber> generateGameNumber(int length) {
        List<GameNumber> attackLottoNumber = new ArrayList<>();

        for(int i =0; i < length; i++) {
            attackLottoNumber.add(new GameNumber(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE)));
        }

        return attackLottoNumber;
    }

    @Override
    public String toString() {
        return "GameNumbers{" +
                "gameNumbers=" + gameNumbers +
                '}';
    }
}

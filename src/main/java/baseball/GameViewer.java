package baseball;

import baseball.common.constants.NoticeMessage;
import baseball.common.exception.GameException;
import baseball.domain.AttackNumbers;
import nextstep.utils.Console;

public class GameViewer {

    public void start() {
        Console.printLine(NoticeMessage.ASK_INPUT_NUMBERS.getMessage());
        String numbers = Console.readLine();
        try{
            AttackNumbers attackNumbers = new AttackNumbers(numbers);

            GamePlayer gamePlayer = new GamePlayer();
            gamePlayer.play(attackNumbers);

        }catch (GameException e) {
            Console.printLine(e.getMessage());
            e.printStackTrace();
        }
    }

}

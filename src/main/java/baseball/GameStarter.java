package baseball;

import baseball.common.constants.NoticeMessage;
import baseball.common.exception.GameException;
import baseball.domain.GameResults;
import nextstep.utils.Console;

public class GameStarter {
    private boolean isRestart = true;
    private GamePrinter gameViewer = new GamePrinter();

    public void start() {
        start(new GamePlayer());
    }

    public void start(GamePlayer gamePlayer) {
        Console.print(NoticeMessage.ASK_INPUT_NUMBERS.getMessage() + " : ");
        String numbers = Console.readLine();
        try{
            GameResults gameResults = gamePlayer.play(numbers);
            isRestart = gameViewer.printResultAndGetIsResult(gameResults);
            reStart(gameResults.isSuccess(), gamePlayer);
        }catch (GameException e) {
            Console.printLine(e.getMessage());
            start(gamePlayer);
        }
    }

    public void reStart(boolean isSuccess, GamePlayer gamePlayer) {
        if(isRestart && isSuccess){
            start();
        }

        if(isRestart && !isSuccess){
            start(gamePlayer);
        }
    }
}

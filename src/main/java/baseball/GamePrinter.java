package baseball;

import baseball.common.constants.GameResult;
import baseball.common.constants.NoticeMessage;
import baseball.common.exception.ExceptionChecker;
import baseball.common.exception.GameException;
import baseball.domain.GameResults;
import nextstep.utils.Console;

public class GamePrinter {
    public boolean printResultAndGetIsResult(GameResults gameResult) {
        printGameResult(gameResult);

        if(gameResult.isSuccess()) {
            Console.printLine(NoticeMessage.THREE_STRIKE.getMessage());
            return printSuccessResultAndGetIsResult();
        }

        return true;
    }

    public void printGameResult(GameResults gameResult) {
        if(gameResult.isNothing()) {
            Console.print(GameResult.NOTHING.getResult());
        }

        for(GameResult result : gameResult.getKeySet()) {
            Console.print(gameResult.get(result) + result.getResult() + " ");
        }

        Console.printLine("");
    }

    private boolean printSuccessResultAndGetIsResult() {
        Console.printLine(NoticeMessage.SUCCESS.getMessage());
        String gameStartResponse = Console.readLine();

        try {
            return isSuccessRestart(gameStartResponse);
        } catch (GameException e) {
            Console.printLine(e.getMessage());
            return printSuccessResultAndGetIsResult();
        }
    }

    private boolean isSuccessRestart(String gameStartResponse) throws GameException {
        new ExceptionChecker().checkGameRestartNumber(gameStartResponse);

        if("2".equals(gameStartResponse)) {
            return false;
        }

        return true;
    }


}

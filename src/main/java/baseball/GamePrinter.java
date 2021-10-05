package baseball;

import baseball.common.constants.GameResult;
import baseball.common.constants.NoticeMessage;
import baseball.common.exception.ExceptionChecker;
import baseball.common.exception.GameException;
import baseball.domain.GameResults;
import nextstep.utils.Console;

/**
 * @author 정선주
 * @version 1.0
 * @since 1.0
 */
public class GamePrinter {

    /**
     * 게임 결과를 출력하고, 재시작 여부를 확인한다.
     *
     * @param gameResult 게임 결과
     */
    public boolean printResultAndGetIsResult(GameResults gameResult) {
        printGameResult(gameResult);

        if(gameResult.isSuccess()) {
            Console.printLine(NoticeMessage.THREE_STRIKE.getMessage());
            return printSuccessResultAndGetIsResult();
        }

        return true;
    }

    private void printGameResult(GameResults gameResult) {
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

    private boolean isSuccessRestart(String gameRestartResponse) throws GameException {
        new ExceptionChecker().checkGameRestartNumber(gameRestartResponse);

        if("2".equals(gameRestartResponse)) {
            return false;
        }

        return true;
    }


}

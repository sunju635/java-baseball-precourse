package baseball;

import baseball.common.constants.NoticeMessage;
import baseball.common.exception.GameException;
import baseball.domain.GameResults;
import nextstep.utils.Console;

/**
 * @author 정선주
 * @version 1.0
 * @since 1.0
 */
public class GameStarter {
    private boolean isRestart = true;
    private GamePrinter gameViewer = new GamePrinter();

    /**
     * 게임을 처음부터 시작한다. (컴퓨터가 생성했던 숫자도 다시 생성)
     */
    public void start() {
        start(new GamePlayer());
    }

    /**
     * Error로 인해 게임을 다시 시작한다. (컴퓨터가 생성 했던 숫자는 그대로 유지)
     */
    public void start(GamePlayer gamePlayer) {
        gameViewer.askAttackNumber();
        String numbers = Console.readLine();
        try{
            // (a) 게임을 진행한다.
            GameResults gameResults = gamePlayer.play(numbers);
            // (b) 게임 결과를 출력하고, 다시 게임을 진행할지 확인한다.
            isRestart = gameViewer.printResultAndGetIsResult(gameResults);
            // (c) 게임 재시작 혹은 중지
            reStart(gameResults.isSuccess(), gamePlayer);
        }catch (GameException e) {
            Console.printLine(e.getMessage());
            start(gamePlayer);
        }
    }

    /**
     * 게임 재시작 혹은 중지
     * <p>
     * 게임을 종료 혹은 완전히 새로시작할지, 컴퓨터가 생성한 숫자는 유지하고 사용자 숫자만 다시 입력받을 지 확인 후 재시작한다.
     * </p>
     *
     * @param isSuccess 게임 승리 여부
     * @param gamePlayer
     */
    public void reStart(boolean isSuccess, GamePlayer gamePlayer) {
        if(isRestart && isSuccess){
            start(); // 완전히 새로 시작
        }

        if(isRestart && !isSuccess){
            start(gamePlayer); // 컴퓨터가 생성한 숫자는 유지하고 사용자 숫자만 다시 입력 받음
        }
        
        // 나머지 종료
    }
}

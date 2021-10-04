package baseball.common.exception;

import baseball.common.exception.code.GameErrorCode;

public class GameException extends Exception{
    private static final long serialVersionUID = 7213071284303684049L;

    private final GameErrorCode gameErrorCode;

    public GameException(GameErrorCode gameErrorCode) {
        super("[ERROR]" + gameErrorCode.getErrorMessage());
        this.gameErrorCode = gameErrorCode;
    }

}

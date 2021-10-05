package baseball.common.exception;

import baseball.common.exception.code.GameErrorCode;

/**
 * @author 정선주
 * @version 1.0
 * @since 1.0
 */
public class GameException extends Exception{
    private static final long serialVersionUID = 7213071284303684049L;

    private final GameErrorCode gameErrorCode;

    /**
     * @param gameErrorCode   error code, error message
     */
    public GameException(GameErrorCode gameErrorCode) {
        super("[ERROR]" + gameErrorCode.getErrorMessage());
        this.gameErrorCode = gameErrorCode;
    }

}

package baseball.common.exception.code;

public enum GameErrorCode {
    NUMBER_LENGTH("0001", "숫자는 3개를 입력해주십시오."),
    NUMBER_DUPLICATED("0002", "중복된 숫자가 있습니다."),
    NUMBER_RANGE("0003", "숫자는 1~9까지만 가능합니다."),
    NUMBER_WRONG_FORMAT("0004", "숫자 외의 문자(+,- 포함)는 입력 할 수 없습니다.");

    private String errorCode;
    private String errorMessage;

    GameErrorCode(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }


}

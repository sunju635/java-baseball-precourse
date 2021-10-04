package baseball.common.constants;

public enum NoticeMessage {
    ASK_INPUT_NUMBERS("숫자를 입력해주세요");

    private String message;

    NoticeMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}

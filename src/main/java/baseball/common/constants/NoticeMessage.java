package baseball.common.constants;

/**
 * @author 정선주
 * @version 1.0
 * @since 1.0
 */
public enum NoticeMessage {
    ASK_INPUT_NUMBERS("숫자를 입력해주세요"),
    THREE_STRIKE("3개의 숫자를 모두 맞히셨습니다! 게임 끝"),
    SUCCESS("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

    private String message;

    /**
     * @param message   사용자에게 출력할 notice message
     */
    NoticeMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}

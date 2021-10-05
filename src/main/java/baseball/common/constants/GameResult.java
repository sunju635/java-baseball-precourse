package baseball.common.constants;

/**
 * @author 정선주
 * @version 1.0
 * @since 1.0
 */
public enum GameResult {
    STRIKE(1, "스트라이크"),
    BALL(2, "볼"),
    NOTHING(3, "낫싱");

    private String result;
    private int order;

    /**
     * @param order   result가 sorting 될 순서
     * @param result   game 결과
     */
    GameResult(int order, String result) {
        this.order = order;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public int getOrder() {
        return order;
    }
}

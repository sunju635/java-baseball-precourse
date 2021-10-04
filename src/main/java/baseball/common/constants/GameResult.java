package baseball.common.constants;

public enum GameResult {
    STRIKE(1, "스트라이크"),
    BALL(2, "볼"),
    NOTHING(3, "낫싱");

    private String result;
    private int order;

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

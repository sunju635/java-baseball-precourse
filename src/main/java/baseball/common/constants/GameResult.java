package baseball.common.constants;

public enum GameResult {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String result;

    GameResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}

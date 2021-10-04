package baseball.domain;

public class GameNumber {
    private int gameNumber;


    public GameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    @Override
    public String toString() {
        return "GameNumber{" +
                "gameNumber=" + gameNumber +
                '}';
    }
}

package baseball.domain;

import baseball.common.constants.GameResult;

import java.util.*;

public class GameResults {

    private static final int SUCCESS_STRIKE_COUNT = 3;

    Map<GameResult, Integer> gameResults;


    public GameResults() {
        this.gameResults = new LinkedHashMap<>();
    }

    public void put(GameResult gameResult) {
        this.gameResults.put(gameResult, countGameResult(gameResult));
    }

    private int countGameResult(GameResult gameResult) {
        return this.gameResults.get(gameResult) == null ? 1 : this.gameResults.get(gameResult) + 1;
    }

    public Integer get(GameResult gameResult) {
        return this.gameResults.get(gameResult);
    }

    public boolean isSuccess() {
        return this.gameResults.get(GameResult.STRIKE) != null && this.gameResults.get(GameResult.STRIKE) == SUCCESS_STRIKE_COUNT ? true : false;
    }

    public boolean isNothing() {
        return this.gameResults.size() == 0 ? true : false;
    }

    public Set<GameResult> getKeySet() {
        return this.gameResults.keySet();
    }

    public void sort() {
        Map<GameResult, Integer> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<GameResult, Integer> map : sortGameResultKeyAsList()) {
            sortedMap.put(map.getKey(), map.getValue());
        }

        this.gameResults = sortedMap;
    }

    private List<Map.Entry<GameResult, Integer>> sortGameResultKeyAsList() {
        List<Map.Entry<GameResult, Integer>> list = new LinkedList<>(this.gameResults.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<GameResult, Integer>>() {
            @Override
            public int compare(Map.Entry<GameResult, Integer> o1, Map.Entry<GameResult, Integer> o2) {
                return o1.getKey().getOrder() - o2.getKey().getOrder();
            }
        });

        return list;
    }

}

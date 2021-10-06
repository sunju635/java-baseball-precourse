package baseball.domain;

import baseball.common.constants.GameResult;

import java.util.*;

/**
 * @author 정선주
 * @version 1.0
 * @since 1.0
 */
public class GameResults {

    private static final int SUCCESS_STRIKE_COUNT = 3;

    Map<GameResult, Integer> gameResults;


    public GameResults() {
        this.gameResults = new LinkedHashMap<>();
    }

    public void put(GameResult gameResult) {
        if(gameResult != null) {
            this.gameResults.put(gameResult, countGameResult(gameResult));
        }
    }

    private int countGameResult(GameResult gameResult) {
        return this.gameResults.get(gameResult) == null ? 1 : this.gameResults.get(gameResult) + 1;
    }

    public Integer get(GameResult gameResult) {
        return this.gameResults.get(gameResult);
    }

    /**
     * 사용자가 게임에 승리하였는지 확인한다.
     * <p>
     * 3STRIKE의 경우 사용자가 승리
     * </p>
     */
    public boolean isSuccess() {
        return this.gameResults.get(GameResult.STRIKE) != null && this.gameResults.get(GameResult.STRIKE) == SUCCESS_STRIKE_COUNT ? true : false;
    }

    /**
     * 게임 결과가 낫싱인지 확인한다.
     * <p>
     * 낫싱은 GameResult에 저장된 값이 없으므로 size가 0이다. 단, 생성자에서 초기화가 이루어지므로 null은 아니다.
     * </p>
     */
    public boolean isNothing() {
        return this.gameResults.size() == 0 ? true : false;
    }

    public Set<GameResult> getKeySet() {
        return this.gameResults.keySet();
    }

    /**
     * 게임 결과를 GameResult order에 맞게 sorting한다.
     */
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

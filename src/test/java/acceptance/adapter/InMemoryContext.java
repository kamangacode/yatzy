package acceptance.adapter;

import fr.muludiki.yatzy.domain.Player;
import fr.muludiki.yatzy.domain.PlayerSet;
import fr.muludiki.yatzy.domain.context.PlayerContext;
import fr.muludiki.yatzy.domain.strategies.ScoreStrategy;
import fr.muludiki.yatzy.domain.strategies.StrategyScoreType;

import java.util.HashMap;
import java.util.Map;

public class InMemoryContext implements PlayerContext {

    private Player currentPlayer;
    private PlayerSet currentSet;
    private ScoreStrategy currentScoreStrategy;
    private final Map<String, Boolean> categoryAvailabilities = new HashMap<>();

    public void setCurrentPlayer(Player c) {
        this.currentPlayer = c;
    }

    public Player currentPlayer() {
        return currentPlayer;
    }

    public void setCurrentSet(PlayerSet s) {
        currentSet = s;
    }

    public PlayerSet currentSet() {
        return currentSet;
    }

    public void setCurrentStrategy(ScoreStrategy scoreStrategy) {
        currentScoreStrategy = scoreStrategy;
    }

    public ScoreStrategy currentStrategy() {
        return currentScoreStrategy;
    }


    public boolean isCategoryAvailable(String category) {
        return categoryAvailabilities.get(category);
    }

    public void deactiveCategory(String category) {
        categoryAvailabilities.replace(category, Boolean.FALSE);
    }

    public void initAvailableCategories() {
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_CHANCE.type, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_YATZI.type, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_ONES.type, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_TWOS.type, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_THREES.type, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_FOURS.type, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_FIVES.type, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_SIXES.type, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_SCORE_PAIR.type, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_TWO_PAIR.type, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_FOUR_OF_A_KIND.type, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_THREE_OF_A_KIND.type, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_SMALL_STRAIGHT.type, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_LARGE_STRAIGHT.type, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_FULLHOUSE.type, Boolean.TRUE);
    }
}

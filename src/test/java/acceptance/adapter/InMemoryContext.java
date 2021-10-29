package acceptance.adapter;

import fr.muludiki.yatzy.domain.Player;
import fr.muludiki.yatzy.domain.PlayerSet;
import fr.muludiki.yatzy.domain.context.PlayerContext;
import fr.muludiki.yatzy.domain.strategies.ScoreStrategy;
import fr.muludiki.yatzy.domain.strategies.StrategyScoreType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryContext implements PlayerContext {

    private Player currentPlayer;
    private PlayerSet currentSet;
    private ScoreStrategy currentScoreStrategy;
    private final Map<StrategyScoreType, Boolean> categoryAvailabilities = new HashMap<>();

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

    public boolean isCategoryAvailable(String category) {
        Optional<Boolean> optionalAvailability = Optional.ofNullable(categoryAvailabilities.get(StrategyScoreType.of(category)));
        return optionalAvailability.isPresent() && optionalAvailability.get();
    }

    public void deactiveCategory(String category) {
        categoryAvailabilities.replace(StrategyScoreType.of(category), Boolean.FALSE);
    }

    public void initAvailableCategories() {
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_CHANCE, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_YATZI, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_ONES, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_TWOS, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_THREES, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_FOURS, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_FIVES, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_SIXES, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_SCORE_PAIR, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_TWO_PAIR, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_FOUR_OF_A_KIND, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_THREE_OF_A_KIND, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_SMALL_STRAIGHT, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_LARGE_STRAIGHT, Boolean.TRUE);
        categoryAvailabilities.put(StrategyScoreType.CATEGORY_FULLHOUSE, Boolean.TRUE);
    }
}

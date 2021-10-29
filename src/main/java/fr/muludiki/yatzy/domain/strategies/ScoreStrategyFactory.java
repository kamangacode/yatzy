package fr.muludiki.yatzy.domain.strategies;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static fr.muludiki.yatzy.domain.strategies.StrategyScoreType.*;

public class ScoreStrategyFactory {

    private Map<StrategyScoreType, ScoreStrategy> strategyMap;

    private void initStrategyMap() {
        strategyMap = new HashMap<>();
        strategyMap.put(CATEGORY_CHANCE, new ChanceStrategy());
        strategyMap.put(CATEGORY_YATZI, new YatziStrategy());
        strategyMap.put(CATEGORY_ONES, new SingleStrategy(1));
        strategyMap.put(CATEGORY_TWOS, new SingleStrategy(2));
        strategyMap.put(CATEGORY_THREES, new SingleStrategy(3));
        strategyMap.put(CATEGORY_FOURS, new SingleStrategy(4));
        strategyMap.put(CATEGORY_FIVES, new SingleStrategy(5));
        strategyMap.put(CATEGORY_SIXES, new SingleStrategy(6));
        strategyMap.put(CATEGORY_SCORE_PAIR, new PairStrategy());
        strategyMap.put(CATEGORY_TWO_PAIR, new TwoPairStrategy());
        strategyMap.put(CATEGORY_FOUR_OF_A_KIND, new FourOfAKindStrategy());
        strategyMap.put(CATEGORY_THREE_OF_A_KIND, new ThreeOfAKindStrategy());
        strategyMap.put(CATEGORY_SMALL_STRAIGHT, new SmallStraightStrategy());
        strategyMap.put(CATEGORY_LARGE_STRAIGHT, new LargeStraightStrategy());
        strategyMap.put(CATEGORY_FULLHOUSE, new FullHouseStrategy());
    }

    public Optional<ScoreStrategy> getStrategy(String category) {
        initStrategyMap();
        return Optional.ofNullable(strategyMap.get(StrategyScoreType.of(category)));
    }
}

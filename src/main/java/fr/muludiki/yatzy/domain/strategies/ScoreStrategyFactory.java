package fr.muludiki.yatzy.domain.strategies;

import java.util.Map;
import java.util.function.Supplier;

import static fr.muludiki.yatzy.domain.strategies.StrategyScoreType.*;

public class ScoreStrategyFactory {

    private static final Map<StrategyScoreType, Supplier<ScoreStrategy>> STRATEGIES = Map.ofEntries(
            Map.entry(CATEGORY_CHANCE, ChanceStrategy::new),
            Map.entry(CATEGORY_YATZI, YatziStrategy::new),
            Map.entry(CATEGORY_ONES, SingleStrategy.OnesStrategy::new),
            Map.entry(CATEGORY_TWOS, SingleStrategy.TwosStrategy::new),
            Map.entry(CATEGORY_THREES, SingleStrategy.ThreesStrategy::new),
            Map.entry(CATEGORY_FOURS, SingleStrategy.FoursStrategy::new),
            Map.entry(CATEGORY_FIVES, SingleStrategy.FivesStrategy::new),
            Map.entry(CATEGORY_SIXES, SingleStrategy.SixStrategy::new),
            Map.entry(CATEGORY_SCORE_PAIR, PairStrategy::new),
            Map.entry(CATEGORY_TWO_PAIR, TwoPairStrategy::new),
            Map.entry(CATEGORY_FOUR_OF_A_KIND, FourOfAKindStrategy::new),
            Map.entry(CATEGORY_THREE_OF_A_KIND, ThreeOfAKindStrategy::new),
            Map.entry(CATEGORY_SMALL_STRAIGHT, SmallStraightStrategy::new),
            Map.entry(CATEGORY_LARGE_STRAIGHT, LargeStraightStrategy::new),
            Map.entry(CATEGORY_FULLHOUSE, FullHouseStrategy::new));


    public ScoreStrategy getStrategy(String category) {

        Supplier<ScoreStrategy> scoreStrategySupplier = STRATEGIES.get(of(category));

        if(scoreStrategySupplier == null) {
            throw new IllegalArgumentException("Invalid category : " + category);
        }

        return scoreStrategySupplier.get();
    }
}

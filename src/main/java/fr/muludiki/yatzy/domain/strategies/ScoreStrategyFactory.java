package fr.muludiki.yatzy.domain.strategies;

import static fr.muludiki.yatzy.domain.strategies.StrategyScoreType.*;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.Optional;

public class ScoreStrategyFactory {

  private static final Map<StrategyScoreType, ScoreStrategy> strategyMap = Map.ofEntries(
      new SimpleEntry<StrategyScoreType, ScoreStrategy>(CATEGORY_CHANCE, new ChanceStrategy()),
      new SimpleEntry<StrategyScoreType, ScoreStrategy>(CATEGORY_YATZI, new YatziStrategy()),
      new SimpleEntry<StrategyScoreType, ScoreStrategy>(CATEGORY_ONES, new SingleStrategy(1)),
      new SimpleEntry<StrategyScoreType, ScoreStrategy>(CATEGORY_TWOS, new SingleStrategy(2)),
      new SimpleEntry<StrategyScoreType, ScoreStrategy>(CATEGORY_THREES, new SingleStrategy(3)),
      new SimpleEntry<StrategyScoreType, ScoreStrategy>(CATEGORY_FOURS, new SingleStrategy(4)),
      new SimpleEntry<StrategyScoreType, ScoreStrategy>(CATEGORY_FIVES, new SingleStrategy(5)),
      new SimpleEntry<StrategyScoreType, ScoreStrategy>(CATEGORY_SIXES, new SingleStrategy(6)),
      new SimpleEntry<StrategyScoreType, ScoreStrategy>(CATEGORY_SCORE_PAIR, new PairStrategy()),
      new SimpleEntry<StrategyScoreType, ScoreStrategy>(CATEGORY_TWO_PAIR, new TwoPairStrategy()),
      new SimpleEntry<StrategyScoreType, ScoreStrategy>(CATEGORY_FOUR_OF_A_KIND, new FourOfAKindStrategy()),
      new SimpleEntry<StrategyScoreType, ScoreStrategy>(CATEGORY_THREE_OF_A_KIND, new ThreeOfAKindStrategy()),
      new SimpleEntry<StrategyScoreType, ScoreStrategy>(CATEGORY_SMALL_STRAIGHT, new SmallStraightStrategy()),
      new SimpleEntry<StrategyScoreType, ScoreStrategy>(CATEGORY_LARGE_STRAIGHT, new LargeStraightStrategy()),
      new SimpleEntry<StrategyScoreType, ScoreStrategy>(CATEGORY_FULLHOUSE, new FullHouseStrategy()));

  public Optional<ScoreStrategy> getStrategy(String category) {
    return Optional.ofNullable(strategyMap.get(StrategyScoreType.of(category)));
  }
}

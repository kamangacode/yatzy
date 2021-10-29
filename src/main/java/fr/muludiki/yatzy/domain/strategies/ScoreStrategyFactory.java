package fr.muludiki.yatzy.domain.strategies;

public class ScoreStrategyFactory {

    public ScoreStrategy getStrategy(StrategyScoreType category) {
        switch (category) {
            case CATEGORY_CHANCE:
                return new ChanceStrategy();
            case CATEGORY_YATZI:
                return new YatziStrategy();
            case CATEGORY_ONES:
                return new SingleStrategy(1);
            case CATEGORY_TWOS:
                return new SingleStrategy(2);
            case CATEGORY_THREES:
                return new SingleStrategy(3);
            case CATEGORY_FOURS:
                return new SingleStrategy(4);
            case CATEGORY_FIVES:
                return new SingleStrategy(5);
            case CATEGORY_SIXES:
                return new SingleStrategy(6);
            case CATEGORY_SCORE_PAIR:
                return new PairStrategy();
            case CATEGORY_TWO_PAIR:
                return new TwoPairStrategy();
            case CATEGORY_FOUR_OF_A_KIND:
                return new FourOfAKindStrategy();
            case CATEGORY_THREE_OF_A_KIND:
                return new ThreeOfAKindStrategy();
            case CATEGORY_SMALL_STRAIGHT:
                return new SmallStraightStrategy();
            case CATEGORY_LARGE_STRAIGHT:
                return new LargeStraightStrategy();
            case CATEGORY_FULLHOUSE:
                return new FullHouseStrategy();
            default:
                throw new UnsupportedOperationException("Type de strategie inconnue");
        }
    }
}

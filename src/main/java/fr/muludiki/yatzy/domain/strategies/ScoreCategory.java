package fr.muludiki.yatzy.domain.strategies;

import java.util.function.Supplier;
import java.util.stream.Stream;

public enum ScoreCategory {
    CATEGORY_CHANCE("chance", ChanceStrategy::new),
    CATEGORY_YATZI("yatzy", YatziStrategy::new),
    CATEGORY_ONES("ones", () -> new SingleStrategy(1)),
    CATEGORY_TWOS("twos", () -> new SingleStrategy(2)),
    CATEGORY_THREES("threes", () -> new SingleStrategy(3)),
    CATEGORY_FOURS("fours", () -> new SingleStrategy(4)),
    CATEGORY_FIVES("fives", () -> new SingleStrategy(5)),
    CATEGORY_SIXES("sixes", () -> new SingleStrategy(6)),
    CATEGORY_SCORE_PAIR("paire", () -> new SomeOfAKindStrategy(2)),
    CATEGORY_TWO_PAIR("deux paires", TwoPairStrategy::new),
    CATEGORY_FOUR_OF_A_KIND("carre",() -> new SomeOfAKindStrategy(4)),
    CATEGORY_THREE_OF_A_KIND("brelan", () -> new SomeOfAKindStrategy(3)),
    CATEGORY_SMALL_STRAIGHT("petite suite", SmallStraightStrategy::new),
    CATEGORY_LARGE_STRAIGHT("grande suite", LargeStraightStrategy::new),
    CATEGORY_FULLHOUSE("full house", FullHouseStrategy::new);

    private final String type;
    public final Supplier<ScoreStrategy> scoreStrategy;

    ScoreCategory(String type, Supplier<ScoreStrategy> scoreStrategy) {
        this.type = type;
        this.scoreStrategy = scoreStrategy;
    }

    public String getType() {
        return type;
    }

    public Supplier<ScoreStrategy> getScoreStrategy() {
        return scoreStrategy;
    }

    public static ScoreCategory of(String type) {
        return Stream.of(ScoreCategory.values())
            .filter(c -> c.type.equals(type))
            .findAny()
            .orElseThrow(IllegalArgumentException::new);
    }
}

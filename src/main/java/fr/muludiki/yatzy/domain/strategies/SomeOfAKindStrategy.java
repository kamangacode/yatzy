package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;
import java.util.stream.Stream;

class SomeOfAKindStrategy implements ScoreStrategy {

  private static final int MISSED_X_OF_A_KIND = 0;

  private final int value;

  public SomeOfAKindStrategy(int value){
    this.value = value;
  }

  @Override
  public int compute(PlayerSet playerSet) {
    return Stream.of(1, 2, 3, 4, 5, 6)
        .filter(integer -> playerSet.getCountDiceByValue()[integer - 1] >= value)
        .mapToInt(diceValue -> diceValue * value)
        .max()
        .orElse(MISSED_X_OF_A_KIND);
  }
}

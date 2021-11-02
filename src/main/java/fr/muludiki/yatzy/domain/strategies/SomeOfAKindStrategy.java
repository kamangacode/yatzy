package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;
import java.util.stream.IntStream;

class SomeOfAKindStrategy implements ScoreStrategy {

  private static final int MISSED_X_OF_A_KIND = 0;

  private final int value;

  public SomeOfAKindStrategy(int value){
    this.value = value;
  }

  @Override
  public int compute(PlayerSet playerSet) {
    return IntStream.range(1, 7)
        .filter(integer -> playerSet.getCountDiceByValue()[integer - 1] >= value)
        .map(diceValue -> diceValue * value)
        .max()
        .orElse(MISSED_X_OF_A_KIND);
  }
}

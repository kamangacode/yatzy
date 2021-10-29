package fr.muludiki.yatzy.domain;

import static java.text.MessageFormat.format;

import java.util.List;

public class PlayerSet {

  public static final int MINIMUM_DICE_VALUE = 1;
  public static final int MAXIMUM_DICE_VALUE = 6;

  private final List<Integer> diceValues;
  public final int[] countDiceByValue = new int[MAXIMUM_DICE_VALUE];

  public PlayerSet(int des1, int des2, int des3, int des4, int des5) {
    diceValues = List.of(des1, des2, des3, des4, des5);
    if (diceValues.stream().anyMatch(diceValue -> diceValue < MINIMUM_DICE_VALUE || diceValue > MAXIMUM_DICE_VALUE)) {
      throw new IllegalArgumentException(
          format("Dice value must be between {0} and {1}.", MINIMUM_DICE_VALUE, MAXIMUM_DICE_VALUE));
    }

    diceValues.forEach(diceValue -> countDiceByValue[diceValue - 1]++);
  }

  public int[] getCountDiceByValue() {
    return countDiceByValue;
  }

  public int sumAllDice() {
    return diceValues.stream().reduce(0, Integer::sum);
  }

  public boolean allDiceHaveSameNumber() {
    return diceValues.stream()
        .distinct()
        .count() == 1;
  }

  public int sumMatchingDiceForDiceValue(int diceValue) {
    return diceValues.stream()
        .filter(value -> value == diceValue)
        .reduce(0, Integer::sum);
  }
}

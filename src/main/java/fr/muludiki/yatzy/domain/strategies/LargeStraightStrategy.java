package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;
import java.util.stream.IntStream;

/**
 * Lorsqu'il est placé sur « grande suite », si les dés indiquent
 *
 * 2,3,4,5,6,
 *
 * le joueur marque 20 (la somme de tous les dés).
 */
class LargeStraightStrategy implements ScoreStrategy {

    private static final int LARGE_STRAIGHT_SCORE = 20;
    private static final int LARGE_STRAIGHT_NO_SCORE = 0;

    @Override
    public int compute(PlayerSet playerSet) {
       return IntStream.range(2, 7)
           .filter(integer -> playerSet.getCountDiceByValue()[integer-1] == 1)
           .count() == 5
           ? LARGE_STRAIGHT_SCORE : LARGE_STRAIGHT_NO_SCORE;
    }
}

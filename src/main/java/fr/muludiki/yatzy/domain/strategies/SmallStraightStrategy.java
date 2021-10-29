package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

import java.util.stream.Stream;

/**
 * Lorsqu'il est placé sur « petite suite », si les dés indiquent
 *
 * 1,2,3,4,5,
 *
 * le joueur marque 15 (la somme de tous les dés).
 */
class SmallStraightStrategy implements ScoreStrategy {

    public static final int SMALL_STRAIGHT_SCORE = 15;
    public static final int SMALL_STRAIGHT_NO_SCORE = 0;

    @Override
    public int compute(PlayerSet playerSet) {
        if(Stream.of(1, 2, 3, 4, 5).filter(integer -> playerSet.getCountDiceByValue()[integer-1] == 1)
                .count() == 5) {
            return SMALL_STRAIGHT_SCORE;
        }else{
            return SMALL_STRAIGHT_NO_SCORE;
        }
    }
}

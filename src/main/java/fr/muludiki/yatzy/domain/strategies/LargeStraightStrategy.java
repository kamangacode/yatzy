package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

import java.util.stream.Stream;

/**
 * Lorsqu'il est placé sur « grande suite », si les dés indiquent
 *
 * 2,3,4,5,6,
 *
 * le joueur marque 20 (la somme de tous les dés).
 */
class LargeStraightStrategy extends AbstractStrategy implements ScoreStrategy {

    public static final int LARGE_STRAIGHT_SCORE = 20;
    public static final int LARGE_STRAIGHT_NO_SCORE = 0;

    @Override
    public int compute(PlayerSet set) {
        increaseRowByOne(set);
        if(Stream.of(2, 3, 4, 5,6).filter(integer -> tallies[integer-1] == 1)
                .count() == 5) {
            return LARGE_STRAIGHT_SCORE;
        }else{
            return LARGE_STRAIGHT_NO_SCORE;
        }
    }

}

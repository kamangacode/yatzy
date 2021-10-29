package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;
import java.util.stream.Stream;

/**
 * Si les dés sont un carre et un brelan, le joueur marque la somme de tous les dés.
 * Par exemple, lorsqu'il est placé sur « pleine maison » :
 *
 * 1,1,2,2,2 note 8 (1+1+2+2+2)
 * 2,2,3,3,4 notes 0
 * 4,4,4,4,4 notes 0
 */
class FullHouseStrategy implements ScoreStrategy {

    private static final int FULL_HOUSE_NO_SCORE = 0;
    private static final int PAIR = 2;
    private static final int THREES = 3;

    @Override
    public int compute(PlayerSet playerSet) {
        int pairs = Stream.of(1, 2, 3, 4, 5, 6)
                .filter(integer -> playerSet.getCountDiceByValue()[integer - 1] == PAIR)
                .findFirst().orElse(0);

        int threes = Stream.of(1, 2, 3, 4, 5, 6)
                .filter(integer -> playerSet.getCountDiceByValue()[integer - 1] == THREES)
                .findFirst().orElse(0);

        return pairs > 0 && threes > 0 ? pairs * 2 + threes * 3 : FULL_HOUSE_NO_SCORE;
    }
}

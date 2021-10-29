package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

/**
 * Lorsqu'il est placé sur « grande ligne droite », si les dés indiquent
 *
 * 2,3,4,5,6,
 *
 * le joueur marque 20 (la somme de tous les dés).
 */
class LargeStraightStrategy extends AbstractStrategy implements ScoreStrategy {
    @Override
    public int compute(PlayerSet set) {
        increaseRowByOne(set);
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
        return 0;
    }
}

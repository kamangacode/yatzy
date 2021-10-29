package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

/**
 * Lorsqu'il est placé sur « petite ligne droite », si les dés indiquent
 *
 * 1,2,3,4,5,
 *
 * le joueur marque 15 (la somme de tous les dés).
 */
class SmallStraightStrategy extends AbstractStrategy implements ScoreStrategy {
    @Override
    public int compute(PlayerSet set) {
        increaseRowByOne(set);
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
        return 0;
    }
}

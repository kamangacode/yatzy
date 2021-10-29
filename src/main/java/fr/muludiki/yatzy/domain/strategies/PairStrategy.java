package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

/**
 * Le joueur marque la somme des deux dés correspondants les plus élevés. Par exemple, lorsqu'il est placé sur « paire » :
 *
 * 3,3,3,4,4 note 8 (4+4)
 * 1,1,6,2,6 note 12 (6+6)
 * 3,3,3,4,1 note 6 (3+3)
 * 3,3,3,3,1 note 6 (3+3)
 */
class PairStrategy extends AbstractStrategy implements ScoreStrategy {
    @Override
    public int compute(PlayerSet set) {
        increaseRowByOne(set);
        for (int at = 0; at != 6; at++)
            if (tallies[6-at-1] >= 2)
                return (6-at)*2;
        return 0;
    }
}

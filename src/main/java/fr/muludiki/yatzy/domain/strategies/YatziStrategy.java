package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

/**
 * Si tous les dés ont le même numéro, le joueur marque 50 points. Par exemple:
 *
 * <li>1,1,1,1,1 placé sur des scores « yatzy » 50</li>
 * <li>1,1,1,2,1 placé sur des scores « yatzy » 0</li>
 */
class YatziStrategy extends AbstractStrategy implements ScoreStrategy {
    public int compute(PlayerSet set) {
        int[] dice = {set.getDes1(),set.getDes2(),set.getDes3(),set.getDes4(),set.getDes5()};
        for (int die : dice)
            tallies[die-1]++;
        for (int i = 0; i != 6; i++)
            if (tallies[i] == 5)
                return 50;
        return 0;
    }
}

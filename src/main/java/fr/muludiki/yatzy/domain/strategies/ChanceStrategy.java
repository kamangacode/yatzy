package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

/**
 * Le joueur marque la somme de tous les dés, peu importe ce qu'il lit. Par exemple:
 *
 * <li>1,1,3,3,6 placé sur « chance » scores 14 (1+1+3+3+6)</li>
 * <li>4,5,5,6,1 placé sur « chance » scores 21 (4+5+5+6+1)</li>
 */
class ChanceStrategy implements ScoreStrategy {

    @Override
    public int compute(PlayerSet playerSet) {
        return playerSet.getDiceValues()
            .stream()
            .reduce(0, Integer::sum);
    }
}

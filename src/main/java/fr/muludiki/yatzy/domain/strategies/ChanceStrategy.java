package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

/**
 * Le joueur marque la somme de tous les dés, peu importe ce qu'il lit. Par exemple:
 *
 * <li>1,1,3,3,6 placé sur « chance » scores 14 (1+1+3+3+6)</li>
 * <li>4,5,5,6,1 placé sur « chance » scores 21 (4+5+5+6+1)</li>
 */
class ChanceStrategy implements ScoreStrategy {
    public int compute(PlayerSet set) {
        int score = 0;
        score += set.getDes1();
        score += set.getDes2();
        score += set.getDes3();
        score += set.getDes4();
        score += set.getDes5();
        return score;
    }
}

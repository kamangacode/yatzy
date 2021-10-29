package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

/**
 * Le joueur marque la somme des dés qui indique un. Par exemple:
 *
 * <li>1,1,2,4,4 placé à un notes 2 (1+1)</li>
 * <li>3,3,3,4,5 placé sur un scores 0</li>
 */
class SingleStrategy implements ScoreStrategy {

    private int value = 0;

    public SingleStrategy(int value){
        this.value = value;
    }
    @Override
    public int compute(PlayerSet set) {
        int score = 0;
        if (set.getDes1() == value) score += value;
        if (set.getDes2() == value) score += value;
        if (set.getDes3() == value) score += value;
        if (set.getDes4() == value) score += value;
        if (set.getDes5() == value) score += value;

        return score;
    }
}

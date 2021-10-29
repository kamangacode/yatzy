package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

/**
 * Le joueur marque la somme des dés qui indique un. Par exemple:
 *
 * <li>1,1,2,4,4 placé à un notes 2 (1+1)</li>
 * <li>3,3,3,4,5 placé sur un scores 0</li>
 */
class SingleStrategy implements ScoreStrategy {

    private final int value;

    public SingleStrategy(int value){
        this.value = value;
    }

    @Override
    public int compute(PlayerSet playerSet) {
        return playerSet.sumMatchingDiceForDiceValue(value);
    }
}

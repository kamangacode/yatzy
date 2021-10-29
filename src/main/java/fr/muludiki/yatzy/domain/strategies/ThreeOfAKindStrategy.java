package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

/**
 * S'il y a trois dés avec le même numéro,
 * le joueur marque la somme de ces dés. Par exemple, lorsqu'il est placé sur « brelan » :
 *
 * 3,3,3,4,5 note 9 (3+3+3)
 * 3,3,4,5,6 notes 0
 * 3,3,3,3,1 note 9 (3+3+3)
 */
class ThreeOfAKindStrategy extends AbstractStrategy implements ScoreStrategy {
    @Override
    public int compute(PlayerSet set) {
        increaseRowByOne(set);
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 3)
                return (i+1) * 3;
        return 0;
    }


}

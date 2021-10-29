package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

/**
 * S'il y a quatre dés avec le même numéro,
 * le joueur marque la somme de ces dés. Par exemple, lorsqu'il est placé sur un « carré » :
 *
 * 2,2,2,2,5 note 8 (2+2+2+2)
 * 2,2,2,5,5 notes 0
 * 2,2,2,2,2 note 8 (2+2+2+2)
 */
class FourOfAKindStrategy extends AbstractStrategy implements ScoreStrategy {
    @Override
    public int compute(PlayerSet set) {
        increaseRowByOne(set);
        for (int die = 0; die < 6; die++)
            if (tallies[die] >= 4)
                return (die+1) * 4;
        return 0;
    }
}

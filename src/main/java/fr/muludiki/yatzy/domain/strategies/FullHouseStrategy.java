package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

/**
 * Si les dés sont un carre et un brelan, le joueur marque la somme de tous les dés.
 * Par exemple, lorsqu'il est placé sur « pleine maison » :
 *
 * 1,1,2,2,2 note 8 (1+1+2+2+2)
 * 2,2,3,3,4 notes 0
 * 4,4,4,4,4 notes 0
 */
class FullHouseStrategy extends AbstractStrategy implements ScoreStrategy {
    @Override
    public int compute(PlayerSet set) {
        boolean isTwoOfAKind = false;
        int twoOfAKindFor = 0;
        boolean isThreeOfAKind = false;
        int threeOfAKindForNumber = 0;
        increaseRowByOne(set);

        for (int i = 0; i != 6; i += 1){
            if (tallies[i] == 2) {
                isTwoOfAKind = true;
                twoOfAKindFor = i+1;
            }
        }

        for (int i = 0; i != 6; i += 1){
            if (tallies[i] == 3) {
                isThreeOfAKind = true;
                threeOfAKindForNumber = i+1;
            }
        }

        if (isTwoOfAKind && isThreeOfAKind)
            return twoOfAKindFor * 2 + threeOfAKindForNumber * 3;
        else
            return 0;
    }
}

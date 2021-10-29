package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;
/**
 * S'il y a deux paires de dés avec le même numéro,
 * le joueur marque la somme de ces dés. Par exemple, lorsqu'il est placé sur « deux paires » :
 *
 * 1,1,2,3,3 note 8 (1+1+3+3)
 * 1,1,2,3,4 notes 0
 * 1,1,2,2,2 note 6 (1+1+2+2)
 */
class TwoPairStrategy extends AbstractStrategy implements ScoreStrategy {
    @Override
    public int compute(PlayerSet set) {
        increaseRowByOne(set);
        int numberOfPair = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1){
            if (tallies[5-i] >= 2) {
                numberOfPair++;
                score += (6-i);
            }
        }

        if (numberOfPair == 2)
            return score * 2;
        else
            return 0;
    }
}

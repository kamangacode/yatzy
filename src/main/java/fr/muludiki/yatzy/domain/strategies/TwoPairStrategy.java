package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * S'il y a deux paires de dés avec le même numéro,
 * le joueur marque la somme de ces dés. Par exemple, lorsqu'il est placé sur « deux paires » :
 *
 * 1,1,2,3,3 note 8 (1+1+3+3)
 * 1,1,2,3,4 notes 0
 * 1,1,2,2,2 note 6 (1+1+2+2)
 */
class TwoPairStrategy extends AbstractStrategy implements ScoreStrategy {

    public static final int TWO_PAIR_NO_SCORE = 0;
    public static final int PAIR = 2;

    @Override
    public int compute(PlayerSet set) {
        increaseRowByOne(set);

        ArrayList<Integer> pairs = Stream.of(1, 2, 3, 4, 5, 6)
                .filter(integer -> tallies[integer - 1] >= PAIR)
                .collect(Collectors.toCollection(ArrayList::new));

        if(pairs.size() == PAIR){
            return pairs.stream().reduce(0, (a, b) -> a + b * 2);
        } else{
            return TWO_PAIR_NO_SCORE;
        }
    }
}

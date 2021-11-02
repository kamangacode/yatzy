package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * S'il y a deux paires de dés avec le même numéro,
 * le joueur marque la somme de ces dés. Par exemple, lorsqu'il est placé sur « deux paires » :
 *
 * 1,1,2,3,3 note 8 (1+1+3+3)
 * 1,1,2,3,4 notes 0
 * 1,1,2,2,2 note 6 (1+1+2+2)
 */
class TwoPairStrategy implements ScoreStrategy {

    private static final int TWO_PAIR_NO_SCORE = 0;
    private static final int PAIR = 2;

    @Override
    public int compute(PlayerSet playerSet) {
        List<Integer> pairs = IntStream.range(1, 7)
            .filter(integer -> playerSet.getCountDiceByValue()[integer - 1] >= PAIR)
            .boxed()
            .collect(Collectors.toList());

        return pairs.size() == PAIR ? pairs.stream().reduce(0, (a, b) -> a + b * 2) : TWO_PAIR_NO_SCORE;
    }
}

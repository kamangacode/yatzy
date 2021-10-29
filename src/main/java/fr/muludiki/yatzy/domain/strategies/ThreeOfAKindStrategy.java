package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

import java.util.stream.Stream;

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
        return Stream.of(1, 2, 3, 4, 5, 6).filter(integer -> tallies[integer-1] >= 3)
                .mapToInt(v -> v * 3)
                .max()
                .orElse(0);
    }


}

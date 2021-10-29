package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

import java.util.stream.Stream;

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
    public int compute(PlayerSet playerSet) {
        increaseRowByOne(playerSet);
        return Stream.of(1, 2, 3, 4, 5).filter(integer -> tallies[integer-1] >= 4)
                .mapToInt(v -> v * 4)
                .max()
                .orElse(0);
    }
}

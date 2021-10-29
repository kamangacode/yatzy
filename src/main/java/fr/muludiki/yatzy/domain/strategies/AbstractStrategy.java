package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

public abstract class AbstractStrategy {
    int[] tallies = new int[6];

    void increaseRowByOne(PlayerSet playerSet) {
        playerSet.getSet().stream().forEach(integer -> tallies[integer-1]++);
    }
}

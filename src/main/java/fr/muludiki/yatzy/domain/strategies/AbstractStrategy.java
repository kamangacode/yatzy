package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

public abstract class AbstractStrategy {
    int[] tallies = new int[6];

    void increaseRowByOne(PlayerSet set) {
        tallies[set.getDes1()-1]++;
        tallies[set.getDes2()-1]++;
        tallies[set.getDes3()-1]++;
        tallies[set.getDes4()-1]++;
        tallies[set.getDes5()-1]++;
    }
}

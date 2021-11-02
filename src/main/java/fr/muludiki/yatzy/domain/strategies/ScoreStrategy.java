package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

public interface ScoreStrategy {
    int compute(PlayerSet set);
}

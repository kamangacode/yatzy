package fr.muludiki.yatzy.domain.repositories;

import fr.muludiki.yatzy.domain.Player;

import java.util.Set;

public interface PlayerRepository {

    Set<Player> all();

    void add(Player booking);
}

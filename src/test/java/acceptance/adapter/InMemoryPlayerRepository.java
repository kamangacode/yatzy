package acceptance.adapter;

import fr.muludiki.yatzy.domain.Player;
import fr.muludiki.yatzy.domain.repositories.PlayerRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class InMemoryPlayerRepository implements PlayerRepository {
    private final Set<Player> players = new HashSet<>();

    public Set<Player> all() {
        return Collections.unmodifiableSet(players);
    }

    public void add(Player pLayer) {
        players.add(pLayer);
    }
}

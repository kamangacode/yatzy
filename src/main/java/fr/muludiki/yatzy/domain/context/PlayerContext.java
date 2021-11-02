package fr.muludiki.yatzy.domain.context;

import fr.muludiki.yatzy.domain.Player;
import fr.muludiki.yatzy.domain.PlayerSet;

public interface PlayerContext {

    Player currentPlayer();
    PlayerSet currentSet();

    void setCurrentSet(PlayerSet s);

    void setCurrentPlayer(Player c);

    boolean isCategoryAvailable(String category);

    void deactiveCategory(String category);

    void initAvailableCategories();
}

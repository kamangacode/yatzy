package fr.muludiki.yatzy.domain.context;

import fr.muludiki.yatzy.domain.Player;
import fr.muludiki.yatzy.domain.PlayerSet;
import fr.muludiki.yatzy.domain.strategies.ScoreStrategy;

public interface PlayerContext {

    void setCurrentPlayer(Player c);
    Player currentPlayer();

    void setCurrentSet(PlayerSet s);
    PlayerSet currentSet();

    boolean isCategoryAvailable(String category);

    void setCurrentStrategy(ScoreStrategy scoreStrategy);
    ScoreStrategy currentStrategy();

    void deactiveCategory(String category);

    void initAvailableCategories();
}

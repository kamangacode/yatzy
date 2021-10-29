package acceptance.steps;

import fr.muludiki.yatzy.domain.context.PlayerContext;
import fr.muludiki.yatzy.usecase.PlayYatzi;
import io.cucumber.java8.En;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GameSteps implements En {

    public GameSteps(PlayerContext playerContext) {
        When("le joueur place le jet dans la catégorie {string}", (String category) -> {
            PlayYatzi yatzi = new PlayYatzi(playerContext);
            yatzi.play(playerContext.currentPlayer(), playerContext.currentSet(),category);
        });

        And("le score du joueur est {string}",
            (String score) -> assertEquals(Integer.parseInt(score), playerContext.currentPlayer().getScore()));

        And("la catégorie {string} ne peut plus être utilisé", (String category) -> {
            playerContext.deactiveCategory(category);
            assertFalse("La catégorie doit être désactivé",playerContext.isCategoryAvailable(category));
        });

        And("^toutes les catégories sont disponibles$", playerContext::initAvailableCategories);
    }
}

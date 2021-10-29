package acceptance.steps;

import fr.muludiki.yatzy.domain.Player;
import fr.muludiki.yatzy.domain.PlayerSet;
import fr.muludiki.yatzy.domain.context.PlayerContext;
import fr.muludiki.yatzy.domain.repositories.PlayerRepository;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;

public class PlayerSteps implements En {

    public PlayerSteps(PlayerRepository playerRepository, PlayerContext playerContext) {
        Given("^des joueurs existent:$", (DataTable dataTable) -> {
            List<Map<String, String>> dataMaps = dataTable.asMaps(String.class, String.class);
            dataMaps.forEach(dataMap -> {
                Player player = new Player(dataMap.get("id"), dataMap.get("firstName"),
                        Integer.parseInt(dataMap.get("score")));
                playerRepository.add(player);
            });
        });

        Given("Le joueur {string}", (String playerFirstName) -> {
            Optional<Player> optionalCustomer =
                    playerRepository.all().stream().filter(p -> p.getFirstName().equals(playerFirstName)).findFirst();
            optionalCustomer.ifPresent(playerContext::setCurrentPlayer);
            assertNotNull(playerContext.currentPlayer());
        });

        And("les dés {string} {string} {string} {string} {string}", (String des1, String des2, String des3, String des4, String des5) -> {
            playerContext.setCurrentSet(new PlayerSet(Integer.parseInt(des1),
                    Integer.parseInt(des2),
                    Integer.parseInt(des3),
                    Integer.parseInt(des4),
                    Integer.parseInt(des5)));

            assertNotNull(playerContext.currentSet());
        });
    }
}

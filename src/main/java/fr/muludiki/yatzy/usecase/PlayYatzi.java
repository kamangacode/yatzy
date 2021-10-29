package fr.muludiki.yatzy.usecase;

import fr.muludiki.yatzy.domain.Player;
import fr.muludiki.yatzy.domain.PlayerSet;
import fr.muludiki.yatzy.domain.context.PlayerContext;
import fr.muludiki.yatzy.domain.strategies.ScoreStrategy;
import fr.muludiki.yatzy.domain.strategies.ScoreStrategyFactory;
import fr.muludiki.yatzy.domain.strategies.StrategyScoreType;

import java.util.Optional;

/**
 * Le jeu de Yatzy est un simple jeu de dés. Chaque joueur lance cinq dés à six faces.
 * Ils peuvent relancer tout ou partie des dés jusqu'à trois fois (y compris le lancer d'origine).
 *
 * Le joueur place ensuite le jet dans une catégorie, comme un, deux, cinq, paire, deux paires, etc.
 * (voir les règles ci-dessous). Si le jet est compatible avec la catégorie,
 * le joueur obtient un score pour le jet selon les règles. Si le jet n'est pas compatible avec la catégorie,
 * le joueur marque zéro pour le jet.
 *
 * Par exemple, supposons qu'un joueur marque 5, 6, 5, 5, 2 dans la catégorie des cinq, il en marquerait
 * 15 (trois cinq). Le score de ce coup est ensuite ajouté à leur total et la catégorie ne peut plus
 * être utilisée dans les coups restants pour ce match. Un jeu complet se compose d'une partie
 * pour chaque catégorie. Ainsi, pour son dernier coup dans une partie, un joueur doit choisir
 * sa seule catégorie restante.
 *
 * Votre tâche est de marquer un jet DONNÉ dans une catégorie DONNÉE. Vous n'avez PAS à programmer
 * le lancer de dés aléatoire. Le jeu ne se joue PAS en laissant l'ordinateur choisir la catégorie
 * de score la plus élevée pour un jet donné.
 */
public class PlayYatzi {

    private final PlayerContext playerContext;

    public PlayYatzi(PlayerContext playerContext){
        this.playerContext = playerContext;
    }

    /**
     * Jouer au yatzi
     * @param player le joueur en cours
     * @param set le jeu de dès utilisé
     * @param category la catégorie choisie
     */
    public void play(Player player, PlayerSet set, String category){
        if(categoryAvailable(category)){
            Optional<ScoreStrategy> scoreStrategy = new ScoreStrategyFactory().getStrategy(category);
            if(scoreStrategy.isPresent()){
                player.updateScore(set, scoreStrategy.get());
                playerContext.setCurrentStrategy(scoreStrategy.get());
            }
        }
    }

    /**
     * Détermine si une catégorie n'a pas été utilisé dans un jeu précédent
     * @param category la catégorie à tester
     * @return la disponibilité de la catégorie pour le jeu du joueur
     */
    private boolean categoryAvailable(String category) {
        return playerContext.isCategoryAvailable(category);
    }
}

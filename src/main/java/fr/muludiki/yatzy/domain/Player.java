package fr.muludiki.yatzy.domain;

import fr.muludiki.yatzy.domain.strategies.ScoreStrategy;

import java.util.Objects;

/**
 * Player représente un joueur en cours de partie
 */
public class Player {
    /**
     * Identifiant unique
     */
    private final String id;

    /**
     * Prénom du joueur
     */
    private final String firstName;

    /**
     * Le score du joueur pour une partie
     */
    private int score;

    public Player(String id, String firstName, int score) {
        this.id = id;
        this.firstName = firstName;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id.equals(player.id) && firstName.equals(player.firstName) && score == player.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, score);
    }

    /**
     * Permet de mettre à jour le score d'un joueur en utilisant
     * le pattern strategy pour déterminé dynamiquement le score à donner.
     * @param set le lancement de dès en cours
     * @param scoreStrategy la strategy a utiliser en fonction de la catégorie choisie.
     */
    public void updateScore(PlayerSet set, ScoreStrategy scoreStrategy){
        int newScore = scoreStrategy.compute(set);
        score = score + newScore;
    }
}

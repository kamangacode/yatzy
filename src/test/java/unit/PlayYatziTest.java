package unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import acceptance.adapter.InMemoryContext;
import fr.muludiki.yatzy.domain.Player;
import fr.muludiki.yatzy.domain.PlayerSet;
import fr.muludiki.yatzy.domain.context.PlayerContext;
import fr.muludiki.yatzy.domain.strategies.StrategyScoreType;
import fr.muludiki.yatzy.usecase.PlayYatzi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayYatziTest {

    private final PlayerContext playerContext = new InMemoryContext();
    private Player brigitte;
    private PlayYatzi sut;

    @BeforeEach
    public void before(){
        playerContext.initAvailableCategories();
        brigitte = new Player("bgi","brigitte",0);
        sut = getPlayYatzi(playerContext);
    }

    public PlayYatzi getPlayYatzi(PlayerContext playerContext){
        return new PlayYatzi(playerContext);
    }

    @Test
    public void shouldPlayYatziWithChanceCategory(){
        //Given
        PlayerSet set = new PlayerSet(1,1,3,3,6);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_CHANCE.getType());

        //Then
        assertEquals(14, brigitte.getScore());
    }

    @Test
    public void shouldPlayYatziWithYatzyCategory(){
        //Given
        PlayerSet set = new PlayerSet(1,1,1,1,1);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set, StrategyScoreType.CATEGORY_YATZI.getType());

        //Then
        assertEquals(50, brigitte.getScore());
    }

    @Test
    public void shouldNotPlayYatziWithYatzyCategory(){
        //Given
        PlayerSet set = new PlayerSet(1,1,1,2,1);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_YATZI.getType());

        //Then
        assertEquals(0, brigitte.getScore());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, 1, 3, 6,     2",
        "1, 2, 1, 3, 1,     3",
        "1, 2, 5, 3, 6,     1",
        "3, 2, 4, 3, 6,     0",
        "1, 2, 1, 3, 6,     2",
    })
    public void shouldPlayYatziWithOnesCategory(final int die1, final int die2, final int die3,
        final int die4, final int die5, final int expected){
        //Given
        PlayerSet set = new PlayerSet(die1, die2, die3, die4, die5);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_ONES.getType());

        //Then
        assertEquals(expected, brigitte.getScore());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, 1, 2, 6,     4",
        "1, 2, 1, 3, 1,     2",
        "1, 2, 5, 2, 2,     6",
        "3, 6, 4, 3, 6,     0",
        "2, 2, 2, 2, 6,     8",
    })
    public void shouldPlayYatziWithTwosCategory(final int die1, final int die2, final int die3,
        final int die4, final int die5, final int expected){
        //Given
        PlayerSet set = new PlayerSet(die1, die2, die3, die4, die5);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_TWOS.getType());

        //Then
        assertEquals(expected, brigitte.getScore());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 3, 1, 2, 6,     3",
        "1, 2, 3, 3, 1,     6",
        "1, 2, 5, 2, 2,     0",
        "3, 3, 4, 3, 6,     9",
        "3, 3, 3, 3, 6,     12",
    })
    public void shouldPlayYatziWithThreesCategory(final int die1, final int die2, final int die3,
        final int die4, final int die5, final int expected){
        //Given
        PlayerSet set = new PlayerSet(die1, die2, die3, die4, die5);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_THREES.getType());

        //Then
        assertEquals(expected, brigitte.getScore());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 3, 1, 2, 4,     4",
        "1, 2, 3, 4, 4,     8",
        "1, 2, 4, 4, 4,     12",
        "3, 3, 5, 3, 6,     0",
        "3, 4, 4, 4, 4,     16",
    })
    public void shouldPlayYatziWithFoursCategory(final int die1, final int die2, final int die3,
        final int die4, final int die5, final int expected){
        //Given
        PlayerSet set = new PlayerSet(die1, die2, die3, die4, die5);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_FOURS.getType());

        //Then
        assertEquals(expected, brigitte.getScore());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 3, 1, 2, 5,     5",
        "1, 2, 3, 5, 5,     10",
        "1, 2, 5, 5, 5,     15",
        "3, 5, 5, 5, 5,     20",
        "3, 4, 4, 4, 4,     0",
    })
    public void shouldPlayYatziWithFivesCategory(final int die1, final int die2, final int die3,
        final int die4, final int die5, final int expected){
        //Given
        PlayerSet set = new PlayerSet(die1, die2, die3, die4, die5);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_FIVES.getType());

        //Then
        assertEquals(expected, brigitte.getScore());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 3, 1, 2, 6,     6",
        "1, 2, 3, 6, 6,     12",
        "1, 2, 6, 6, 6,     18",
        "3, 6, 6, 6, 6,     24",
        "3, 4, 4, 4, 4,     0",
    })
    public void shouldPlayYatziWithSixesCategory(final int die1, final int die2, final int die3,
        final int die4, final int die5, final int expected){
        //Given
        PlayerSet set = new PlayerSet(die1, die2, die3, die4, die5);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_SIXES.getType());

        //Then
        assertEquals(expected, brigitte.getScore());
    }

    @Test
    public void shouldPlayYatziWithScorePairCategory(){
        //Given
        PlayerSet set = new PlayerSet(3,3,3,4,4);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_SCORE_PAIR.getType());

        //Then
        assertEquals(8, brigitte.getScore());
    }

    @Test
    public void shouldNotPlayYatziWithScorePairCategory(){
        //Given
        PlayerSet set = new PlayerSet(3,5,2,1,6);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_SCORE_PAIR.getType());

        //Then
        assertEquals(0, brigitte.getScore());
    }

    @Test
    public void shouldPlayYatziWithTwoPairCategory(){
        //Given
        PlayerSet set = new PlayerSet(1,1,2,3,3);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_TWO_PAIR.getType());

        //Then
        assertEquals(8, brigitte.getScore());
    }

    @Test
    public void shouldNotPlayYatziWithTwoPairCategory(){
        //Given
        PlayerSet set = new PlayerSet(1,1,2,3,4);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_TWO_PAIR.getType());

        //Then
        assertEquals(0, brigitte.getScore());
    }

    @Test
    public void shouldPlayYatziWithThreeOfAKindCategory(){
        //Given
        PlayerSet set = new PlayerSet(5,4,3,3,3);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_THREE_OF_A_KIND.getType());

        //Then
        assertEquals(9, brigitte.getScore());
    }

    @Test
    public void shouldNotPlayYatziWithThreeOfAKindCategory(){
        //Given
        PlayerSet set = new PlayerSet(3,3,4,5,6);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_THREE_OF_A_KIND.getType());

        //Then
        assertEquals(0, brigitte.getScore());
    }

    @Test
    public void shouldPlayYatziWithSmallStraightCategory(){
        //Given
        PlayerSet set = new PlayerSet(1,2,3,4,5);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_SMALL_STRAIGHT.getType());

        //Then
        assertEquals(15, brigitte.getScore());
    }

    @Test
    public void shouldNotPlayYatziWithSmallStraightCategory(){
        //Given
        PlayerSet set = new PlayerSet(3,3,4,5,6);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_SMALL_STRAIGHT.getType());

        //Then
        assertEquals(0, brigitte.getScore());
    }

    @Test
    public void shouldPlayYatziWithLargeStraightCategory(){
        //Given
        PlayerSet set = new PlayerSet(2,3,4,5,6);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_LARGE_STRAIGHT.getType());

        //Then
        assertEquals(20, brigitte.getScore());
    }

    @Test
    public void shouldNotPlayYatziWithLargeStraightCategory(){
        //Given
        PlayerSet set = new PlayerSet(3,3,4,5,6);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_LARGE_STRAIGHT.getType());

        //Then
        assertEquals(0, brigitte.getScore());
    }

    @Test
    public void shouldPlayYatziWithFullHouseCategory(){
        //Given
        PlayerSet set = new PlayerSet(1,1,2,2,2);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_FULLHOUSE.getType());

        //Then
        assertEquals(8, brigitte.getScore());
    }

    @Test
    public void shouldNotPlayYatziWithFullHouseCategory(){
        //Given
        PlayerSet set = new PlayerSet(1,1,2,2,2);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_FULLHOUSE.getType());

        //Then
        assertEquals(8, brigitte.getScore());
    }

    @Test
    public void shouldPlayYatziWithFourOfAKindCategory(){
        //Given
        PlayerSet set = new PlayerSet(4,4,4,4,6);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_FOUR_OF_A_KIND.getType());

        //Then
        assertEquals(16, brigitte.getScore());
    }

    @Test
    public void shouldNotPlayYatziWithFourOfAKindCategory(){
        //Given
        PlayerSet set = new PlayerSet(1,1,2,2,2);
        playerContext.setCurrentPlayer(brigitte);
        playerContext.setCurrentSet(set);

        //When
        sut.play(brigitte,set,StrategyScoreType.CATEGORY_FOUR_OF_A_KIND.getType());

        //Then
        assertEquals(0, brigitte.getScore());
    }
}

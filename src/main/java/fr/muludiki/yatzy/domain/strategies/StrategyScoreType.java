package fr.muludiki.yatzy.domain.strategies;

import java.util.Arrays;

public enum StrategyScoreType {
    CATEGORY_CHANCE("chance"),
    CATEGORY_YATZI("yatzy"),
    CATEGORY_ONES("ones"),
    CATEGORY_TWOS("twos"),
    CATEGORY_THREES("threes"),
    CATEGORY_FOURS("fours"),
    CATEGORY_FIVES("fives"),
    CATEGORY_SIXES("sixes"),
    CATEGORY_SCORE_PAIR("paire"),
    CATEGORY_TWO_PAIR("deux paires"),
    CATEGORY_FOUR_OF_A_KIND("carre"),
    CATEGORY_THREE_OF_A_KIND("brelan"),
    CATEGORY_SMALL_STRAIGHT("petite ligne droite"),
    CATEGORY_LARGE_STRAIGHT("grand ligne droite"),
    CATEGORY_FULLHOUSE("full house");
    
    public String type;
    
    StrategyScoreType(String type){
        this.type = type;
    }

    public static StrategyScoreType of(String type){
        return Arrays.stream(StrategyScoreType.values()).filter(c -> c.type.equals(type)).findFirst().get();
    }

}

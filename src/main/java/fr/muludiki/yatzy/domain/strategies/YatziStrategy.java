package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

/**
 * Si tous les dés ont le même numéro, le joueur marque 50 points. Par exemple:
 *
 * <li>1,1,1,1,1 placé sur des scores « yatzy » 50</li>
 * <li>1,1,1,2,1 placé sur des scores « yatzy » 0</li>
 */
class YatziStrategy implements ScoreStrategy {

    public static final int YATZI_STRATEGY_SCORE = 50;
    public static final int YATZI_STRATEGY_NO_SCORE = 0;

    public int compute(PlayerSet playerSet) {
        if( playerSet.getDiceValues().stream().distinct().count() == 1 ){
            return YATZI_STRATEGY_SCORE;
        }else{
            return YATZI_STRATEGY_NO_SCORE;
        }
    }
}

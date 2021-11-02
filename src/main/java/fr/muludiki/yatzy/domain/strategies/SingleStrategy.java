package fr.muludiki.yatzy.domain.strategies;

import fr.muludiki.yatzy.domain.PlayerSet;

/**
 * Le joueur marque la somme des dés qui indique un. Par exemple:
 *
 * <li>1,1,2,4,4 placé à un notes 2 (1+1)</li>
 * <li>3,3,3,4,5 placé sur un scores 0</li>
 */
class SingleStrategy implements ScoreStrategy {

    private int value = 0;

    public SingleStrategy(int value){
        this.value = value;
    }

    @Override
    public int compute(PlayerSet playerSet) {
        return playerSet.getSet().stream().filter(integer -> integer == value)
                .reduce(0, ((a, b) -> a + b));
    }

    static class OnesStrategy extends SingleStrategy{
        public OnesStrategy() {
            super(1);
        }
    }

    static class TwosStrategy extends SingleStrategy{
        public TwosStrategy() {
            super(2);
        }
    }

    static class ThreesStrategy extends SingleStrategy{
        public ThreesStrategy() {
            super(3);
        }
    }

    static class FoursStrategy extends SingleStrategy{
        public FoursStrategy() {
            super(4);
        }
    }

    static class FivesStrategy extends SingleStrategy{
        public FivesStrategy() {
            super(5);
        }
    }

    static class SixStrategy extends SingleStrategy{
        public SixStrategy() {
            super(6);
        }
    }

}

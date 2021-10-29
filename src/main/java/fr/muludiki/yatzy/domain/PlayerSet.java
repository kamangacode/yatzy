package fr.muludiki.yatzy.domain;

/**
 * Permet de stocker les faces de dès jouées par un joueur
 */
public class PlayerSet {

    /**
     * Face du dès 1
     */
    private final int des1;

    /**
     * Face du dès 2
     */
    private final int des2;

    /**
     * Face du dès 3
     */
    private final int des3;

    /**
     * Face du dès 4
     */
    private final int des4;

    /**
     * Face du dès 5
     */
    private final int des5;

    public PlayerSet(int des1, int des2, int des3, int des4, int des5){
        this.des1 = des1;
        this.des2 = des2;
        this.des3 = des3;
        this.des4 = des4;
        this.des5 = des5;
    }

    public int getDes1() {
        return des1;
    }

    public int getDes2() {
        return des2;
    }

    public int getDes3() {
        return des3;
    }

    public int getDes4() {
        return des4;
    }

    public int getDes5() {
        return des5;
    }



}

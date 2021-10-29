package fr.muludiki.yatzy.domain;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Permet de stocker les faces de dès jouées par un joueur
 */
public class PlayerSet {

    private final List<Integer> set = new ArrayList<>();

    public PlayerSet(@Valid()  int des1, int des2, int des3, int des4, int des5){
        set.add(canAddDes(des1));
        set.add(canAddDes(des2));
        set.add(canAddDes(des3));
        set.add(canAddDes(des4));
        set.add(canAddDes(des5));
    }

    private int canAddDes(int des) {
        if(0 < des && des <= 6){
            return des;
        }else{
            throw new IllegalArgumentException("The number for the dice must be greater than 0 and less than 7");
        }
    }

    public List<Integer> getSet() {
        return set;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import javax.swing.*;

/**
 *
 * @author Bryan
 */
public class ExpBar {

    //------------ Variables ------------
    private int level = 1;          //indicates the level of the exp bar, all of then start at level 1
    private int levelLimit;        //each expBar will have a level limit
    private int exp;                //total exp
    private int expLimit = 100;     //exp necessary to level up, 100 expLimit is used
    private String name;

    //------------ Constructors ------------
    public ExpBar(int level, int levelLimit, String name){   //
        this.exp = 0;
        this.levelLimit = levelLimit;
        this.name = name;
        if(level > 1){
            for (int i = 1; i < level; i++){
                addExp(this.expLimit);
                if(level == levelLimit) {
                    JOptionPane.showMessageDialog(null, this.name + " has already reach max level");
                    break;
                };
            }
        }
    }

    //------------ getters ------------
    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getLevelLimit() { return levelLimit; }

    //------------ custom methods ------------
    public boolean addExp(int qtdExp){      //add exp and already checks if it leveled up
        if(level == levelLimit) {
            JOptionPane.showMessageDialog(null, this.name + " has already reach max level");
            return false;
        };

        boolean isLevelingUp = true;
        boolean levelUp = false;
        this.exp += qtdExp;

        while(isLevelingUp) {
            if(this.exp >= expLimit){
                exp -= expLimit;
                calculateExpLimit();
                levelUp = true;
            } else {
                isLevelingUp = false;
            }

        }
        return levelUp;
    }
    
    private void calculateExpLimit() {       //raises the exp necessary to level up between levels
        int incremento = 100 * level;
        this.expLimit += incremento;
        this.level++;
        if(level == levelLimit) JOptionPane.showMessageDialog(null, this.name + " has already reach max level");
    }
    
}

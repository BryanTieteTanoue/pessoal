/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

/**
 *
 * @author Bryan
 */
public interface Character {
    
    public boolean addExp(int qtdExp);  //will add exp to the expBars (level, skills)
    public boolean changeHealth();      //will add/remove HP of the character
    
}

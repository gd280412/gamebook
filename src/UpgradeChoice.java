/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NossoJogo;

import basico.Character;
import basico.Choice;
import basico.Event;

/**
 *
 * @author Familia
 */
public class UpgradeChoice extends Choice{
    public UpgradeChoice(String description, Event event){
        super(description, event);
    }

    @Override
    public String executeChoice(Character character) {
    	Arma arma = new Arma("Espada longa",3,15);
        return arma.usarItem(character);
    }
  
}

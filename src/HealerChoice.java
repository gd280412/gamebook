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
public class HealerChoice extends Choice{
    public HealerChoice(String description, Event event){
        super(description, event);
    }
    @Override
    public String executeChoice(Character character) {
    	PoscaoDeCura cura = new PoscaoDeCura("Frasco misterioso");
        return cura.usarItem(character);
    }
}

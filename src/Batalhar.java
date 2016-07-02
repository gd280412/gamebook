package NossoJogo;
import java.util.Random;

import basico.Character;
import basico.Choice;
import basico.Enemy;
import basico.Event;

public class Batalhar extends Choice {
	public Batalhar(String description, Event event, Enemy enemy, String who) {
        super(description, event);
        
        this.who = who;
        this.enemy = enemy;
        }
	
	@Override
    public String executeChoice(Character character) {
		Random random = new Random();
		Enemy inimigo = new Enemy(enemy.getLife()+random.nextInt(enemy.getLife()+1),enemy.getAttack()+random.nextInt(enemy.getAttack()+1));
		String batalha = "Você encontrou um " + who + ". Se prepare para a batalha!\n";
		while(inimigo.isAlive()&&character.isAlive()){
		batalha = batalha + ("Personagem   VS  Monstro\n");
		batalha = batalha + ("HP: "+ character.getLife() +"  |  HP: " + inimigo.getLife()+ "\n");
		batalha = batalha + character.battle(inimigo);
		}
		
		if(!inimigo.isAlive())
			batalha = batalha + ("Você derrotou o inimigo\n");
		
		if(!character.isAlive())
			batalha = batalha + ("Você foi derrotado\n");
		
		return batalha;
    }

    private Enemy enemy;
    private String who;
}
	


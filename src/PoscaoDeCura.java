package NossoJogo;

import java.util.Random;
import basico.Character;
import basico.Player;

public class PoscaoDeCura extends Item {

	public PoscaoDeCura(String nome) {
		super(nome);
	}

	@Override
	public String usarItem(Character character) {
		Player personagem = (Player)character;
		Random valor = new Random();
		int cura = valor.nextInt(20);
		int vida = personagem.getLife() + cura;
		if(vida > personagem.getMaxLife()){
			personagem.setLife(personagem.getMaxLife());
			return ("Você encontrou um "+ this.getNome() +", personagem curado / life +" + (vida-personagem.getMaxLife()) + "\n");
		} else{
			personagem.setLife(vida);
			return ("Você encontrou um "+ this.getNome() +", personagem curado / life +" + cura + "\n");
		}
	}

}

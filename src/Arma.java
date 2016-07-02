package NossoJogo;

import java.util.Random;
import basico.Character;
import basico.Player;

public class Arma extends Item {

	public Arma(String nome,int atq, int crit) {
		super(nome);
		this.atq = atq;
		this.crit = crit;
	}

	@Override
	public String usarItem(Character character) {
		Player personagem = (Player)character;
		Random valor = new Random();
		int adicionalAttack = valor.nextInt(5);
		int adicionalCritical = valor.nextInt(10);
		personagem.setAttack(10 + this.atq + adicionalAttack);
		personagem.setCritical(this.crit + adicionalCritical);
		return ("Você adquiriu uma "+ super.getNome() +" / atq +"+ (this.atq + adicionalAttack) +" crit +"+ (this.crit + adicionalCritical) + "\n");
	}
	
	private int atq;
	private int crit;
	
}

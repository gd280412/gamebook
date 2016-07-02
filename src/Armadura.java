package NossoJogo;

import java.util.Random;

import basico.Character;
import basico.Player;

public class Armadura extends Item {

	public Armadura(String nome, int def, int Mlife) {
		super(nome);
		this.def = def;
		this.Mlife = Mlife;
	}

	@Override
	public String usarItem(Character character) {
		Player personagem = (Player)character;
		Random valor = new Random();
		int adicionalDefense = valor.nextInt(5);
		int adicionalMaxLife = valor.nextInt(10);
		personagem.setDefense(this.def + adicionalDefense);
		personagem.setMaxLife(this.Mlife + adicionalMaxLife);
		personagem.setLife(personagem.getLife() + adicionalMaxLife);
		return ("Você adquiriu uma "+ super.getNome() +" / def +"+ (this.def + adicionalDefense) +" MaxHP +"+ (this.Mlife + adicionalMaxLife) + "\n");
	}
	
	private int def;
	private int Mlife;

}

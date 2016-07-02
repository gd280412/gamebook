package NossoJogo;
import basico.Character;

public abstract class Item {
	public Item(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public abstract String usarItem(Character character);
	
	private String nome;
}

package NossoJogo;
import java.util.Collection;

import basico.Character;
import basico.Choice;
import basico.Event;

public class EncontrandoItem extends Event {

	public EncontrandoItem(String description, Collection<Choice> choices, Item item) {
		super(description, choices);
		this.item = item;
	}

	@Override
	public String applyHistory(Character character) {
		return this.item.usarItem(character);
	}
	
	private Item item;
}

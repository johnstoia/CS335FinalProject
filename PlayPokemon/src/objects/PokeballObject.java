package objects;

import sprites.PokeballSprite;
import sprites.Sprite;

public class PokeballObject extends SpriteObject{
	
	String itemName;
	
	public PokeballObject(int x, int y, String name) {
		super(new PokeballSprite(), x, y, name, 100);
		itemName = name;
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return itemName;
	}

}

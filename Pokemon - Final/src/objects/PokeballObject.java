package objects;

import sprites.PokeballSprite;
import sprites.Sprite;

public class PokeballObject extends SpriteObject{
	
	String itemName;
	
	/**
	 * Description: 
	 *
	 * Mapping a new sprite and placing 
	 * a pokeballObject in the XY coordinate 
	 * 
	 * @param x coordinate 
	 * @param y coordinate 
	 * @param name of pokemon
	 * @author Ryan Ressler, Abdul Hammed	 
	 */
	
	public PokeballObject(int x, int y, String name) {
		super(new PokeballSprite(), x, y, name, 100);
		itemName = name;
	}
	
	/**
	 * Description: 
	 *
	 * Returning the name of the object
	 * 
	 *
	 * @return itemName name of the item
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public String getName() {
		return itemName;
	}

}

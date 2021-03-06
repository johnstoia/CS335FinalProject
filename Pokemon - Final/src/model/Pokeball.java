package model;

public abstract class Pokeball extends Item {
	private String itemName;
	private int quantity;
	
	/**
	 * Description: 
	 *
	 * Pokeball Constructor
	 * 
	 * @param itemName of item 
	 * @param quantity of items 
	 *
	 * @author Christopher Leon
	 */
	public Pokeball(String itemName, int quantity){
		super(itemName, quantity);
	}
	
	/**
	 * Description: 
	 *
	 * useItem, method to use an item
	 * 
	 * 
	 * @return String 
	 * @author Christopher Leon
	 */
	public String useItem(){
		if( this.getQuantity() == 0){
			return "You do not have any " +this.itemName + " left!";
		}
		else{
			quantity--;
			//try to catch pokemon
			//if success add pokemon to collection
			return "You caught the Pokemon!";
			//else
			//return "The Pokemon escaped!";
		}
	}
	
	/**
	 * Description: 
	 *
	 * getQuantity, method to find out how many of an item the player has
	 * 
	 *
	 * @return int item list 
	 * @author Christopher Leon
	 */
	public int getQuantity(){
		return quantity;
		}
}

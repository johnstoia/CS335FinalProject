package model;

public abstract class Item {
	
	private String itemName;
	private int quantity;
	
	/**
	 * Description: 
	 *
	 * Item Constructor
	 * 
	 * @param itemName 
	 * @param quantity of items 
	 * 
	 * @author Christopher Leon
	 */
	public Item( String itemName, int quantity){
		this.itemName = itemName;
		this.quantity = quantity;
	}
	
	/**
	 * Description: 
	 *
	 * useItem, method to use an item
	 * 
	 * 
	 * @return number of items 
	 * @author Christopher Leon
	 */
	public String useItem(){
		if( this.getQuantity() == 0){
			return "You do not have any " +this.itemName + " left!";
		}
		else{
			quantity--;
			return "You used " +this.itemName +".";
		}
	}
	
	/**
	 * Description: 
	 *
	 * getQuantity, method to find out how many of an item the player has
	 * 
	 * 
	 * @return quantity 
	 * @author Christopher Leon
	 */
	public int getQuantity(){
		return this.quantity;
	}
	
	/**
	 * Description: 
	 *
	 * addItem
	 * 
	 * 
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public void addItem(){
		quantity++;
	}
	
	/**
	 * Description: 
	 *
	 * gets the item name 
	 * 
	 * 
	 * @return item name 
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public String getItemName(){
		return itemName;
	}
}

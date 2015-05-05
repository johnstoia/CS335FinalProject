package model;

public abstract class Item {
	
	private String itemName;
	private int quantity;
	
	/**
	 * Description: 
	 *
	 * Item Constructor
	 * 
	 * @param String itemName, int quantity
	 * @return
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
	 * @param 
	 * @return String
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
	 * @param 
	 * @return int
	 * @author Christopher Leon
	 */
	public int getQuantity(){
		return this.quantity;
	}
	
	public void addItem(){
		quantity++;
	}
	
	public String getItemName(){
		return itemName;
	}
}

package model;

public class SafariBall extends Pokeball {
	private String itemName;
	private int quantity;
	private double catchRate;
	
	/**
	 * Description: 
	 *
	 * SafariBall Constructor
	 * 
	 * @param itemName name of item 
	 * @param quantity the amount 
	 * @author Christopher Leon
	 */
	public SafariBall( String itemName, int quantity){
		super(itemName, quantity);
		this.quantity = quantity;
	}
	
	/**
	 * Description: 
	 *
	 * useItem, method to use an item
	 * 
	 * 
	 * @return items left string 
	 * @author Christopher Leon, John Stoia
	 */
	public String useItem(){
		if( this.getQuantity() == 0){
			return "You do not have any " +this.itemName + "s left!";
		}
		else{
			quantity--;
			return "You Threw a Safari Ball!";
		}
	}
	
	/**
	 * Description: 
	 *
	 * getQuantity, method to find out how many of an item the player has
	 * 
	 * 
	 * @return how many items  
	 * @author Christopher Leon, John Stoia
	 */
	public int getQuantity(){
		return quantity;
		}
}

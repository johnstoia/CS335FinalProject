

public class RunningShoes extends Item{
	private String itemName;
	private int quantity;
	
	/**
	 * Description: 
	 *
	 * RunningShoes Constructor
	 * 
	 * @param String itemName, int quantity
	 * @return
	 * @author Christopher Leon
	 */
	public RunningShoes( String itemName, int quantity){
		super(itemName, quantity);
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
			return "You do not have any " +this.itemName + "!";
		}
		else{
			quantity--;
			return "500 additional steps when added to your Safari adventure!";
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
		return quantity;
		}
	
	/**
	 * Description: 
	 *
	 * Add's 1 item to inventory
	 * 
	 * @param 
	 * @return 
	 * @author John Stoia
	 */
	public void addItem(){
		quantity++;
	}
}

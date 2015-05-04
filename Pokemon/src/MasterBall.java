

public class MasterBall extends Pokeball {
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
	public MasterBall( String itemName, int quantity){
		super(itemName, quantity);
	}
	
	/**
	 * Description: 
	 *
	 * useItem, method to use an item
	 * 
	 * @param 
	 * @return String
	 * @author Christopher Leon & John Stoia
	 */
	public String useItem(){
		if( this.getQuantity() == 0){
			return "You do not have any " +this.itemName + "s left!";
		}
		else{
			quantity--;
			return "You threw a "+this.itemName+"!";
		}
	}
	
	/**
	 * Description: 
	 *
	 * getQuantity, method to find out how many of an item the player has
	 * 
	 * @param 
	 * @return int
	 * @author Christopher Leon & John Stoia
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

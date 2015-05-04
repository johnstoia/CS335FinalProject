
public class Bait extends Item{
	private String itemName;
	private int quantity;
	
	/**
	 * Description: 
	 *
	 * Bait Constructor
	 * 
	 * @param String itemName, int quantity
	 * @return
	 * @author Christopher Leon
	 */
	public Bait( String itemName, int quantity){
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
			return "You do not have any " +this.itemName + " left!";
		}
		else{
			quantity--;
			//call method in pokemon class to affect catch rate/run rate
			return "You toss some bait.";
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
		return super.getQuantity();
		}
}

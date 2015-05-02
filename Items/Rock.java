
public class Rock extends Item{
	private String itemName;
	private int quantity;
	
	/**
	 * Description: 
	 *
	 * Rock Constructor
	 * 
	 * @param String itemName, int quantity
	 * @return
	 * @author Christopher Leon
	 */
	public Rock( String itemName, int quantity){
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
			//change the Pokemon's likelyToRun, catchRate 
			return "You threw a rock.";
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

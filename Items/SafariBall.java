
public class SafariBall extends Pokeball {
	private String itemName;
	private int quantity;
	private double catchRate;
	
	/**
	 * Description: 
	 *
	 * SafariBall Constructor
	 * 
	 * @param String itemName, int quantity
	 * @return
	 * @author Christopher Leon
	 */
	public SafariBall( String itemName, int quantity, double catchRate){
		super(itemName, quantity, catchRate);
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
	 * @param 
	 * @return int
	 * @author Christopher Leon
	 */
	public int getQuantity(){
		return super.getQuantity();
		}
}
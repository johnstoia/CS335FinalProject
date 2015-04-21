import java.lang.Math;

public abstract class Pokemon {
	
	private String name;
	private int rarity;
	private int likelyToRun;
	private int likelyToCatch;
	
	/**
	 * Description: 
	 *
	 * Pokemon Constructor
	 * 
	 * @param String name, Int rarity, Int toRun, Int toCatch
	 * @return
	 * @author John Stoia
	 */
	public Pokemon(String name, int rarity, int toRun, int toCatch){
		this.name = name;
		this.rarity = rarity;
		this.likelyToRun = toRun;
		this.likelyToCatch = toCatch;
		
	}
	
	/**
	 * Description: 
	 *
	 * Getter for name
	 * 
	 * @param
	 * @return
	 * @author John Stoia
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Description: 
	 *
	 * Getter for rarity
	 * 
	 * @param
	 * @return
	 * @author John Stoia
	 */
	public int getRarity(){
		return rarity;
	}
	
	/**
	 * Description: 
	 *
	 * Getter for likelyToRun
	 * 
	 * @param
	 * @return
	 * @author John Stoia
	 */
	public int getRun(){
		return likelyToRun;
	}
	
	/**
	 * Description: 
	 *
	 * Getter for likelyToCatch
	 * 
	 * @param
	 * @return
	 * @author John Stoia
	 */
	public int getCatch(){
		return likelyToCatch;
	}
	
	/**
	 * Description: 
	 *
	 * Increases the likeliness of the pokemon running
	 * 
	 * @param
	 * @return
	 * @author John Stoia
	 */
	public void upRun(){
		
	}
	
	/**
	 * Description: 
	 *
	 * Decreases the likeliness of the pokemon running
	 * 
	 * @param
	 * @return
	 * @author John Stoia
	 */
	
	public void downRun(){
		
	}
	
	/**
	 * Description: 
	 *
	 * Increases the likeliness of the pokemon being caught
	 * 
	 * @param
	 * @return
	 * @author John Stoia
	 */
	public void upCatch(){
		
	}
	
	/**
	 * Description: 
	 *
	 * Decreases the likeliness of the pokemon being caught
	 * 
	 * @param
	 * @return
	 * @author John Stoia
	 */
	public void downCatch(){
		
	}
	
	/**
	 * Description: 
	 *
	 * Checks to see if the pokemon will be caught using percentage and RNG
	 * 
	 * @param
	 * @return boolean
	 * @author John Stoia
	 */
	
	public boolean catches(){
		return false;
	}
	
	/**
	 * Description: 
	 *
	 * Checks to see if the pokemon will run using percentage and RNG
	 * 
	 * @param
	 * @return boolean
	 * @author John Stoia
	 */
	public boolean runs(){
		return false;
	}
}

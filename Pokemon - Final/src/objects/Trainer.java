package objects;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.JComponent;
import javax.swing.Timer;

import model.*;
import sprites.TrainerSprite;


public class Trainer extends SpriteObject{	
	private SleepingDart dart;
	private RunningShoes shoes;
	private Pokeball master;
	private Pokeball safari;
	private String name;
	private ArrayList<Pokemon> caughtList;
	private String[] itemList;
	
	/**
	 * Description: 
	 *
	 * Trainer Constructor:
	 * Creates a new Trainer with 30 SafariBalls and a name. Also sets up TrainerSprite in the map
	 * 
	 * @param x
	 * @param y
	 * @param name
	 * 
	 * @author John Stoia, Ryan Ressler
	 */
	
	public Trainer(int x, int y, String name){
		super(new TrainerSprite(), x, y, name, 100);
		dart = new SleepingDart("Sleeping Dart",0);
		shoes = new RunningShoes("Running Shoes",0);
		master = new MasterBall("Master Ball", 0);
		safari = new SafariBall("Safari Ball", 30);
		this.name = name;
		caughtList = new ArrayList<Pokemon>();
		itemList = new String[3];
		setItemList(itemList);
	}
	
	
	/**
	 * Description: 
	 *
	 * Getter for global variable dart
	 * 
	 * @return SleepingDart dart
	 * @author John Stoia
	 */
	public SleepingDart getDart() {
		return dart;
	}
	
	/**
	 * Description: 
	 *
	 * Getter for global variable shoes
	 * 
	 * 
	 * @return RunningShoes shoes
	 * @author John Stoia
	 */
	public RunningShoes getShoes() {
		return shoes;
	}

	/**
	 * Description: 
	 *
	 * Getter for global variable master
	 * 
	 * 
	 * @return MasterBall master
	 * @author John Stoia
	 */
	public Pokeball getMaster() {
		return master;
	}

	/**
	 * Description: 
	 *
	 * Getter for global variable safari
	 * 
	 * 
	 * @return SafariBall safari
	 * @author John Stoia
	 */
	public Pokeball getSafari() {
		return safari;
	}
	
	/**
	 * Description: 
	 *
	 * Getter for global variable name
	 * 
	 * 
	 * @return String name
	 * @author John Stoia
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Description: 
	 *
	 * Adds a pokemon caught in battle to an ArrayList of all caught pokemon. 
	 * This list is used to calculate score and check win conditions
	 * 
	 * @param pokemon
	 * 
	 * @author John Stoia
	 */
	public void caughtPokemon(Pokemon pokemon) {
		caughtList.add(pokemon);
		
	}
	
	/**
	 * Description: 
	 *
	 * sets the list of the items you have 
	 * 
	 * @param items 
	 * 
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public void setItemList(String[] items) {
		itemList[2] = "Master Ball: " + getDart().getQuantity();
		itemList[1] = "Running Shoes: " + getShoes().getQuantity();
		itemList[0] = "Sleeping Darts: " + getDart().getQuantity();
	}
	
	/**
	 * Description: 
	 *
	 * gets the list you have 
	 * 
	 * 
	 * @return itemList
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public String[] getItemList() {
		return itemList;
	}
	
	/**
	 * Description: 
	 *
	 * gets the caught list of pokemon 
	 * 
	 * 
	 * @return caughtlist
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public ArrayList<Pokemon> getCaughtList(){
		return caughtList;
	}
	
	/**
	 * Description: 
	 *
	 * gets the pokemon list of caught 
	 * 
	 *
	 * @return toPrint
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public ArrayList<String> getPokemonList(){
		ArrayList<String> toPrint = new ArrayList<String>();
		for(int i = 0; i < caughtList.size(); i++){
			toPrint.add(caughtList.get(i).getName());
		}
		return toPrint;
	}
}

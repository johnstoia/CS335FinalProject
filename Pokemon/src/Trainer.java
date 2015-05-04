import java.util.ArrayList;

public class Trainer {
	private SleepingDart dart;
	private RunningShoes shoes;
	private Pokeball master;
	private Pokeball safari;
	private String name;
	private ArrayList<Pokemon> caughtList;
	
	/**
	 * Description: 
	 *
	 * Trainer Constructor:
	 * Creates a new named Trainer with 30 SafariBalls and no other items
	 * 
	 * @param String name
	 * @return
	 * @author John Stoia
	 */
	
	public Trainer(String name){
		dart = new SleepingDart("Sleeping Dart",0);
		shoes = new RunningShoes("Running Shoes",0);
		master = new MasterBall("Master Ball", 0);
		safari = new SafariBall("Safari Ball", 30);
		this.name = name;
	}
	
	/**
	 * Description: 
	 *
	 * Getter for global variable dart
	 * 
	 * @param
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
	 * @param
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
	 * @param
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
	 * @param
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
	 * @param
	 * @return String name
	 * @author John Stoia
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Description: 
	 *
	 * Adds a pokemon caugt in battle to an ArrayList of all caught pokemon. This list is used to calculate score and check win conditions
	 * 
	 * @param Pokemon pokemon
	 * @return
	 * @author John Stoia
	 */
	public void caughtPokemon(Pokemon pokemon) {
		caughtList.add(pokemon);
		
	}


	
	
}

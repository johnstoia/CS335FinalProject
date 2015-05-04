import java.util.Random;

public class PokeBattle {
	private Trainer trainer;
	private Pokemon pokemon;
	private String textString;
	private boolean endBattle = false;
	private boolean isAsleep = false;
	private int sleepTurns;
	private int sleepTurnCounter = 0;
	
	/**
	 * Description: 
	 *
	 * Sets the trainer and pokemon and generates a random number of turns a pokemon will sleep if hit by a sleepdart
	 * 
	 * @param Trainer trainer, Pokemon pokemon
	 * @return
	 * @author John Stoia
	 */
	
	public PokeBattle(Trainer trainer, Pokemon pokemon){
		this.trainer = trainer;
		this.pokemon = pokemon;
		
		Random r = new Random();
		int low = 1;
		int high = 4;
		int randomNumber = r.nextInt(high-low) + low;
		
		this.sleepTurns = randomNumber;
	}
	
	/**
	 * Description: 
	 *
	 * Switches turns between the trainer and the pokemon
	 * 
	 * @param
	 * @return
	 * @author John Stoia
	 */
	private void switchTurns() {
		checkRun();
	}
	
	/**
	 * Description: 
	 *
	 * Checks if the pokemon runs away. If the pokemon is asleep it skips the check and if the pokemon wakes up from sleep
	 * it instantly runs away.
	 * 
	 * @param
	 * @return
	 * @author John Stoia
	 */
	public void checkRun(){
		
		if(sleepTurnCounter == sleepTurns){
			isAsleep = false;
			textString = pokemon.getName()+" woke up and ran away!";
			endBattle = true;
		}
		
		if(isAsleep == false){
			if(pokemon.runs() == true){
				textString = pokemon.getName()+" ran away!";
				endBattle = true;
			}
		}else{
			textString = pokemon.getName()+" is asleep";
			sleepTurnCounter++;
		}
	}
	
	/**
	 * Description: 
	 *
	 * Throws a rock at the pokemon. Upping the ability to catch but also the likeliness to run
	 * 
	 * @param
	 * @return
	 * @author John Stoia
	 */
	public void throwRock(){
		pokemon.upCatch();
		pokemon.upRun();
		textString = trainer.getName()+" Threw A Rock!";
		switchTurns();
	}
	
	/**
	 * Description: 
	 *
	 * Throws bait at the pokemon. Lowering the ability to catch but also the likeliness to run
	 * 
	 * @param
	 * @return
	 * @author John Stoia
	 */
	public void throwBait(){
		pokemon.downCatch();
		pokemon.downRun();
		textString = trainer.getName()+" Threw Bait!";
		switchTurns();
	}
	
	/**
	 * Description: 
	 *
	 * Throws a SafariBall at the pokemon and checks if it was caught or breaks free. If caught it ends the battle and adds to the list of caught pokemon.
	 * 
	 * @param
	 * @return
	 * @author John Stoia
	 */
	public void throwSafariBall(){
		if(pokemon.catches() == true){
			textString = pokemon.getName()+" was caught!";
			trainer.caughtPokemon(pokemon);
			endBattle = true;
		}else{
			textString = pokemon.getName()+" broke free!";
			switchTurns();
		}
	}

	/**
	 * Description: 
	 *
	 * Shoots a sleeping dart at the pokemon, putting it to sleep. This increases the likeliness of it being caught and does not allow it to run away for a certain number of
	 * turns. However, when the pokemon wakes up it will instantly run.
	 * 
	 * @param
	 * @return
	 * @author John Stoia
	 */
	public void useSleepDart(){
		if(trainer.getDart().getQuantity() == 0){
			textString = "You don't have anymore of those!";
		}else{
			textString = trainer.getDart().useItem();
			pokemon.setCatch(1);
			isAsleep = true;
			switchTurns();
		}
	}
	
	/**
	 * Description: 
	 *
	 * Throws a MasterBall at the pokemon, instantly catching it.
	 * 
	 * @param
	 * @return
	 * @author John Stoia
	 */
	public void useMasterBall(){
		if(trainer.getMaster().getQuantity() == 0){
			textString = "You don't have anymore of those!";
		}else{
			textString = trainer.getMaster().useItem()+" and caught "+pokemon.getName()+"!";
			pokemon.setCatch(2);
		}
		
		if(pokemon.catches() == true){
			trainer.caughtPokemon(pokemon);
			endBattle = true;
		}
	}
}

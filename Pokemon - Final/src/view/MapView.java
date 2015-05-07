package view;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;

import objects.Trainer;
import maps.Map;
import maps.Map1;
import maps.Map2;
import model.GeneratePokeBattle;
import model.Pokemon;

public class MapView extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private Map map;
	private int [][] mapView;
	private int [][] tempMap;
	private int positionY = 0;
	private int positionX = 0;
	private GeneratePokeBattle pokemonEncounter;
	private Pokemon pokemon;
	private Trainer trainer;
	private boolean encounter;
	private Random num;
	private int encounterRate;
	private int stepCounter;
	private boolean state;
	private int winChoice;
	
	/**
	 * Description: 
	 *
	 * MapView constructor  
	 * 
	 * @param mapType which map
	 * @param trainer name 
	 * @param winChoice
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public MapView(int mapType, Trainer trainer, int winChoice) {
		stepCounter = 500;
		this.encounter = false;
		this.state = true;
		this.trainer = trainer;
		pokemonEncounter = new GeneratePokeBattle(trainer);
		if(mapType == 1)
			map = new Map2();
		else
			map = new Map1();
		this.winChoice = winChoice;
			
		tempMap = map.getMap();
		mapView = new int[11][11];
		for(int i = 0; i < mapView.length; i++){
			for(int j = 0; j < mapView[i].length; j++) {
				mapView[i][j] = tempMap[i][j];
			}
		}
		
		pokemon = generateRandomPokemon();
		
	}
	
	public void draw(Graphics g) {
		map.draw(g, mapView);
	}
	
	/**
	 * Description: 
	 *
	 * Trainer may moveDown 
	 * 
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public void moveDown(){
		if(positionY < tempMap[positionX].length - mapView.length){
			positionY++;
			stepCounter--;
			mapView[5][5] = tempMap[positionX+5][positionY+5];
			if(mapView[5][5] == 1){
				positionY--;
				stepCounter++;
			}
			if(mapView[5][5] == 4){
				addItem(positionX+5, positionY+5);
				tempMap[positionX+5][positionY+5] = -1;
			}
			if(mapView[5][5] == 0){
				num = new Random();
				encounterRate = num.nextInt(100);
				if(encounterRate <= 7) {
					generateRandomPokemon();
//					pokemonEncounter.generatePokemon();
					setEncounter(true);
				}
				else {setEncounter(false);}
			}
			for(int i = 0; i < mapView.length; i++){
				for(int j = 0; j < mapView[i].length; j++) {
					mapView[i][j] = tempMap[i + positionX][j + positionY];
				}
			}
		}
		
	}
	
	/**
	 * Description: 
	 *
	 *  Trainer may move up 
	 * 
	 * @author Ryan Ressler , Abdul Hammed 	 
	 */
	
	public void moveUp(){
		if(positionY > 0){
			positionY--;
			stepCounter--;
			mapView[5][5] = tempMap[positionX+5][positionY+5];
			if(mapView[5][5] == 1){
				positionY++;
				stepCounter++;
			}
			if(mapView[5][5] == 4){
				addItem(positionX+5, positionY+5);
				tempMap[positionX+5][positionY+5] = -1;
			}
			if(mapView[5][5] == 0){
				num = new Random();
				encounterRate = num.nextInt(100);
				if(encounterRate <= 7) {
					generateRandomPokemon();
					setEncounter(true);
				}
				else {setEncounter(false);}
			}
			for(int i = 0; i < mapView.length; i++){
				for(int j = 0; j < mapView[i].length; j++) {
					mapView[i][j] = tempMap[i + positionX][j + positionY];
				}
			}
		}
	}
	
	/**
	 * Description: 
	 *
	 * Trainer may moveLeft 
	 * 
	 * @author Ryan Ressler 	 
	 */
	
	public void moveLeft(){
		if(positionX > 0){
			positionX--;
			stepCounter--;
			mapView[5][5] = tempMap[positionX+5][positionY+5];
			if(mapView[5][5] == 1){
				positionX++;
				stepCounter++;
			}
			if(mapView[5][5] == 4){
				addItem(positionX+5, positionY+5);
				tempMap[positionX+5][positionY+5] = -1;
			}
			if(mapView[5][5] == 0){
				num = new Random();
				encounterRate = num.nextInt(100);
				if(encounterRate <= 7) {
					generateRandomPokemon();
//					pokemonEncounter.generatePokemon();
					setEncounter(true);
				}
				else {setEncounter(false);}
			}
			for(int i = 0; i < mapView.length; i++){
				for(int j = 0; j < mapView[i].length; j++) {
					mapView[i][j] = tempMap[i + positionX][j + positionY];
				}
			}
		}
	}
	
	/**
	 * Description: 
	 *
	 * Trainer may moveRight 
	 *  
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public void moveRight(){
		if(positionX < tempMap.length - mapView.length){
			positionX++;
			stepCounter--;
			mapView[5][5] = tempMap[positionX+5][positionY+5];
			if(mapView[5][5] == 1){
				positionX--;
				stepCounter++;
			}
			if(mapView[5][5] == 4){
				addItem(positionX+5, positionY+5);
				tempMap[positionX+5][positionY+5] = -1;
			}
			if(mapView[5][5] == 0){
				num = new Random();
				encounterRate = num.nextInt(100);
				if(encounterRate <= 7) {
					generateRandomPokemon();
//					pokemonEncounter.generatePokemon();
					setEncounter(true);
				}
				else {setEncounter(false);}
			}
			for(int i = 0; i < mapView.length; i++){
				for(int j = 0; j < mapView[i].length; j++) {
					mapView[i][j] = tempMap[i + positionX][j + positionY];
				}
			}
		}
	}
	
	/**
	 * Description: 
	 *
	 * Checking if Trainer encountered anything  
	 * 
	 * @param encounter did it encounter 
	 * @author Ryan Ressler 	 
	 */
	
	public void setEncounter(boolean encounter) {
		this.encounter = encounter;
	}
	
	public boolean getEncounter() {
		return encounter;
	}
	
	public void addItem(int x, int y) {
		String item = map.getItem(x, y);
		try {
	        Robot robot = new Robot();

	        // Simulate a key press
	        robot.keyPress(KeyEvent.VK_A);
	        robot.keyRelease(KeyEvent.VK_A);

		} catch (AWTException g) {
			g.printStackTrace();
		}
		if(item.equals("Sleeping Dart"))
			trainer.getDart().addItem();
		else if(item.equals("Running Shoes"))
			trainer.getShoes().addItem();
		else if(item.equals("Master Ball"))
			trainer.getMaster().addItem();
		else
			throw new RuntimeException("Item does not exist.");
	}
	/**
	 * Description: 
	 *
	 * adds to the step counter 
	 * 
	 * @param steps
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public void addSteps(int steps) {
		stepCounter += steps;
	}
	
	/**
	 * Description: 
	 *
	 * gets the step counter
	 * 
	 * @return stepCounter how many steps 
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public int getSteps() {
		return stepCounter;
	}
	
	/**
	 * Description: 
	 *
	 * sets the state of the sprite 
	 * 
	 * @param state whats the sate 
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public void setState(boolean state) {
		this.state = state;
	}
	/**
	 * Description: 
	 *
	 * gets the state 
	 * 
	 * @return state 
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public boolean getState() {
		return state;
	}
	
	/**
	 * Description: 
	 *
	 * gets the pokemon 
	 * 
	 * @return pokemon the pokemon 
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public Pokemon getPokemon() {
		return pokemon;
	}
	
	/**
	 * Description: 
	 *
	 * generates random pokemons 
	 * 
	 * @return get the Pokemon 
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public Pokemon generateRandomPokemon(){
		GeneratePokeBattle temp = new GeneratePokeBattle(trainer);
		pokemon = temp.getPokemon();
		return temp.getPokemon();
	}
	/**
	 * Description: 
	 *
	 * gets the trainer 
	 * 
	 * @return trainer the trainer 
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public Trainer getTrainer(){
		return trainer;
	}
	
	/**
	 * Description: 
	 *
	 * gets the win choice the user 
	 * picker
	 * 
	 * @return winChoice type of gaame 
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public int getWinChoice(){
		return winChoice;
	}
}

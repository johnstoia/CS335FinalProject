package view;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import objects.Trainer;
import maps.Map;
import maps.Map1;
import maps.Map2;
import model.GeneratePokeBattle;

public class MapView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map map;
	private int [][] mapView;
	private int [][] tempMap;
	private int positionY = 0;
	private int positionX = 0;
	private GeneratePokeBattle pokemonEncounter;
	private Trainer trainer;
	private boolean encounter;
	private Random num;
	private int encounterRate;
	private int stepCounter;
	
	public MapView(int mapType, Trainer trainer) {
		stepCounter = 500;
		this.encounter = false;
		this.trainer = trainer;
		pokemonEncounter = new GeneratePokeBattle(trainer);
		if(mapType == 1)
			map = new Map2();
		else
			map = new Map1();
		tempMap = map.getMap();
		mapView = new int[11][11];
		for(int i = 0; i < mapView.length; i++){
			for(int j = 0; j < mapView[i].length; j++) {
				mapView[i][j] = tempMap[i][j];
			}
		}
		
	}
	
	public void draw(Graphics g) {
		map.draw(g, mapView);
	}
	
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
					pokemonEncounter.generatePokemon();
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
					pokemonEncounter.generatePokemon();
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
					pokemonEncounter.generatePokemon();
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
					pokemonEncounter.generatePokemon();
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
	
	public void setEncounter(boolean encounter) {
		this.encounter = encounter;
	}
	
	public boolean getEncounter() {
		return encounter;
	}
	
	public void addItem(int x, int y) {
		String item = map.getItem(x, y);
		
		if(item.equals("Sleeping Dart"))
			trainer.getDart().addItem();
		else if(item.equals("Running Shoes"))
			trainer.getShoes().addItem();
		else if(item.equals("Master Ball"))
			trainer.getMaster().addItem();
		else
			throw new RuntimeException("Item does not exist.");
	}
	
	public void addSteps(int steps) {
		stepCounter += steps;
	}
	
	public int getSteps() {
		return stepCounter;
	}
}

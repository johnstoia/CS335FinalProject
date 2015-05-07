package model;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Pokemon {
	
	private String name;
	private int rarity;
	private int likelyToRun;
	private int likelyToCatch;
	private BufferedImage image;
	
	/**
	 * Description: 
	 *
	 * Pokemon Constructor. Pass in a name and a rarity and the rest is calculated
	 * 
	 * @param name of poke 
	 * @param rarity of poke 
	 * @author John Stoia
	 */
	public Pokemon(String name, int rarity){
		this.name = name;
		this.rarity = rarity;
		if(this.image == null){
			try{
				this.image = ImageIO.read(new File("images/"+name+".png"));
			}catch(Exception e) {
				System.out.println("No Picture Found!");
			};
		
		this.likelyToRun = 30;
		this.likelyToCatch = 30;
		
	}

		
		
	}
	
	/**
	 * Description: 
	 *
	 * Getter for name
	 * 
	 * @return name of poke
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
	 * @return rarity of pokemon 
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
	 * @return likelyToRun how likely to run
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
	 * @return likelyToCatch how likely to run
	 * @author John Stoia
	 */
	public int getCatch(){
		return likelyToCatch;
	}
	
	public Image getImage(){
		return image;
	}
	
	/**
	 * Description: 
	 *
	 * Increases the likeliness of the pokemon running
	 * 
	 * 
	 * @author John Stoia
	 */
	public void upRun(){
			likelyToRun += 10;
	}
	
	/**
	 * Description: 
	 *
	 * Decreases the likeliness of the pokemon running
	 * 
	 * 
	 * @author John Stoia
	 */
	
	public void downRun(){
		likelyToRun -= 10;
		
	}
	
	/**
	 * Description: 
	 *
	 * Increases the likeliness of the pokemon being caught
	 * 
	 * @author John Stoia
	 */
	public void upCatch(){
		likelyToCatch += 10;
	}
	
	/**
	 * Description: 
	 *
	 * Decreases the likeliness of the pokemon being caught
	 * 
	 *
	 * @author John Stoia
	 */
	public void downCatch(){
		likelyToCatch -= 10;
	}
	
	/**
	 * Description: 
	 *
	 * Used by items such as SleepDart and MasterBall to modify the catchRate
	 * @param choice
	 *  
	 * @author John Stoia
	 */
	
	public void setCatch(int choice){
		Random r = new Random();
		int low = 20;
		int high = 40;
		int randomNumber = r.nextInt(high-low) + low;
		
		if(choice == 1){
			likelyToCatch += randomNumber; 
		}
		
		if(choice == 2){
			likelyToCatch = 100;
		}
	}
	
	/**
	 * Description: 
	 *
	 * Used to set the likeliness of running to 100% due to the Pokemon waking up from sleep dart
	 * 
	 * 
	 * @author John Stoia
	 */
	public void setRun(){
		likelyToRun = 100;
		
	}
	/**
	 * Description: 
	 *
	 * Checks to see if the pokemon will be caught using percentage and RNG
	 * 
	 *
	 * @return boolean  t or f 
	 * @author John Stoia
	 */
	
	public boolean catches(){
		Random r = new Random();
		int low = 1;
		int high = 101;
		int randomNumber = r.nextInt(high-low) + low;
		if(randomNumber <= likelyToCatch){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Description: 
	 *
	 * Checks to see if the pokemon will run using percentage and RNG
	 * 
	 *
	 * @return boolean t or f 
	 * @author John Stoia
	 */
	public boolean runs(){
		Random r = new Random();
		int low = 1;
		int high = 101;
		int randomNumber = r.nextInt(high-low) + low;
		
		if(randomNumber <= likelyToRun){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Description: 
	 *
	 * sets the liklyness of being caught
	 * 
	 * 
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public void setLikelyToCatch(){
		this.likelyToCatch = 30;
	}
	
	/**
	 * Description: 
	 *
	 * sets the likelyness to run
	 * 
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	
	public void setLikelyToRun(){
		this.likelyToRun = 30;
	}
	
	}
	


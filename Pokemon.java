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
	 * @param String name, Int rarity, Int toRun, Int toCatch
	 * @return
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
		
		if(rarity >= 1 && rarity <= 6) this.likelyToCatch = 40;
		if(rarity > 6 && rarity <= 9) this.likelyToCatch = 30;
		if(rarity == 10) this.likelyToCatch = 20;
		
	}

		
		
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
	
	public Image getImage(){
		return image;
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
			likelyToRun += 10;
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
		likelyToRun -= 10;
		
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
		likelyToCatch += 10;
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
		likelyToCatch -= 10;
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
		Random r = new Random();
		int low = 1;
		int high = 100;
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
	 * @param
	 * @return boolean
	 * @author John Stoia
	 */
	public boolean runs(){
		Random r = new Random();
		int low = 1;
		int high = 100;
		int randomNumber = r.nextInt(high-low) + low;
		
		System.out.println(randomNumber);
		if(randomNumber <= likelyToCatch){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String []args){
	Pokemon gregachu = new Pokemon("gregachu",9);
	Graphics g;
	JPanel panel = new JPanel(){
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(gregachu.getImage(),0,0,300,400,null);
	}};
	
	JFrame x = new JFrame();
	x.setSize(new Dimension(300,450));
	x.add(panel);
	x.setVisible(true);
	
	System.out.println(gregachu.runs());
	}
	}
	


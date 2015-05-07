package tiles;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

public class GrassTile extends Tile{

	private static final int width = 30, height = 31;
	private static BufferedImage tile;
	
	public GrassTile(){
		if (tile == null) // load the sprite sheet into memory
			try{
				tile = ImageIO.read(new File("images/grass.png"));
			}catch(Exception e){};
	}
	
	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return tile;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}
	
	public boolean getPassable(){
		return true;
	}
	
	public void triggerEvent(boolean event){
		Random x = new Random();
		int y = x.nextInt();
		if(y < 10)
			System.out.print("You have encountered a Pokemon!");
	}

}

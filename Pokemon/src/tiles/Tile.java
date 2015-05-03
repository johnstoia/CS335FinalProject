package tiles;

import java.awt.Image;
import java.awt.image.BufferedImage;

public abstract class Tile {

	protected boolean passable;
	
	public Tile(){
		
	}
	
	public abstract Image getImage();
	
	public abstract int getWidth();
	
	public abstract int getHeight();
	
	public void isPassable(boolean pass){
		passable = pass;
	}
	
}

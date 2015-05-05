package tiles;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class PlainTile extends Tile{
	
	private static final int width = 30, height = 30;
	private static BufferedImage tile;
	
	public PlainTile(){
		if (tile == null) // load the sprite sheet into memory
			try{
				tile = ImageIO.read(new File("images/plain.png"));
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

}

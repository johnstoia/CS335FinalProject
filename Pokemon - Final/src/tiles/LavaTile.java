package tiles;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class LavaTile extends Tile{

	private static final int width = 30, height = 31;
	private static BufferedImage tile;
	
	public LavaTile() {
		if (tile == null) // load the sprite sheet into memory
			try{
				tile = ImageIO.read(new File("images/lava.png"));
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

}

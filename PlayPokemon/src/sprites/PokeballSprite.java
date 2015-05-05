package sprites;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class PokeballSprite extends Sprite{

	private static final int width = 30, height = 30; // width and height
	private static BufferedImage sheet; // the sprite sheet
	
	public PokeballSprite() {
		if (sheet == null) // load the sprite sheet into memory
			try{
				sheet = ImageIO.read(new File("images/pokeball.png"));
			}catch(Exception e){};
	}
	
	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return sheet;
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

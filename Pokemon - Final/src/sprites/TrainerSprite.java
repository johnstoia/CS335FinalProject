package sprites;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class TrainerSprite extends Sprite {
	private static final int leftBorder = 0, vertBorder = 0;
	private static final int MAX_FRAMES = 3; 
	private static final int width = 20, height = 27; 
	private static BufferedImage sheet; 
	private State previousState; 

	/**
	 * Description: 
	 *
	 *  Adding the trainer sprite 
	 * 
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public TrainerSprite(){
		if (sheet == null) 
			try{
				sheet = ImageIO.read(new File("images/trainerSprite.png"));
			}catch(Exception e){};
		previousState = State.MOVING_DOWN; 
	}
	
	@Override
	public void setState(State state){ 
		previousState = getState();
		super.setState(state);
	}
	
	/**
	 * Description: 
	 *
	 *  
	 *
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */

	@Override
	public Image getImage() {
		
		if (sheet == null)
			return null;
		
		int row = 0, col = frame;
		
		switch(getState()){
			case IDLE: 
				col = 0;
				switch (previousState) {
					case MOVING_UP:
						row = 2;
						break;
					case MOVING_DOWN:
						row = 0;
						break;
					case MOVING_LEFT:
						row = 1;
						break;
					case MOVING_RIGHT:
						row = 3;
						break;
					default:
						break;
				}
				break;		
			case MOVING_UP:
				row = 2;
				break;
			case MOVING_DOWN:
				row = 0;
				break;
			case MOVING_LEFT:
				row = 1;
				break;
			case MOVING_RIGHT:
				row = 3;
				break;
			default:
				break;
		}
	

		frame = (frame + 1) % MAX_FRAMES; // increment frame
		
		// get the subimage of the frame from the row and column
		BufferedImage temp = sheet.getSubimage(leftBorder + col * width, row * (height + vertBorder), width, height);
		
		
		return temp.getScaledInstance(3*width/2, 3*height/2, Image.SCALE_DEFAULT);
	}

	/**
	 * Description: 
	 *
	 * Getting height 
	 * 
	 * 
	 * @return height*2
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	@Override
	public int getHeight() {
		return 2 * height;
	}
	
	/**
	 * Description: 
	 *
	 * Getting width 
	 * 
	 * @return 2 * width 
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */

	@Override
	public int getWidth() {
		return 2 * width;
	}
}

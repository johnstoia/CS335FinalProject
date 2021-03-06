package objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import sprites.Sprite;


public abstract class SpriteObject {
	public Point position; // position of the sprite object
	private Sprite sprite; // the object's sprite
	private Image frame; // the last frame of the sprite
	private Timer t; // timer used to update the frame
	private String name;
	
	/**
	 * Constructs a new SpriteObject.
	 * 
	 * @param sprite	sprite to use for this object
	 * @param x	x position of the object
	 * @param y	y position of the object
	 * @param delay	delay in switching animation frames
	 */
	protected SpriteObject(Sprite sprite, int x, int y, String name, int delay){
		this.name = name;
		this.sprite = sprite;
		this.position = new Point(x, y);
		frame = sprite.getImage();
		
		// this timer is constructed using an anonymous class
		t = new Timer(delay, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				nextFrame();
			}
		});
	}
	
	/**
	 * Get the sprite for this SpriteObject
	 * @return	the object's sprite
	 */
	public Sprite getSprite(){
		return sprite;
	}
	
	/**
	 * Sets the SpriteObject to be at the given position
	 * @param x	the new x position
	 * @param y	the new y position
	 */
	public void setPosition(int x, int y){
		position.setLocation(x, y);
	}

	/**
	 * Draws the SpriteObject on the given context
	 * @param g	the graphics context to render to
	 */
	public void draw(Graphics g){
		if (sprite != null && !sprite.isFinished()) // only render if not finished
			g.drawImage(frame, position.x  - sprite.getWidth()/2, position.y - sprite.getHeight()/2, null);
	}
	
	/**
	 * Move the SpriteObject left
	 */
	public void moveLeft(){
		if (sprite.getState() != Sprite.State.MOVING_LEFT){
			
			sprite.setState(Sprite.State.MOVING_LEFT);
			nextFrame();	
		}	
	}
	
	/**
	 * Move the SpriteObject right
	 */
	public void moveRight(){
//		System.out.println(position);
		if (sprite.getState() != Sprite.State.MOVING_RIGHT){
			sprite.setState(Sprite.State.MOVING_RIGHT);
			nextFrame();
		}
	}
	
	/**
	 * Move the SpriteObject up
	 */
	public void moveUp(){
//		System.out.println(position);
		if (sprite.getState() != Sprite.State.MOVING_UP){
			sprite.setState(Sprite.State.MOVING_UP);
			nextFrame();
		}
	}
	
	/**
	 * Move the SpriteObject down
	 */
	public void moveDown(){
//		System.out.println(position);
		if (sprite.getState() != Sprite.State.MOVING_DOWN){
			sprite.setState(Sprite.State.MOVING_DOWN);
			nextFrame();
		}
	}
	
	/**
	 * Stop moving the SpriteObject
	 */
	public void moveStop(){
		if (sprite.getState() != Sprite.State.IDLE){
			sprite.setState(Sprite.State.IDLE);
			nextFrame();
		}
	}
	
	/**
	 * Start animating the SpriteObject
	 */
	public void start(){
		if (!t.isRunning())
			t.start();
		sprite.reset();
	}
	
	/**
	 * Stop animating the sprite
	 */
	public void stop(){
		t.stop();
	}
	
	/**
	 * Advance the frame to the next image
	 */
	private void nextFrame(){
		frame = sprite.getImage();
	}
}

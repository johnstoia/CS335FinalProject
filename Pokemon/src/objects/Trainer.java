package objects;
import java.util.TreeSet;

import javax.swing.JComponent;
import javax.swing.Timer;

import sprites.TrainerSprite;


public class Trainer extends SpriteObject{	
	public Trainer(int x, int y){
		super(new TrainerSprite(), x, y, 100);
	}
	
	
}

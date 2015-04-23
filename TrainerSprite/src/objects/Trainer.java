package objects;
import sprites.TrainerSprite;

// TODO 10: Look at Frog. How could this design be improved (think Factory)
public class Trainer extends SpriteObject{
	public Trainer(int x, int y){
		super(new TrainerSprite(), x, y, 100);
	}
	
	
}

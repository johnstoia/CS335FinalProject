package maps;
import java.awt.*;
import java.util.Random;

import objects.*;
import sprites.PokeballSprite;
import tiles.*;

public abstract class Map {
	
	public Map() {}	
	
	public abstract int[][] getMap();

	public abstract void draw(Graphics g, int[][] mapView);
	
	public abstract String getItem(int x, int y);
	
}

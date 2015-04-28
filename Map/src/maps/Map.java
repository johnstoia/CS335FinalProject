package maps;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.TreeSet;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import objects.SpriteObject;
import objects.Trainer;
import tiles.BridgeHorizontal;
import tiles.BridgeVertical;
import tiles.GrassTile;
import tiles.PlainTile;
import tiles.WaterTile;

public class Map {

	private int [][] map;
	private JComponent myMap;
	private static final long serialVersionUID = 1L;
	private static final int width = 30;
	public Point position;
	
	GrassTile grass = new GrassTile();
	PlainTile plain = new PlainTile();
	WaterTile water = new WaterTile();
	BridgeHorizontal bridgeH = new BridgeHorizontal();
	BridgeVertical bridgeV = new BridgeVertical();
	
	public Map() {
		map = new int[30][20];
		
		// setting up map
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++)
				//map[i][j] = -1;
				setTile(i,j,-1);
		}
		for(int i = 2; i < 13 ; i++){
			for(int j = 2; j < 8; j++)
				//map[i][j] = 0;
				setTile(i,j,0);
		}
		for(int i = 18; i < 28 ; i++){
			for(int j = 2; j < 8; j++)
				//map[i][j] = 0;
				setTile(i,j,0);
		}
		for(int i = 2; i < 13 ; i++){
			for(int j = 13; j < 18; j++)
				//map[i][j] = 0;
				setTile(i,j,0);
		}
		for(int i = 18; i < 28 ; i++){
			for(int j = 13; j < 18; j++)
				//map[i][j] = 0;
				setTile(i,j,0);
		}
		for(int i = 0; i < map[i].length; i++){
			//map[15][i] = 1;
			setTile(15,i,1);
		}
		for(int i = 0; i < map.length; i++){
			//map[i][10] = 1;
			setTile(i,10,1);
		}
		setTile(6,10,2);
		setTile(23,10,2);
		setTile(15,5,3);
		setTile(15,15,3);
//		map[6][10] = 2;
//		map[23][10] = 2;
//		map[15][5] = 3;
//		map[15][15] = 3;
		// end of setting up map
	}	
		// drawing map
	public void draw(Graphics g) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				drawMap(map[i][j], g, i, j);
			}
		}
	}

	private void drawMap(int value, Graphics g, int i, int j) {
		if(value == 0){ //grass
			try {
				g.drawImage(grass.getImage(), i*width, j*width, width, width, null);
			} catch(Exception e) {}
		}
		else if(value == 1){ //water
			try {
				g.drawImage(water.getImage(), i*width, j*width, width, width, null);
			} catch(Exception e) {}
		}
		else if(value == 2){ //vertical bridge
			try {
				g.drawImage(bridgeV.getImage(), i*width, j*width, width, width, null);
			} catch(Exception e) {}
		}
		else if(value == 3){ //horizontal bridge
			try {
				g.drawImage(bridgeH.getImage(), i*width, j*width, width, width, null);
			} catch(Exception e) {}
		}
		else if(value == 4){
			
		}
		else {
			try {
				g.drawImage(plain.getImage(), i*width, j*width, width, width, null);
			} catch(Exception e) {}
			
		}
	}
	
	public void setTile(int x, int y, int value) {
		map[x][y] = value;
		position = new Point(x,y);
	}
	
	public Point getPosition() {
		return position;
	}
	
/*	public Tile getTile() {
		if()
	}
*/
/*	public static void main(String[] args) {
		new Map();
	}*/

}

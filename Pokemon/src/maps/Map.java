package maps;
import java.awt.*;
import objects.*;
import tiles.*;

public class Map {

	private int [][] map;
	private static final long serialVersionUID = 1L;
	private static final int width = 30;
	
	GrassTile grass = new GrassTile();
	PlainTile plain = new PlainTile();
	WaterTile water = new WaterTile();
	BridgeHorizontal bridgeH = new BridgeHorizontal();
	BridgeVertical bridgeV = new BridgeVertical();
	
	public Map() {
		map = new int[40][29];
		
		// setting up map
		// plain tiles
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++)
				setTile(i,j,-1);
		}
		// top-left grass tiles
		for(int i = 7; i < 18 ; i++){
			for(int j = 6; j < 11; j++)
				setTile(i,j,0);
		}
		// top-right grass tiles
		for(int i = 23; i < 33 ; i++){
			for(int j = 6; j < 11; j++)
				setTile(i,j,0);
		}
		// bottom-left grass tiles
		for(int i = 7; i < 18 ; i++){
			for(int j = 16; j < 20; j++)
				setTile(i,j,0);
		}
		// bottom-right grass tiles
		for(int i = 23; i < 33 ; i++){
			for(int j = 16; j < 20; j++)
				setTile(i,j,0);
		}
		// mid-vertical river tiles
		for(int i = 4; i < map[i].length-6; i++){
			setTile(20,i,1);
		}
		// mid-horizontal river tiles
		for(int i = 4; i < map.length-4; i++){
			setTile(i,13,1);
		}
		// top-horizontal river tiles
		for(int i = 4; i < map.length-4; i++){
			setTile(i,4,1);
		}
		// bottom-horizontal river tiles
		for(int i = 4; i < map.length-4; i++){
			setTile(i,22,1);
		}
		// left-vertical river tiles
		for(int i = 4; i < map[i].length-6; i++){
			setTile(4,i,1);
		}
		// right-vertical river tiles
		for(int i = 4; i < map[i].length-6; i++){
			setTile(35,i,1);
		}
		
		// bridge tiles
		setTile(12,13,2);
		setTile(28,13,2);
		setTile(20,8,3);
		setTile(20,18,3);
	}	
	
	// drawing map
	public void draw(Graphics g, int[][] mapView) {
		for(int i = 0; i < mapView.length; i++) {
			for(int j = 0; j < mapView[i].length; j++) {
				drawMap(mapView[i][j], g, i, j);
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
		else {
			try {
				g.drawImage(plain.getImage(), i*width, j*width, width, width, null);
			} catch(Exception e) {}
			
		}
	}
	
	public void setTile(int x, int y, int value) {
		map[x][y] = value;
	}
	
	public int[][] getMap() {
		return map;
	}
	
/*	public static void main(String[] args) {
		new Map();
	}*/

}

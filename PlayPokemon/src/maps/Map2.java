package maps;

import java.awt.Graphics;

import objects.PokeballObject;
import sprites.PokeballSprite;
import tiles.BridgeHorizontal;
import tiles.BridgeVertical;
import tiles.GrassTile;
import tiles.LavaTile;
import tiles.PlainTile;
import tiles.WaterTile;

public class Map2 extends Map{
	
	private int [][] map;
	private String [][] items;
	private static final long serialVersionUID = 1L;
	private static final int width = 30;

	private GrassTile grass = new GrassTile();
	private PlainTile plain = new PlainTile();
	private LavaTile lava = new LavaTile();
	private BridgeHorizontal bridgeH = new BridgeHorizontal();
	private BridgeVertical bridgeV = new BridgeVertical();
	
	public Map2() {
		map = new int[50][50];
		items = new String[50][50];
		
		// setting up map
		// plain tiles
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++)
				setTile(i,j,-1,null);
		}
		
		// grass tiles
		for(int i = 5; i < map.length-6; i++){
			if(i%2 == 0)
				i++;
			for(int j = 5; j < map[i].length-6; j+=2){
				setTile(i,j,0,null);
			}
		}
		for(int i = 6; i < map.length-6; i++){
			if(i%2 == 1)
				i++;
			for(int j = 6; j < map[i].length-6; j+=2){
				setTile(i,j,0,null);
			}
		}
		
		// top-horizontal lava tiles
		for(int i = 4; i < map.length-4; i++){
			setTile(i,4,1,null);
		}
		// bottom-horizontal lava tiles
		for(int i = 4; i < map.length-4; i++){
			setTile(i,43,1,null);
		}
		// left-vertical lava tiles
		for(int i = 4; i < map[i].length-6; i++){
			setTile(4,i,1,null);
		}
		// right-vertical lava tiles
		for(int i = 4; i < map[i].length-6; i++){
			setTile(45,i,1,null);
		}
		// inner-top-horizontal lava tiles
		for(int i = 19; i < map.length-21; i++){
			setTile(i,14,1,null);
		}
		// inner-bottom-horizontal lava tiles
		for(int i = 19; i < map.length-21; i++){
			setTile(i,28,1,null);
		}
		// inner-left-vertical lava tiles
		for(int i = 15; i < map[i].length-21; i++){
			setTile(19,i,1,null);
		}
		// inner-right-vertical lava tiles
		for(int i = 15; i < map[i].length-23; i++){
			setTile(28,i,1,null);
		}
		// top-right-corner lava tiles
		for(int i = 5; i < 12; i++){
			setTile(38,i,1,null);
		}
		for(int i = 39; i < map.length-6; i++){
			setTile(i,11,1,null);
		}
		for(int i = 6; i < 11; i++){
			setTile(43,i,1,null);
		}
		for(int i = 40; i < map.length-7; i++){
			setTile(i,6,1,null);
		}
		for(int i = 7; i < 10; i++){
			setTile(40,i,1,null);
		}
		setTile(41,9,1,null);
		
		// bottom-left-corner lava tiles
		for(int i = 5; i < 12; i++){
			setTile(i,36,1,null);
		}
		for(int i = 37; i < map.length-8; i++){
			setTile(11,i,1,null);
		}
		for(int i = 6; i < 11; i++){
			setTile(i,41,1,null);
		}
		for(int i = 38; i < map.length-9; i++){
			setTile(6,i,1,null);
		}
		for(int i = 7; i < 10; i++){
			setTile(i,38,1,null);
		}
		setTile(9,39,1,null);
		
		
		setTile(24,15,4,new PokeballObject(70,70,"Master Ball"));
		setTile(7,40,4,new PokeballObject(70,70,"Running Shoes"));
		setTile(41,8,4,new PokeballObject(70,70,"Running Shoes"));
		setTile(8,39,4,new PokeballObject(70,70,"Sleeping Dart"));
		setTile(42,7,4,new PokeballObject(70,70,"Sleeping Dart"));
	}
	
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
		else if(value == 1){ //lava
			try {
				g.drawImage(lava.getImage(), i*width, j*width, width, width, null);
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
		else if(value == 4){ // pokeballs
			try {
				g.drawImage(new PokeballSprite().getImage(), i*width, j*width, width, width, null);
			} catch(Exception e) {}
		}
		else {
			try { // plain
				g.drawImage(plain.getImage(), i*width, j*width, width, width, null);
			} catch(Exception e) {}
			
		}
	}
	
	public void setTile(int x, int y, int value, PokeballObject item) {
		map[x][y] = value;
		if(item != null)
			items[x][y] = item.getName();
	}
	
	public int[][] getMap() {
		return map;
	}
	
	public String getItem(int x, int y) {
		return items[x][y];
	}

}

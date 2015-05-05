package maps;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import objects.*;
import sprites.PokeballSprite;
import tiles.*;

public class Map1 extends Map{

	private int [][] map;
	private String [][] items;
	private static final long serialVersionUID = 1L;
	private static final int width = 30;

	private GrassTile grass = new GrassTile();
	private PlainTile plain = new PlainTile();
	private WaterTile water = new WaterTile();
	private BridgeHorizontal bridgeH = new BridgeHorizontal();
	private BridgeVertical bridgeV = new BridgeVertical();
	
	public Map1() {
		map = new int[40][29];
		items = new String[40][29];
		
		// setting up map
		// plain tiles
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++)
				setTile(i,j,-1,null);
		}
		// top-left grass tiles
		for(int i = 7; i < 18 ; i++){
			for(int j = 6; j < 11; j++)
				setTile(i,j,0,null);
		}
		// top-right grass tiles
		for(int i = 23; i < 33 ; i++){
			for(int j = 6; j < 11; j++)
				setTile(i,j,0,null);
		}
		// bottom-left grass tiles
		for(int i = 7; i < 18 ; i++){
			for(int j = 16; j < 20; j++)
				setTile(i,j,0,null);
		}
		// bottom-right grass tiles
		for(int i = 23; i < 33 ; i++){
			for(int j = 16; j < 20; j++)
				setTile(i,j,0,null);
		}
		// mid-vertical river tiles
		for(int i = 4; i < map[i].length-6; i++){
			setTile(20,i,1,null);
		}
		// mid-horizontal river tiles
		for(int i = 4; i < map.length-4; i++){
			setTile(i,13,1,null);
		}
		// top-horizontal river tiles
		for(int i = 4; i < map.length-4; i++){
			setTile(i,4,1,null);
		}
		// bottom-horizontal river tiles
		for(int i = 4; i < map.length-4; i++){
			setTile(i,22,1,null);
		}
		// left-vertical river tiles
		for(int i = 4; i < map[i].length-6; i++){
			setTile(4,i,1,null);
		}
		// right-vertical river tiles
		for(int i = 4; i < map[i].length-6; i++){
			setTile(35,i,1,null);
		}
		
		// bridge tiles
		setTile(12,13,2,null);
		setTile(28,13,2,null);
		setTile(20,8,3,null);
		setTile(20,18,3,null);
		
		// items
		setTile(34,21,4,new PokeballObject(70,70,"Master Ball"));
		setTile(5,21,4,new PokeballObject(70,70,"Running Shoes"));
		setTile(34,5,4,new PokeballObject(70,70,"Sleeping Dart"));
		setTile(19,12,4,new PokeballObject(70,70,"Sleeping Dart"));
		
		
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

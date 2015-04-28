package maps;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.TreeSet;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import objects.SpriteObject;
import objects.Trainer;
import sprites.Sprite;
import tiles.BridgeHorizontal;
import tiles.BridgeVertical;
import tiles.GrassTile;
import tiles.PlainTile;
import tiles.WaterTile;

public class MapBase extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int width = 30;
	int [][] myMap;
	
	GrassTile grass = new GrassTile();
	PlainTile plain = new PlainTile();
	WaterTile water = new WaterTile();
	BridgeHorizontal bridgeH = new BridgeHorizontal();
	BridgeVertical bridgeV = new BridgeVertical();
	
	public MapBase(int [][] newMap){
		myMap = newMap;
	}
	
	public void paintComponent(Graphics g) {
		for(int i = 0; i < myMap.length; i++) {
			for(int j = 0; j < myMap[i].length; j++) {
				drawTile(myMap[i][j], g, i, j);
			}
		}
	}

	private void drawTile(int value, Graphics g, int i, int j) {
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
}

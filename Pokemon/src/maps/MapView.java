package maps;

import java.awt.Graphics;

import javax.swing.JPanel;

public class MapView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map map;
	private int [][] mapView;
	private int [][] tempMap;
	private int positionY = 0;
	private int positionX = 0;
	
	public MapView() {
		map = new Map();
		tempMap = map.getMap();
		mapView = new int[11][11];
		for(int i = 0; i < mapView.length; i++){
			for(int j = 0; j < mapView[i].length; j++) {
				mapView[i][j] = tempMap[i][j];
			}
		}
		
	}
	
	public void draw(Graphics g) {
		map.draw(g, mapView);
	}
	
	public void moveDown(){
		if(positionY < tempMap[0].length - mapView.length)
			positionY++;
		for(int i = 0; i < mapView.length; i++){
			for(int j = 0; j < mapView[i].length; j++) {
				mapView[i][j] = tempMap[i + positionX][j + positionY];
			}
		}
	}
	
	public void moveUp(){
		if(positionY > 0)
			positionY--;
		for(int i = 0; i < mapView.length; i++){
			for(int j = 0; j < mapView[i].length; j++) {
				mapView[i][j] = tempMap[i + positionX][j + positionY];
			}
		}
	}
	
	public void moveLeft(){
		if(positionX > 0)
			positionX--;
		for(int i = 0; i < mapView.length; i++){
			for(int j = 0; j < mapView[i].length; j++) {
				mapView[i][j] = tempMap[i + positionX][j + positionY];
			}
		}
	}
	
	public void moveRight(){
		if(positionX < tempMap.length - mapView.length)
			positionX++;
		for(int i = 0; i < mapView.length; i++){
			for(int j = 0; j < mapView[i].length; j++) {
				mapView[i][j] = tempMap[i + positionX][j + positionY];
			}
		}
	}
	
}

package map;


import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JPanel;

import objects.Grass;
import sprites.GrassSprite;

public class Map extends JPanel{
	private static int width = 320;
	private static int height = 320;
	private Grass grass = new Grass(32, 32);
	private JPanel panel;
	
	public Map(){
		this.setSize(height,width);
		
			
			for(int i = 0; i*grass.getSprite().getHeight() < height-grass.getSprite().getHeight(); i++){
				for(int j = 0; j *grass.getSprite().getWidth() < width-grass.getSprite().getWidth(); j++){
					this.add(new JPanel(){
						public void paintComponent(Graphics g){
							grass.draw(g);
						}
					});
					
				}
			}
			this.repaint();
		
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}

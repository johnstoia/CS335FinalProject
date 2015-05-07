package controller;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.TreeSet;

import javax.swing.*;

import objects.Trainer;
import view.ItemView;
import view.MapView;
import maps.*;

public class World extends JPanel{

	private static final long serialVersionUID = 1L;
	private Trainer trainer;
	private TreeSet<Character> keySet;
	private Timer animTimer;
	private MapView mapView;
	private boolean visibility;

	/**
	 * Description: 
	 *
	 * Setting up the map 
	 * 
	 * @param name of pokemon
	 * @param mapType int type of map 
	 * @param winChoice int type of win
	 * @author Ryan
	 */
	public World(String name, int mapType, int winChoice) {
		trainer = new Trainer(170,170,name);
		this.visibility = true;
		mapView = new MapView(mapType, trainer, winChoice);
		keySet = new TreeSet<Character>();
		trainer.start();
		animTimer = new Timer(125, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (trainer != null & mapView.getSteps() > 0){ // move the trainer according to what keys are being pressed & checking for Pokemon encounters
					if (keySet.contains('w') & mapView.getEncounter() != true) {
						trainer.moveUp();
						mapView.moveUp();
					}
					else if (keySet.contains('a') & mapView.getEncounter() != true) {
						trainer.moveLeft();
						mapView.moveLeft();
					}
					else if (keySet.contains('s') & mapView.getEncounter() != true) {
						trainer.moveDown();
						mapView.moveDown();
					}
					else if (keySet.contains('d') & mapView.getEncounter() != true) {
						trainer.moveRight();
						mapView.moveRight();
					}
					else
						trainer.moveStop();
				}
				else{
					trainer.moveStop();
				}
				// repaint the component
				repaint();
			}
			
		});
		this.setEnabled(false);
		this.setPreferredSize(new Dimension(336,349));
		this.revalidate();
		this.setVisible(true);
		animTimer.start();
	}
	
	/**
	 * Description: 
	 *
	 * Setting up the map 
	 * 
	 * 
	 * @author Ryan
	 */
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		mapView.draw(g);
		trainer.draw(g);
	}
	
	/**
	 * Description: 
	 *
	 * Setting up the map 
	 * 
	 * @return the animeTimer 
	 * @author Ryan
	 */
	public Timer getAnimTimer() {
		return animTimer;
	}
	/**
	 * Description: 
	 *
	 * Setting up the keyset 
	 * 
	 * @return TreeSet<Character>
	 * @author Ryan
	 */
	public TreeSet<Character> getKeySet() {
		return keySet;
	}
	/**
	 * Description: 
	 *
	 * Setting up the trainer  
	 * 
	 * @return Trainer
	 * @author Ryan
	 */
	public Trainer getTrainer() {
		return trainer;
	}
	/**
	 * Description: 
	 *
	 * get the view
	 * 
	 * @return MapView
	 * @author Ryan
	 */
	public MapView getMapView() {
		return mapView;
	}
	/**
	 * Description: 
	 *
	 * @param flag of the visibility  
	 * 
	 * 
	 * @author Ryan
	 */
	public void setVisibility(boolean flag){
		visibility = flag;
	}
	
	/**
	 * Description: 
	 *
	 * get the visibilty 
	 * 
	 * @return return the visibility 
	 * @author Ryan
	 */
	
	public boolean getVisiblity(){
		return visibility;
	}
}

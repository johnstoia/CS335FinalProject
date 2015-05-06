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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Trainer trainer;
	private TreeSet<Character> keySet;
	private Timer animTimer;
	private MapView mapView;
	
	public World(String name, int mapType) {
		trainer = new Trainer(170,170,name);
		
		mapView = new MapView(mapType, trainer);
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
				else
					trainer.moveStop();
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
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		mapView.draw(g);
		trainer.draw(g);
	}
	
	public Timer getAnimTimer() {
		return animTimer;
	}
	
	public TreeSet<Character> getKeySet() {
		return keySet;
	}
	
	public Trainer getTrainer() {
		return trainer;
	}
	
	public MapView getMapView() {
		return mapView;
	}
}

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
//	private ItemView itemList;
//	private boolean showItems;
	
	
	public World(String name, int mapType) {
		trainer = new Trainer(170,170,name);
//		itemList = new ItemView(trainer);
//		add(itemList);
//		showItems = false;
//		itemList.setVisible(showItems);
		
		mapView = new MapView(mapType, trainer);
		keySet = new TreeSet<Character>();
		trainer.start();
		animTimer = new Timer(125, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				System.out.println(mapView.getEncounter());
				if (trainer != null & mapView.getSteps() > 0){ // move the trainer according to what keys are being pressed & checking for Pokemon encounters
					if (keySet.contains('w')/* & showItems != true */& mapView.getEncounter() != true) {
						trainer.moveUp();
						mapView.moveUp();
//						System.out.println(mapView.getEncounter());
//						System.out.println(mapView.getSteps());
					}
					else if (keySet.contains('a')/* & showItems != true */& mapView.getEncounter() != true) {
						trainer.moveLeft();
						mapView.moveLeft();
//						System.out.println(mapView.getEncounter());
//						System.out.println(mapView.getSteps());
					}
					else if (keySet.contains('s')/* & showItems != true */& mapView.getEncounter() != true) {
						trainer.moveDown();
						mapView.moveDown();
//						System.out.println(mapView.getEncounter());
//						System.out.println(mapView.getSteps());
					}
					else if (keySet.contains('d')/* & showItems != true*/ & mapView.getEncounter() != true) {
						trainer.moveRight();
						mapView.moveRight();
//						System.out.println(mapView.getEncounter());
//						System.out.println(mapView.getSteps());
					}
//					else if(keySet.contains('i')) {
////						trainer.moveStop();
//						try {
//							Thread.sleep(200);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//						if(showItems == false){
//							setShowItems(true);
//							itemList.setItemList(trainer);
//							itemList.setVisible(showItems);
//						}
//						else {
//							setShowItems(false);
//							itemList.setVisible(showItems);
//						}
//					}
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
//		this.setEnabled(mapView.getState());
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
	
//	public ItemView getItemList() {
//		return itemList;
//	}
//	
//	public void setShowItems(boolean flag){
//		showItems = flag;
//	}
	/*
	public static void main(String[] args){
		World myWorld = new World();
		JFrame frame = new JFrame("Pokemon");
		frame.add(myWorld);
		frame.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent arg0) {
				keySet.add(arg0.getKeyChar());
//				System.out.println(arg0 + "here");
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {keySet.remove(arg0.getKeyChar());}
		});
		frame.setBounds(30, 30, 345, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		myWorld.revalidate();
		myWorld.repaint();

	}
	*/
}

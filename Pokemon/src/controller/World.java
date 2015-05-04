package controller;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.TreeSet;

import javax.swing.*;

import objects.Trainer;
import maps.*;

public class World extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Map map = new Map();
	private Trainer trainer = new Trainer(170,170);
	private static TreeSet<Character> keySet;
	private Timer animTimer;
	private static MapView mapView = new MapView();
	
	
	public World() {
		keySet = new TreeSet<Character>();
		trainer.start();
		animTimer = new Timer(50, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				System.out.println("here");
				if (trainer != null){ // move the trainer according to what keys are being pressed
					if (keySet.contains('w')) {
						trainer.moveUp();
						mapView.moveUp();
					}
					else if (keySet.contains('a')) {
						trainer.moveLeft();
						mapView.moveLeft();
					}
					else if (keySet.contains('s')) {
						trainer.moveDown();
						mapView.moveDown();
					}
					else if (keySet.contains('d')) {
						trainer.moveRight();
						mapView.moveRight();
					}
					else
						trainer.moveStop();
				}
				
				// repaint the component
				repaint();
			}
			
		});
		
		
		
		this.setBounds(30, 30, 1200, 720);
		this.setVisible(true);
		animTimer.start();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		mapView.draw(g);
		trainer.draw(g);
	}
	
	public static Map getMap() {
		return map;
	}
	
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
/*	
		int i = 0;
		while(i != myWorld.getMap().getTileMapping().get(1).size()) {
		if(myWorld.getMap().getTileMapping().containsKey(1)){
			System.out.println(myWorld.getMap().getTileMapping().get(1).get(i).x);
			System.out.println(myWorld.getMap().getTileMapping().get(1).get(i).y);
			i++;
		}
		}
*/
	}
}

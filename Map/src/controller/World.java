package controller;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.TreeSet;

import javax.swing.*;

import objects.Trainer;
import maps.Map;

public class World extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Map map = new Map();
	Trainer trainer = new Trainer(80,80);
	private static TreeSet<Character> keySet;
	private Timer animTimer;
	
	
	public World() {
		keySet = new TreeSet<Character>();
		trainer.start();
		animTimer = new Timer(50, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				System.out.println("here");
				if (trainer != null){ // move the trainer according to what keys are being pressed
					if (keySet.contains('w'))
						trainer.moveUp();
					else if (keySet.contains('a'))
						trainer.moveLeft();
					else if (keySet.contains('s'))
						trainer.moveDown();
					else if (keySet.contains('d'))
						trainer.moveRight();
					else
						trainer.moveStop();
				}
				
				// repaint the component
				repaint();
			}
			
		});
		
		
		
		this.setBounds(30, 30, 900, 600);
		this.setVisible(true);
		animTimer.start();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		map.draw(g);
		trainer.draw(g);
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
		frame.setBounds(30, 30, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		myWorld.revalidate();
		myWorld.repaint();
	}
}

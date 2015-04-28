package controller;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.TreeSet;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

import maps.Map;
import objects.Trainer;
import objects.SpriteObject;


public class MasterTrainer{
	private TreeSet<Character> keySet;
	private SpriteObject trainer;
	private JComponent component;
	private Timer animTimer;
	
	public MasterTrainer() {
		keySet = new TreeSet<Character>();
		
		// TODO 13: uncomment these two lines
		trainer = new Trainer(100, 100);
		trainer.start();
		
		// creates the component that actually draws the sprites
//		component = new JComponent(){
//			public void paintComponent(Graphics g){
//				super.paintComponent(g);
//				
//				// TODO 14: uncomment the next line
//				
//				trainer.draw(g);
//			}
//		};
//		component.setPreferredSize(new Dimension(30, 30));
//		
		// creates the timer for animating the component
		animTimer = new Timer(15, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
			//	repaint();
			}
			
		});
		
////		frame = new JFrame();
//		
////		this.add(component);
//		
//		this.addKeyListener(new KeyAdapter(){
//			@Override
//			public void keyPressed(KeyEvent arg0) {
//				keySet.add(arg0.getKeyChar());
//				
//				
//			}
//			
//			@Override
//			public void keyReleased(KeyEvent arg0) {keySet.remove(arg0.getKeyChar());}
//		});
//		
//		
//		this.setSize(800, 600);
////		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setVisible(true);

		animTimer.start();
	}
	
	public SpriteObject getSpriteObject() {
		return trainer;
	}
	
	
/*	public static void main(String[] args){
		new Runner();
	}*/
}

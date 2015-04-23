package controller;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import objects.Trainer;
import objects.SpriteObject;


public class Runner {
	private TreeSet<Character> keySet;
	private SpriteObject trainer;
	private JFrame frame;
	private JPanel panel;
	private Timer animTimer;
	
	public Runner() {
		keySet = new TreeSet<Character>();
		
		// TODO 13: uncomment these two lines
		trainer = new Trainer(400, 300);
		trainer.start();
		
		// creates the panel that actually draws the sprites
		panel = new JPanel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				
				// TODO 14: uncomment the next line
				trainer.draw(g);
			}
		};
		panel.setPreferredSize(new Dimension(800, 600));
		
		// creates the timer for animating the panel
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
				
				// repaint the panel
				panel.repaint();
			}
			
		});
		
		frame = new JFrame();
		frame.add(panel);
		
		frame.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent arg0) {
				keySet.add(arg0.getKeyChar());
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {keySet.remove(arg0.getKeyChar());}
		});
		
		
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		animTimer.start();
	}
	
	public static void main(String[] args){
		new Runner();
	}
}

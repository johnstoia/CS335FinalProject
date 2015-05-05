package controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TreeSet;

import javax.swing.*;

import model.Pokemon;
import objects.*;
import view.ItemView;
import view.PokemonCaptureView;


public class PokeWorld{
	public static void main(String args[]) throws RuntimeException{
		
		Object[] options = {"Beat the NPC's",
                "Catch \"Snodgrass\"",
                };
		
		Object[] options1 = {"Map 1",
                "Map 2",
                };
		
		Component frame = null;
		
		int mapChoice = -1;
		int winChoice = -1;
		String trainerName = "";
		
		trainerName = JOptionPane.showInputDialog(null,"Trainer Name"); 
		
		
		mapChoice = JOptionPane.showOptionDialog(frame,
					"Please Choose a Map",
					"Map",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options1,
					options1[1]);
			

		
		winChoice = JOptionPane.showOptionDialog(frame,
					"Please Choose a Win Condition",
					"Win Condition",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					options[1]);
		
		if(mapChoice == -1 || winChoice == -1){
			throw new RuntimeException("You must pick an option from each prompt!");
		}
		
		
		// setting up Pokemon game
		JFrame gameFrame = new JFrame("Pokémon: " + trainerName);
		gameFrame.setSize(998,689);
		gameFrame.setLayout(new GridLayout(2,3));
		World myWorld = new World(trainerName,mapChoice);
		ItemView itemView = new ItemView(myWorld.getTrainer()); // list of items by making new ItemView
		JList itemList = new JList(myWorld.getTrainer().getItemList()); // hardcoding list of items
		myWorld.getTrainer().caughtPokemon(new Pokemon("Gregachu",9));
		PokemonCaptureView capturedList = new PokemonCaptureView(myWorld.getTrainer());
		
		JLabel l = new JLabel("BLah");
		
		JPanel p = new JPanel();
		p.add(l);
		JPanel a = new JPanel();
		JPanel b = new JPanel();
		JPanel c = new JPanel();
		JPanel d = new JPanel();
		a.setPreferredSize(new Dimension(336,349));
		b.setPreferredSize(new Dimension(336,349));
		p.setPreferredSize(new Dimension(336,349));
		c.setPreferredSize(new Dimension(336,349));
		p.setBackground(Color.CYAN);
		a.setBackground(Color.RED);
		b.setBackground(Color.GREEN);
		c.setBackground(Color.BLACK);
		d.setBackground(Color.MAGENTA);
		
		gameFrame.add(c);
		gameFrame.add(myWorld); // add map to frame

//		gameFrame.add(capturedList);
//		itemList.removeKeyListener(itemList.getKeyListeners());
//		gameFrame.add(a);
//		gameFrame.add(itemView); // add item list to frame
//		b.add(itemList);
//		gameFrame.add(itemList); // add hardcode item list to frame
		gameFrame.add(b);
		gameFrame.add(d);
		gameFrame.add(p);
		
//		itemList.setEnabled(false);
		gameFrame.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
//				if(myWorld.getMapView().getEncounter() == false)
					myWorld.getKeySet().add(e.getKeyChar());
//					myWorld.getItemList().setVisible(true);
			}
			public void keyReleased(KeyEvent e) {
				myWorld.getKeySet().remove(e.getKeyChar());
//				myWorld.getItemList().setVisible(false);
			}
		});
		
		
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		gameFrame.revalidate();
		gameFrame.repaint();
		gameFrame.setResizable(false);
	}
	




}

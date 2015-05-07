package controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.TreeSet;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.PokeBattle;
import model.Pokemon;
import objects.*;
import view.ItemView;
import view.PokeBattleView;
import view.PokeText;
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
		
		JFrame gameFrame = new JFrame("Pokémon: " + trainerName);
		
		gameFrame.setSize(998,689);
		gameFrame.setLayout(new GridLayout(2,3));
		World myWorld = new World(trainerName,mapChoice,winChoice);
		gameFrame.setVisible(myWorld.getVisiblity());
		JList itemList = new JList(myWorld.getTrainer().getItemList()); // hardcoding list of items
		PokemonCaptureView capturedList = new PokemonCaptureView(myWorld.getTrainer());
		PokeBattle battle = new PokeBattle(myWorld.getTrainer(),myWorld.getMapView().getPokemon());
		PokeText pokeText = new PokeText(battle);
		ItemView itemView = new ItemView(myWorld.getTrainer(), myWorld.getMapView(), pokeText, battle, myWorld.getKeySet()); // list of items by making new ItemView
		PokeBattleView battleScene = new PokeBattleView(battle,myWorld.getMapView(),pokeText,capturedList,itemView);

	
		gameFrame.add(battleScene);
		gameFrame.add(myWorld); // add map to frame
		gameFrame.add(capturedList);
		gameFrame.add(new JPanel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(new File("images/SafariZoneSimulator.png")), 0, 0, 336,349,null );
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		gameFrame.add(pokeText);
		gameFrame.add(itemView);

		gameFrame.addKeyListener(new KeyAdapter(){
			@Override
			
			public void keyPressed(KeyEvent e) {
				
				if(myWorld.getMapView().getEncounter() == true){
					battleScene.setVisibility(true);
					battleScene.setVisible(true);
					myWorld.getMapView().setState(false);
					pokeText.updateText(battleScene.getMap().getPokemon().getName() + " has appeared!");
					battleScene.setImage(myWorld.getMapView().getPokemon());
					battleScene.setPokemonName(battleScene.getMap().getPokemon().getName());
					battleScene.setPokemonRarity(battleScene.getMap().getPokemon().getRarity());
					battleScene.getLabelName().setText(battleScene.getMap().getPokemon().getName());
					battleScene.getLabelRarity().setText(""+battleScene.getMap().getPokemon().getRarity());
					battle.setPokemon(battleScene.getMap().getPokemon());
					itemView.setItemList(myWorld.getTrainer());
					capturedList.setPokemonList(myWorld.getMapView().getTrainer().getCaughtList());
				}
				
					
				else{
					itemView.setItemList(myWorld.getTrainer());
					battleScene.setVisibility(false);
					battleScene.setVisible(false);
					myWorld.getMapView().setState(true);
					myWorld.getKeySet().add(e.getKeyChar());
					myWorld.getMapView().setState(true);
					
					capturedList.setPokemonList(myWorld.getMapView().getTrainer().getCaughtList());
					
					if(myWorld.getMapView().getWinChoice() == 1 
							& (myWorld.getMapView().getSteps() <= 0 
							| myWorld.getTrainer().getPokemonList().contains("Snodgrass") 
							| myWorld.getTrainer().getSafari().getQuantity() <= 0) 
							& myWorld.getMapView().getEncounter() == false){
						
						    		String message = "";
									if(myWorld.getTrainer().getPokemonList().contains("Snodgrass")){
										message += "You Have Won!\nYou Have Taken " + (500-myWorld.getMapView().getSteps())+" Steps\n";
									}
									else{
										message += "You Have Lost!\nYou Have Taken " + (500-myWorld.getMapView().getSteps())+" Steps\n";
									}
									message += "List of Pokemon Caught:\n";
									for(int i = 0; i < myWorld.getTrainer().getCaughtList().size(); i++){
										message += myWorld.getTrainer().getCaughtList().get(i).getName()+"\n";
									}
						    		JOptionPane.showMessageDialog(null,message,"Game Over",JOptionPane.PLAIN_MESSAGE);
						    	
						            	gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						            	System.exit(0);			
						
					}			
					
					if(myWorld.getMapView().getWinChoice() == 0 
							& (myWorld.getMapView().getSteps() <= 0  
							| (myWorld.getTrainer().getSafari().getQuantity() <= 0 && myWorld.getTrainer().getMaster().getQuantity() == 0)) 
							& myWorld.getMapView().getEncounter() == false){
						String message = "";
						Random r = new Random();
						int low = 50;
						int high = 70;
						int randomNumber = r.nextInt(high-low) + low;
						int score = 0;
						for(int i = 0; i < myWorld.getTrainer().getCaughtList().size(); i++){
							score += myWorld.getTrainer().getCaughtList().get(i).getRarity();
						}
						
						if(score > randomNumber){
						message += "You Have Beaten The NPC!\nYou Have Taken " + (500-myWorld.getMapView().getSteps())+" Steps\n"
						+"Your Score: "+score+"\n"+"Trainer Greg's Score: "+randomNumber+"\n";
						}else if(score < randomNumber){
							message += "You Have Lost To The NPC :(\nYou Have Taken " + (500-myWorld.getMapView().getSteps())+" Steps\n"
									+"Your Score: "+score+"\n"+"Trainer Greg's Score: "+randomNumber;
						}
						
						message += "List of Pokemon Caught:\n";
						
						for(int i = 0; i < myWorld.getTrainer().getCaughtList().size(); i++){
							message += myWorld.getTrainer().getCaughtList().get(i).getName()+"\n";
						}
			    		JOptionPane.showMessageDialog(null,message,"Game Over",JOptionPane.PLAIN_MESSAGE);
			    	
			            	gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			            	System.exit(0);			
						
						
					}
					
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				myWorld.getKeySet().remove(e.getKeyChar());
				itemView.setItemList(myWorld.getTrainer());
				itemView.repaint();
				
			}
		});
		gameFrame.setFocusable(true);
		
		
		
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameFrame.revalidate();
		gameFrame.repaint();
		gameFrame.setResizable(false);
	}
	

}

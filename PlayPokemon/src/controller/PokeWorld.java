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
import java.io.File;
import java.io.IOException;
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
		
		
		// setting up Pokemon game
		JFrame gameFrame = new JFrame("Pokémon: " + trainerName);
		gameFrame.setSize(998,689);
		gameFrame.setLayout(new GridLayout(2,3));
		World myWorld = new World(trainerName,mapChoice);
		ItemView itemView = new ItemView(myWorld.getTrainer(), myWorld.getMapView(), myWorld.getKeySet()); // list of items by making new ItemView
		JList itemList = new JList(myWorld.getTrainer().getItemList()); // hardcoding list of items
		PokemonCaptureView capturedList = new PokemonCaptureView(myWorld.getTrainer());
		PokeBattle battle = new PokeBattle(myWorld.getTrainer(),myWorld.getMapView().getPokemon());
		PokeText pokeText = new PokeText(battle);
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
//					System.out.println(myWorld.getMapView().getTrainer().getCaughtList().toString());
					capturedList.setPokemonList(myWorld.getMapView().getTrainer().getCaughtList());
//					capturedList.repaint();
					System.out.println(capturedList.toStrings());
//					battle = new PokeBattle(myWorld.getTrainer(),battleScene.getMap().getPokemon());
//					myWorld.setEnabled(false);
//					System.out.println(myWorld.getMapView().getState());
//					System.out.println(battleScene.getVisibility());
//					battleScene.setVisibility(true);
//					battleScene.repaint();
//					pokeText.updateText(battleScene.getPokeBattle().getPokemon().getName());
//					pokeText.repaint();
//					System.out.println(battleScene.getVisibility());
				}
				
					
				else{
					
					battleScene.setVisibility(false);
					battleScene.setVisible(false);
					myWorld.getMapView().setState(true);
//				if(myWorld.getMapView().getEncounter() == false){
					myWorld.getKeySet().add(e.getKeyChar());
//					myWorld.getItemList().setVisible(true);
					myWorld.getMapView().setState(true);
					itemView.setItemList(myWorld.getTrainer());
//					itemView.repaint();
					capturedList.setPokemonList(myWorld.getMapView().getTrainer().getCaughtList());
//				}
					
				}
//					myWorld.getMapView().setState(true);
//					myWorld.setEnabled(myWorld.getMapView().getState());
			}
			@Override
			public void keyReleased(KeyEvent e) {
				myWorld.getKeySet().remove(e.getKeyChar());
//				myWorld.getItemList().setVisible(false);
				itemView.setItemList(myWorld.getTrainer());
				itemView.repaint();
			}
		});
		gameFrame.setFocusable(true);
		
		
		
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		gameFrame.revalidate();
		gameFrame.repaint();
		gameFrame.setResizable(false);
	}
	




}

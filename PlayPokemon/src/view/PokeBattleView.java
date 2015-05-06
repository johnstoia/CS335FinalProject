package view;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.PokeBattle;
import model.Pokemon;

public class PokeBattleView extends JPanel{
	
	private PokeBattle battle;
	private BufferedImage trainerSprite = null;
	private Image pokeSprite;
	private MapView map;
	private boolean visibility;
	private PokeText pokeText;
	private String pokemonName;
	private int pokemonRarity;
	private JLabel name;
	private JLabel rarity;
	private PokemonCaptureView pokemonView;
	private ItemView itemView;
	
	public PokeBattleView(PokeBattle battle, MapView map,PokeText pokeText, PokemonCaptureView pokemonView, ItemView itemView){
		this.pokeText = pokeText;
		this.battle = battle;
		this.map = map;
		this.itemView = itemView;
		this.pokemonView = pokemonView;
		this.visibility = false;
		
		try {
			this.trainerSprite = ImageIO.read(new File("images/trainerBattleSprite.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.pokemonName = map.getPokemon().getName();
		this.pokemonRarity = map.getPokemon().getRarity();
		this.pokeSprite = map.getPokemon().getImage();
//				battle.getPokemon().getImage();
		
		JPanel pokePanel = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(pokeSprite,70,0,null);
		}};
		JPanel trainerPanel = new JPanel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(trainerSprite,-6,69,84,87,null);
		}};
	
		JPanel containerPanel = new JPanel();
	
		JPanel pokeName = new JPanel();
		JPanel buttons = new JPanel();
		
		JButton throwRock = new JButton("Throw Rock");
		throwRock.setFocusable(false);
		throwRock.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == throwRock) {
					pokeText.updateText("You throw a rock.");
					battle.throwRock();
					if(battle.getEndBattle() == true){
						pokeText.updateText("The Pokemon Ran Away!");
						map.setEncounter(false);
						battle.reset();
						try {
					        Robot robot = new Robot();

					        // Simulate a key press
					        robot.keyPress(KeyEvent.VK_A);
					        robot.keyRelease(KeyEvent.VK_A);

					} catch (AWTException g) {
					        g.printStackTrace();
					}
					}
//					repaint();
				}
			}		
		});
		JButton throwBait = new JButton("Throw Bait");
		throwBait.setFocusable(false);
		throwBait.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == throwBait) {
					pokeText.updateText("You throw some bait...nom nom nom.");
					battle.throwBait();
					if(battle.getEndBattle() == true){
						pokeText.updateText("The Pokemon Ran Away!");
						map.setEncounter(false);
						battle.reset();
						try {
					        Robot robot = new Robot();

					        // Simulate a key press
					        robot.keyPress(KeyEvent.VK_A);
					        robot.keyRelease(KeyEvent.VK_A);

					} catch (AWTException g) {
					        g.printStackTrace();
					}

					}
					
//					repaint();
				}
			}		
		});
		JButton safariBall = new JButton("Safari Ball");
		safariBall.setFocusable(false);
		safariBall.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == safariBall) {
					if(map.getTrainer().getSafari().getQuantity() <= 0){
						pokeText.updateText("You Have No More Safari Balls!");
					}else if(map.getTrainer().getSafari().getQuantity() > 0){
						battle.throwSafariBall();
						map.getTrainer().getSafari().useItem();
						itemView.updateItemList(map.getTrainer());
//						System.out.println(map.getTrainer().getSafari().getQuantity());
					if(battle.getEndBattle() == false){
					pokeText.updateText("You throw a Safari Ball. But do not catch the Pokemon");
					}
					
					if((battle.getEndBattle() == true && battle.isCaught() == true)){
						
						pokeText.updateText("The Pokemon was Caught!");
//						pokemonView.addPokemon(battle.getPokemon());
						map.setEncounter(false);
						battle.reset();
						try {
					        Robot robot = new Robot();
					        
					        // Simulate a key press
					        robot.keyPress(KeyEvent.VK_A);
					        robot.keyRelease(KeyEvent.VK_A);

					} catch (AWTException g) {
					        g.printStackTrace();
					}
						
					} else if(battle.getEndBattle() == true && battle.isCaught() == false){
						pokeText.updateText("The Pokemon ran away..");
						map.setEncounter(false);
						battle.reset();
						try {
					        Robot robot = new Robot();

					        // Simulate a key press
					        robot.keyPress(KeyEvent.VK_A);
					        robot.keyRelease(KeyEvent.VK_A);

					} catch (AWTException g) {
					        g.printStackTrace();
					}

					}
//					repaint();
				}
				
				}
				
			}		
		});
		JButton run = new JButton("Run Away");
		run.setFocusable(false);
		run.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == run) {
					pokeText.updateText("You run away!");
					map.setEncounter(false);
					battle.reset();
					try {
				        Robot robot = new Robot();

				        // Simulate a key press
				        robot.keyPress(KeyEvent.VK_A);
				        robot.keyRelease(KeyEvent.VK_A);

				} catch (AWTException g) {
				        g.printStackTrace();
				}
					
				}
			}		
		});
		
		
		name = new JLabel(pokemonName);
		rarity = new JLabel("Rarity: "+ pokemonRarity);
		name.setFont(new Font("Arial", Font.BOLD, 20));
		pokeName.setLayout(new BoxLayout(pokeName, BoxLayout.PAGE_AXIS));
		pokeName.add(name);
		pokeName.add(rarity);
		buttons.setLayout(new GridLayout(2,2));
		throwRock.setFont(new Font("Arial", Font.PLAIN, 8));
		throwBait.setFont(new Font("Arial", Font.PLAIN, 9));
		safariBall.setFont(new Font("Arial", Font.PLAIN, 9));
		run.setFont(new Font("Arial", Font.PLAIN, 9));
		buttons.add(throwRock);
		buttons.add(throwBait);
		buttons.add(safariBall);
		buttons.add(run);
		
		
		setLayout(new GridLayout(2,2));
		setBackground(Color.cyan);
		throwRock.setBackground(Color.cyan);
		throwBait.setBackground(Color.cyan);
		safariBall.setBackground(Color.cyan);
		run.setBackground(Color.cyan);
		pokePanel.setOpaque(false);
		trainerPanel.setOpaque(false);
		pokeName.setOpaque(false);
		buttons.setOpaque(false);
		this.setOpaque(true);
		this.add(pokeName);
		this.add(pokePanel);
		this.add(trainerPanel);
		this.add(buttons);

		this.setFocusable(false);
		this.setVisible(visibility);
	}
	
	public void setImage(Pokemon pokemon) {
		pokeSprite = pokemon.getImage();
	}
	
	public void setPokemonName(String string) {
		pokemonName = string;
	}
	
	public void setPokemonRarity(int i) {
		pokemonRarity = i;
	}
	
	public MapView getMap() {
		return map;
	}
	
	public void setVisibility(boolean flag){
		visibility = flag;
	}
	
	public boolean getVisibility(){
		return visibility;
	}
	
	public PokeBattle getPokeBattle() {
		return battle;
	}
	
	public JLabel getLabelName(){
		return name;
	}
	
	public JLabel getLabelRarity(){
		return rarity;
	}
	
	

}

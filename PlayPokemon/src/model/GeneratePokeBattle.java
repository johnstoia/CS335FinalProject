package model;
import java.util.Random;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import objects.*;

public class GeneratePokeBattle {
	private Trainer trainer;
	private static Pokemon pokemon = null;
	
	public GeneratePokeBattle(Trainer trainer){
		this.trainer = trainer;
	}
	
	public void generatePokemon(){
		Random r = new Random();
		int low = 1;
		int high = 26;
		int randomNumber = r.nextInt(high-low) + low;
		Pokemon pokemon = null;
		
//		System.out.println(randomNumber);
		
		switch(randomNumber){
		case 1:
		case 2:
		case 3:
			pokemon = new Pokemon("Caterpie",1);
			break;
		case 4:
		case 5:
		case 6:
			pokemon = new Pokemon("Rattata",2);
			break;
		case 7:
		case 8:
		case 9:
			pokemon = new Pokemon("Zubat",3);
			break;
		case 10:
		case 11:
		case 12:
			pokemon = new Pokemon("Diglett",4);
			break;
		case 13:
		case 14:
		case 15:
			pokemon = new Pokemon("Geodude",5);
			break;
		case 16:
		case 17:
		case 18:
			pokemon = new Pokemon("Eevee",6);
			break;
		case 19:
		case 20:
		    pokemon = new Pokemon("Jeremyduck",7);
			break;
		case 21:
		case 22:
			pokemon = new Pokemon("Hassidoof",8);
			break;
		case 23:
		case 24:
			pokemon = new Pokemon("Gregachu",9);
			break;
		case 25:
			pokemon = new Pokemon("Snodgrass",10);
			break;
		default:
			break;
		}
		
		this.pokemon = pokemon;	
		}
	
	public Pokemon getPokemon(){
		return pokemon;
	}
		
/*	public static void main(String[] args){
		Trainer x = new Trainer(10,10,"x");
		GeneratePokeBattle y = new GeneratePokeBattle(x);
		y.generatePokemon();
		System.out.println(y.getPokemon().getName());
		System.out.println(y.getPokemon().getRarity());
		
		Graphics g;
		JPanel panel = new JPanel(){
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(y.getPokemon().getImage(),0,0,300,400,null);
		}};
		
		JFrame xx = new JFrame();
		xx.setSize(new Dimension(300,450));
		xx.add(panel);
		xx.setVisible(true);
		}
	*/
	}


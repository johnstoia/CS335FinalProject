package view;

import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;

import model.Pokemon;
import objects.Trainer;

public class PokemonCaptureView extends JPanel {
	
	private Trainer trainer;
	private String[] pokemonList;
	private JList<String> list;
	
	public PokemonCaptureView(Trainer trainer) {
		this.trainer = trainer;
		System.out.println(trainer.getCaughtList().size());
		pokemonList = new String[trainer.getCaughtList().size()];
		setPokemonList(trainer.getCaughtList());
		list = new JList<String>(pokemonList);
		this.add(list);
	}
	
	public void setPokemonList(ArrayList<Pokemon> pokemon) {
		if(pokemonList.length == 0) {
			throw new RuntimeException("You have not caught any Pokemon.");
		}
		else {
			for(int i = 0; i < trainer.getCaughtList().size(); i++) {
				pokemonList[i] = trainer.getCaughtList().get(i).getName();
			}
		}
	}
	
}

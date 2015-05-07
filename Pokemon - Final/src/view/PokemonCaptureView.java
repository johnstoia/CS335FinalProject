package view;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.Pokemon;
import objects.Trainer;

public class PokemonCaptureView extends JPanel {
	
	private Trainer trainer;
	private String[] pokemonList;
	private JList<String> list;
	private JScrollPane scrollList;
	
	public PokemonCaptureView(Trainer trainer) {
		this.trainer = trainer;
		pokemonList = new String[1];
		setPokemonList(trainer.getCaughtList());
		list = new JList<String>(pokemonList);
		list.setFont(new Font(null, Font.PLAIN, 20));
		list.setFocusable(false);
		list.setAutoscrolls(true);
		scrollList = new JScrollPane(list);
		scrollList.setPreferredSize(new Dimension(230,310));
		this.add(scrollList);
	}
	
	/**
	 * Description: 
	 *
	 * SetPokemonList Constructor 
	 * makes the list of pokemon and the ones captured. 
	 * and set the view of the captured pokemon
	 * 
	 * 
	 * @param pokemon
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public void setPokemonList(ArrayList<Pokemon> pokemon) {
		if(pokemon.size() == 0) {
			return;
		}
		else {
			String[] temp = new String[pokemon.size()];
			for(int i = 0; i < pokemon.size(); i++) {
				temp[i] = pokemon.get(i).getName() + "(Rarity: " + pokemon.get(i).getRarity() + ")";
			}
			temp[pokemon.size()-1] = pokemon.get(pokemon.size()-1).getName() + "(Rarity: " + pokemon.get(pokemon.size()-1).getRarity() + ")";
			pokemonList = temp;
			list.setListData(pokemonList);
		}
	}
	
	/**
	 * Description: 
	 *
	 * 
	 * @return String[]
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public String[] getPokemonList() {
		return pokemonList;
	}	
	
	public String toStrings(){
		String toString = "";
		for(int i = 0; i < pokemonList.length; i++){
			toString += pokemonList[i] + "\n";
		}
		return toString;
	}
}

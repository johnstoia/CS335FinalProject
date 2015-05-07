package view;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.PokeBattle;

public class PokeText extends JPanel {
	
	private String text;
	private JLabel labelText;
	
	/**
	 * Description: 
	 *
	 * List of what is happening in the battle. 
	 * Threw rock, Threw pokeball ect
	 *  
	 * @param battle
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public PokeText(PokeBattle battle){
		this.setPreferredSize(new Dimension(369,374));
		this.text = battle.getTextString();
		labelText = new JLabel(text);
		this.add(labelText);
	}
	/**
	 * Description: 
	 *
	 * updates the text in the text panel
	 * 
	 * @param toUpdate the string 
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public void updateText(String toUpdate) {
		text = toUpdate;
		labelText.setText(text);
	}
	
	/**
	 * Description: 
	 *
	 * gets the text to be placed in the txt panel
	 * 
	 * @return text getter 
	 * @author Ryan Ressler, Abdul Hammed 	 
	 */
	
	public String getText(){
		return text;
	}

}

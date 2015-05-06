package view;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.PokeBattle;

public class PokeText extends JPanel {
	
	private String text;
	private JLabel labelText;
	
	public PokeText(PokeBattle battle){
		this.setPreferredSize(new Dimension(369,374));
		this.text = battle.getTextString();
		labelText = new JLabel(text);
		this.add(labelText);
	}
	
	public void updateText(String toUpdate) {
		text = toUpdate;
		labelText.setText(text);
	}
	
	public String getText(){
		return text;
	}

}

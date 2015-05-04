package model;
import java.awt.Component;
import javax.swing.*;
import objects.*;


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
		String trainerName = null;
		
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
		
		World myWorld = new World(trainerName,mapChoice,winChoice);
	}
	




}

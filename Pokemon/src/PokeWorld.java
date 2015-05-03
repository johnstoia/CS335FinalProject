import java.awt.Component;
import javax.swing.*;

public class PokeWorld {
	public static void main(String args[]) throws RuntimeException{
		
		Object[] options = {"Beat the NPC's",
                "Catch \"Snodgrass\"",
                };
		
		Object[] options1 = {"Map 1",
                "Map 2",
                };
		
		Component frame = null;
		
		int x = -1;
		int n = -1;
		String trainerName = null;
		
		trainerName = JOptionPane.showInputDialog(null,"Trainer Name"); 
		
		
			 x = JOptionPane.showOptionDialog(frame,
					"Please Choose a Map",
					"Map",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options1,
					options1[1]);
			
			
		
		
		n = JOptionPane.showOptionDialog(frame,
				"Please Choose a Win Condition",
				"Win Condition",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[1]);
		
		if(x == -1 || n == -1){
			throw new RuntimeException("You must pick an option from each prompt!");
		}
		
		Trainer trainer = new Trainer(trainerName);
	}
	




}

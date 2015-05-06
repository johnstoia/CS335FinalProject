package view;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.PokeBattle;
import objects.Trainer;

public class ItemView extends JPanel{

	private static final long serialVersionUID = 1L;
	private String[] itemList;
	private Trainer trainer;
	private MapView map;
	private JList<String> items;
	private JButton useItem;
	private int index;
	private ListSelectionListener selectionListener;
//	private KeyListener[] key;
	private TreeSet<Character> treeSet;
	private PokeText pokeText;
	private PokeBattle battle;
	
	public ItemView(Trainer trainer, MapView map, PokeText pokeText, PokeBattle battle, TreeSet<Character> treeSet) {
//		this.setPreferredSize(new Dimension(300,300));
		this.setLayout(new BorderLayout());
		this.trainer = trainer;
		this.map = map;
		this.pokeText = pokeText;
		this.battle = battle;
		this.itemList = new String[4];
		setItemList(this.trainer);
		this.items = new JList<String>(itemList);
		this.add(items,BorderLayout.CENTER);
		items.setFocusable(false);
		this.treeSet = treeSet;
		
		selectionListener = new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent f) {
				if(f.getSource() == items){
					index = items.getSelectedIndex();
//					System.out.println(items.getSelectedIndex());
				}
				
			}
			
		}; 
		items.addListSelectionListener(selectionListener);
//		items.addListSelectionListener(new ListSelectionListener(){
//			@Override
//			public void valueChanged(ListSelectionEvent f) {
//				if(f.getSource() == items){
//					index = items.getSelectedIndex();
////					System.out.println(items.getSelectedIndex());
//				}
//				
//			}
//			
//		});
		
		
		useItem = new JButton("Use Item");
		useItem.setFocusable(false);
		useItem.requestFocusInWindow();
		this.add(useItem,BorderLayout.SOUTH);
		useItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == useItem & items.getSelectedIndex() >= 0 & items.getSelectedIndex() < itemList.length){
//					map.setState(false);
					if(itemList[items.getSelectedIndex()].contains(trainer.getShoes().getItemName()) & map.getState() == true) {
						if(trainer.getShoes().getQuantity() > 0){
							trainer.getShoes().useItem();
							map.addSteps(50);
						}
						else{
							treeSet.clear();
							JOptionPane.showMessageDialog(null, "Professor Snodgrass says you do not have enough of that!", "No Item!", JOptionPane.PLAIN_MESSAGE);
						}
					}
					else if(itemList[items.getSelectedIndex()].contains(trainer.getDart().getItemName()) & map.getState() == false){
						if(trainer.getDart().getQuantity() > 0){
							pokeText.updateText("The Pokemon Is Now Asleep!");
							battle.useSleepDart();
						}
						else{
							pokeText.updateText("You Have No More Sleeping Darts!");
						}
						
						
						
					}
					else if(itemList[items.getSelectedIndex()].contains(trainer.getMaster().getItemName()) & map.getState() == false) {
						if(trainer.getMaster().getQuantity() <= 0){
							pokeText.updateText("You Have No More Master Balls!");
						}
						else if(trainer.getMaster().getQuantity() > 0){
							battle.useMasterBall();
							trainer.getMaster().useItem();
							if(battle.getEndBattle() == true & battle.isCaught() == true){
								pokeText.updateText("The Pokemon was Caught!");
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
					}
					else{
						treeSet.clear();
						JOptionPane.showMessageDialog(null, "Professor Snodgrass says now's not the time to use that!", "Can't Use!", JOptionPane.PLAIN_MESSAGE);
						
					}
				}
//				map.setState(true);
				setItemList(trainer);
				repaint();
			}
			
		});
		
	}
	
	public void updateItemList(Trainer trainer){
		itemList[3] = "Master Balls: " + trainer.getMaster().getQuantity();
		itemList[2] = "Safari Balls: " + trainer.getSafari().getQuantity();
		itemList[1] = "Running Shoes: " + trainer.getShoes().getQuantity();
		itemList[0] = "Sleeping Darts: " + trainer.getDart().getQuantity();
		items.setListData(itemList);
//		items.setListData(this.itemList);
	}
	
	public void setItemList(Trainer trainer) {
		itemList[3] = "Master Balls: " + trainer.getMaster().getQuantity();
		itemList[2] = "Safari Balls: " + trainer.getSafari().getQuantity();
		itemList[1] = "Running Shoes: " + trainer.getShoes().getQuantity();
		itemList[0] = "Sleeping Darts: " + trainer.getDart().getQuantity();
//		updateItemList(itemList);
	}
	
}

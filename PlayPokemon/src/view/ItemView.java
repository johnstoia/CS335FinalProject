package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
	
	public ItemView(Trainer trainer, MapView map, TreeSet<Character> treeSet) {
//		this.setPreferredSize(new Dimension(300,300));
		this.setLayout(new BorderLayout());
		this.trainer = trainer;
		this.map = map;
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
						
						trainer.getDart().useItem();
						
					}
					else if(itemList[items.getSelectedIndex()].contains(trainer.getMaster().getItemName()) & map.getState() == false) {
						trainer.getMaster().useItem();
						
					}
					
//					System.out.println(itemList[index] + " " + trainer.getDart().useItem() + " " + itemList[index]);
//					System.out.println(itemList[index])
					else{
//						JOptionPane message = new JOptionPane();
//						message.setFocusable(false);
//						requestFocusInWindow();
//						JPanel msgPanel = new JPanel(new BorderLayout());
//						msgPanel.add(new JLabel("You do not have enough " + itemList[items.getSelectedIndex()]));
//						msgPanel.setFocusable(false);
//						msgPanel.requestFocusInWindow();
//						map.setState(false);
						treeSet.clear();
						JOptionPane.showMessageDialog(null, "Professor Snodgrass says now's not the time to use that!", "Can't Use!", JOptionPane.PLAIN_MESSAGE);
						
					}
				}
//				map.setState(true);
				setItemList(trainer);
				repaint();
				
				
				
				System.out.println(itemList[items.getSelectedIndex()]);
				System.out.println(trainer.getShoes().getQuantity());
				System.out.println(map.getSteps());
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

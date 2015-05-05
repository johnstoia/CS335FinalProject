package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import objects.Trainer;

public class ItemView extends JPanel{

	private static final long serialVersionUID = 1L;
	private String[] itemList;
	private Trainer trainer;
	private JList<String> items;
	private JButton useItem;
	private int index;
	private ListSelectionListener selectionListener;
//	private KeyListener[] key;
	
	public ItemView(Trainer trainer) {
//		this.setPreferredSize(new Dimension(300,300));
		this.setLayout(new BorderLayout());
		this.trainer = trainer;
		
		this.itemList = new String[4];
		setItemList(this.trainer);
		this.items = new JList<String>(itemList);
		this.add(items,BorderLayout.CENTER);
		
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
		this.add(useItem,BorderLayout.SOUTH);
		useItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == useItem){
					System.out.println(itemList[items.getSelectedIndex()]);
//					System.out.println(itemList[index] + " " + trainer.getDart().useItem() + " " + itemList[index]);
//					System.out.println(itemList[index])
				}
			}
		});
		
	}
	
	public void updateItemList(String[] itemList){
		this.itemList = itemList;
//		items.setListData(this.itemList);
	}
	
	public void setItemList(Trainer trainer) {
		itemList[3] = "Master Balls: " + trainer.getMaster().getQuantity();
		itemList[2] = "Safari Balls: " + trainer.getSafari().getQuantity();
		itemList[1] = "Running Shoes: " + trainer.getShoes().getQuantity();
		itemList[0] = "Sleeping Darts: " + trainer.getDart().getQuantity();
		updateItemList(itemList);
	}
	
}

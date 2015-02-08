package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.BookController;
import controller.EarningsController;
import utilities.GUIUtilities;

public class EconomyGUI {

	private final String[] names = {"Totale libri venduti", "Totali in negozio", "Totale guadagnato", "Totale speso", "Totale fatturato"};
	private final JButton[] buttons = new JButton[names.length];
	private final JPanel main = new JPanel();
	private final JLabel[] labels = new JLabel[names.length];
	
	public EconomyGUI(BookController controller, EarningsController earcontroller){
		
		main.setLayout(new BorderLayout());
		
		final JPanel mid = new JPanel(new GridLayout(0,2));
		
		
		for (int i = 0; i < names.length; i++ ){
			labels[i] = new JLabel(names[i]);
		}
		
	//	for (int i = 0; i < names.length; i++){
		//	mid.add(GUIUtilities.wrapperPanel(new JLabel(names[i]),FlowLayout.RIGHT));
		//}
		
		mid.add(GUIUtilities.wrapperPanel(new JLabel(names[0]),FlowLayout.RIGHT));
		mid.add(GUIUtilities.wrapperPanel(new JLabel("" + earcontroller.bookSold(controller.bookList()) + "€"),FlowLayout.CENTER));
	
		mid.add(GUIUtilities.wrapperPanel(new JLabel(names[1]),FlowLayout.RIGHT));
		mid.add(GUIUtilities.wrapperPanel(new JLabel("" + earcontroller.bookInStore(controller.bookList()) + "€"),FlowLayout.CENTER));
	
		
		mid.add(GUIUtilities.wrapperPanel(new JLabel(names[2]),FlowLayout.RIGHT));
		mid.add(GUIUtilities.wrapperPanel(new JLabel("" + earcontroller.totSell(controller.bookList()) + "€"),FlowLayout.CENTER));
			
		
		mid.add(GUIUtilities.wrapperPanel(new JLabel(names[3]),FlowLayout.RIGHT));
		mid.add(GUIUtilities.wrapperPanel(new JLabel("" + earcontroller.totSpent(controller.bookList()) + "€"),FlowLayout.CENTER));
		
		
		mid.add(GUIUtilities.wrapperPanel(new JLabel(names[4]),FlowLayout.RIGHT));
		mid.add(GUIUtilities.wrapperPanel(new JLabel("" + earcontroller.totEarnings(controller.bookList()) + "€"),FlowLayout.CENTER));
		
		
		main.add(mid, BorderLayout.CENTER);
		
	
	}
	
	public JPanel getPane(){
		return this.main;
	}
}

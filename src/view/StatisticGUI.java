package view;

import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JPanel;

import utilities.GUIUtilities;

public class StatisticGUI {
	
	private final JButton[] buttons = new JButton[5];
	private final String[] names = {"Più venduto", "Meno venduto", "Fatturato", "", "Lista dei libri"};
	private final JButton chiudi = new JButton("Chiudi");
	private final JPanel main = new JPanel();

	
	public StatisticGUI(){
		
		GridBagConstraints c = GUIUtilities.getConstr();
	}
	
	
}

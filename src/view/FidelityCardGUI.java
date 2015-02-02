package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import utilities.GUIUtilities;

public class FidelityCardGUI {
	
	private final JButton[] buttons = new JButton[5];
	private final String[] names = {"Aggiungi una carta", "Rimuovi una carta", "Modifica una carta", "Ricerca una carta", "Lista delle carte"};
	
	private final JPanel main = new JPanel();
	
	
	public FidelityCardGUI(){
		
		main.setLayout(new BorderLayout());
	    final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    final int x = (dim.width )/4;
	    final int y = (dim.height)/3;
	    main.setSize(x, y);
	    main.setLocation(x, y);	
		
		
		
		final JPanel top = new JPanel();
		top.setLayout(new GridBagLayout());
		GridBagConstraints c = GUIUtilities.getConstr();
		
		for (int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton(names[i]);
			buttons[i].setPreferredSize(new Dimension(150,25));
			top.add(buttons[i], c);
			c.gridy++;
			
		}
		
		top.setBorder(new TitledBorder("Gestione Carta Soci"));
		
		final JPanel comandi = new JPanel(new FlowLayout());
		comandi.add(top);
		final JPanel bot = new JPanel(new FlowLayout());
		bot.add(GUIUtilities.getClosing());
		
		main.add(comandi, BorderLayout.CENTER);
		main.add(bot, BorderLayout.SOUTH);
		
				
	}
	
	public JPanel getPane(){
		return this.main;
	}
	
	

}

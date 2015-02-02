package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import utilities.GUIUtilities;
/**
 * 
 * @author Alberto Mulazzani
 *
 */
public class OrdGUI {
	
	
	private final JButton[] buttons = new JButton[5];
	private final String[] names = {"Aggiungi un ordine", "Rimuovi un ordine", "Modifica un ordine", "Ricerca un ordine", "Lista degli Ordini"};
	private final JPanel main = new JPanel();
	
	public OrdGUI(){
		
		
		main.setLayout(new BorderLayout());
	    
		final JPanel top = new JPanel();
		top.setLayout(new GridBagLayout());
		top.setBorder(new TitledBorder("Gestione Ordini"));
		GridBagConstraints c = GUIUtilities.getConstr();

		
		for (int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton(names[i]);
			buttons[i].setPreferredSize(new Dimension(150,25));
			top.add(buttons[i], c);
			c.gridy++;
		}
		
		final JPanel topExt = new JPanel(new FlowLayout());
		topExt.add(top);

		
		main.add(topExt, BorderLayout.NORTH);
		
		final JPanel bot = new JPanel(new FlowLayout());
		bot.add(GUIUtilities.getClosing());
		main.add(bot, BorderLayout.SOUTH);
		
	}

	public JPanel getPane() {
		return this.main;
	}
	
	
	
	
	
}

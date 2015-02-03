package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.BookController;
import utilities.GUIUtilities;
/**
 * 
 * @author Alberto Mulazzani
 *
 */
public class FidelityCardGUI {
	
	private final JButton[] buttons = new JButton[5];
	private final String[] names = {"Aggiungi una carta", "Rimuovi una carta", "Modifica una carta", "Ricerca una carta", "Lista delle carte"};
	
	private final JPanel main = new JPanel();
	
	
	public FidelityCardGUI(BookController controller){
		
		main.setLayout(new BorderLayout());
		
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

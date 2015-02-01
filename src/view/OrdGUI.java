package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class OrdGUI {
	
	
	private JButton[] buttons = new JButton[5];
	private String[] names = {"Aggiungi un ordine", "Rimuovi un ordine", "Modifica un ordine", "Ricerca un ordine", "Lista degli Ordini"};
	private JButton chiudi = new JButton("Chiudi");
	private String nomeAzienda;
	private JPanel main = new JPanel();
	
	public OrdGUI(String nomeAziendaR){
		
		this.nomeAzienda = nomeAziendaR;
		
		main.setLayout(new BorderLayout());
		
	    final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    final int x = (dim.width )/4;
	    final int y = (dim.height)/3;
	    main.setSize(x, y);
	    main.setLocation(x, y);
	    
		final JPanel top = new JPanel();
		top.setLayout(new GridBagLayout());
		top.setBorder(new TitledBorder("Ordini di " + nomeAzienda));
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = 0;
		c.insets = new Insets(3,3,3,3);
		c.fill = GridBagConstraints.HORIZONTAL;
		
		for (int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton(names[i]);
		}
		
		for (int i = 0; i < buttons.length; i++){
			top.add(buttons[i], c);
			c.gridy++;
		}
		
		final JPanel topExt = new JPanel(new FlowLayout());
		topExt.add(top);
		
		
		
		
		
		
		main.add(topExt, BorderLayout.NORTH);
		
		JPanel bot = new JPanel(new FlowLayout());
		bot.add(chiudi);
		main.add(bot, BorderLayout.SOUTH);
		
		
		
		
		
	}

	public JPanel getPane() {
		return this.main;
	}
	
	
	
	
	
}

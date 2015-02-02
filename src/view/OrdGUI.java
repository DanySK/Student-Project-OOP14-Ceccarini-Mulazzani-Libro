package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class OrdGUI {
	
	
	private final JButton[] buttons = new JButton[5];
	private final String[] names = {"Aggiungi un ordine", "Rimuovi un ordine", "Modifica un ordine", "Ricerca un ordine", "Lista degli Ordini"};
	private final JButton chiudi = new JButton("Chiudi");
	private final JPanel main = new JPanel();
	
	public OrdGUI(){
		
		
		main.setLayout(new BorderLayout());
		
	    final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    final int x = (dim.width )/4;
	    final int y = (dim.height)/3;
	    main.setSize(x, y);
	    main.setLocation(x, y);
	    
		final JPanel top = new JPanel();
		top.setLayout(new GridBagLayout());
		top.setBorder(new TitledBorder("Gestione Ordini"));
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = 0;
		c.insets = new Insets(3,3,7,3);
		c.fill = GridBagConstraints.HORIZONTAL;
		
		for (int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton(names[i]);
			buttons[i].setPreferredSize(new Dimension(150,25));
		}
		
		for (int i = 0; i < buttons.length; i++){
			top.add(buttons[i], c);
			c.gridy++;
		}
		
		final JPanel topExt = new JPanel(new FlowLayout());
		topExt.add(top);
		
		
		
		
		
		
		main.add(topExt, BorderLayout.NORTH);
		
		final JPanel bot = new JPanel(new FlowLayout());
		bot.add(chiudi);
		main.add(bot, BorderLayout.SOUTH);
		
		
		chiudi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		
	}

	public JPanel getPane() {
		return this.main;
	}
	
	
	
	
	
}

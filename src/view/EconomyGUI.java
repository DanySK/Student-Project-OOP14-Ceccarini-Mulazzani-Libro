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

import controller.BookController;
import utilities.GUIUtilities;

public class EconomyGUI {

	private final String[] names = {"Totale libri venduti", "Totale guadagnato", "Totale speso", "Totale fatturato"};
	private final JButton[] buttons = new JButton[names.length];
	private final JPanel main = new JPanel();

	
	public EconomyGUI(BookController controller){
		
		main.setLayout(new BorderLayout());
		
	    final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    final int x = (dim.width )/4;
	    final int y = (dim.height)/3;
	    main.setSize(x, y);
	    main.setLocation(x, y);
	    
		final JPanel top = new JPanel();
		top.setLayout(new GridBagLayout());
		top.setBorder(new TitledBorder("Fatturato e Guadagni"));
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
	
	public JPanel getPane(){
		return this.main;
	}
}

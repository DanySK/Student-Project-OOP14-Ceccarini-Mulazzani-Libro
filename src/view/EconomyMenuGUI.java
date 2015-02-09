package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.BookController;
import controller.EarningsController;
import utilities.GUIUtilities;

public class EconomyMenuGUI {

	private final JPanel main = new JPanel();
	private final JButton open = new JButton("Apri la sezione Economia");
	
	
	public EconomyMenuGUI(BookController controller, EarningsController earcontroller){
		
		main.setLayout(new BorderLayout());
		
		final JPanel top = new JPanel();
		top.setLayout(new GridBagLayout());
		GridBagConstraints c = GUIUtilities.getConstr();
		
		
		top.add(open, c);
		
		top.setBorder(new TitledBorder("Gestione Fatturato e Guadagni"));
		
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

package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.BookController;
import controller.EarningsController;
import utilities.GUIUtilities;

public class EconomyMenuGUI {

	private final BackgroundPanel main = new BackgroundPanel(GUIUtilities.back);
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
		
		
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				JOptionPane.showOptionDialog(main, new EconomyGUI(controller, earcontroller).getPane() , "Fatturato e Guadagni", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, GUIUtilities.icon, GUIUtilities.string, null);
			
			}
		});
		
		
	}
	
	
	public JPanel getPane(){
		return this.main;
	}
}

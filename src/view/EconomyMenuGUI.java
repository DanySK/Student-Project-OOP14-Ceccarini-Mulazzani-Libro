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

import model.IEarnings;
import utilities.GUIUtilities;
import controller.IBookController;
/**
 * 
 * @author Alberto Mulazzani
 *
 */
public class EconomyMenuGUI {

	private final BackgroundPanel main = new BackgroundPanel(GUIUtilities.getBackground());
	private final JButton open = new JButton("Apri la sezione Economia");
	
	/**
	 * 
	 * @param controller is the BookController
	 * @param earcontroller is the EarningsController
	 */
	public EconomyMenuGUI(final IBookController controller, final IEarnings earcontroller) {
		
		main.setLayout(new BorderLayout());
		
		final JPanel top = new JPanel();
		top.setLayout(new GridBagLayout());
		final GridBagConstraints c = GUIUtilities.getConstr();
		
		
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
			public void actionPerformed(final ActionEvent e) {
			
				JOptionPane.showOptionDialog(main, new EconomyGUI(controller, earcontroller).getPane() , "Fatturato e Guadagni", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, GUIUtilities.getCommonIcon(), GUIUtilities.STRING, null);
			
			}
		});
		
		
	}
	
	/**
	 * 
	 * @return the main panel of the GUI
	 */
	public JPanel getPane() {
		return this.main;
	}
}

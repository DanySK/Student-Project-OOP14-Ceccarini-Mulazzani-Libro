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

import utilities.GUIUtilities;
import controller.BookController;
/**
 * 
 * @author Alberto Mulazzani
 *
 */
public class OrdGUI {
	
	
	private final JButton[] buttons = new JButton[6];
	private final String[] names = {"Aggiungi un ordine", "Rimuovi un ordine", "Modifica un ordine", "Ricerca un ordine", "Lista degli Ordini", "Evadi gli ordini"};
	private final JPanel main = new JPanel();
	
	public OrdGUI(BookController controller){
		
		
		main.setLayout(new BorderLayout());
	    
		final JPanel top = new JPanel();
		top.setLayout(new GridBagLayout());
		top.setBorder(new TitledBorder("Gestione Ordini"));
		GridBagConstraints c = GUIUtilities.getConstr();

		
		for (int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton(names[i]);
			//buttons[i].setPreferredSize(new Dimension(150,25));
			top.add(buttons[i], c);
			c.gridy++;
		}
		
		final JPanel topExt = new JPanel(new FlowLayout());
		topExt.add(top);

		
		main.add(topExt, BorderLayout.NORTH);
		
		final JPanel bot = new JPanel(new FlowLayout());
		bot.add(GUIUtilities.getClosing());
		main.add(bot, BorderLayout.SOUTH);
		
		buttons[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				JOptionPane.showOptionDialog(main, new AddBookGUI(controller).getPane() , "Aggiungi un ordine", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, GUIUtilities.icon, GUIUtilities.string, null);
			
			}
		});
		
		buttons[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showOptionDialog(main, new RemoveOrderGUI(controller).getPane() , "Rimuovi un ordine", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, GUIUtilities.icon, GUIUtilities.string, null);
			
			}
		});
		
		buttons[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				JOptionPane.showOptionDialog(main, new SearchBookGUI(controller).getPane() , "Modifica un ordine", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, GUIUtilities.icon, GUIUtilities.string, null);
			
			}
		});
		
		
		
		buttons[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				JOptionPane.showOptionDialog(main, new SearchBookGUI(controller).getPane() , "Cerca un ordine", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, GUIUtilities.icon, GUIUtilities.string, null);
			
			}
		});
		
		buttons[4].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				JOptionPane.showOptionDialog(main, new ListTableGUI(controller.bookList(), false).getPane() , "Lista degli ordini", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, GUIUtilities.icon, GUIUtilities.string, null);
			
			}
		});
		
		
		
	}

	public JPanel getPane() {
		return this.main;
	}
	
	
	
	
	
}

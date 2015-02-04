package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import utilities.GUIUtilities;
import utilities.ControllerUtilities.TipoController;
/**
 * 
 * @author Alberto Mulazzani
 *
 */
public class OrdGUI {
	
	
	private final JButton[] buttons = new JButton[6];
	private final String[] names = {"Aggiungi un ordine", "Rimuovi un ordine", "Modifica un ordine", "Ricerca un ordine", "Lista degli Ordini", "Evadi gli ordini"};
	private final JPanel main = new JPanel();
	
	public OrdGUI(BookController controller, TipoController type){
		
		
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
				
				
				JOptionPane.showOptionDialog(main, new AddBookGUI(controller, type).getPane() , "Aggiungi un ordine", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, null, GUIUtilities.string, null);
			
			}
		});
		
		buttons[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showOptionDialog(main, new SearchBookGUI(controller, type).getPane() , "Vendi un libro", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, null, GUIUtilities.string, null);
			
			}
		});
		
		buttons[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				JOptionPane.showOptionDialog(main, new SearchBookGUI(controller, type).getPane() , "Modifica un libro", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, null, GUIUtilities.string, null);
			
			}
		});
		
		
		
		buttons[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				JOptionPane.showOptionDialog(main, new SearchBookGUI(controller, type).getPane() , "Cerca un libro", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, null, GUIUtilities.string, null);
			
			}
		});
		
		buttons[4].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				JOptionPane.showOptionDialog(main, new ListTableGUI(controller, type).getPane() , "Lista dei libri", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, null, GUIUtilities.string, null);
			
			}
		});
		
		
		
	}

	public JPanel getPane() {
		return this.main;
	}
	
	
	
	
	
}

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
import controller.StatisticsController;
import utilities.ControllerUtilities.TipoController;
import utilities.GUIUtilities;
/**
 * 
 * @author Alberto Mulazzani
 *
 */
public class StatisticGUI {
	
	private final JButton[] buttons = new JButton[4];
	private final String[] names = {"Libro più venduto", "Libro meno venduto", "Autore più attivo", "Autore meno attivo"};
	private final BackgroundPanel main = new BackgroundPanel(GUIUtilities.back);

	
	public StatisticGUI(final BookController controller, final StatisticsController statcontroller){
		
		main.setLayout(new BorderLayout());
	    
		final JPanel top = new JPanel();
		top.setLayout(new GridBagLayout());
		top.setBorder(new TitledBorder("Statistiche"));
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
		
		//Libro più venduto
		
		buttons[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(final ActionEvent e) {
				
				controller.setType(TipoController.MAGAZZINO);
				JOptionPane.showOptionDialog(main, new ListTableGUI(statcontroller.mostPopularBook(controller.bookList()), true).getPane() , "Lista dei libri più venduti", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, GUIUtilities.icon, GUIUtilities.STRING, null);
			
			}
		});
		
		//Libro meno venduto
		
		buttons[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(final ActionEvent e) {
				

				JOptionPane.showOptionDialog(main, new ListTableGUI(statcontroller.lessPopularBook(controller.bookList()),true).getPane() , "Lista dei libri meno venduti", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, GUIUtilities.icon, GUIUtilities.STRING, null);
			
			}
		});
		
		buttons[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(final ActionEvent e) {
				

				JOptionPane.showOptionDialog(main, new StatisticDetailGUI(statcontroller.mostActiveAuthor(controller.bookList())).getPane() , "Lista degli autori più attivi", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, GUIUtilities.icon, GUIUtilities.STRING, null);
					
			}
		});
		
		buttons[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(final ActionEvent e) {
				

				JOptionPane.showOptionDialog(main, new StatisticDetailGUI(statcontroller.lessActiveAuthor(controller.bookList())).getPane() , "Lista degli autori meno attivi", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, GUIUtilities.icon, GUIUtilities.STRING, null);
			
			}
		});
	}
	
	public JPanel getPane(){
		return this.main;
	}
	
}

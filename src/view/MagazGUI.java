package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
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


public class MagazGUI {

	private final JButton[] buttons = new JButton[5];
	private final String[] names = {"Aggiungi un libro", "Vendi un libro", "Modifica un libro", "Ricerca un libro", "Lista dei libri"};
	private final JPanel jf = new JPanel();
	//private final String filesep = System.getProperty("file.separator");
	
	
	
	public MagazGUI(BookController controller){	
		
	
		jf.setLayout(new BorderLayout());
	    final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    final int x = (dim.width )/4;
	    final int y = (dim.height)/3;
	    jf.setSize(x, y);
	    jf.setLocation(x, y);
	    

	//	ImageIcon icon = new ImageIcon("iconBook.png");
		
		final JPanel main = new JPanel();
		main.setLayout(new GridBagLayout());
		GridBagConstraints c = GUIUtilities.getConstr();
		
		for (int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton(names[i]);
			buttons[i].setPreferredSize(new Dimension(150,25));
			main.add(buttons[i], c);
			c.gridy++;
			
		}		
		
		final JPanel comandi = new JPanel(new FlowLayout());
		comandi.add(main);
		main.setBorder(new TitledBorder("Gestione Magazzino"));
		final JPanel main2 = new JPanel(new FlowLayout());
		main2.add(GUIUtilities.getClosing());
		
		jf.add(comandi, BorderLayout.CENTER);
		jf.add(main2, BorderLayout.SOUTH);
		
	
		//AGGIUNGI UN LIBRO 
		
		buttons[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				JOptionPane.showOptionDialog(jf, new AddBookGUI(controller).getPane() , "Aggiungi un libro", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, GUIUtilities.icon, GUIUtilities.string, null);
			
			}
		});
		
		//VENDI UN LIBRO
		
		buttons[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showOptionDialog(jf, new SellBookGUI(controller).getPane() , "Vendi un libro", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, GUIUtilities.icon, GUIUtilities.string, null);
			
			}
		});
		
		//MODIFICA UN LIBRO
		
		buttons[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				JOptionPane.showOptionDialog(jf, new SearchBookGUI(controller).getPane() , "Modifica un libro", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, GUIUtilities.icon, GUIUtilities.string, null);
			
			}
		});
		
		//CERCA UN LIBRO
		
		buttons[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				JOptionPane.showOptionDialog(jf, new SearchBookGUI(controller).getPane() , "Cerca un libro", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, GUIUtilities.icon, GUIUtilities.string, null);
			
			}
		});
		
		
		//LISTA DEI LIBRI 
		
		buttons[4].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				JOptionPane.showOptionDialog(jf, new ListTableGUI(controller.bookList()).getPane() , "Lista dei libri", JOptionPane.DEFAULT_OPTION, 
	                     JOptionPane.INFORMATION_MESSAGE, GUIUtilities.icon, GUIUtilities.string, null);
			
			}
		});
	

	}
	
	
	public JPanel getPane(){
		return this.jf;
	}
}

package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utilities.GUIUtilities;
import controller.BookController;
import exceptions.MissingBookException;

public class SearchBookGUI extends JDialog {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6224252338040945108L;
	private JTextField[] fields = new JTextField[2];
	private String[] names = {"Titolo", "Autore",};
	private JButton[] oks = new JButton[2];
	private final JPanel main = new JPanel();
	private JButton conf = new JButton("Cerca coppia");
	
	public SearchBookGUI(BookController controller) {
		
		
		main.setLayout(new BorderLayout());
		
		final JPanel mid = new JPanel(new GridLayout(0,3));
		
		for (int i = 0; i < fields.length; i++ ){
			fields[i] = new JTextField(15);
			oks[i] = new JButton("Ok");
		}
		
		
		
		for (int i = 0; i < fields.length; i++){
			mid.add(GUIUtilities.wrapperPanel(new JLabel(names[i]),FlowLayout.RIGHT));
			mid.add(GUIUtilities.wrapperPanel(fields[i],FlowLayout.CENTER));
			mid.add(GUIUtilities.wrapperPanel(oks[i], FlowLayout.LEFT));
		}
		
		main.add(mid, BorderLayout.CENTER);
		
		final JPanel bot = new JPanel(new FlowLayout());
		
		bot.add(conf);
		bot.add(GUIUtilities.getReset(fields));
		main.add(bot, BorderLayout.SOUTH);
		
		oks[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					JOptionPane.showOptionDialog(main, new ListTableGUI(controller.searchTitle(fields[0])).getPane() , "Ricerca titolo", JOptionPane.DEFAULT_OPTION, 
					         JOptionPane.INFORMATION_MESSAGE, GUIUtilities.icon, GUIUtilities.string, null);
				} catch (MissingBookException e1) {
					JOptionPane.showMessageDialog(main, "Il titolo non è presente", "Titolo mancante", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		oks[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					JOptionPane.showOptionDialog(main, new ListTableGUI(controller.searchAuthor(fields[1])).getPane() , "Ricerca autore", JOptionPane.DEFAULT_OPTION, 
					         JOptionPane.INFORMATION_MESSAGE, GUIUtilities.icon, GUIUtilities.string, null);
				} catch (MissingBookException e1) {
					JOptionPane.showMessageDialog(main, "L'Autore non è presente", "Autore mancante", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		conf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					JOptionPane.showOptionDialog(main, new BookDetailGUI(controller.searchBook(fields)).getPane() , "Ricerca libro", JOptionPane.DEFAULT_OPTION, 
					         JOptionPane.INFORMATION_MESSAGE, GUIUtilities.icon, GUIUtilities.string, null);
				} catch (MissingBookException e) {
					
					JOptionPane.showMessageDialog(main, "Il libro non è presente", "Libro mancante", JOptionPane.ERROR_MESSAGE);							
				}
			}
		});
		
	}
	
	public JPanel getPane(){
		return this.main;
	}
	
	

}

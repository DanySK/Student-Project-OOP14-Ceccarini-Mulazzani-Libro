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
import javax.swing.SwingUtilities;

import model.Libro;
import utilities.GUIUtilities;
import controller.BookController;
import exceptions.MissingBookException;
import exceptions.NotEnoughBookException;

public class SellBookGUI extends JDialog {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6224252338040945108L;
	private String[] names = {"Titolo", "Autore", "Copie", "Carta"};
	private JTextField[] fields = new JTextField[names.length];
	private final JPanel main = new JPanel();
	private JButton conf = new JButton("Conferma");
	private	Libro lib;
	
	public SellBookGUI(BookController controller) {
		
		main.setLayout(new BorderLayout());
		
		final JPanel mid = new JPanel(new GridLayout(0,2));
		
		for (int i = 0; i < fields.length; i++ ){
			fields[i] = new JTextField(20);
		}
		
		for (int i = 0; i < fields.length; i++){
			mid.add(GUIUtilities.wrapperPanel(new JLabel(names[i]),FlowLayout.RIGHT));
			mid.add(GUIUtilities.wrapperPanel(fields[i],FlowLayout.CENTER));

		}
		
		main.add(mid, BorderLayout.CENTER);
		
		final JPanel bot = new JPanel(new FlowLayout());
		
		bot.add(conf);
		bot.add(GUIUtilities.getReset(fields));
		main.add(bot, BorderLayout.SOUTH);
	
		
		conf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					lib = controller.searchBook(fields);
					controller.sellBook(lib, fields[2].getText());
					JOptionPane.showMessageDialog(main, "Il libro è stato venduto con successo!!", "Successo!!", JOptionPane.ERROR_MESSAGE);
					JOptionPane optionPane = (JOptionPane)
						    SwingUtilities.getAncestorOfClass(JOptionPane.class, conf);
						optionPane.setValue(JOptionPane.CLOSED_OPTION);
				} catch (MissingBookException e1) {
					JOptionPane.showMessageDialog(main, "Il libro non esiste in magazzino", "Il libro non esiste", JOptionPane.ERROR_MESSAGE);
				} catch (NotEnoughBookException e1) {
					JOptionPane.showMessageDialog(main, "Non sono presenti abbastanza copie in magazzino \n "
							+ "ne sono state richieste " + fields[2].getText() + ", ma ne sono presenti solo " + lib.getNCopy(), "Copie mancanti", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
	}
	
	public JPanel getPane(){
		return this.main;
	}
	
	
	
	

}

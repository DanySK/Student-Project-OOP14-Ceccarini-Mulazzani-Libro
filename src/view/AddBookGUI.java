package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import utilities.ControllerUtilities.TipoController;
import controller.BookController;
import exceptions.MissingDataException;
import exceptions.WrongDataException;

/**
 * 
 * @author Alberto Mulazzani
 *
 */
public class AddBookGUI extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JTextField[] fields = new JTextField[7];
	private final JButton add = new JButton("Conferma");
	private final JButton reset = new JButton("Reset");
	private final JPanel main = new JPanel();
	private final String[] names = {"Titolo", "Autore", "Anno di pubblicazione", "Editore", "ISBN", "Prezzo", "Quantità" };
	
	public AddBookGUI(BookController controller, TipoController type){
		
		main.setLayout(new BorderLayout());
		
		final JPanel bot = new JPanel(new FlowLayout());
		bot.add(reset);
		bot.add(add);
		main.add(bot, BorderLayout.SOUTH);
				
		
		final JPanel mid = new JPanel(new GridLayout(0,2));
		
		for (int i = 0; i < fields.length; i++ ){
			fields[i] = new JTextField(20);
		}
		
		for (int i = 0; i < fields.length; i++){
			mid.add(wrapperPanel(new JLabel(names[i]),FlowLayout.RIGHT));
			mid.add(wrapperPanel(fields[i],FlowLayout.CENTER));
		}
		
		
		main.add(mid, BorderLayout.CENTER);
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					controller.setFields(fields);

					JOptionPane.showMessageDialog(main, "Il libro è stato inserito correttamente", "Successo!", JOptionPane.INFORMATION_MESSAGE);
					controller.addBook();
					JOptionPane optionPane = (JOptionPane)
						    SwingUtilities.getAncestorOfClass(JOptionPane.class, reset);
						optionPane.setValue(JOptionPane.CLOSED_OPTION);
									
				} catch (MissingDataException e1) {
					JOptionPane.showMessageDialog(main, "Inserire tutti i dati richiesti", "Dati mancanti", JOptionPane.ERROR_MESSAGE);
				} catch (WrongDataException e1) {
					JOptionPane.showMessageDialog(main, "I dati inseriti non sono corretti, ricontrollare", "Dati Errati", JOptionPane.ERROR_MESSAGE);
					
				}			
			
			}
		});
		
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < fields.length; i++){
					fields[i].setText("");
				}
			}
		});
		
	}
	
	
	public JPanel getPane(){
		return this.main;
	}
	
	private static JPanel wrapperPanel(final JComponent component, final int orientation){
		final JPanel panel = new JPanel(new FlowLayout(orientation));
		panel.add(component);
		return panel;
	}

}

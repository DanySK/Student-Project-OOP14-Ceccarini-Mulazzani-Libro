package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.FidelityController;
import exceptions.MissingDataException;
import exceptions.UserAlreadyExisting;
import exceptions.WrongDataException;

/**
 * 
 * @author Alberto Mulazzani
 *
 */
public class AddPersonGUI {
	
	private final JTextField[] fields = new JTextField[3];
	private final String[] names = {"Nome", "Cognome", "Email"};
	private final JButton add = new JButton("Conferma");
	private final JButton reset = new JButton("Reset");
	private final JButton annulla = new JButton("Annulla");
	private final JPanel main = new JPanel();
	
	public AddPersonGUI(FidelityController controller){
		
		
		main.setLayout(new BorderLayout());
		//main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		main.setLayout(new BorderLayout());
		
		final JPanel bot = new JPanel(new FlowLayout());
		bot.add(reset);
		bot.add(add);
		bot.add(annulla);
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
		
		//main.setVisible(true);

		
		// Handler dei pulsanti
		
		//PULSANTE RESET
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(final ActionEvent e) {
				
				for (int i = 0; i < fields.length; i++){
					fields[i].setText("");
				}
			}
		});
		
		//PULSANTE CONFERMA
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
	
					controller.addPerson(fields);
					JOptionPane.showMessageDialog(main, "La carta è stata creata con successo", "Successo!", JOptionPane.INFORMATION_MESSAGE);
					
					JOptionPane optionPane = (JOptionPane)
						    SwingUtilities.getAncestorOfClass(JOptionPane.class, add);
						optionPane.setValue(JOptionPane.CLOSED_OPTION);
			
				} catch (UserAlreadyExisting e1) {
					JOptionPane.showMessageDialog(main, "L'utente è già presente", "Utente già presente", JOptionPane.ERROR_MESSAGE);
				} catch (MissingDataException e1) {
					JOptionPane.showMessageDialog(main, "Inserire tutti i dati richiesti", "Dati mancanti", JOptionPane.ERROR_MESSAGE);
				} catch (WrongDataException | NumberFormatException e1) {
					JOptionPane.showMessageDialog(main, "I dati inseriti non sono corretti, ricontrollare", "Dati Errati", JOptionPane.ERROR_MESSAGE);					
				}	
			}
		});
		
		
	}
	
	
	
	
	private static JPanel wrapperPanel(final JComponent component, final int orientation){
		final JPanel panel = new JPanel(new FlowLayout(orientation));
		panel.add(component);
		return  panel;
	}
	
	public JPanel getPane(){
		return main;
	}

}

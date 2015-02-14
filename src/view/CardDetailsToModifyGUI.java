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

import utilities.GUIUtilities;
import cartasoci.User;
import controller.FidelityController;
import exceptions.WrongDataException;
/**
 * 
 * @author Alberto Mulazzani
 *
 */
public class CardDetailsToModifyGUI	extends JDialog {
	
	
	private static final long serialVersionUID = -5294910808056208082L;
	private final JPanel main = new JPanel();
	private final String[] names = {"Nome","Cognome", "Email"};
	private final JTextField[] jfields = new JTextField[names.length];
	private final JButton conf = new JButton("Conferma");
	
	
	
	public CardDetailsToModifyGUI(FidelityController controller, User b){
		
		main.setLayout(new BorderLayout());
		
		final JPanel mid = new JPanel(new GridLayout(0,3));
		
		for (int i = 0; i < names.length; i++){
			jfields[i] = new JTextField(15);
		}
		
		mid.add(GUIUtilities.wrapperPanel(new JLabel(names[0]),FlowLayout.RIGHT));
		mid.add(GUIUtilities.wrapperPanel(new JLabel(b.getName()),FlowLayout.CENTER));
		mid.add(GUIUtilities.wrapperPanel(jfields[0], FlowLayout.RIGHT));
		
		
		mid.add(GUIUtilities.wrapperPanel(new JLabel(names[1]),FlowLayout.RIGHT));
		mid.add(GUIUtilities.wrapperPanel(new JLabel(b.getSurname()),FlowLayout.CENTER));
		mid.add(GUIUtilities.wrapperPanel(jfields[1], FlowLayout.RIGHT));	
		
		mid.add(GUIUtilities.wrapperPanel(new JLabel(names[2]),FlowLayout.RIGHT));
		mid.add(GUIUtilities.wrapperPanel(new JLabel(b.getEmail()),FlowLayout.CENTER));
		mid.add(GUIUtilities.wrapperPanel(jfields[2], FlowLayout.RIGHT));
				
		
		main.add(mid, BorderLayout.CENTER);
		
		
		final JPanel bot = new JPanel(new FlowLayout());
		
		bot.add(conf);
		bot.add(GUIUtilities.getReset(jfields));
		
		
		main.add(bot, BorderLayout.SOUTH);
		
		conf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.modifyUser(b, jfields);
					JOptionPane.showMessageDialog(main, "L'utente è stato modificato correttamente", "Successo!", JOptionPane.INFORMATION_MESSAGE);
					JOptionPane optionPane = (JOptionPane)
						    SwingUtilities.getAncestorOfClass(JOptionPane.class, conf);
						optionPane.setValue(JOptionPane.CLOSED_OPTION);
				} catch (WrongDataException e1) {
					
					JOptionPane.showMessageDialog(main, "I dati inseriti non sono corretti, ricontrollare", "Dati Errati", JOptionPane.ERROR_MESSAGE);				
				}
				
			}
		});
		
		
		
	}
	
	public JPanel getPane(){
		return this.main;
	}

}

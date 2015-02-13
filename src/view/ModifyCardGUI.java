package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import utilities.GUIUtilities;
import controller.FidelityController;
import exceptions.MissingUserException;
/**
 * 
 * @author Alberto Mulazzani
 *
 */
public class ModifyCardGUI {
	
	
	
	private JPanel main = new JPanel();
	private JButton conf = new JButton("Conferma");
	private JTextField[] fields = new JTextField[1];
	private String[] names = {"Identificativo"};
	
	public ModifyCardGUI(FidelityController controller){
		
		main.setLayout(new BorderLayout());
		
		final JPanel mid = new JPanel(new GridLayout(0,2));
		
		
		for (int i = 0; i < fields.length; i++ ){
			fields[i] = new JTextField(15);
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
			public void actionPerformed(ActionEvent arg0) {
				try {
					JOptionPane.showOptionDialog(main, new CardDetailsToModifyGUI(controller, controller.searchID(fields[0])).getPane() , "Modifica libro", JOptionPane.DEFAULT_OPTION, 
					         JOptionPane.INFORMATION_MESSAGE, GUIUtilities.icon, GUIUtilities.string, null);
					JOptionPane optionPane = (JOptionPane)
						    SwingUtilities.getAncestorOfClass(JOptionPane.class, conf);
						optionPane.setValue(JOptionPane.CLOSED_OPTION);
				} catch (MissingUserException e) {
					
					JOptionPane.showMessageDialog(main, "L'ID non è presente", "ID mancante", JOptionPane.ERROR_MESSAGE);							
				}
			}
		});
	}
	
	public JPanel getPane(){
		return this.main;
	}
	

}

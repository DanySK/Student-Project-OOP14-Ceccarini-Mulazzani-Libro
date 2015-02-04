package utilities;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.BookController;
/**
 * 
 * @author Alberto Mulazzani
 *
 */
public class GUIUtilities {

	public final static String[] string = {"Annulla"};
	
	
	public static GridBagConstraints getConstr(){
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = 0;
		c.insets = new Insets(3,3,7,3);
		c.fill = GridBagConstraints.HORIZONTAL;
		
		return c;
	}
	
	public static JButton getClosing(){
		final JButton chiudi = new JButton("Salva e Chiudi");
		chiudi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SaveClass.saveAll();
				System.exit(0);
			}
		});
		return chiudi;	
		
	}
	

	
	
	
}

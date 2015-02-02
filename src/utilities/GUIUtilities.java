package utilities;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

public class GUIUtilities {

	
	
	public static GridBagConstraints getConstr(){
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = 0;
		c.insets = new Insets(3,3,7,3);
		c.fill = GridBagConstraints.HORIZONTAL;
		
		return c;
	}
	
	public static JButton getClosing(){
		final JButton chiudi = new JButton("Chiudi");
		chiudi.addActionListener(e->System.exit(0));	
		return chiudi;	
		
	}
	
	
	
	
	
	
}

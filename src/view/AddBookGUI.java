package view;

import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class AddBookGUI {
	
	
	private static JPanel wrapperPanel(final JComponent component, final int orientation){
		final JPanel panel = new JPanel(new FlowLayout(orientation));
		panel.add(component);
		return  panel;
	}

}

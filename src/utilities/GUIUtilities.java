package utilities;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import view.MagazGUI;
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
				try {
					SaveClass.saveAll();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		return chiudi;	
		
	}
	
	public static ImageIcon icon = createImageIcon("/iconBook.png");
	
	private static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = MagazGUI.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find image file: " + path);
			return null;
		}
	}
	
}

package utilities;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * @author Alberto Mulazzani
 *
 */
public final class GUIUtilities {
	
	public final static String[] STRING = {"Annulla"};
	
	public static ImageIcon icon = createImageIcon("/iconBook.png");
	public static Image image = icon.getImage();
	private static ImageIcon icon2 = createImageIcon("/background.png");
	public static Image back = icon2.getImage();

	
	
	private GUIUtilities(){
		
	}

	
	public static GridBagConstraints getConstr(){
		final GridBagConstraints c = new GridBagConstraints();
		c.gridy = 0;
		c.insets = new Insets(3,3,7,3);
		c.fill = GridBagConstraints.HORIZONTAL;
		
		return c;
	}
	
	public static JButton getClosing(){
		final JButton chiudi = new JButton("Chiudi");
		chiudi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(final ActionEvent e) {
	     	    final String objButtons[] = {"Sì","No"};
        	    final int promptResult = JOptionPane.showOptionDialog(null, 
        	        "Sei sicuro di voler uscire? I dati non salvati saranno persi", "Sei proprio sicuro?", 
        	        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
        	        objButtons,objButtons[1]);
        	    if(promptResult==0)
        	    {
        	      System.exit(0);          
        	    }
			}
		});
		return chiudi;	
		
	}
	
	
	public static JButton getReset(final JTextField[] fields){
		final JButton reset = new JButton("Reset");
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(final ActionEvent e) {
				for (int i = 0; i < fields.length; i++){
					fields[i].setText("");
				}
			}
		});
		
		return reset;
	}
	
	
	private static ImageIcon createImageIcon(final String path) {
		final java.net.URL imgURL = GUIUtilities.class.getResource(path);

		if (imgURL == null) {
			System.err.println("Couldn't find image file: " + path);
			return null;

		} else {
			return new ImageIcon(imgURL);
		}
	}
	
	public static JPanel wrapperPanel(final JComponent component, final int orientation){
		final JPanel panel = new JPanel(new FlowLayout(orientation));
		panel.add(component);
		return panel;
	}
	
	
}

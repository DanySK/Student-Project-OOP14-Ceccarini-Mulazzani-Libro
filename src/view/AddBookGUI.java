package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Alberto Mulazzani
 *
 */
public class AddBookGUI {
	
	private final JTextField[] fields = new JTextField[7];
	private final JButton add = new JButton("Conferma");
	private final JButton reset = new JButton("Reset");
	private final JButton annulla = new JButton("Annulla");
	private final JPanel main = new JPanel();
	private final String[] names = {"Titolo", "Autore", "Anno di pubblicazione", "Editore", "ISBN", "Prezzo", "Quantità" };
	
	public AddBookGUI(){
		
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

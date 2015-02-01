package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddBookGUI {
	
	private JTextField[] fields = new JTextField[7];
	private JButton add = new JButton("Conferma");
	private JButton reset = new JButton("Reset");
	private JButton annulla = new JButton("Annulla");
	private JPanel main = new JPanel();
	private String[] names = {"Titolo", "Autore", "Anno di pubblicazione", "Editore", "ISBN", "Prezzo", "Quantità" };
	
	public AddBookGUI(){
		
		main.setLayout(new BorderLayout());
		
		JPanel bot = new JPanel(new FlowLayout());
		bot.add(reset);
		bot.add(add);
		bot.add(annulla);
		main.add(bot, BorderLayout.SOUTH);
				
		
		JPanel mid = new JPanel(new GridLayout(0,2));
		
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

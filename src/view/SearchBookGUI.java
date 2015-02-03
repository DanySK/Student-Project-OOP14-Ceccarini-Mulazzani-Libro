package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.BookController;
/**
 * 
 * @author Alberto Mulazzani
 *
 */
public class SearchBookGUI {
	
	private JButton[] buttons = new JButton[2];	
	private final static String ok = "Ok";
	private JPanel main = new JPanel();
	private JTextField[] fields = new JTextField[2];
	private JLabel[] labels = new JLabel[2];
	private String[] names = {"Nome", "Autore"};
	
	public SearchBookGUI(BookController controller){
		
		
		main.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = 0;
		c.insets = new Insets(3,3,7,3);
		c.fill = GridBagConstraints.HORIZONTAL;
		
		
		for (int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton(ok);
			fields[i] = new JTextField(20);
			labels[i] = new JLabel(names[i]);
			
		}
		
		
		for (int i = 0; i < buttons.length; i++){
			
			main.add(labels[i], c);
			main.add(fields[i], c);
			main.add(buttons[i], c);
			c.gridy++;
		}
		

		
	}
	
	
	
	public JPanel getPane(){
		return this.main;
	}
	
	

}

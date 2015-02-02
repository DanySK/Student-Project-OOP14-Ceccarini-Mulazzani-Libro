package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchBookGUI {
	
	private JButton[] buttons = new JButton[2];	
	private final static String ok = "Ok";
	private JPanel main = new JPanel();
	private JTextField[] fields = new JTextField[2];
	private JLabel[] labels = new JLabel[2];
	private String[] names = {"Nome", "Autore"};
	
	public SearchBookGUI(){
		
		
		//main.setLayout(new FlowLayout());
		
		final JPanel top = new JPanel();
		
		main.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = 0;
	//	c.gridx = 0;
		c.insets = new Insets(3,3,7,3);
		c.fill = GridBagConstraints.HORIZONTAL;
		
		
		for (int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton(ok);
			fields[i] = new JTextField(20);
			labels[i] = new JLabel(names[i]);
			
		}
		
		
		for (int i = 0; i < buttons.length; i++){
			
			main.add(labels[i], c);
	//		c.gridx++;
			main.add(fields[i], c);
		//	c.gridx++;
			main.add(buttons[i], c);
			c.gridy++;
		}
		
		//main.add(top);
		
		
		
		
		
	/*	top.add(labels[0]);
		top.add(fields[0]);
		top.add(buttons[0]);
			
		final JPanel bot = new JPanel(new FlowLayout());
		
		bot.add(labels[1]);
		bot.add(fields[1]);
		bot.add(buttons[1]);
		
		
		main.add(top, BorderLayout.NORTH);
		main.add(bot, BorderLayout.CENTER);
		
	*/	
		
	}
	
	
	
	public JPanel getPane(){
		return this.main;
	}
	
	

}

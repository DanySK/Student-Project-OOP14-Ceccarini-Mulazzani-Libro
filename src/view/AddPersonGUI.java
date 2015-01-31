package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cartasoci.FidelityCards;
import cartasoci.IFidelityCards;
import cartasoci.User;

public class AddPersonGUI {
	
	private JTextField nome = new JTextField(20);
	private JTextField cognome = new JTextField(20);
	private JTextField email = new JTextField(20);
	private JButton add = new JButton("Conferma");
	private JButton reset = new JButton("Reset");
	private JButton annulla = new JButton("Annulla");
	private IFidelityCards cards = new FidelityCards();
	
	
	public AddPersonGUI(){
		
		JFrame main = new JFrame();
		main.setLayout(new BorderLayout());
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel bot = new JPanel(new FlowLayout());
		bot.add(reset);
		bot.add(add);
		bot.add(annulla);
		main.add(bot, BorderLayout.SOUTH);
		
		JPanel mid = new JPanel(new GridLayout(0,2));
		mid.add(wrapperPanel(new JLabel("Nome"),FlowLayout.RIGHT));
		mid.add(wrapperPanel(this.nome,FlowLayout.CENTER));
		mid.add(wrapperPanel(new JLabel("Cognome"),FlowLayout.RIGHT));
		mid.add(wrapperPanel(this.cognome,FlowLayout.CENTER));		
		mid.add(wrapperPanel(new JLabel("Email"),FlowLayout.RIGHT));
		mid.add(wrapperPanel(this.email,FlowLayout.CENTER));
			
		main.add(mid, BorderLayout.CENTER);
		
		main.pack();
		main.setVisible(true);

		
		// Handler dei pulsanti
		
		//PULSANTE RESET
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				nome.setText("");
				cognome.setText("");
				email.setText("");
			}
		});
		
		//PULSANTE CONFERMA
		
		add.addActionListener(new ActionListener() {
			
			//DA SISTEMARE L'MVC
			@Override
			public void actionPerformed(ActionEvent e) {
				if (nome.getText().length() != 0 &&
						cognome.getText().length() != 0 &&
						email.getText().contains("@")){
						
					JOptionPane.showMessageDialog(main, "Swag", "I dati non sono stati inseriti correttamente", JOptionPane.DEFAULT_OPTION);
					
						cards.addPerson(cards.getNextId(), new User(nome.getText(), cognome.getText(), email.getText()));				
				
				}else if (nome.getText().length() != 0 && 
						cognome.getText().length() != 0 &&
						(!email.getText().contains("@") ||
								email.getText().length() != 0)){
					if (JOptionPane.showConfirmDialog(main, "Email non valida, continuare?") == JOptionPane.YES_OPTION){		
					cards.addPerson(cards.getNextId(), new User(nome.getText(), cognome.getText()));
						
					}else{
						System.out.println("Swag");
					}
				}else if (nome.getText().length() != 0 &&
						cognome.getText().length() == 0 &&
						(!email.getText().contains("@") ||
								email.getText().length() == 0)){
					
					cards.addPerson(cards.getNextId(), new User(nome.getText()));
				
				}else {
					JOptionPane.showMessageDialog(main, "Dati errati", "I dati non sono stati inseriti correttamente", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		
	}
	
	
	
	
	private static JPanel wrapperPanel(final JComponent component, final int orientation){
		final JPanel panel = new JPanel(new FlowLayout(orientation));
		panel.add(component);
		return  panel;
	}

}

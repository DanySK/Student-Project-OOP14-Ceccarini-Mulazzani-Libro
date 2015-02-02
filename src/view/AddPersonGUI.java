package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class AddPersonGUI {
	
	private final JTextField[] fields = new JTextField[3];
	private final String[] names = {"Nome", "Cognome", "Email"};
	private final JButton add = new JButton("Conferma");
	private final JButton reset = new JButton("Reset");
	private final JButton annulla = new JButton("Annulla");
	private final JPanel main = new JPanel();
	
	public AddPersonGUI(){
		
		
		main.setLayout(new BorderLayout());
		//main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
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
		
		//main.setVisible(true);

		
		// Handler dei pulsanti
		
		//PULSANTE RESET
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(final ActionEvent e) {
				
				for (int i = 0; i < fields.length; i++){
					fields[i].setText("");
				}
			}
		});
		
		//PULSANTE CONFERMA
		
	//	add.addActionListener(new ActionListener() {
			
			//DA SISTEMARE L'MVC
	//		@Override
	/*		public void actionPerformed(ActionEvent e) {
				if (nome.getText().length() != 0 &&
						cognome.getText().length() != 0 &&
						email.getText().contains("@")){
						
					JOptionPane.showMessageDialog(main, "Swag", "I dati non sono stati inseriti correttamente", JOptionPane.DEFAULT_OPTION);
					
				//		cards.addPerson(cards.getNextId(), new User(nome.getText(), cognome.getText(), email.getText()));				
				
				}else if (nome.getText().length() != 0 && 
						cognome.getText().length() != 0 &&
						(!email.getText().contains("@") ||
								email.getText().length() != 0)){
					if (JOptionPane.showConfirmDialog(main, "Email non valida, continuare?") == JOptionPane.YES_OPTION){		
				//	cards.addPerson(cards.getNextId(), new User(nome.getText(), cognome.getText()));
						
					}else{
						System.out.println("Swag");
					}
				}else if (nome.getText().length() != 0 &&
						cognome.getText().length() == 0 &&
						(!email.getText().contains("@") ||
								email.getText().length() == 0)){
					
					//cards.addPerson(cards.getNextId(), new User(nome.getText()));
				
				}else {
					JOptionPane.showMessageDialog(main, "Dati errati", "I dati non sono stati inseriti correttamente", JOptionPane.ERROR_MESSAGE);
				}
			}
		});*/
		
		
		
	}
	
	
	
	
	private static JPanel wrapperPanel(final JComponent component, final int orientation){
		final JPanel panel = new JPanel(new FlowLayout(orientation));
		panel.add(component);
		return  panel;
	}
	
	public JPanel getPane(){
		return main;
	}

}

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * 
 * @author Alberto Mulazzani
 *
 */


public class MagazGUI {

	private final JButton[] buttons = new JButton[5];
	private final String[] names = {"Aggiungi un libro", "Rimuovi un libro", "Modifica un libro", "Ricerca un libro", "Lista dei libri"};
	private final JButton chiudi = new JButton("Chiudi");
	private final JPanel jf = new JPanel();
	
	public MagazGUI(final String nomeAziendaR){
		
		

		jf.setLayout(new BorderLayout());
	    final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    final int x = (dim.width )/4;
	    final int y = (dim.height)/3;
	    jf.setSize(x, y);
	    jf.setLocation(x, y);
		
		
		final JPanel main = new JPanel();
		main.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = 0;
		c.insets = new Insets(3,3,3,3);
		c.fill = GridBagConstraints.HORIZONTAL;
		
		
		for (int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton(names[i]);
			main.add(buttons[i], c);
			c.gridy++;
			
		}
		
		
		
		final JPanel comandi = new JPanel(new FlowLayout());
		comandi.add(main);
		main.setBorder(new TitledBorder("Magazzino di " + nomeAziendaR));
		final JPanel main2 = new JPanel(new FlowLayout());
		main2.add(chiudi);
		
		jf.add(comandi, BorderLayout.CENTER);
		jf.add(main2, BorderLayout.SOUTH);
		
		
		chiudi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
	}
	
	
	public JPanel getPane(){
		return this.jf;
	}
	
}

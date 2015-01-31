package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
/**
 * 
 * @author Alberto Mulazzani
 *
 */


public class MagazGUI {

	private final JButton aggiungi = new JButton("Aggiungi un prodotto");
	private final JButton rimuovi = new JButton("Rimuovi un prodotto");
	private final JButton modifica = new JButton("Modifica un prodotto");
	private final JButton cerca = new JButton("Ricerca un prodotto");
	private final JButton lista = new JButton("Lista dei prodotti");
	private final JButton indietro = new JButton("Torna Indietro");
	private final JButton chiudi = new JButton("Chiudi");
	private final String nomeAzienda;
	
	
	public MagazGUI(final String nomeAziendaR){
		
		this.nomeAzienda = nomeAziendaR;
		
		final JFrame jf = new JFrame();
		jf.setLayout(new BorderLayout());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		main.add(aggiungi,c);
		c.gridy++;
		main.add(rimuovi,c);
		c.gridy++;
		main.add(modifica,c);
		c.gridy++;
		main.add(cerca,c);
		c.gridy++;
		main.add(lista,c);
		
		
		final JPanel comandi = new JPanel(new FlowLayout());
		comandi.add(main);
		main.setBorder(new TitledBorder("Magazzino di " + nomeAzienda));
		final JPanel main2 = new JPanel(new FlowLayout());
		main2.add(indietro);
		main2.add(chiudi);
		
		jf.add(comandi, BorderLayout.CENTER);
		jf.add(main2, BorderLayout.SOUTH);
		
		jf.setVisible(true);
		
		
		
		
	}
	
}

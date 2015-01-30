package mainview;

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

	private JButton aggiungi = new JButton("Aggiungi un prodotto");
	private JButton rimuovi = new JButton("Rimuovi un prodotto");
	private JButton modifica = new JButton("Modifica un prodotto");
	private JButton cerca = new JButton("Ricerca un prodotto");
	private JButton lista = new JButton("Lista dei prodotti");
	private JButton indietro = new JButton("Torna Indietro");
	private JButton chiudi = new JButton("Chiudi");
	private String nomeAzienda;
	
	
	public MagazGUI(final String nomeAziendaR){
		
		this.nomeAzienda = nomeAziendaR;
		
		JFrame jf = new JFrame();
		jf.setLayout(new BorderLayout());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (dim.width )/4;
	    int y = (dim.height)/3;
	    jf.setSize(x, y);
	    jf.setLocation(x, y);
		
		
		JPanel main = new JPanel();
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
		
		
		JPanel comandi = new JPanel(new FlowLayout());
		comandi.add(main);
		main.setBorder(new TitledBorder("Magazzino di " + nomeAzienda));
		JPanel main2 = new JPanel(new FlowLayout());
		main2.add(indietro);
		main2.add(chiudi);
		
		jf.add(comandi, BorderLayout.CENTER);
		jf.add(main2, BorderLayout.SOUTH);
		
		jf.setVisible(true);
		
		
		
		
	}
	
}

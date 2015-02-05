package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.Set;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Libro;
import utilities.GUIUtilities;

public class ListTableGUI extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8563544567918601056L;
	private JLabel[] list;
	private JPanel main = new JPanel();

	public ListTableGUI(Set<Libro> set){
		
		main.setLayout(new BorderLayout());
		
		final JPanel top = new JPanel(new GridBagLayout());
		GridBagConstraints c = GUIUtilities.getConstr();

		top.add(new JLabel("Titolo"), c);
		top.add(new JLabel("Autore"), c);
		top.add(new JLabel("Quantità"), c);
		c.gridy++;
		
		list = new JLabel[set.size() * 3];
		
		for (int i = 0; i < list.length; i++){
			list[i] = new JLabel();
		}
		
		
		System.out.println(set.size());
		int i = 0;
		
		for (Libro b : set){
			list[i].setText(b.getTitle());
			list[i+1].setText(b.getAuthor());
			list[i+2].setText("" + b.getNCopy());
			top.add(list[i], c );
			top.add(list[i+1], c);
			top.add(list[i+2], c);
			c.gridy++;
			i+=3;
		}
		
		
		JPanel mid = new JPanel(new FlowLayout());
		mid.add(top);
		
		final JScrollPane extPane = new JScrollPane(top);
		extPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    final int x = (dim.width )/5;
	    final int y = (dim.height)/3;
		extPane.setPreferredSize(new Dimension(x,y));
		
		main.add(extPane);
		
		
		
	}
	
	public JPanel getPane(){
		return this.main;
	}
	
	
}

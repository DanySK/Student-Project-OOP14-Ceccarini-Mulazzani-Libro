package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Libro;
import utilities.ControllerUtilities.TipoController;
import utilities.GUIUtilities;
import controller.BookController;

public class ListTableGUI {

	private JLabel[] list = new JLabel[50];
	private JPanel main = new JPanel();
	private Set<Libro> set;
	
	public ListTableGUI(BookController controller, TipoController type){
		
		main.setLayout(new BorderLayout());
		
		final JPanel top = new JPanel(new GridBagLayout());
		GridBagConstraints c = GUIUtilities.getConstr();

		top.add(new JLabel("Titolo"), c);
		top.add(new JLabel("Autore"), c);
		c.gridy++;

		set = controller.bookList();
		
		list = new JLabel[set.size() * 2];
		
		for (int i = 0; i < list.length; i++){
			list[i] = new JLabel();
		}
		
		System.out.println(set.size());
		int i = 0;
		
		for (Libro b : set){
			list[i].setText(b.getTitle());
			list[i+1].setText(b.getAuthor());
			top.add(list[i], c );
			top.add(list[i+1], c);
			c.gridy++;
			i+=2;
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

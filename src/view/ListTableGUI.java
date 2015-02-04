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
import utilities.GUIUtilities;
import utilities.ControllerUtilities.TipoController;
import controller.BookController;

public class ListTableGUI {

	private JLabel[] list = new JLabel[50];
	private JPanel main = new JPanel();
	private Set<Libro> set;
	
	public ListTableGUI(BookController controller, TipoController type){
		
		main.setLayout(new BorderLayout());
		
		final JPanel top = new JPanel(new GridBagLayout());
		GridBagConstraints c = GUIUtilities.getConstr();

		set = controller.bookList();

		list = new JLabel[set.size()];
		
		for (int i = 0; i < list.length; i++){
			list[i] = new JLabel();
		}
		
		for (int i = 0; i < list.length; i+=2){
			Libro curr = set.iterator().next();
			list[i].setText(curr.getTitle());
			list[i+1].setText(curr.getAuthor());
			top.add(list[i], c);
			top.add(list[i+1], c);
			c.gridy++;
			
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

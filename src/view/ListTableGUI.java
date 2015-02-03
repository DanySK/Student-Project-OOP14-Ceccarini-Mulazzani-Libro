package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Libro;
import controller.BookController;
import utilities.GUIUtilities;

public class ListTableGUI {

	private JLabel[] list = new JLabel[2];
	private JPanel main = new JPanel();
	private Set<Libro> set;
	private Set<String> set2 = new HashSet<String>();
	
	public ListTableGUI(BookController controller){
		
		main.setLayout(new BorderLayout());
		
		final JPanel top = new JPanel(new GridBagLayout());
		GridBagConstraints c = GUIUtilities.getConstr();

//		set = controller.bookList();
		set2.add("Scimmia");
		set2.add("Banana");
		//list = new JLabel[set2.size()];
/*		
		for (int i = 0; i < list.length; i+=2){
			Libro curr = set.iterator().next();
			list[i].setText(curr.getTitle());
			list[i+1].setText(curr.getAuthor());
			top.add(list[i], c);
			top.add(list[i+1], c);
			c.gridy++;
			
		}*/
		
		for (int i = 0; i < list.length; i++){
			list[i] = new JLabel();
		}
		
		list[0].setText("Banana");
		list[1].setText("Scimmia");
		top.add(list[0], c);
		top.add(list[1], c);
		c.gridy++;
		
		final JScrollPane extPane = new JScrollPane();
		
		extPane.add(top);
		
		main.add(extPane);
		
		
		
	}
	
	public JPanel getPane(){
		return this.main;
	}
	
	
}

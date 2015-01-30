package mainview;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainGUI {
	
	private JButton magaz = new JButton("Accedi al Magazzino");
	private JButton ord = new JButton("Accedi agli Ordini");
	private JLabel index = new JLabel("<html><CENTER>Benvenuto in Libro <BR> di Chiara Ceccarini e Alberto Mulazzani</CENTER></html>");
	
	
	public MainGUI(){
		
		
		
		JFrame main = new JFrame();
		main.setLayout(new BorderLayout());
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	     int w = main.getSize().width / 7;
	     int h = main.getSize().height / 7;
	     int x = (dim.width + w)/3;
	     int y = (dim.height + h)/3;
	     main.setLocation(x, y);
		
		JPanel top = new JPanel(new FlowLayout());
		top.add(index);
		main.add(top,BorderLayout.NORTH);
		
		
		JPanel bot = new JPanel(new FlowLayout());
		bot.add(magaz);
		magaz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Inserire GUI Magazzino
				
			}
		});
		bot.add(ord);
		ord.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Inserire GUI Ordini
				
			}
		});
		main.add(bot,BorderLayout.SOUTH);
		
		main.pack();
		main.setVisible(true);
		
		
		
	}
	

}

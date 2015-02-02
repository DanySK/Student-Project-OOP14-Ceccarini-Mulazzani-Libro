package view;

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
import javax.swing.SwingUtilities;



/**
 * 
 * @author Alberto Mulazzani
 *
 */

public class MainGUI {
	
	private final JButton magaz = new JButton("Accedi al Magazzino");
	private final JButton ord = new JButton("Accedi agli Ordini");
	private final JLabel index = new JLabel("<html><CENTER>Benvenuto in Libro <BR> di Chiara Ceccarini e Alberto Mulazzani</CENTER></html>");
	
	
	public MainGUI(){
		
		
		
		final JFrame main = new JFrame();
		main.setLayout(new BorderLayout());
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    final int w = main.getSize().width / 7;
	    final int h = main.getSize().height / 7;
	    final int x = (dim.width + w)/3;
	    final int y = (dim.height + h)/3;
	     main.setLocation(x, y);
		
		final JPanel top = new JPanel(new FlowLayout());
		top.add(index);
		main.add(top,BorderLayout.NORTH);
		
		
		final JPanel bot = new JPanel(new FlowLayout());
		bot.add(magaz);
		magaz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				// TODO Inserire GUI Magazzino
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						new MagazGUI();
					}
				});
				
			
			}
		});
		bot.add(ord);
		ord.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Inserire GUI Ordini
				
				
			}
		});
		main.add(bot,BorderLayout.SOUTH);
		
		main.pack();
		main.setVisible(true);
		
		
		
	}
	

}

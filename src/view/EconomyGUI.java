package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import utilities.GUIUtilities;
import controller.BookController;
import controller.EarningsController;

public class EconomyGUI {

	private final String[] names = {"Totale libri venduti", "Totali in negozio", "Totale guadagnato", "Totale speso", "Totale fatturato"};
	private final JPanel main = new JPanel();
	private final JLabel[] labels = new JLabel[names.length];
	
	public EconomyGUI(BookController controller, EarningsController earcontroller){
		
		main.setLayout(new BorderLayout());
		
		final JPanel mid = new JPanel(new GridLayout(0,2));
		
		
		for (int i = 0; i < names.length; i++ ){
			labels[i] = new JLabel(names[i]);
		}
		
		

			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					mid.add(GUIUtilities.wrapperPanel(new JLabel(names[0]),FlowLayout.RIGHT));
					mid.add(GUIUtilities.wrapperPanel(new JLabel("" + earcontroller.bookSold(controller.bookList())),FlowLayout.CENTER));
				
					mid.add(GUIUtilities.wrapperPanel(new JLabel(names[1]),FlowLayout.RIGHT));
					mid.add(GUIUtilities.wrapperPanel(new JLabel("" + earcontroller.bookInStore(controller.bookList()) + "€"),FlowLayout.CENTER));
				
					
					mid.add(GUIUtilities.wrapperPanel(new JLabel(names[2]),FlowLayout.RIGHT));
					mid.add(GUIUtilities.wrapperPanel(new JLabel("" + earcontroller.totSell(controller.bookList()) + "€"),FlowLayout.CENTER));
						
					
					mid.add(GUIUtilities.wrapperPanel(new JLabel(names[3]),FlowLayout.RIGHT));
					mid.add(GUIUtilities.wrapperPanel(new JLabel("" + earcontroller.totSpent(controller.bookList()) + "€"),FlowLayout.CENTER));
					
					
					mid.add(GUIUtilities.wrapperPanel(new JLabel(names[4]),FlowLayout.RIGHT));
					mid.add(GUIUtilities.wrapperPanel(new JLabel("" + earcontroller.totEarnings(controller.bookList()) + "€"),FlowLayout.CENTER));
					
				}
			});
		
	
		

		
		main.add(mid, BorderLayout.CENTER);
		
		final JPanel bot = new JPanel(new FlowLayout());
		
		bot.add(GUIUtilities.getClosing());
		
		main.add(bot,BorderLayout.SOUTH);
	
	}
	
	public JPanel getPane(){
		return this.main;
	}
}

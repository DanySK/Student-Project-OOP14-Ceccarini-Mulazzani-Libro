package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FileTabMenuGUI  extends JMenu{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1894309391410079587L;

	private String[] names = {"Carica", "Salva", "Salva e chiudi"};
	private JMenuItem[] buttons = new JMenuItem[names.length];
	
	
	public FileTabMenuGUI(){
	
		super("File");
		
	//	setMnemonic('f');
		//super.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F));

		
		
		for (int i = 0; i < names.length; i++){
			buttons[i] = new JMenuItem(names[i]);
			add(buttons[i]);
			if (i == 1){
				addSeparator();
			}
		}
		
		
		
		
		buttons[0].setMnemonic('c');
		buttons[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				System.out.println("Carica");
				
			}
		});
		
		
		buttons[1].setMnemonic('S');
		buttons[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		buttons[2].setMnemonic('V');
		buttons[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	

}

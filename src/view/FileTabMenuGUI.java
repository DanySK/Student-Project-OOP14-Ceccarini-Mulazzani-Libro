package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import utilities.ControllerUtilities.TipoController;
import model.Libro;
import cartasoci.FidCard;
import cartasoci.User;

import com.thoughtworks.xstream.XStream;

import controller.BookController;
import controller.FidelityController;

public class FileTabMenuGUI  extends JMenu{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1894309391410079587L;

	private String[] names = {"Carica", "Salva", "Salva e chiudi"};
	private JMenuItem[] buttons = new JMenuItem[names.length];
	private Set<User> set = new HashSet<>();
	
	
	public FileTabMenuGUI(JFrame frame, final BookController controller, final FidelityController fidcontroller){
	
		super("File");
		
	//	setMnemonic('f');
		//super.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F));

		set.add(new User("Banana", "Scimmia", "1@1"));
		set.add(new User("Banana2", "Scimmia2", "12@1"));
		set.add(new User("Banan3a", "Scimmi3a", "1@13"));

		
		System.out.println(set.size());
		
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

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Documento XML (*.xml)", "xml"));
				fileChooser.setDialogTitle("Specify a file to Load");   
				 
				int userSelection = fileChooser.showSaveDialog(frame);
				 
				if (userSelection == JFileChooser.APPROVE_OPTION) {
				    File fileToLoad = fileChooser.getSelectedFile();
				    System.out.println("Load as file: " + fileToLoad.getAbsolutePath());
				}
			}
		});
		
		
		buttons[1].setMnemonic('S');
		buttons[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home") + System.getProperty("line.separator") + "Desktop");
				fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Documento XML (*.xml)", "xml"));
				fileChooser.setDialogTitle("Specify a file to Save");   
				 
				int userSelection = fileChooser.showSaveDialog(frame);
				 
				if (userSelection == JFileChooser.APPROVE_OPTION) {
				    File fileToLoad = fileChooser.getSelectedFile();
				    System.out.println("Save as file: " + fileToLoad.getAbsolutePath());
				    File file = new File(fileToLoad.getAbsolutePath());
				    XStream xstream = new XStream();
				    xstream.alias("User", User.class);
				    xstream.alias("Carta", FidCard.class);
				    BufferedWriter out;
				    try {
				    	if (file.getAbsolutePath().contains(".xml")){
							 out = new BufferedWriter(new FileWriter(file));
							
				    	}else{
				    		 out = new BufferedWriter(new FileWriter(file + ".xml"));	
				    	}
				    	controller.setType(TipoController.MAGAZZINO);
				    	for (Libro b : controller.bookList()){
				    	    String tosave=xstream.toXML(b);
							out.write(tosave);		
				    	}
				    	out.write("Ordini");
				    	controller.setType(TipoController.ORDINI);
				    	for (Libro b : controller.bookList()){
				    	    String tosave=xstream.toXML(b);
							out.write(tosave);		
				    	}
						out.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				  
				    
				}
				
			}
		});
		
		buttons[2].setMnemonic('V');
		buttons[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Documento XML (*.xml)", "xml"));
				fileChooser.setDialogTitle("Specify a file to Save");   
				 
				int userSelection = fileChooser.showSaveDialog(frame);
				 
				if (userSelection == JFileChooser.APPROVE_OPTION) {
				    File fileToLoad = fileChooser.getSelectedFile();
				    System.out.println("Save as file: " + fileToLoad.getAbsolutePath());
				}
				
				System.exit(0);
			}
		});
		
	}
	

}

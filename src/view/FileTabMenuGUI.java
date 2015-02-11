package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import utilities.ControllerUtilities.TipoController;
import model.BasicOperations;
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
				    XStream xstream = new XStream();
				    xstream.alias("User", User.class);
				    xstream.alias("Carta", FidCard.class);
				    xstream.alias("Libro", Libro.class);
				    xstream.alias("Lista", List.class);
				
					
				    
				    List<Libro> list;
					try {
						ObjectInputStream ois = xstream.createObjectInputStream(new ObjectInputStream(new FileInputStream(fileToLoad)));
						
						controller.setType(TipoController.MAGAZZINO);
						list = (List<Libro>) ois.readObject();
					    controller.loadMemory(list);
					    list = (List<Libro>) ois.readObject();
						controller.setType(TipoController.ORDINI);
						controller.loadMemory(list);
						Map<Integer, User> map = (Map<Integer, User>) ois.readObject();
						fidcontroller.loadMemory(map);
						

					    
					    ois.close();
					    
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   
				    
				  //  List<Libro> list2 = (List<Libro>) xstream.fromXML
				    
				   // controller.loadMemory(list2);		    


				    
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
				    
				    File file;
				    if (!fileToLoad.getAbsolutePath().contains(".xml")){
					    file = new File(fileToLoad + ".xml");
				    }else {
				    	file = new File(fileToLoad.getAbsolutePath());
				    }
				    
				    XStream xstream = new XStream();
				    xstream.alias("User", User.class);
				    xstream.alias("Carta", FidCard.class);
				    xstream.alias("Libro", Libro.class);
				    xstream.alias("Lista", List.class);
				    
				  //  BufferedWriter out;
					try {
						//out = new BufferedWriter(new FileWriter(file));
					    //xstream.alias("Lista", List.class);
						controller.setType(TipoController.MAGAZZINO);
						ObjectOutputStream out = xstream.createObjectOutputStream(new ObjectOutputStream(new FileOutputStream(file)));
						out.writeObject(controller.bookList());

						controller.setType(TipoController.ORDINI);
						out.writeObject(controller.bookList());
						
						out.writeObject(fidcontroller.getMap());
						
						out.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				    	
				    /*	for (Libro b : controller.bookList()){
				    	    String tosave=xstream.toXML(b);
							out.write(tosave);		
				    	}*/

						
						
				   /* 	controller.setType(TipoController.ORDINI);
				    	tosave=xstream.toXML(controller.bookList());
						out.write(tosave);	
					*/	
						
				    	/*	for (Libro b : controller.bookList()){
				    	    tosave=xstream.toXML(b);
							out.write(tosave);		
				    	}
				    	
				    	for (Entry<Integer, User> u : fidcontroller.getMap().entrySet()){
				    	    tosave=xstream.toXML(u.getKey());
							out.write(tosave);
				    	    tosave=xstream.toXML(u.getValue());
							out.write(tosave);
				    	}*/
						
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

package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import utilities.ControllerUtilities.TipoController;
import controller.BookController;
import controller.EarningsController;
import controller.FidelityController;
import controller.StatisticsController;
/**
 * 
 * @author Alberto Mulazzani
 *
 */
public class Main implements ActionListener {

    private JPanel cardHolder;
    private final JButton magazzino = new JButton("Magazzino");
    private final JButton ordini = new JButton("Ordini");
    private final JButton fatturato = new JButton("Fatturato e guadagni");
    private final JButton cartasoci = new JButton("Carta Soci");
    private final JButton statistiche = new JButton("Statistiche");
    private final BookController controller = new BookController();
    private final EarningsController earcontroller = new EarningsController();
    private final StatisticsController statcontroller = new StatisticsController();
    private final FidelityController fidcontroller = new FidelityController();
  
    public JPanel createCardHolderPanel() {
    	cardHolder = new JPanel();
    	cardHolder.setLayout(new CardLayout());
        cardHolder.setBorder(BorderFactory.createTitledBorder("Scegli l'azione"));
        cardHolder.add(createWareHousePanel(), "Magazzino");
        cardHolder.add(createOrderPanel(), "Ordini");
        cardHolder.add(createEconomyPanel(), "Fatturato e Guadagni");
        cardHolder.add(createFidelityPanel(), "Carta Soci");
        cardHolder.add(createStatisticPanel(), "Statistiche");
        
        return cardHolder;
    }
    
    
    private JPanel createEconomyPanel( ) {
    	
    	return new	EconomyMenuGUI(controller, earcontroller).getPane();
    }
    
    private JPanel createStatisticPanel(){
    	
    	return new StatisticGUI(controller, statcontroller).getPane();
    }

    private JPanel createWareHousePanel() {


    	return new MagazGUI(controller, fidcontroller).getPane();
    }
    
    private JPanel createOrderPanel( ) {
    	

    	return new OrdGUI(controller).getPane();
    }
    
    private JPanel createFidelityPanel() {
    	
    	return new FidelityCardGUI(fidcontroller).getPane();
    }
     

    public JPanel createButtonPanel() {
        final JPanel buttonPanel = new JPanel(new GridLayout(5, 0, 5, 5));
        
        /*
         *     	final BackgroundPanel buttonPanel = new BackgroundPanel(GUIUtilities.back2);
        buttonPanel.setLayout(new GridLayout(5, 0, 5, 5));
         */
        
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Scegli la sezione"));
        buttonPanel.add(magazzino);
        buttonPanel.add(ordini);
        buttonPanel.add(statistiche); 
        buttonPanel.add(fatturato);
        buttonPanel.add(cartasoci);
        magazzino.addActionListener(this);
        ordini.addActionListener(this);
        fatturato.addActionListener(this);
        cartasoci.addActionListener(this);
        statistiche.addActionListener(this);
        return buttonPanel;
    }

    public JPanel createContentPane() {
    	final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Menù principale"));
        panel.add(createButtonPanel(), BorderLayout.WEST);
        panel.add(createCardHolderPanel(), BorderLayout.CENTER);
        return panel;
    }

    public JMenuBar createMenuBar(final JFrame frame) {
    	final JMenuBar menuBar = new JMenuBar();
        //final JMenu file = new JMenu("File");
        final JMenu help = new JMenu("Help");
        menuBar.add( new FileTabMenuGUI(frame, controller, fidcontroller));
        menuBar.add(help);
        return menuBar;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        final CardLayout cardLayout = (CardLayout) (cardHolder.getLayout());
        if (e.getSource() == magazzino) {
        	controller.setType(TipoController.MAGAZZINO);
            cardLayout.show(cardHolder, "Magazzino");
        }
        if (e.getSource() == ordini) {
        	controller.setType(TipoController.ORDINI);
            cardLayout.show(cardHolder, "Ordini");
        }
        if (e.getSource() == fatturato) {
        	controller.setType(TipoController.MAGAZZINO);
        	cardHolder.repaint();
            cardLayout.show(cardHolder, "Fatturato e Guadagni");
        }
        if (e.getSource() == cartasoci) {
            cardLayout.show(cardHolder, "Carta Soci");
        }
        if (e.getSource() == statistiche) {
        	cardLayout.show(cardHolder, "Statistiche");
        }
    }

    public static void createAndShowGUI() {
        final JFrame frame = new JFrame("Libro di Chiara Ceccarini e Alberto Mulazzani");
        try {
			//UIManager.setLookAndFeel(new javax.swing.plaf.nimbus.NimbusLookAndFeel());
        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  	
        } catch (UnsupportedLookAndFeelException e) {	
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		}
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        frame.addWindowListener(new WindowAdapter() {
        	  @Override
        	  public void windowClosing(WindowEvent we)
        	  { 
        	    final String objButtons[] = {"Sì","No"};
        	    final int promptResult = JOptionPane.showOptionDialog(null, 
        	        "Sei sicuro di voler uscire? I dati non salvati saranno persi", "Sei proprio sicuro?", 
        	        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
        	        objButtons,objButtons[1]);
        	    if(promptResult==0)
        	    {
        	      System.exit(0);          
        	    }
        	  }
        	});    
        
        frame.setResizable(false);
        final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    final int x = (dim.width + dim.width/3)/3;
	    final int y = (dim.height+dim.height/6)/2;
	    frame.setPreferredSize(new Dimension(x, y));
	//    frame.setLocation(x, y);
        final Main main = new Main();
        frame.setJMenuBar(main.createMenuBar(frame));
        frame.add(main.createContentPane());
        frame.pack();
        
        frame.setVisible(true);
    }
    
    

}
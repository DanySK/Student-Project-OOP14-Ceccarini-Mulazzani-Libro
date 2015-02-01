package mainview;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import view.*;

public class Main implements ActionListener {

    private JPanel cardHolder;
    private final JButton magazzino = new JButton("Magazzino");
    private final JButton ordini = new JButton("Ordini");
    private final JButton fatturato = new JButton("Fatturato e guadagni");
    private final JButton cartasoci = new JButton("Carta Soci");
    
    public JPanel createCardHolderPanel() {
        cardHolder = new JPanel(new CardLayout());
        cardHolder.setBorder(BorderFactory.createTitledBorder("Card Holder Panel"));
        cardHolder.add(createWareHousePanel(), "Magazzino");
        cardHolder.add(createOrderPanel(), "Ordini");
        cardHolder.add(createColorPanel2(), "Fatturato e Guadagni");
        cardHolder.add(createColorPanel2(), "Carta Soci");

        return cardHolder;
    }
   
    private JPanel createColorPanel2( ) {

    	return new AddBookGUI().getPane();
    }

    private JPanel createWareHousePanel() {

    	return new MagazGUI("Scimmia").getPane();
    }
    
    private JPanel createOrderPanel( ) {

    	return new OrdGUI("Scimmia").getPane();
    }
    
    

    public JPanel createButtonPanel() {
        final JPanel buttonPanel = new JPanel(new GridLayout(4, 0, 5, 5));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Scegli la sezione"));
        buttonPanel.add(magazzino);
        buttonPanel.add(ordini);
        buttonPanel.add(fatturato);
        buttonPanel.add(cartasoci);
        magazzino.addActionListener(this);
        ordini.addActionListener(this);
        fatturato.addActionListener(this);
        cartasoci.addActionListener(this);
        return buttonPanel;
    }

    public JPanel createContentPane() {
    	final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Menù principale"));
      //  panel.setBackground(Color.GRAY);
        panel.setPreferredSize(new Dimension(650, 288));
        panel.add(createButtonPanel(), BorderLayout.WEST);
        panel.add(createCardHolderPanel(), BorderLayout.CENTER);
        return panel;
    }

    public JMenuBar createMenuBar() {
    	final JMenuBar menuBar = new JMenuBar();
        final JMenu file = new JMenu("File");
        final JMenu users = new JMenu("Users");
        final JMenu options = new JMenu("Options");
        final JMenu help = new JMenu("Help");
        menuBar.add(file);
        menuBar.add(users);
        menuBar.add(options);
        menuBar.add(help);
        return menuBar;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        final CardLayout cardLayout = (CardLayout) (cardHolder.getLayout());
        if (e.getSource() == magazzino) {
            cardLayout.show(cardHolder, "Magazzino");
        }
        if (e.getSource() == ordini) {
            cardLayout.show(cardHolder, "Ordini");
        }
        if (e.getSource() == fatturato) {
            cardLayout.show(cardHolder, "Fatturato e Guadagni");
        }
        if (e.getSource() == cartasoci) {
            cardLayout.show(cardHolder, "Carta Soci");
        }
    }

    public static void createAndShowGUI() {
        final JFrame frame = new JFrame("Libro di Chiara Ceccarini e Alberto Mulazzani");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Main main = new Main();
        frame.setJMenuBar(main.createMenuBar());
        frame.add(main.createContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(final String[] args) { // NOPMD by Alberto on 01/02/15 17.12
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
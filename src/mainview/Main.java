package mainview;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import view.*;

public class Main implements ActionListener {

    private static final String HOME_CARD = "Home";
    private static final String BLUE_PANEL = "Blue Panel";
    private static final String RED_PANEL = "Red Panel";
    private static final String ORANGE_PANEL = "Orange Panel";
    private JPanel cardHolder;
    private JButton homeButton = new JButton("Magazzino");
    private JButton blueButton = new JButton("Ordini");
    private JButton redButton = new JButton("Fatturato e guadagni");
    private JButton orangeButton = new JButton("Carta Soci");
    
    public JPanel createCardHolderPanel() {
        cardHolder = new JPanel(new CardLayout());
        cardHolder.setBorder(BorderFactory.createTitledBorder("Card Holder Panel"));
        cardHolder.add(createWareHousePanel(Color.gray), HOME_CARD);
        cardHolder.add(createOrderPanel(Color.blue), BLUE_PANEL);
        cardHolder.add(createColorPanel2(Color.red), RED_PANEL);
        cardHolder.add(createColorPanel2(Color.orange), ORANGE_PANEL);

        return cardHolder;
    }
   
    private JPanel createColorPanel2(Color color) {
    /*    JPanel panel = new JPanel(new FlowLayout());
        panel.setBackground(color);
        panel.add(new JButton("Scimmia"));
        panel.add(new JButton("Scimmia"));
        
        
        
        */
    	return new AddBookGUI().getPane();
    }

    private JPanel createWareHousePanel(Color color) {

    	return new MagazGUI("Scimmia").getPane();
    }
    
    private JPanel createOrderPanel(Color color) {

    	return new OrdGUI("Scimmia").getPane();
    }
    
    

    public JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(4, 0, 5, 5));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Button Panel"));
        buttonPanel.add(homeButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);
        buttonPanel.add(orangeButton);
        homeButton.addActionListener(this);
        blueButton.addActionListener(this);
        redButton.addActionListener(this);
        orangeButton.addActionListener(this);
        return buttonPanel;
    }

    public JPanel createContentPane() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Main Content Pane"));
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(650, 288));
       // panel.add(createButtonPanel(), BorderLayout.WEST);
        panel.add(createButtonPanel(), BorderLayout.WEST);
        panel.add(createCardHolderPanel(), BorderLayout.CENTER);
        return panel;
    }

    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu users = new JMenu("Users");
        JMenu options = new JMenu("Options");
        JMenu help = new JMenu("Help");
        menuBar.add(file);
        menuBar.add(users);
        menuBar.add(options);
        menuBar.add(help);
        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) (cardHolder.getLayout());
        if (e.getSource() == homeButton) {
            cardLayout.show(cardHolder, HOME_CARD);
        }
        if (e.getSource() == blueButton) {
            cardLayout.show(cardHolder, BLUE_PANEL);
        }
        if (e.getSource() == redButton) {
            cardLayout.show(cardHolder, RED_PANEL);
        }
        if (e.getSource() == orangeButton) {
            cardLayout.show(cardHolder, ORANGE_PANEL);
        }
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Simple CardLayout Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main main = new Main();
        frame.setJMenuBar(main.createMenuBar());
        frame.add(main.createContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
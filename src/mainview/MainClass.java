package mainview;

import javax.swing.SwingUtilities;

import view.Main;

public class MainClass {

    public static void main(final String[] args) { // NOPMD by Alberto on 01/02/15 17.12
    	
    	
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Main();
				Main.createAndShowGUI();
            }
        });
	}

}

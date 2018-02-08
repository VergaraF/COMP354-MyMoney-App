

import javax.swing.SwingUtilities;

/**
 *
 * @author Vincent
 */
public class App354 {

    /**
     * @param args the command line arguments
     */
	
	
    public static void main(String[] args) {
    	
    	MyMoneyController.controller();
    	FinanceController.setup();
    	/**
        SwingUtilities.invokeLater(() -> {
            MainPanel p = new MainPanel();
            p.setupForPanel();
        });
        */
    }

}

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
    SwingUtilities.invokeLater(new Runnable(){
        public void run(){
       Panel p = new Panel();     
        }
    });
    }
    
}

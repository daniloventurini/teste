/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package portalemoda;

import javax.swing.UIManager;
import visao.Login;

/**
 *
 * @author DANILO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception x) {
        }

        new Login().setVisible(true);
    }

}

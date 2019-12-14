package exec;

import javax.swing.SwingUtilities;
import gui.Accueil;




public class Main {

public static void main (String[] args){

SwingUtilities.invokeLater(new Runnable(){ public void run(){ new Accueil(); } });

}

}
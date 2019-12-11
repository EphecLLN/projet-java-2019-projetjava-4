package exec;

import javax.swing.SwingUtilities;
import ecrans.Accueil;




public class Main {

public static void main (String[] args){

SwingUtilities.invokeLater(new Runnable(){ public void run(){ new Accueil(); } });

}

}
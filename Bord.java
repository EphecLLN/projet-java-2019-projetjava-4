package Login;

import java.awt.EventQueue;
import java.util.Scanner;

public class Bord extends Log {
	protected Scanner sc;
	private GroupeClass maClasse;

	public Bord() {
		if (super.connect == true) {
			clear();
			affiche("Pour créer un groupe avec un nouveau professeur appuyer sur G");
			affiche("Pour prendre les précenses P");

			sc = new Scanner(System.in);

		} else {
			affiche("pas connecter.");
		}

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				while (true) {
					System.out.println("Entrez G|P|Q");
					String c = sc.next();
					switch (c) {
					case "G":

						Bord.this.maClasse = new GroupeClass();

						System.out.println(maClasse);
						break;

					case "P":
						if(Bord.this.maClasse == null) {
							System.err.println("Il faut d'abord créer une classe..");
							continue;
						}
						Etu[] etus = Bord.this.maClasse.getListeEtu();
						Presence.checkPresence(sc, etus);
						break;
					case "Q":
						System.exit(0);
					default:
						affiche("Op\u00E9ration incorrecte");

					}
				}

			}
		});

	}
}

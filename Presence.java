package Login;

import java.util.Scanner;

public class Presence {
	public static void checkPresence(Scanner scanner, Etu[] etus) {
		System.out.println("Entrez la présences des Etudiants suivants:");

		for (Etu etu : etus) {
			askPresence(scanner, etu);
		}
		
	}

	private static void askPresence(Scanner scanner, Etu etu) {
		System.out.println(etu.getPrenom() + " " + etu.getNom());
		System.out.println("y|n");


		boolean done = false;
		while (!done) {
			String input = scanner.next();
			switch (input) {
			case "y":
				System.out.println("Présent");
				done = true;
				break;
			case "n":
				System.out.println("Absent");
				done = true;
				break;
			}
		}
		
	}

}

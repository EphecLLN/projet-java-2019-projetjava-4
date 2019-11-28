package Login;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Log {


	private static String username;
	private static String password;
	public static boolean connect;
	
	
	
	public Log(String username, String password, boolean connect ) {
		
		this.username = username;
		this.password = password;
		this.connect = connect;
	}
	
	public Log() {
		
		this.username =JOptionPane.showInputDialog("username :");
		this.password = JOptionPane.showInputDialog("Password:");
		
		if(password.contains("Ephec") && username.contains("he201575")){
			
			connect = true ;
			
		}	
		
		else{
			JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login error", JOptionPane.ERROR_MESSAGE);
			connect = false;
			
			
			
		}
		}
		


public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void clear() {
		for(int i = 0; i < 50; i++){
				System.out.println("");
				};
	}

		public void affiche(String string) {
	System.out.println(string);
	
		}
		
		
		

	}
		

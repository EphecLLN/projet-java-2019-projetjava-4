package donnees;



import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;





public class Bdd{

private Connection connection;
private Statement statement;
private ResultSet resultSet;

//----------------------------------------------------------------------------------------------------------------

public Bdd(){

try{

Class.forName("org.gjt.mm.mysql.Driver");

}catch(ClassNotFoundException classNonTrouvee){

JOptionPane.showMessageDialog(null,"Echec de chargement du driver : "+classNonTrouvee.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);

}	

}

//----------------------------------------------------------------------------------------------------------------

public void etablirConnexion(){

try{

String url = "jdbc:mysql://localhost:3306/java";
connection = DriverManager.getConnection(url,"root","");

}catch(SQLException exceptionSQL){

JOptionPane.showMessageDialog(null,"Echec d'établissement de la connexion à la base de données : "+exceptionSQL.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);

}

}

//----------------------------------------------------------------------------------------------------------------

public ResultSet lire(String requete){

try{

statement = connection.createStatement(); 
resultSet = statement.executeQuery(requete);

}catch (SQLException exceptionSQL) {
         
JOptionPane.showMessageDialog(null,"Echec d'exécution de la requête : "+exceptionSQL.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE );

}

return resultSet;

}

//----------------------------------------------------------------------------------------------------------------

public void  mettreAJour(String requete){

try{

statement = connection.createStatement();
statement.executeUpdate(requete);

}catch (SQLException exceptionSQL) {
         
JOptionPane.showMessageDialog(null,"Echec d'exécution de la requête : "+exceptionSQL.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE );

}

}

//----------------------------------------------------------------------------------------------------------------

public void fermerConnexion(){

try{

statement.close();
connection.close();

}catch(SQLException exceptionSQL){

JOptionPane.showMessageDialog(null,"Echec de fermeture de la connexion : "+exceptionSQL.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);

}

}

//----------------------------------------------------------------------------------------------------------------

}
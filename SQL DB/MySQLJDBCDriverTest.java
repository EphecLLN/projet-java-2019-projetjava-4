import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
 
 
 
public class MySQLJDBCDriverTest extends JFrame{
 
private static javax.swing.JList<String> list;
 
public static void main(String args[]) throws ClassNotFoundException, SQLException
 
{
 
Connection connection ;
 
Statement statement ;
 
ResultSet resultSet ;
ResultSetMetaData metaData ;
int numberOfColumns = 0;
DefaultListModel mod=new DefaultListModel();
 
try
 
{
 
Class.forName("com.mysql.jdbc.Driver");
 
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java" ,"root",""); //phone et le nom de BD 
 
statement = connection.createStatement();
 
System.out.println("Connection Established");

//Création d'un objet Statement
Statement state = connection.createStatement();
//L'objet ResultSet contient le résultat de la requête SQL
ResultSet result = state.executeQuery("SELECT * FROM prof");
//On récupère les MetaData
ResultSetMetaData resultMeta = result.getMetaData();
   
System.out.println("\n**********************************");
//On affiche le nom des colonnes
for(int i = 1; i <= resultMeta.getColumnCount(); i++)
  System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
   
System.out.println("\n**********************************");
   
while(result.next()){         
  for(int i = 1; i <= resultMeta.getColumnCount(); i++)
    System.out.print("\t" + result.getObject(i).toString() + "\t |");
      
  System.out.println("\n---------------------------------");

}






 
 
}catch(ClassNotFoundException | SQLException e){
    System.err.println(e);
}
}}
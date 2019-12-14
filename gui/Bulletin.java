package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;

import java.text.DecimalFormat;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.StringTokenizer;

import pack_classe.Note;

import donnees.Bdd;





public class Bulletin extends Note{

private JLabel nom,prenom;
private JPanel conteneurPrincipal;
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public Bulletin(String idEtudiant){

this.conteneurPrincipal = new JPanel(false);
this.conteneurPrincipal.setBackground(Color.WHITE);

JLabel estm = new JLabel("ESTM - ECOLE SUPERIEURE DE TECHNOLOGIE ET DE MANAGEMENT");
estm.setOpaque(true);
estm.setBackground(Color.WHITE);
estm.setFont(new Font("Times New Roman",Font.BOLD,24));

JLabel lhh = new JLabel("_________________________________________________________________");
lhh.setOpaque(true);
lhh.setBackground(Color.WHITE);
lhh.setFont(new Font("Verdana",Font.BOLD,18));

JLabel aa = new JLabel("Année Académique 2007/2008  - ");
aa.setOpaque(true);
aa.setBackground(Color.WHITE);
aa.setFont(new Font("Verdana",Font.BOLD,16));

JLabel lp = new JLabel("LICENCE PROFESSIONNELLE");
lp.setOpaque(true);
lp.setBackground(Color.WHITE);
lp.setFont(new Font("Verdana",Font.BOLD,18));

JLabel espaceh = new JLabel("                                                                 ");
espaceh.setOpaque(true);
espaceh.setBackground(Color.WHITE);
espaceh.setFont(new Font("Verdana",Font.BOLD,22));

JLabel bn = new JLabel("                          BULLETIN DE NOTES                          ");
bn.setOpaque(true);
bn.setBackground(Color.WHITE);
bn.setFont(new Font("Verdana",Font.BOLD,20));

JLabel lhb = new JLabel("                         ___________________                         ");
lhb.setOpaque(true);
lhb.setBackground(Color.WHITE);
lhb.setFont(new Font("Verdana",Font.BOLD,18));

JPanel conteneurNom = new JPanel(new FlowLayout(FlowLayout.LEFT));
conteneurNom.setBackground(Color.WHITE);
conteneurNom.setPreferredSize(new Dimension(890,27));

JPanel conteneurPrenom = new JPanel(new FlowLayout(FlowLayout.LEFT));
conteneurPrenom.setBackground(Color.WHITE);
conteneurPrenom.setPreferredSize(new Dimension(890,27));

this.nom = new JLabel();
this.nom.setOpaque(true);
this.nom.setBackground(Color.WHITE);

this.prenom = new JLabel();
this.prenom.setOpaque(true);
this.prenom.setBackground(Color.WHITE);

conteneurNom.add(this.nom);
conteneurPrenom.add(this.prenom);

this.conteneurPrincipal.add(estm);
this.conteneurPrincipal.add(lhh);
this.conteneurPrincipal.add(aa);
this.conteneurPrincipal.add(lp);
this.conteneurPrincipal.add(espaceh);
this.conteneurPrincipal.add(bn);
this.conteneurPrincipal.add(lhb);
this.conteneurPrincipal.add(conteneurNom);
this.conteneurPrincipal.add(conteneurPrenom);

this.afficherIdentiteEtudiant(idEtudiant);
this.creerAfficherTableau(idEtudiant);
calculerAfficherTotauxEtMoyenne(idEtudiant);

JLabel espaceb1 = new JLabel("                                                                 ");
espaceb1.setOpaque(true);
espaceb1.setBackground(Color.WHITE);
espaceb1.setFont(new Font("Verdana",Font.BOLD,22));

JPanel conteneurDE = new JPanel(new FlowLayout(FlowLayout.RIGHT));
conteneurDE.setBackground(Color.WHITE);
conteneurDE.setPreferredSize(new Dimension(890,27));

JLabel DE = new JLabel("                                      Le Direteur des Etudes");
DE.setOpaque(true);
DE.setBackground(Color.WHITE);

JLabel espaceb2 = new JLabel("                                                                 ");
espaceb2.setOpaque(true);
espaceb2.setBackground(Color.WHITE);
espaceb2.setFont(new Font("Verdana",Font.BOLD,22));

JPanel conteneurNomDE = new JPanel(new FlowLayout(FlowLayout.RIGHT));
conteneurNomDE.setBackground(Color.WHITE);
conteneurNomDE.setPreferredSize(new Dimension(890,27));

JLabel nomDE = new JLabel("                                      Félix CAMPAL");
nomDE.setOpaque(true);
nomDE.setBackground(Color.WHITE);

JPanel conteneurNB = new JPanel(new FlowLayout(FlowLayout.LEFT));
conteneurNB.setBackground(Color.WHITE);
conteneurNB.setPreferredSize(new Dimension(890,27));

JLabel NB = new JLabel("NB : Il n'est délivré qu'un seul exemplaire du bulletin");
NB.setOpaque(true);
NB.setBackground(Color.WHITE);
NB.setFont(new Font("Verdana",Font.BOLD|Font.ITALIC,11));

conteneurDE.add(DE);
conteneurNomDE.add(nomDE);
conteneurNB.add(NB);

this.conteneurPrincipal.add(espaceb1);
this.conteneurPrincipal.add(conteneurDE);
this.conteneurPrincipal.add(espaceb2);
this.conteneurPrincipal.add(conteneurNomDE);
this.conteneurPrincipal.add(conteneurNB);

JFrame fenetre = new JFrame("Bulletin de notes");
fenetre.getContentPane().add(this.conteneurPrincipal);
Image iconeFenetre = Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"/images/icone_crayon.gif");
fenetre.setIconImage(iconeFenetre);
fenetre.setBounds(0,0,1024,768);
fenetre.setResizable(false);
fenetre.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
fenetre.setVisible(true);

}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

private void creerAfficherTableau(String idEtudiant){
	
try{

ResultSet jeuEnregistrements = this.calculerMoyennesMatieres(idEtudiant);
ResultSetMetaData metaDonnees = jeuEnregistrements.getMetaData();	

StringBuffer tampon = new StringBuffer();

while(jeuEnregistrements.next()){
									
for(int j = 0; j < metaDonnees.getColumnCount(); j++){
								
tampon.append(jeuEnregistrements.getObject(j+1)+"¤");

}

}
					
StringTokenizer st = new StringTokenizer(tampon.toString(),"¤");

jeuEnregistrements.last();
int nl = jeuEnregistrements.getRow();

Object[][] lignes = new Object[nl+1][metaDonnees.getColumnCount()+1];

int i = 0,j = 0;

while (st.hasMoreTokens()) {	
					
if( j < metaDonnees.getColumnCount()){ lignes[i][j] = st.nextToken(); j++; }
else{ j = 0; i++; }

}

this.getConnexion().fermerConnexion();

String[] nomsDesColonnes = {"MATIERE","MOYENNE","","TOTAL","APPRECIATION"};

JTable table = new JTable(lignes,nomsDesColonnes);
table.setPreferredScrollableViewportSize(new Dimension(882,250));
table.setFillsViewportHeight(true);

JScrollPane conteneurTable = new JScrollPane(table);
conteneurTable.setBackground(Color.WHITE);
conteneurTable.setMinimumSize(new Dimension(0,0));
Border bordNoir = BorderFactory.createLineBorder(Color.BLACK);
conteneurTable.setBorder(bordNoir);

this.conteneurPrincipal.add(conteneurTable);
			
}catch (SQLException exceptionSQL) {
		    
JOptionPane.showMessageDialog(null,"Echec d'exécution de la requête : "+exceptionSQL.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE );

}	
	
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

private void afficherIdentiteEtudiant(String idEtudiant){

try{	
	
	Bdd connexion = new Bdd();
connexion.etablirConnexion();	
String requete = "SELECT nom,prenom FROM etudiants WHERE ID_etudiant='"+idEtudiant+"'";
ResultSet jeuEnregistrements = connexion.lire(requete);
ResultSetMetaData metaDonnees = jeuEnregistrements.getMetaData();
	
while(jeuEnregistrements.next()){
for(int i = 1; i <= metaDonnees.getColumnCount(); i++){
		
if(i == 1) this.nom.setText("NOM       :    "+jeuEnregistrements.getString(i));
if(i == 2) this.prenom.setText("PRENOM(S)       :    "+jeuEnregistrements.getString(i));

}
}

connexion.fermerConnexion();

}catch (SQLException exceptionSQL) {
    
JOptionPane.showMessageDialog(null,"Echec d'exécution de la requête : "+exceptionSQL.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE );

}

}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

private void calculerAfficherTotauxEtMoyenne(String idEtudiant){	
	
try{	
	
	Bdd connexion = new Bdd();
connexion.etablirConnexion();	
String requete = "SELECT ,AVG(valeur)* FROM matieres,notes " 
	             +"WHERE ID_etudiant='"+idEtudiant+"' "
	             +"AND matieres.ID_matiere=notes.ID_matiere "
	             +"GROUP BY notes.ID_matiere";
ResultSet jeuEnregistrements = connexion.lire(requete);
ResultSetMetaData metaDonnees = jeuEnregistrements.getMetaData();
	
int totals = 0;
double totalMoyennesCoefficiees = 0;

while(jeuEnregistrements.next()){
for(int i = 1; i <= metaDonnees.getColumnCount(); i++){
			
if(i == 1) totals +=  Integer.parseInt(jeuEnregistrements.getString(i));
if(i == 2) totalMoyennesCoefficiees +=  Double.parseDouble(jeuEnregistrements.getString(i));

}
}

connexion.fermerConnexion();

this.conteneurPrincipal.add(new JLabel("TOTAL S : "+totals
+"                       TOTAL MOYENNES PONDEREES : "+totalMoyennesCoefficiees
+"                       MOYENNE GENERALE : "+new DecimalFormat("0.00").format(totalMoyennesCoefficiees/totals)
+"                       RANG : X ème"));

}catch (SQLException exceptionSQL) {
	    
JOptionPane.showMessageDialog(null,"Echec d'exécution de la requête : "+exceptionSQL.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE );

}

}


//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}
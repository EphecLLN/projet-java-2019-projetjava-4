package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.StringTokenizer;

import pack_classe.Etudiant;
import pack_classe.Matiere;
import pack_classe.Note;





public class Accueil implements ActionListener{

private JPanel cp,cc;	
private JComboBox et,mt,nt;
private Etudiant etdt = new Etudiant();
private Matiere mtre = new Matiere();
private Note nte = new Note();
private JTextField cne,cpn,cdn,cme,cidse,cnr,cnm,ccm,cmm,cidsm,cideln,cidean,cidman,cna,cidesn,cidmsn,cns;
private JLabel lme,lmm;
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public Accueil(){

this.cp = new JPanel(false);
this.cp.setBackground(Color.WHITE);

JLabel nomApplication = new JLabel("ESTM - GESTION DES NOTES");
nomApplication.setOpaque(true);
nomApplication.setBackground(Color.WHITE);
nomApplication.setForeground(new Color(102,51,0));
nomApplication.setFont(new Font("Verdana",Font.BOLD,54));

JLabel lh = new JLabel("___________________________________");
lh.setOpaque(true);
lh.setBackground(Color.WHITE);
lh.setForeground(new Color(102,51,0));
lh.setFont(new Font("Verdana",Font.BOLD,38));	


Object[] menuEt = new Object[]{"Etudiants","Liste des étudiants","Ajout d'un étudiant"
                              ,"Modification d'un étudiant","Suppression d'un étudiant"
                              ,"Recherche d'un étudiant"};
this.et = new JComboBox(menuEt);
this.et.setBackground(new Color(102,51,0));
this.et.setFont(new Font("Verdana",Font.BOLD,11));
this.et.setForeground(Color.WHITE);
this.et.addActionListener(this);

Object[] menuMt = new Object[]{"Matières","Liste des matières","Ajout d'une matière"
                               ,"Modification d'une matière","Suppression d'une matière"};
this.mt = new JComboBox(menuMt);
this.mt.setBackground(new Color(102,51,0));
this.mt.setFont(new Font("Verdana",Font.BOLD,11));
this.mt.setForeground(Color.WHITE);
this.mt.addActionListener(this);

Object[] menuNt = new Object[]{"Notes","Notes d'un étudiant","Moyenne par matière"
		                       ,"Ajout d'une note","Suppression d'une note"};
this.nt = new JComboBox(menuNt);
this.nt.setBackground(new Color(102,51,0));
this.nt.setFont(new Font("Verdana",Font.BOLD,11));
this.nt.setForeground(Color.WHITE);
this.nt.addActionListener(this);

JLabel lb = new JLabel("___________________________________");
lb.setOpaque(true);
lb.setBackground(Color.WHITE);
lb.setForeground(new Color(102,51,0));
lb.setFont(new Font("Verdana",Font.BOLD,38));

this.cc = new JPanel(false);
this.cc.setBackground(Color.WHITE);

this.cp.add(nomApplication);
this.cp.add(lh);
this.cp.add(this.et);
this.cp.add(this.mt);
this.cp.add(this.nt);
this.cp.add(lb);
this.cp.add(this.cc);


JFrame f = new JFrame("Gestion des notes");
f.getContentPane().add(cp);
f.setBounds(0,0,1024,768);
f.setResizable(false);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setVisible(true);

}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public void actionPerformed(ActionEvent ae){
	
if(ae.getSource() == et){
	
Object tache = et.getSelectedItem();
et.getSelectedIndex();

if(tache.equals("Liste des étudiants")) this.afficherListeEtudiants("listage");
else if(tache.equals("Ajout d'un étudiant")) this.afficherInterfaceAjoutEtudiant("insertion");
else if(tache.equals("Modification d'un étudiant")){
	this.afficherInterfaceAjoutEtudiant("modification");
	this.lme.setEnabled(true);
	this.cme.setEditable(true);
}
else if(tache.equals("Suppression d'un étudiant")) this.afficherInterfaceSuppressionEtudiant();
else if(tache.equals("Recherche d'un étudiant")) this.afficherInterfaceRechercheEtudiant();
	
}

if(ae.getSource() == mt){
	
Object tache = mt.getSelectedItem();
mt.getSelectedIndex();

if(tache.equals("Liste des matières")) this.afficherListeMatieres();
else if(tache.equals("Ajout d'une matière")) this.afficherInterfaceAjoutMatiere("insertion");
else if(tache.equals("Modification d'une matière")){
	this.afficherInterfaceAjoutMatiere("modification");
	this.lmm.setEnabled(true);
	this.cmm.setEditable(true);
}
else if(tache.equals("Suppression d'une matière")) this.afficherInterfaceSuppressionMatiere();
		
}

if(ae.getSource() == nt){
	
Object tache = nt.getSelectedItem();
nt.getSelectedIndex();

if(tache.equals("Notes d'un étudiant")) this.afficherListeNotes();
else if(tache.equals("Ajout d'une note")) this.afficherInterfaceAjoutNote();
else if(tache.equals("Suppression d'une note")) this.afficherInterfaceSuppressionNote();
else if(tache.equals("Moyenne par matière")) this.afficherMoyenneParMatiere();
		
}
	
	
}






//-Partie Etudiants---------------------------------------------------------------------------------------------------------

private void afficherListeEtudiants(String typeTache){

String[] nomsDesColonnes = {"ID","Nom","Prénom(s)","Date de naissance"};	
	
if(typeTache.equals("listage")){
	

if(this.cc.getComponentCount() != 0){
this.cc.removeAll();
this.cc.validate();
}

this.cc.add(this.trierDonneesRecues(etdt.listerEtudiants(),nomsDesColonnes,"Etudiants"));

}
else if(typeTache.equals("recherche")){
	
this.cc.setPreferredSize(new Dimension(1009,400));
this.cc.add(this.trierDonneesRecues(etdt.rechercherEtudiant(this.cnr.getText()),nomsDesColonnes,"Etudiants"));

}

this.cc.validate();
this.cp.validate();
	
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

private void afficherInterfaceAjoutEtudiant(String typeTache){

this.lme = new JLabel("ID de l'étudiant à modifier");
this.lme.setForeground(new Color(102,51,0));
this.lme.setFont(new Font("Verdana",Font.BOLD,11));
this.lme.setEnabled(false);
	
JLabel ln = new JLabel("Nom");
ln.setForeground(new Color(102,51,0));
ln.setFont(new Font("Verdana",Font.BOLD,11));

JLabel lpn = new JLabel("Prénom");
lpn.setForeground(new Color(102,51,0));
lpn.setFont(new Font("Verdana",Font.BOLD,11));

JLabel ldn = new JLabel("Date de naissance");
ldn.setForeground(new Color(102,51,0));
ldn.setFont(new Font("Verdana",Font.BOLD,11));

this.cme = new JTextField(30);
this.cme.setEditable(false);

this.cne = new JTextField(30);

this.cpn = new JTextField(30);

this.cdn = new JTextField(30);
this.cdn.setText("AAAA-MM-JJ");

JButton ee = new JButton("Enregistrer");
ee.setBackground(new Color(102,51,0));
ee.setFont(new Font("Verdana",Font.BOLD,11));
ee.setForeground(Color.WHITE);

if(typeTache.equals("insertion"))
ee.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
etdt.ajouterEtudiant(cne.getText(),cpn.getText(),cdn.getText());
cme.setText("");
cne.setText("");
cpn.setText("");
cdn.setText("AAAA-MM-JJ");
	                                              }
});
else if(typeTache.equals("modification"))
ee.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
etdt.modifierEtudiant(cne.getText(),cpn.getText(),cdn.getText(),cme.getText());
cme.setText("");
cne.setText("");
cpn.setText("");
cdn.setText("AAAA-MM-JJ");
			                                      }
});


JPanel cf = new JPanel(false);
cf.setLayout(new GridLayout(5,2,2,30));
cf.setBackground(Color.WHITE);

cf.add(lme);
cf.add(this.cme);
cf.add(ln);
cf.add(this.cne);
cf.add(lpn);
cf.add(this.cpn);
cf.add(ldn);
cf.add(this.cdn);
cf.add(ee);

if(this.cc.getComponentCount() != 0){
this.cc.removeAll();
this.cc.validate();
}

this.cc.setPreferredSize(null);
this.cc.add(cf);
this.cc.validate();
this.cp.validate();
	
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

private void afficherInterfaceSuppressionEtudiant(){
	
JLabel lids = new JLabel("ID de l'étudiant à supprimer");
lids.setOpaque(true);
lids.setBackground(Color.WHITE);
lids.setForeground(new Color(102,51,0));
lids.setFont(new Font("Verdana",Font.BOLD,11));

this.cidse = new JTextField(10);

JButton se = new JButton("Supprimer");
se.setBackground(new Color(102,51,0));
se.setFont(new Font("Verdana",Font.BOLD,11));
se.setForeground(Color.WHITE);
se.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
		                                    etdt.supprimerEtudiant(cidse.getText());
		                                    cidse.setText("");
		                                   }
});

if(this.cc.getComponentCount() != 0){
this.cc.removeAll();
this.cc.validate();
}

this.cc.setPreferredSize(null);
this.cc.add(lids);
this.cc.add(cidse);
this.cc.add(se);
this.cc.validate();
this.cp.validate();	
	
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

private void afficherInterfaceRechercheEtudiant(){

JLabel lnr = new JLabel("Nom de l'étudiant à rechercher");
lnr.setOpaque(true);
lnr.setBackground(Color.WHITE);
lnr.setForeground(new Color(102,51,0));
lnr.setFont(new Font("Verdana",Font.BOLD,11));

cnr = new JTextField(30);

JButton re = new JButton("Rechercher");
re.setBackground(new Color(102,51,0));
re.setFont(new Font("Verdana",Font.BOLD,11));
re.setForeground(Color.WHITE);
re.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
	                                       afficherListeEtudiants("recherche");    
	                                      }
});

JButton rr = new JButton("Nouvelle recherche");
rr.setBackground(new Color(102,51,0));
rr.setFont(new Font("Verdana",Font.BOLD,11));
rr.setForeground(Color.WHITE);
rr.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
	                                      afficherInterfaceRechercheEtudiant();   
	                                       }
});

if(this.cc.getComponentCount() != 0){
this.cc.removeAll();
this.cc.validate();
}

this.cc.setPreferredSize(null);
this.cc.add(lnr);
this.cc.add(cnr);
this.cc.add(re);
this.cc.add(rr);
this.cc.validate();
this.cp.validate();	
	
}





//-Partie Matières---------------------------------------------------------------------------------------------------------

private void afficherListeMatieres(){
	
String[] nomsDesColonnes = {"ID","Nom","credit"};	
	
if(this.cc.getComponentCount() != 0){
this.cc.removeAll();
this.cc.validate();
}

this.cc.setPreferredSize(new Dimension(1009,400));
this.cc.add(this.trierDonneesRecues(mtre.listerMatieres(),nomsDesColonnes,"Matieres"));
this.cc.validate();
this.cp.validate();	
	
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

private void afficherInterfaceAjoutMatiere(String typeTache){

this.lmm = new JLabel("ID de la matière à modifier");
this.lmm.setForeground(new Color(102,51,0));
this.lmm.setFont(new Font("Verdana",Font.BOLD,11));
this.lmm.setEnabled(false);
	
JLabel ln = new JLabel("Nom");
ln.setForeground(new Color(102,51,0));
ln.setFont(new Font("Verdana",Font.BOLD,11));

JLabel lc = new JLabel("credit");
lc.setForeground(new Color(102,51,0));
lc.setFont(new Font("Verdana",Font.BOLD,11));

this.cmm = new JTextField(30);
this.cmm.setEditable(false);

this.cnm = new JTextField(30);

this.ccm = new JTextField(30);

JButton em = new JButton("Enregistrer");
em.setBackground(new Color(102,51,0));
em.setFont(new Font("Verdana",Font.BOLD,11));
em.setForeground(Color.WHITE);

if(typeTache.equals("insertion"))
em.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
		    mtre.ajouterMatiere(cnm.getText(),ccm.getText());
		      cmm.setText("");
		      cnm.setText("");
		      ccm.setText("");
	                                              }
});
else if(typeTache.equals("modification"))
em.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
	         mtre.modifierMatiere(cnm.getText(),ccm.getText(),cmm.getText());
	         cmm.setText("");
	         cnm.setText("");
		     ccm.setText("");
			                                      }
});


JPanel cf = new JPanel(false);
cf.setLayout(new GridLayout(4,2,2,30));
cf.setBackground(Color.WHITE);

cf.add(lmm);
cf.add(this.cmm);
cf.add(ln);
cf.add(this.cnm);
cf.add(lc);
cf.add(this.ccm);
cf.add(em);

if(this.cc.getComponentCount() != 0){
this.cc.removeAll();
this.cc.validate();
}

this.cc.setPreferredSize(null);
this.cc.add(cf);
this.cc.validate();
this.cp.validate(); 

	
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

private void afficherInterfaceSuppressionMatiere(){

JLabel lids = new JLabel("ID de la matière à supprimer");
lids.setOpaque(true);
lids.setBackground(Color.WHITE);
lids.setForeground(new Color(102,51,0));
lids.setFont(new Font("Verdana",Font.BOLD,11));

this.cidsm = new JTextField(10);

JButton sm = new JButton("Supprimer");
sm.setBackground(new Color(102,51,0));
sm.setFont(new Font("Verdana",Font.BOLD,11));
sm.setForeground(Color.WHITE);
sm.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
			                                 mtre.supprimerMatiere(cidsm.getText());
			                                  cidsm.setText("");
			                                   }
});

if(this.cc.getComponentCount() != 0){
this.cc.removeAll();
this.cc.validate();
}

this.cc.setPreferredSize(null);
this.cc.add(lids);
this.cc.add(cidsm);
this.cc.add(sm);
this.cc.validate();
this.cp.validate();	
	
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------






//-Partie Notes---------------------------------------------------------------------------------------------------------
private void afficherListeNotes(){
	
JLabel lideln = new JLabel("ID de l'étudiant dont vous voulez lister les notes");
lideln.setOpaque(true);
lideln.setBackground(Color.WHITE);
lideln.setForeground(new Color(102,51,0));
lideln.setFont(new Font("Verdana",Font.BOLD,12));

this.cideln = new JTextField(10);

JButton ln = new JButton("Valider");
ln.setBackground(new Color(102,51,0));
ln.setFont(new Font("Verdana",Font.BOLD,11));
ln.setForeground(Color.WHITE);
ln.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){

String[] nomsDesColonnes = {"Matière","Note"};
cc.setPreferredSize(new Dimension(1009,400));
cc.add(trierDonneesRecues(nte.listerNotes(cideln.getText()),nomsDesColonnes,"Notes"));
cc.validate();
cp.validate();
	
	                                       }
});

if(this.cc.getComponentCount() != 0){
this.cc.removeAll();
this.cc.validate();
}

this.cc.setPreferredSize(null);
this.cc.add(lideln);
this.cc.add(cideln);
this.cc.add(ln);
this.cc.validate();
this.cp.validate();
		
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

private void afficherInterfaceAjoutNote(){
	
JLabel lidean = new JLabel("ID de l'étudiant concerné par la note");
lidean.setForeground(new Color(102,51,0));
lidean.setFont(new Font("Verdana",Font.BOLD,11));

JLabel lidman = new JLabel("ID de la matière concerné par la note");
lidman.setForeground(new Color(102,51,0));
lidman.setFont(new Font("Verdana",Font.BOLD,11));

JLabel lna = new JLabel("Note");
lna.setForeground(new Color(102,51,0));
lna.setFont(new Font("Verdana",Font.BOLD,11));

this.cidean = new JTextField(30);
this.cidman = new JTextField(30);
this.cna = new JTextField(30);

JButton en = new JButton("Enregistrer");
en.setBackground(new Color(102,51,0));
en.setFont(new Font("Verdana",Font.BOLD,11));
en.setForeground(Color.WHITE);


en.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
			 nte.ajouterNote(cidean.getText(),cidman.getText(),cna.getText());
			 cidean.setText("");
			 cidman.setText("");
			 cna.setText("");
		                                              }
});


JPanel cf = new JPanel(false);
cf.setLayout(new GridLayout(4,2,2,30));
cf.setBackground(Color.WHITE);

cf.add(lidean);
cf.add(this.cidean);
cf.add(lidman);
cf.add(this.cidman);
cf.add(lna);
cf.add(this.cna);
cf.add(en);

if(this.cc.getComponentCount() != 0){
this.cc.removeAll();
this.cc.validate();
}

this.cc.setPreferredSize(null);
this.cc.add(cf);
this.cc.validate();
this.cp.validate(); 

}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

private void afficherMoyenneParMatiere(){
	
String[] nomsDesColonnes = {"Matière","Moyenne","credit","Moyenne pondérée"};

if(this.cc.getComponentCount() != 0){
this.cc.removeAll();
this.cc.validate();
}

this.cc.setPreferredSize(new Dimension(1009,400));

JButton eb = new JButton("Editer le bulletin de notes");
eb.setBackground(new Color(102,51,0));
eb.setFont(new Font("Verdana",Font.BOLD,11));
eb.setForeground(Color.WHITE);
eb.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
                                           new Bulletin(cideln.getText());	                    
	                                       }
});

this.cc.add(this.trierDonneesRecues(
				nte.calculerMoyennesMatieres(cideln.getText()),nomsDesColonnes,"Notes"));
this.cc.add(eb);
this.cc.validate();
this.cp.validate();

}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

private void afficherInterfaceSuppressionNote(){

JLabel lidesn = new JLabel("ID de l'étudiant dont vous voulez supprimer la note");
lidesn.setOpaque(true);
lidesn.setBackground(Color.WHITE);
lidesn.setForeground(new Color(102,51,0));
lidesn.setFont(new Font("Verdana",Font.BOLD,11));
	
JLabel lidmsn = new JLabel("ID de la matière dont vous voulez supprimer la note");
lidmsn.setOpaque(true);
lidmsn.setBackground(Color.WHITE);
lidmsn.setForeground(new Color(102,51,0));
lidmsn.setFont(new Font("Verdana",Font.BOLD,11));

JLabel lns = new JLabel("Note à supprimer");
lns.setOpaque(true);
lns.setBackground(Color.WHITE);
lns.setForeground(new Color(102,51,0));
lns.setFont(new Font("Verdana",Font.BOLD,11));

this.cidesn = new JTextField(10);
this.cidmsn = new JTextField(10);
this.cns = new JTextField(10);

JButton sn = new JButton("Supprimer");
sn.setBackground(new Color(102,51,0));
sn.setFont(new Font("Verdana",Font.BOLD,11));
sn.setForeground(Color.WHITE);
sn.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
		         nte.supprimerNote(cidesn.getText(),cidmsn.getText(),cns.getText());
		         cidesn.setText("");
		         cidmsn.setText("");
		         cns.setText("");
		        
		                                       }
});

JPanel cf = new JPanel(false);
cf.setLayout(new GridLayout(4,2,2,30));
cf.setBackground(Color.WHITE);

cf.add(lidesn);
cf.add(cidesn);
cf.add(lidmsn);
cf.add(cidmsn);
cf.add(lns);
cf.add(cns);
cf.add(sn);

if(this.cc.getComponentCount() != 0){
this.cc.removeAll();
this.cc.validate();
}

this.cc.setPreferredSize(null);
this.cc.add(cf);
this.cc.validate();
this.cp.validate();
	
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------






//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

private JScrollPane trierDonneesRecues(ResultSet resultSet,String[] nomsDesColonnes,String rubrique){
	
JScrollPane scrollPane = null;	
	
try{	
			
ResultSetMetaData metaDonnees = resultSet.getMetaData();

StringBuffer tampon = new StringBuffer();	

while(resultSet.next()){
								
for(int j = 0; j < metaDonnees.getColumnCount(); j++){
							
tampon.append(resultSet.getObject(j+1)+"¤");

}

}
				
StringTokenizer st = new StringTokenizer(tampon.toString(),"¤");

resultSet.last();
int nl = resultSet.getRow();

Object[][] lignes = new Object[nl][metaDonnees.getColumnCount()];

int i = 0,j = 0;

while (st.hasMoreTokens()) {	
				
if( j < metaDonnees.getColumnCount()){ lignes[i][j] = st.nextToken(); j++; }
else{ j = 0; i++; }

}

if(rubrique.equals("Etudiants")) etdt.getConnexion().fermerConnexion();
else if(rubrique.equals("Matieres")) mtre.getConnexion().fermerConnexion();
else if(rubrique.equals("Notes")) nte.getConnexion().fermerConnexion();

JTable table = new JTable(lignes,nomsDesColonnes);
table.setPreferredScrollableViewportSize(new Dimension(500, 70));
table.setFillsViewportHeight(true);

scrollPane = new JScrollPane(table);
scrollPane.setPreferredSize(new Dimension(1008,360));
		
}catch (SQLException exceptionSQL) {
	    
JOptionPane.showMessageDialog(null,"Echec d'exécution de la requête : "+exceptionSQL.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE );

}

return scrollPane;	
	
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}
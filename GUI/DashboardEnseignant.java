package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import DataBase.Base;
import GestionTables.GestionClasse;
import GestionTables.GestionEtudiant;
import Tables.Classe;
import Tables.Etudiant;

public class DashboardEnseignant extends JFrame {

    private JFrame frame;
    private JLabel libelleNom;
    private JLabel libellePrenom;

    JTable tableau1;
    JButton buttonGetClasse;

    private GestionClasse gestionClasse;
    private GestionEtudiant gestionEtudiant;
    private Base dataBase;
    private ResultSet resultat;
    private String nom;
    private String preNom;
    private Vector<Etudiant> etudiant;
    private ArrayList<Classe> classeList;
    private Classe[] tabClasse;
    private JComboBox classeBox;
    private int idClasse;

    public DashboardEnseignant(String username, String password) {
        this.dataBase = new Base();
        this.gestionClasse = new GestionClasse();
        this.gestionEtudiant = new GestionEtudiant();
        frame = new JFrame();
        
        

        this.etudiant = new Vector<Etudiant>();

        this.classeList = new ArrayList<Classe>();
        this.tabClasse = new Classe[100];
        String[] tabLibell = new String[100];

        this.classeList = this.gestionClasse.getAllClasse();

        for (int i = 0; i < this.classeList.size(); i++) {
            this.tabClasse[i] = this.classeList.get(i);
            tabLibell[i] = this.tabClasse[i].getLibelle();
        }
        this.classeBox = new JComboBox<String>(tabLibell);
        this.classeBox.setBounds(5, 50, 150, 20);
        

        this.buttonGetClasse = new JButton("Afficher Etudiant");
        this.buttonGetClasse.setBounds(200, 50, 150, 20);

        String query = "SELECT * FROM enseignant WHERE login = '" + username + "'";
        this.resultat = dataBase.useStatament(query);
        try {
            if (resultat.next()) {
                this.nom = resultat.getString(2);
                this.preNom = resultat.getString(3);
                this.libelleNom = new JLabel(nom);
                this.libellePrenom = new JLabel(preNom);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.libelleNom.setBounds(450, 5, 100, 35);
        this.libellePrenom.setBounds(500, 5, 100, 35);

        buttonGetClasse.addActionListener((ActionListener) new ActionListener() {
            ArrayList<Etudiant> listEtudiant = new ArrayList<Etudiant>();
            private GestionClasse gestionClasse = new GestionClasse();

            @Override
            public void actionPerformed(ActionEvent e) {
                  
                Object libelleClasse = new Object();
                libelleClasse = classeBox.getSelectedItem();
                String libelleClass = libelleClasse.toString();
                idClasse = this.gestionClasse.getClasseByLibelle(libelleClass);
                listEtudiant = gestionEtudiant.getEtudiantByIdClasse(idClasse);
                Vector<Vector> data = new Vector<Vector>();
                Vector<String> column = new Vector<String>();
                for(int i=0; i < listEtudiant.size(); i++){

                    int idClassee;
                    String nom, prenom,login,idCls;
                    idClassee = listEtudiant.get(i).getIdClasse();
                    idCls = Integer.toString(idClassee);
                    nom = listEtudiant.get(i).getNom();
                    prenom = listEtudiant.get(i).getPrenom();
                    login = listEtudiant.get(i).getLogin();

                    Vector<String> row1 = new Vector<String>();
                    
                    row1.addElement(nom);
                    row1.addElement(prenom);
                    row1.addElement(login);
                    row1.addElement(idCls);

                    data.addElement(row1);
                    // System.out.println(data);
                    System.out.println(listEtudiant);
                    column.addElement("nom");
                    column.addElement("prenom");
                    column.addElement("login");
                    column.addElement("id_classe");

                    
                    JTable table = new JTable(data, column);
                    table.setBounds(10, 80, 500, 500);
                    frame.invalidate();
                    frame.validate();
                    frame.repaint();
                    
                    add(table); 
                }
            }
        });

        add(libelleNom);
        add(libellePrenom);
        add(buttonGetClasse);
        add(this.classeBox);

        setTitle("Gestion Absence ~ Enseignant Dashboard");
        setSize(900, 700);
        setLayout(null);
        setVisible(true);
    }

}

/*
 * // 
 * 
 * 
 * // ListEtudiant = gestionEtudiant.getEtudiantByIdClasse(idClasse);
 * 
 * // 
 * // 
 * // 
 * 
 * // 
 * 
 * // 
 * 
 * // 
 * 
 * // 
 * 
 * // 
 * // }
 */
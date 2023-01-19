package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import DataBase.Base;
import GestionTables.GestionClasse;
import Tables.Classe;

public class DashboardEnseignant extends JFrame {

    private JFrame frame;
    private JLabel libelleNom;
    private JLabel libellePrenom;

    JTable tableau1;
    JButton buttonGetClasse;

    private GestionClasse gestionClasse;
    private Base dataBase;
    private ResultSet resultat;
    private String nom;
    private String preNom;
    private Vector<Classe> classe;

    public DashboardEnseignant(String username, String password) {
        this.dataBase = new Base();
        this.gestionClasse = new GestionClasse();
        this.classe = new Vector<Classe>();

        frame = new JFrame();

        this.buttonGetClasse = new JButton("Classe");
        this.buttonGetClasse.setBounds(5, 100, 100, 35);

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

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Classe> ListClasse = new ArrayList<Classe> ();

                
                ListClasse = gestionClasse.getAllClasse();

                Vector<Vector> data1 = new Vector<Vector>();
                Vector<String> column = new Vector<String>();
                for(int i=0; i < ListClasse.size(); i++){

                    int idClasse;
                    String libelle, niveau,filliaire,idCls;

                    
                    idClasse = ListClasse.get(i).getIdClasse();
                    idCls = Integer.toString(idClasse);
                    libelle = ListClasse.get(i).getLibelle();
                    niveau = ListClasse.get(i).getNiveau();
                    filliaire = ListClasse.get(i).getFiliere();

                    Vector<String> row1 = new Vector<String>();
                    row1.addElement(idCls);
                    row1.addElement(libelle);
                    row1.addElement(niveau);
                    row1.addElement(filliaire);

                    data1.addElement(row1);

                    column.addElement("id");
                    column.addElement("libelle");
                    column.addElement("niveau");
                    column.addElement("filiaire");

                    System.out.println("ena houni data : " + data1);
                    JTable table = new JTable(data1, column);
                    table.setBounds(70, 200, 700, 500);
                    add(table);
                }     
            }
        });

        add(libelleNom);
        add(libellePrenom);
        add(buttonGetClasse);

        setTitle("Gestion Absence ~ Enseignant Dashboard");
        setSize(900, 700);
        setLayout(null);
        setVisible(true);
    }

}

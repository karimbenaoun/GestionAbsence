package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        // this.cnn = dataBase.connect();
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
                String strId;
                String libelle;
                String filiaire;
                String niveau;
                classe = gestionClasse.getAllClasse();
                for(int i = 0; i < classe.size(); i++){
                    int id = classe.get(i).getIdClasse();
                    strId = Integer.toString(id);
                    libelle = classe.get(i).getLibelle();
                    filiaire = classe.get(i).getFiliere();
                    niveau = classe.get(i).getNiveau();

                    Vector<String> row = new Vector<String>();
                    row.addElement(strId);
                    row.addElement(libelle);
                    row.addElement(filiaire);
                    row.addElement(niveau);

                    Vector<String> columns = new Vector<String>();

                    columns.addElement("titel1");
                    columns.addElement("titel1");
                    columns.addElement("titel1");
                    columns.addElement("titel1");
                    
                    Vector<Vector> data = new Vector<Vector>();
                    data.addElement(row);
                    System.out.println("data : "+data);
                    JTable table = new JTable(data,columns);
                    table.setBounds(50, 100,500,600);
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
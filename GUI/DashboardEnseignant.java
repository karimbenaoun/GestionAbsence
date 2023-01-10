package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import DataBase.Base;
import GestionTables.GestionClasse;
import GestionTables.GestionEnseignant;
import Tables.Classe;
import Tables.Enseignant;
import Tables.Etudiant;
import Tables.Matiere;
import Tables.Classe;



public class DashboardEnseignant extends JFrame {

    private JFrame frame;
    private JLabel libelleNom;
    private JLabel libellePrenom;

    JTable tableau1;
    JButton buttonGetClasse;

    private Etudiant etudiant;
    private Enseignant enseignant;
    private Matiere matiere;
    private GestionEnseignant gestionEnseignant;
    private GestionClasse gestionClasse;
    private Base dataBase;
    private Connection cnn;
    private ResultSet resultat;
    private String nom;
    private String preNom;
    private Vector<Classe> classe;


    public DashboardEnseignant(String username, String password) {
        this.dataBase = new Base();
        // this.cnn = dataBase.connect();
        this.gestionClasse = new GestionClasse();
        this.classe = new Vector();
        Vector<Vector> data = new Vector<Vector>();
        
        frame = new JFrame();

        this.buttonGetClasse = new JButton("Classe");
        this.buttonGetClasse.setBounds(5, 100, 100, 35);

        String query = "SELECT * FROM enseignant WHERE login = '"+username+"'";
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
       
        this.libelleNom.setBounds(450,5,100,35);
        this.libellePrenom.setBounds(500, 5, 100, 35);

        buttonGetClasse.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                classe = gestionClasse.getAllClasse();
            }

        });

        add(libelleNom);
        add(libellePrenom);
        add(buttonGetClasse);

        setTitle("Gestion Absence ~ Enseignant Dashboard");
        setSize(600, 700);
        setLayout(null);
        setVisible(true);
    }
    
}
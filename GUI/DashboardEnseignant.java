package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import DataBase.Base;
import GestionTables.GestionEnseignant;
import Tables.Classe;
import Tables.Enseignant;
import Tables.Etudiant;
import Tables.Matiere;



public class DashboardEnseignant extends JFrame {

    private JFrame frame;
    private JLabel libelleNom;
    private JLabel libellePrenom;
    JTable tableau1;

    private Etudiant etudiant;
    private Enseignant enseignant;
    private Matiere matiere;
    private GestionEnseignant gestionEnseignant;
    private Base dataBase;
    private Connection cnn;
    private ResultSet resultat;

    public DashboardEnseignant(String username, String password) {
        dataBase = new Base();
        cnn = dataBase.connect();
        frame = new JFrame();

        String query = "SELECT * FROM enseignant WHERE login = '"+username+"'";
        resultat = dataBase.useStatament(query);
        try {
            if (resultat.next()) {
                String nom = resultat.getString(2);
                String preNom = resultat.getString(3);
                libelleNom = new JLabel(nom);
                libellePrenom = new JLabel(preNom);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        libelleNom.setBounds(450,5,100,35);
        libellePrenom.setBounds(500, 5, 100, 35);

        add(libelleNom);
        add(libellePrenom);

        setTitle("Gestion Absence ~ Enseignant Dashboard");
        setSize(600, 700);
        setLayout(null);
        setVisible(true);
    }
    
}
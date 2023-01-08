package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import GestionTables.GestionEtudiant;
import Tables.Etudiant;
import DataBase.Base;

public class DashboardEtudiant extends JFrame {

    private JFrame frame;
    private JLabel libelleNom;
    private JLabel libellePrenom;
    private JLabel libelleLogin;
    private JLabel libelleIdClasse;
    JTable tableau1;


    private Etudiant etudiant;
    private GestionEtudiant gestionEtudiant;
    private Base db;
    private Connection cnn;

    public DashboardEtudiant(String username, String password) {

        this.frame = new JFrame();
        db = new Base();
        etudiant = new Etudiant();
        gestionEtudiant = new GestionEtudiant();
        etudiant = gestionEtudiant.authentifier(password, username);
        System.out.println("Dashboard GUI: "+ etudiant);

        int id = etudiant.getIdEtudiant();
        String nom = etudiant.getNom();
        String prenom = etudiant.getPrenom();
        int id_class = etudiant.getIdClasse();
        String id_classe = Integer.toString(id_class);

    /* DB treatment */
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        String ur1 = "jdbc:mysql://localhost:3306/gestion_absence";
        String DBusername = "root";
        String DBpassword = "";
        try {
            this.cnn = DriverManager.getConnection(ur1, DBusername, DBpassword);
            Statement state = this.cnn.createStatement();

            System.out.println("Connection avec succées ");
        } catch (SQLException e) {
            System.out.println("connection failed ");
            System.out.println(e.toString());
        }

        String query = "SELECT * FROM CLASSE WHERE id = '"+id_class+"'";
        try {
            Statement stm = this.cnn.prepareStatement(query);
            ResultSet res = stm.executeQuery(query);
            if (res.next()) {
                String libelle = res.getString(2);
                libelleIdClasse = new JLabel(libelle);
                libelleIdClasse.setBounds(210, 5, 200, 35);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        query = "SELECT * FROM ABSENCE WHERE id_etudiant = '"+id+"'";
        try {
            Statement stm = this.cnn.prepareStatement(query);
            ResultSet res = stm.executeQuery(query);
            int i = 0;
            if (res.next()) {
                int numSea = res.getInt(1);
                String numSeance = Integer.toString(numSea);

                int idEt = res.getInt(3);
                String idEtt = Integer.toString(idEt);

                int idEns = res.getInt(4);
                String idEs = Integer.toString(idEns);

                int idMat = res.getInt(5);
                String idMt = Integer.toString(idMat);

                Date date = res.getDate(2);
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                String strDate = dateFormat.format(date);
                String column[] = {"Seance", "Date", "Etudiant", "Enseignant", "Matiere"};
                String data[][] = {{ numSeance, strDate, idEtt, idEs, idMt}};
                tableau1 = new JTable(data,column);
                tableau1.setBounds(10, 70, 600, 500);
                add(tableau1);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }


    /* DB treatment */

        libelleNom = new JLabel(nom);
        libellePrenom = new JLabel(prenom);
        
        libelleNom.setBounds(10, 5, 200, 35);
        libellePrenom.setBounds(100, 5, 200, 35);

        libelleNom = new JLabel(nom);
        libellePrenom = new JLabel(prenom);

        libelleNom.setBounds(10, 5, 200, 35);
        libellePrenom.setBounds(100, 5, 200, 35);

        JLabel libelleNumSeance = new JLabel("Seance");
        JLabel libelleDate = new JLabel("Date");
        JLabel libelleEtudiant = new JLabel("Etudiant");
        JLabel libelleEnseignant = new JLabel("Enseignant");
        JLabel libelleMatier = new JLabel("Matiere");

        libelleNumSeance.setBounds(15, 40, 200, 35);
        libelleDate.setBounds(150, 40, 200, 35);
        libelleEtudiant.setBounds(257, 40, 200, 35);
        libelleEnseignant.setBounds(380, 40, 200, 35);
        libelleMatier.setBounds(500, 40, 200, 35);
        

        add(libelleIdClasse);
        add(libelleNumSeance);
        add(libelleDate);
        add(libelleEtudiant);
        add(libelleEnseignant);
        add(libelleMatier);
        add(tableau1);
        
        add(libelleNom);
        add(libellePrenom);
        add(libelleIdClasse);
        setTitle("Gestion Absence ~ Etudiant Dashboard");
        setSize(1000, 700);
        setLayout(null);
        setVisible(true);
    }

}
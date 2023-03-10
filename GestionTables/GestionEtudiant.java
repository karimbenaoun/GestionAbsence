package GestionTables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

import GUI.DashboardEtudiant;
import Tables.Etudiant;
import DataBase.Base;

public class GestionEtudiant {
    private Connection cnn;
    private Base db;
    int id_etudiant, id_classe;
    String nom, prenom, login;
    private ArrayList<Etudiant> etudiant;
    private String query;
    private ResultSet resultat;

    public GestionEtudiant() {
    }

    public Etudiant authentifier(String passwd, String username) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        String ur1 = "jdbc:mysql://localhost:3306/gestion_absence";
        String DBusername = "root";
        String password = "";
        try {
            this.cnn = DriverManager.getConnection(ur1, DBusername, password);
            Statement state = this.cnn.createStatement();

            System.out.println("Connection avec succées ");
        } catch (SQLException e) {
            System.out.println("connection failed ");
            System.out.println(e.toString());
        }

        String query = "SELECT * FROM ETUDIANT WHERE login ='" + username + "' AND password = '" + passwd + "'";

        try {
            PreparedStatement preparedStatement = this.cnn.prepareStatement(query);
            ResultSet res = preparedStatement.executeQuery(query);
            if (res.next()) {
                id_etudiant = res.getInt(1);
                nom = res.getString(2);
                prenom = res.getString(3);
                login = res.getString(4);
                id_classe = res.getInt(6);
                Etudiant etudiant = new Etudiant(id_etudiant, nom, prenom, login, query, id_classe);
                return etudiant;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public void signUp(String nom, String prenom, String login, String password, int idClasse) {
        db = new Base();
        this.cnn = db.connect();
        String query = "INSERT INTO etudiant (`nom`, `prenom`, `login`, `password`, `id_classe`) VALUES ('" + nom + "', '" + prenom
                + "', '" + login + "', '" + password + "', '"+idClasse+"')";
        try {
            PreparedStatement stm = this.cnn.prepareStatement(query);
            int res = stm.executeUpdate();
            if (res == 1) {
                System.out.println("Console add /> add with success");
            } else {
                System.out.println("Console add /> Error Fail");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Etudiant> getEtudiantByIdClasse(int idClasse){
        db = new Base();
        this.cnn = db.connect();
        this.etudiant = new ArrayList<Etudiant>();
        this.query = "SELECT * FROM etudiant WHERE id_classe = '"+idClasse+"'";
        this.resultat = db.useStatament(query);

        try {
            while (resultat.next()) {
                this.id_etudiant = resultat.getInt(1);
                this.nom = resultat.getString(2);
                this.prenom = resultat.getString(3);
                this.login = resultat.getString(4);
                this.id_classe = resultat.getInt(6);

                Etudiant objEtudiant = new Etudiant();

                objEtudiant.setIdEtudiant(this.id_etudiant);
                objEtudiant.setNom(this.nom);
                objEtudiant.setPrenom(this.prenom);
                objEtudiant.setLogin(this.login);
                objEtudiant.setIdClasse(idClasse);
                this.etudiant.add(objEtudiant);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return etudiant;
    }

}

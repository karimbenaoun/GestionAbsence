package GestionTables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DataBase.Base;

import java.sql.*;

import Tables.Enseignant;

public class GestionEnseignant {
    private static Connection cnn;
    static int id_enseignant;
    static String nom;
    static String prenom;
    static String login;
    private static Base db;

    public GestionEnseignant() {
    }

    public static Enseignant authentifierEN(String passwd, String username) {

        cnn = db.connect();
        

        String query = "SELECT * FROM ENSEIGNANT WHERE login ='" + username + "' AND password = '" + passwd + "'";

        try {
            PreparedStatement preparedStatement = cnn.prepareStatement(query);
            ResultSet res = preparedStatement.executeQuery(query);
            if (res.next()) {
                id_enseignant = res.getInt(1);
                nom = res.getString(2);
                prenom = res.getString(3);
                login = res.getString(4);
                
                Enseignant enseignant = new Enseignant(id_enseignant, nom, prenom, login);
                return enseignant;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void ajouterEnseignant(String nom, String prenom, String login, String password){

        this.cnn = db.connect();
        JFrame frame = new JFrame();
        String query1 = "SELECT * FROM enseignant WHERE login ='"+login+"'";
        String query = "INSERT INTO enseignant (`nom`, `prenom`, `login`, `password`) VALUES (:nom, :prenom, :login, :password)";

        try{
            PreparedStatement prstm = cnn.prepareStatement(query1);
            ResultSet res = prstm.executeQuery(query1);
            if(res.next()){
                JOptionPane.showMessageDialog(frame,"Login allready exist !");
            }else{
                PreparedStatement prstm1 = cnn.prepareStatement(query);
                ResultSet res2 = prstm.executeQuery(query);
                if(res2.next()){
                    System.out.println("Console :/> add with success");
                }else{
                    System.out.println("Console:/> Fail !");
                }
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

}
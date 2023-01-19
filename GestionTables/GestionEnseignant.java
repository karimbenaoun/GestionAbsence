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


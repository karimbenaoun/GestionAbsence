package GestionTables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

import GUI.DashboardEtudiant;
import Tables.Etudiant;
import DataBase.Base;

public class GestionEtudiant {
    private Connection cnn;
    private Base db;
    int id_etudiant, id_classe;
    String nom, prenom, login;

    public GestionEtudiant() {
    }

    public Etudiant authentifier(String passwd, String username) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        String ur1 = "jdbc:mysql://localhost:3306/gestion_ab";
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

}

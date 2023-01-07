package GestionTables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.sql.*;
import GUI.DashboardEtudiant;

public class GestionEtudiant {
    private Connection cnn;

    public GestionEtudiant() {
    }

    public boolean authentifier(String passwd, String username) {

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

        String query = "SELECT * FROM ETUDIANT WHERE login ='" + username + "' AND passwd = '" + passwd + "'";

        try {
            PreparedStatement preparedStatement = this.cnn.prepareStatement(query);
            ResultSet res = preparedStatement.executeQuery();
            System.out.println(res);
            if (res.next()) {
                new DashboardEtudiant();
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

}

package GUI;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import GestionTables.GestionEnseignant;
import GestionTables.GestionEtudiant;
import Tables.Enseignant;
import Tables.Etudiant;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

    JFrame frame;
    JLabel label1, lable2;
    JTextField tfLogin;
    JPasswordField pfPassword;
    JButton btnConnection;
    GestionEtudiant gestionEtudiant;
    GestionEnseignant gestionEnseignant;
    String userLogin;
    char[] userPassword;
    Connection cnn;

    public Login() {

        frame = new JFrame();

        // db connexion :
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        String ur1 = "jdbc:mysql://localhost:3306/gestion_absence";
        String DBusername = "root";
        String password = "";
        try {
            cnn = DriverManager.getConnection(ur1, DBusername, password);
            Statement state = cnn.createStatement();

            System.out.println("Connection avec succées ");
        } catch (SQLException ex) {
            System.out.println("connection failed ");
            System.out.println(ex.toString());
        }

        

        label1 = new JLabel("Login");
        label1.setBounds(50, 50, 100, 30);
        tfLogin = new JTextField();
        tfLogin.setBounds(50, 80, 100, 20);

        lable2 = new JLabel("password");
        lable2.setBounds(50, 100, 100, 30);
        pfPassword = new JPasswordField();
        pfPassword.setBounds(50, 130, 100, 20);

        btnConnection = new JButton("connection");
        btnConnection.setBounds(300, 140, 100, 30);

        btnConnection.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                gestionEtudiant = new GestionEtudiant();
                Etudiant auth;
                gestionEnseignant = new GestionEnseignant();
                Enseignant authEnseignant;

                userLogin = tfLogin.getText();
                userPassword = pfPassword.getPassword();
                String userPasswd = new String(userPassword);

                

               
                //query to check user role :
                String query = "SELECT * FROM enseignant WHERE login = '"+userLogin+"'";
                String queryEt = "SELECT * FROM etudiant WHERE login = '" + userLogin + "'";
                try {
                    PreparedStatement stm = cnn.prepareStatement(query);
                    ResultSet res = stm.executeQuery(query);
                    PreparedStatement stm1 = cnn.prepareStatement(queryEt);
                    ResultSet res1 = stm1.executeQuery(queryEt);
                    System.out.println("in query test ! befor if statment");
                    if(res.next()){
                        authEnseignant = GestionEnseignant.authentifierEN(userPasswd, userLogin);
                        if (authEnseignant != null) {
                            dispose();
                            new DashboardEnseignant(userLogin, userPasswd);
                        } else {
                            JOptionPane.showMessageDialog(frame, "mot de passe ou username n'est pas correct !.");
                        }
                    }else if(res1.next()){
                        auth = gestionEtudiant.authentifier(userPasswd, userLogin);
                        if (auth != null) {
                            dispose();
                            new DashboardEtudiant(userLogin, userPasswd);
                        }
                    }else{
                        JOptionPane.showMessageDialog(frame, "USER ERROR /> Not found on Data Base ! or userLogin not valid or password not valid !.");
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                

            }
        });

        setTitle("Gestion Absence ~ User Login");
        add(label1);
        add(lable2);
        add(tfLogin);
        add(pfPassword);
        add(btnConnection);
        setSize(500, 230);
        setLayout(null);
        setVisible(true);
    }

}

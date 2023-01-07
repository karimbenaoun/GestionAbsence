package GUI;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import GestionTables.GestionEtudiant;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import DataBase.Base;

public class Login extends JFrame {

    JFrame frame;
    JLabel label1, lable2;
    JTextField tfLogin;
    JPasswordField pfPassword;
    JButton btnConnection;
    GestionEtudiant gestionEtudiant;
    String userLogin;
    char[] userPassword;
    Connection cnn;

    public Login() {

        frame = new JFrame();

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
                userLogin = tfLogin.getText();
                userPassword = pfPassword.getPassword();
                System.out.println("pass => " + new String(userPassword) + "|| login username => " + userLogin);
                String userPasswd = new String(userPassword);
                boolean auth;
                auth = gestionEtudiant.authentifier(userPasswd, userLogin);
                System.out.println("auth =>" + auth);
                if(auth){
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(frame, "mot de passe ou username n'est pas correct !.");
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

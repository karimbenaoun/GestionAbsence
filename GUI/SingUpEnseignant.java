package GUI;

import javax.swing.JButton;
import GestionTables.GestionEnseignant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SingUpEnseignant extends JFrame{

    private JLabel lNom, lPrenom,libelleLogin, libellePassword;
    private JButton btnAdd;
    private JTextField tfNom, tfPrenom, tfLogin;
    private JPasswordField pfPassword;
    private String nom, prenom, login;
    char[] password;
    private GestionEnseignant Gens;

    /**
     * 
     */
    public SingUpEnseignant(){

        Gens = new GestionEnseignant();
        
        this.lNom = new JLabel("Nom");
        this.lNom.setBounds(20, 20, 100, 20);
         this.tfNom = new JTextField();
         this.tfNom.setBounds(50, 22, 100, 20);
        
        this.lPrenom = new JLabel("Prenom");
        this.lPrenom.setBounds(20, 60, 100, 35);
        this.tfPrenom = new JTextField();
        this.tfPrenom.setBounds(70, 69, 100, 20);

        this.libelleLogin = new JLabel("login");
        this.libelleLogin.setBounds(20, 100, 100, 35);
        this.tfLogin = new JTextField();
        this.tfLogin.setBounds(60, 110, 100, 20);

        this.libellePassword = new JLabel("Password");
        this.libellePassword.setBounds(20, 140, 100, 35);
        this.pfPassword = new JPasswordField();
        this.pfPassword.setBounds(85, 150, 100, 20);

        this.btnAdd = new JButton("Add");
        this.btnAdd.setBounds(200, 200, 120, 35);

        btnAdd.addActionListener(new ActionListener(){
             @Override
            public void actionPerformed(ActionEvent e) {
                nom = tfNom.getText();
                prenom = tfPrenom.getText();
                login = tfLogin.getText();
                password = pfPassword.getPassword();
                String userPasswd = new String(password);
                Gens.signUp(nom, prenom, login, userPasswd);
            }
        });

        add(this.lNom);
        add(this.lPrenom);
        add(this.libelleLogin);
        add(this.libellePassword);

        add(this.tfNom);
        add(this.tfPrenom);
        add(this.tfLogin);
        add(this.tfPrenom);
        add(this.pfPassword);

        add(this.btnAdd);


        setSize(400, 300);
        setLayout(null);
        setVisible(true);
    }

    
}

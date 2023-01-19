package GUI;

import javax.swing.JButton;
import GestionTables.GestionEnseignant;

import javax.swing.*;

public class SingUpEnseignant extends JFrame{

    private JLabel lNom, lPrenom,libelleLogin, libellePassword;
    private JButton btnAdd;
    private String nom, prenom, login, password;
    private GestionEnseignant Gens;

    /**
     * 
     */
    public SingUpEnseignant(){
        
        lNom = new JLabel("Nom");
        lNom.setBounds(5, 20, 100, 35);
        
        lPrenom = new JLabel("Prenom");
        lPrenom.setBounds(5, 60, 100, 35);
        
        libelleLogin = new JLabel("login");
        libelleLogin.setBounds(5, 90, 100, 35);
        
        libellePassword = new JLabel("Password");
        libellePassword.setBounds(5, 105, 100, 35);

        btnAdd = new JButton("Add");
        btnAdd.setBounds(100, 120, 120, 35);

        add(lNom);
        add(lPrenom);
        add(libelleLogin);
        add(libellePassword);

        setSize(500, 230);
        setLayout(null);
        setVisible(true);
    }

    
}

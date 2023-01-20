package GUI;

import javax.swing.JButton;

import GestionTables.GestionClasse;
import GestionTables.GestionEtudiant;
import Tables.Classe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class SingUpEtudiant extends JFrame {

    private JLabel lNom, lPrenom, libelleLogin, libellePassword;
    private JButton btnAdd;
    private JTextField tfNom, tfPrenom, tfLogin;
    private JPasswordField pfPassword;
    private JComboBox classeBox;
    private String nom, prenom, login;
    private char[] password;
    private GestionEtudiant GestionEtudiant;
    private GestionClasse gestionClasse;
    private ArrayList<Classe> classeListe;
    private Classe[] tabClasse;
    private int idClasse;

    /**
     * 
     */
    public SingUpEtudiant() {

        this.GestionEtudiant = new GestionEtudiant();
        this.gestionClasse = new GestionClasse();
        this.classeListe = new ArrayList<Classe>();
        this.tabClasse = new Classe[100];
        String[] tabLibelle = new String[100];
        this.classeListe = this.gestionClasse.getAllClasse();

        for(int i = 0; i < this.classeListe.size(); i++){
            this.tabClasse[i] = this.classeListe.get(i);
            tabLibelle[i] = this.tabClasse[i].getLibelle();
        }
        
            this.classeBox = new JComboBox<String>(tabLibelle);
        

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

        this.classeBox.setBounds(200,20,150,20);



        this.btnAdd = new JButton("Add");
        this.btnAdd.setBounds(200, 200, 120, 35);

        

        btnAdd.addActionListener(new ActionListener() {
            private GestionClasse gestionClasse = new GestionClasse();

            @Override
            public void actionPerformed(ActionEvent e) {
                gestionClasse = new GestionClasse();
                nom = tfNom.getText();
                prenom = tfPrenom.getText();
                login = tfLogin.getText();
                password = pfPassword.getPassword();
                Object libelleClasse = new Object();
                libelleClasse = classeBox.getSelectedItem();
                String libelleClass = libelleClasse.toString();
                String userPasswd = new String(password);
                idClasse = this.gestionClasse.getClasseByLibelle(libelleClass);
                System.out.println(idClasse);
                GestionEtudiant.signUp(nom, prenom, login, userPasswd,idClasse);
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
        add(this.classeBox);

        setSize(400, 300);
        setLayout(null);
        setVisible(true);
    }

}

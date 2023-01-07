package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import GestionTables.GestionEtudiant;
import Tables.Etudiant;

public class DashboardEtudiant extends JFrame {

    JFrame frame;
    JLabel libelleId;
    JLabel libelleNom;
    JLabel libellePrenom;
    JLabel libelleLogin;
    JLabel libelleIdClasse;
    Etudiant etudiant;
    GestionEtudiant gestionEtudiant;

    public DashboardEtudiant(String username, String password) {

        frame = new JFrame();
        etudiant = new Etudiant();
        gestionEtudiant = new GestionEtudiant();
        etudiant = gestionEtudiant.authentifier(password, username);
        System.out.println("Dashboard GUI: "+ etudiant);

        int id = etudiant.getIdEtudiant();
        String nom = etudiant.getNom();
        String prenom = etudiant.getPrenom();
        String login = etudiant.getLogin();
        int id_class = etudiant.getIdClasse();
      
        String id_etudiant = Integer.toString(id);
        String id_classe = Integer.toString(id_class);

        libelleId = new JLabel(id_etudiant);
        libelleNom = new JLabel(nom);
        libellePrenom = new JLabel(prenom);
        libelleLogin = new JLabel(login);
        libelleIdClasse = new JLabel(id_classe);

        libelleId.setBounds(10,30,200,35);
        libelleNom.setBounds(110, 30, 200, 35);
        libellePrenom.setBounds(210, 30, 200, 35);
        libelleLogin.setBounds(310, 30, 200, 35);
        libelleIdClasse.setBounds(410, 30, 200, 35);


        add(libelleId);
        add(libelleNom);
        add(libellePrenom);
        add(libelleLogin);
        add(libelleIdClasse);
        setTitle("Gestion Absence ~ Etudiant Dashboard");
        setSize(1000, 700);
        setLayout(null);
        setVisible(true);
    }

}

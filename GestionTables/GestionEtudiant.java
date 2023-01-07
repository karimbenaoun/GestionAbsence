package GestionTables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DataBase.Base;
import GUI.DashboardEtudiant;
import Tables.Etudiant;

public class GestionEtudiant {
    private Base cnn = new Base();
    private Etudiant etudiant;

    public GestionEtudiant(Base cnn) {
        this.cnn = cnn;
    }

    public Base getCnn() {
        return cnn;
    }

    public void setCnn(Base cnn) {
        this.cnn = cnn;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Etudiant authentifier(JPasswordField passwd, JTextField username) {
        String query = "SELECT * FROM ETUDIANT WHERE login ='" + username + "' AND passwd = '" + passwd + "'";

        try {
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                new DashboardEtudiant();
                Etudiant etudiant = new Etudiant(res.getInt(1), res.getString(2), res.getString(3), res.getString(4),
                        res.getString(5), res.getInt(6));
                System.out.println(etudiant);
                return etudiant;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public Etudiant trouvEtudiant(int id_etudiant) {
        String query = "SELECT * FROM etudiant WHERE id_etudiant = ? ";
        try {
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_etudiant);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                Etudiant etudiant = new Etudiant(res.getInt(1), res.getString(2), res.getString(3), res.getString(4),
                        res.getString(5), res.getInt(6));
                return etudiant;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public void ajoutEtudiant(String nom, String prenom, String login, String pwd, int id_classe) {
        try {
            String query = "INSERT INTO etudiant (`nom`,`prenom`,`login`,`pwd`,`id_classe`) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, prenom);
            preparedStatement.setString(3, login);
            preparedStatement.setString(4, pwd);
            preparedStatement.setInt(5, id_classe);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public void supprimEtudiant(int id_etudiant) {
        try {
            String query = "DELETE FROM `etudiant` WHERE id_etudiant = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_etudiant);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.print(e.toString());
        }
    }

    public void modifNomEtudiant(int id_etudiant, String nom) {
        try {
            String query = "UPDATE `etudiant` SET `nom` = ? WHERE `id_etudiant` = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setString(1, nom);
            preparedStatement.setInt(2, id_etudiant);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print("erreur: " + e.toString());
        }
    }

    public void modifPrenomEtudiant(int id_etudiant, String prenom) {
        try {
            String query = "UPDATE `etudiant` SET `prenom` = ? WHERE `id_etudiant` = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setString(1, prenom);
            preparedStatement.setInt(2, id_etudiant);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print("erreur: " + e.toString());
        }
    }

    public void modifLoginEtudiant(int id_etudiant, String login) {
        try {
            String query = "UPDATE `etudiant` SET `login` = ? WHERE `id_etudiant` = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setInt(2, id_etudiant);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print("erreur: " + e.toString());
        }
    }

    public void modifPwdEtudiant(int id_etudiant, String pwd) {
        try {
            String query = "UPDATE `etudiant` SET `pwd` = ? WHERE `id_etudiant` = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setString(1, pwd);
            preparedStatement.setInt(2, id_etudiant);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print("erreur: " + e.toString());
        }
    }

    public void modifIdClasseEtudiant(int id_etudiant, int id_classe) {
        try {
            String query = "UPDATE `etudiant` SET `id_classe` = ? WHERE `id_etudiant` = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_classe);
            preparedStatement.setInt(2, id_etudiant);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print("erreur: " + e.toString());
        }
    }

    public void afficheEtudiant(int id_etudiant) {
        try {
            String query = "SELECT * FROM `etudiant` WHERE id_etudiant = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_etudiant);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                Etudiant etudiant = new Etudiant(res.getInt(1), res.getString(2), res.getString(3), res.getString(4),
                        res.getString(5), res.getInt(6));
                System.out.println(etudiant.toString());
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}

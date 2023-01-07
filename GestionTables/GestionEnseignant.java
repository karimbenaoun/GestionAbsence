package GestionTables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DataBase.Base;
import Tables.Enseignant;

public class GestionEnseignant {
    private Base cn;
    private Enseignant enseignant;

    public GestionEnseignant(Base cn) {
        this.cn = cn;
    }

    public Base getCnn() {
        return cn;
    }

    public void setCnn(Base cn) {
        this.cn = cn;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEtudiant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Enseignant trouvEnseignant(int id_enseignant) {
        try {
            String query = "SELECT * FROM enseignant WHERE id_enseignant = ? ";
            PreparedStatement preparedStatement = cn.preparedStatement(query);
            preparedStatement.setInt(1, id_enseignant);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                Enseignant enseignant = new Enseignant(res.getInt(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getString(5));
                return enseignant;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public void ajoutEnseignant(String nom, String prenom, String login, String pwd) {
        try {
            String query = "INSERT INTO enseignant (`nom`,`prenom`,`login`,`pwd`) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = cn.preparedStatement(query);
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, prenom);
            preparedStatement.setString(3, login);
            preparedStatement.setString(4, pwd);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void supprimEnseignant(int id_enseignant) {
        try {
            String query = "DELETE FROM `enseignant` WHERE id_enseignant = ?";
            PreparedStatement preparedStatement = cn.preparedStatement(query);
            preparedStatement.setInt(1, id_enseignant);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }

    public void modifNomEtudiant(int id_enseignant, String nom) {
        try {
            String query = "UPDATE `enseignant` SET `nom` = ? WHERE `id_enseignant` = ?";
            PreparedStatement preparedStatement = cn.preparedStatement(query);
            preparedStatement.setString(1, nom);
            preparedStatement.setInt(2, id_enseignant);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print("erreur: " + e.toString());
        }
    }

    public void modifPrenomEnseignant(int id_enseignant, String prenom) {
        try {
            String query = "UPDATE `enseignant` SET `prenom` = ? WHERE `id_enseignant` = ?";
            PreparedStatement preparedStatement = cn.preparedStatement(query);
            preparedStatement.setString(1, prenom);
            preparedStatement.setInt(2, id_enseignant);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print("erreur: " + e.toString());
        }
    }

    public void modifLoginEnseignant(int id_enseignant, String login) {
        try {
            String query = "UPDATE `enseignant` SET `login` = ? WHERE `id_enseignant` = ?";
            PreparedStatement preparedStatement = cn.preparedStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setInt(2, id_enseignant);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print("erreur: " + e.toString());
        }
    }

    public void modifPwdEnseignant(int id_enseignant, String pwd) {
        try {
            String query = "UPDATE `enseignant` SET `pwd` = ? WHERE `id_enseignant` = ?";
            PreparedStatement preparedStatement = cn.preparedStatement(query);
            preparedStatement.setString(1, pwd);
            preparedStatement.setInt(2, id_enseignant);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print("erreur: " + e.toString());
        }
    }

    public void afficheEnseignant(int id_enseignant) {
        try {
            String query = "SELECT * FROM `enseignant` WHERE id_enseignant = ?";
            PreparedStatement preparedStatement = cn.preparedStatement(query);
            preparedStatement.setInt(1, id_enseignant);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                Enseignant enseignant = new Enseignant(res.getInt(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getString(5));
                System.out.println(enseignant.toString());
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}

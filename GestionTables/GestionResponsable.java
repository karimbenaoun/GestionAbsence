package GestionTables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DataBase.Base;
import Tables.Responsable;

public class GestionResponsable {
    private Base cnn = new Base();
    private Responsable responsable;

    public GestionResponsable(Base cnn) {
        this.cnn = cnn;
    }

    public Base getCnn() {
        return cnn;
    }

    public void setCnn(Base cnn) {
        this.cnn = cnn;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public Responsable trouvResponsable(int id_responsable) {
        String query = "SELECT * FROM responsable WHERE id_responsable = ? ";
        try {
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_responsable);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                Responsable responsable = new Responsable(res.getInt(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getString(5));
                return responsable;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public void ajoutResponsable(String nom, String prenom, String login, String pwd) {
        try {
            String query = "INSERT INTO responsable (`nom`,`prenom`,`login`,`pwd`) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, prenom);
            preparedStatement.setString(3, login);
            preparedStatement.setString(4, pwd);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public void supprimResponsale(int id_responsable) {
        try {
            String query = "DELETE FROM `responsable` WHERE id_responsable = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_responsable);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.print(e.toString());
        }
    }

    public void modifNomResponsable(int id_responsable, String nom) {
        try {
            String query = "UPDATE `responsable` SET `nom` = ? WHERE `id_responsable` = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setString(1, nom);
            preparedStatement.setInt(2, id_responsable);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print("erreur: " + e.toString());
        }
    }

    public void modifPrenomResponsable(int id_responsable, String prenom) {
        try {
            String query = "UPDATE `responsable` SET `prenom` = ? WHERE `id_responsable` = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setString(1, prenom);
            preparedStatement.setInt(2, id_responsable);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print("erreur: " + e.toString());
        }
    }

    public void modifLoginResponsable(int id_responsable, String login) {
        try {
            String query = "UPDATE `responsable` SET `login` = ? WHERE `id_responsable` = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setInt(2, id_responsable);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print("erreur: " + e.toString());
        }
    }

    public void modifPwdResponsabme(int id_responsable, String pwd) {
        try {
            String query = "UPDATE `responsable` SET `pwd` = ? WHERE `id_responsable` = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setString(1, pwd);
            preparedStatement.setInt(2, id_responsable);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print("erreur: " + e.toString());
        }
    }

    public void afficheResponsable(int id_responsable) {
        try {
            String query = "SELECT * FROM `responsable` WHERE id_responsable = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_responsable);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                Responsable responsable = new Responsable(res.getInt(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getString(5));
                System.out.println(responsable.toString());
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}

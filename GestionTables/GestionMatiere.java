package GestionTables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DataBase.Base;
import Tables.Matiere;

public class GestionMatiere {
    private Base cnn = new Base();
    private Matiere matiere;

    public GestionMatiere(Base cnn) {
        this.cnn = cnn;
    }

    public Base getCnn() {
        return cnn;
    }

    public void setCnn(Base cnn) {
        this.cnn = cnn;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Matiere trouvMatiere(int id_matiere) {
        String query = "SELECT * FROM matiere WHERE id_matiere = ? ";
        try {
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_matiere);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                Matiere matiere = new Matiere(res.getInt(1), res.getString(2));
                return matiere;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public void ajoutMatiere(int id_matiere, String libelle) {
        try {
            String query = "INSERT INTO matière (`id_matière`,`libelle`) VALUES (?,?)";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_matiere);
            preparedStatement.setString(2, libelle);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public void supprimMatiere(int id_matiere) {
        try {
            String query = "DELETE FROM `matière` WHERE id_matiere = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_matiere);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.print(e.toString());
        }
    }

    public void modifLibelleMatiere(int id_matiere, String libelle) {
        try {
            String query = "UPDATE `matière` SET `libelle` = ? WHERE `id_matière` = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(2, id_matiere);
            preparedStatement.setString(1, libelle);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print("erreur: " + e.toString());
        }
    }

    public void afficheMatiere(int id_matiere) {
        try {
            String query = "SELECT * FROM `matière` WHERE id_matière = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_matiere);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                Matiere matiere = new Matiere(res.getInt(1), res.getString(2));
                System.out.println(matiere.toString());
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}

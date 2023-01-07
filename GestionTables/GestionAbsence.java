package GestionTables;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DataBase.Base;
import Tables.Absence;

public class GestionAbsence {
    private Base cnn = new Base();
    private Absence absence;

    public GestionAbsence(Base cnn) {
        this.cnn = cnn;
    }

    public Base getCnn() {
        return cnn;
    }

    public void setCnn(Base cnn) {
        this.cnn = cnn;
    }

    public Absence getAbsence() {
        return absence;
    }

    public void setAbsence(Absence absence) {
        this.absence = absence;
    }

    public Absence trouvAbsence(int id_etudiant) {
        String query = "SELECT * FROM absences WHERE id_etudiant = ? ";
        try {
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_etudiant);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                Absence absence = new Absence(res.getInt(1), res.getDate(5), res.getInt(3), res.getInt(4));
                return absence;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public void ajoutAbsence(int id_etudiant, int id_enseignant, int id_matiere, int numSeance, Date date) {
        try {
            String query = "INSERT INTO absences (`id_etudiant`,`id_enseignant`, `id_matière`, `numseance`, date) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_etudiant);
            preparedStatement.setInt(2, id_enseignant);
            preparedStatement.setInt(3, id_matiere);
            preparedStatement.setInt(4, numSeance);
            preparedStatement.setDate(5, date);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public void supprimAbsence(int id_etudiant) {
        try {
            String query = "DELETE FROM `absences` WHERE id_etudiant = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_etudiant);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.print(e.toString());
        }
    }

    public void modifNumseanceAbsence(int id_etudiant, int numSeance) {
        try {
            String query = "UPDATE `classe` SET `numseance` = ? WHERE `id_etudiant` = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(2, id_etudiant);
            preparedStatement.setInt(1, numSeance);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print("erreur: " + e.toString());
        }
    }

    public void modifDateAbsence(int id_etudiant, Date date) {
        try {
            String query = "UPDATE `absences` SET `date` = ? WHERE `id_etudiant` = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(2, id_etudiant);
            preparedStatement.setDate(1, date);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print("erreur: " + e.toString());
        }
    }

    public void afficheAbsence(int id_etudiant) {
        try {
            String query = "SELECT * FROM `absences` WHERE id_etudiant = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_etudiant);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                Absence absence = new Absence(res.getInt(1), res.getDate(5), res.getInt(2), res.getInt(3));
                System.out.println(absence.toString());
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}

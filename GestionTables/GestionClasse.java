package GestionTables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DataBase.Base;
import Tables.Classe;

public class GestionClasse {
    private Base cnn = new Base();
    private Classe classe;

    public GestionClasse(Base cnn) {
        this.cnn = cnn;

    }

    public Base getCnn() {
        return cnn;
    }

    public void setCnn(Base cnn) {
        this.cnn = cnn;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Classe trouvClasse(int id_classe) {
        String query = "SELECT * FROM classe WHERE id_classe = ? ";
        try {
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_classe);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                Classe classe = new Classe(res.getInt(1), res.getString(2), res.getString(3), res.getString(4));
                return classe;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public void ajoutClasse(int id_classe, String libelle, String niveau, String filiere) {
        try {
            String query = "INSERT INTO classe (`id_classe`,`libelle`, `niveau`, `filière`  ) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_classe);
            preparedStatement.setString(2, libelle);
            preparedStatement.setString(3, niveau);
            preparedStatement.setString(4, filiere);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public void supprimClasse(int id_classe) {
        try {
            String query = "DELETE FROM `classe` WHERE id_classe = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_classe);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.print(e.toString());
        }
    }

    public void modifLibelleClasse(int id_classe, String libelle) {
        try {
            String query = "UPDATE `classe` SET `libelle` = ? WHERE `id_classe` = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(2, id_classe);
            preparedStatement.setString(1, libelle);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print("erreur: " + e.toString());
        }
    }

    public void modifNiveauClasse(int id_classe, String niveau) {
        try {
            String query = "UPDATE `classe` SET `niveau` = ? WHERE `id_classe` = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(2, id_classe);
            preparedStatement.setString(1, niveau);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print("erreur: " + e.toString());
        }
    }

    public void modifFiliereClasse(int id_classe, String filiere) {
        try {
            String query = "UPDATE `classe` SET `filière` = ? WHERE `id_classe` = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(2, id_classe);
            preparedStatement.setString(1, filiere);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print("erreur: " + e.toString());
        }
    }

    public void afficheClasse(int id_classe) {
        try {
            String query = "SELECT * FROM `classe` WHERE id_classe = ?";
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_classe);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                Classe classe = new Classe(res.getInt(1), res.getString(2), res.getString(3), res.getString(4));
                System.out.println(classe.toString());
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}

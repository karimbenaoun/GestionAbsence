package GestionTables;

import DataBase.Base;
import Tables.Correspondance;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GestionCorrespondance {
    private Base cnn = new Base();
    private Correspondance correspondance;

    public GestionCorrespondance(Base cnn) {
        this.cnn = cnn;

    }

    public Base getCnn() {
        return cnn;
    }

    public void setCnn(Base cnn) {
        this.cnn = cnn;
    }

    public Correspondance GetCorrespondance() {
        return correspondance;
    }

    public void setCorrespondance(Correspondance correspondance) {
        this.correspondance = correspondance;
    }

    public Correspondance trouvCorrespondanceEnseignant(int id_enseignant) {
        String query = "SELECT * FROM correspondance WHERE id_enseignant = ? ";
        try {
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_enseignant);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                Correspondance correspondance = new Correspondance(res.getInt(1), res.getInt(2), res.getInt(3));
                return correspondance;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    // matier chkoun y9ari feha
    public ArrayList<Integer> trouvCorrespondanceMatiere(int id_matiere) {
        ArrayList<Integer> ArrayIdEnseignant = new ArrayList<Integer>();

        String query = "SELECT id_enseignant FROM correspondance WHERE id_matiere = ? ";
        try {
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_matiere);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                ArrayIdEnseignant.add(res.getInt(1));
                return ArrayIdEnseignant;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return ArrayIdEnseignant;
    }

    // matere win tet9ara
    public ArrayList<Integer> trouvCorrespondanceMatiereClasse(int id_matiere) {
        ArrayList<Integer> ArrayIdClasse = new ArrayList<Integer>();

        String query = "SELECT id_class FROM correspondance WHERE id_matiere = ? ";
        try {
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_matiere);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                ArrayIdClasse.add(res.getInt(1));
                return ArrayIdClasse;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return ArrayIdClasse;
    }

    // class enehi matiere tet9ara feha
    public ArrayList<Integer> trouvCorrespondanceClasseMatiere(int id_class) {
        ArrayList<Integer> ArrayIdMatiere = new ArrayList<Integer>();

        String query = "SELECT id_matiere FROM correspondance WHERE id_class = ? ";
        try {
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_class);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                ArrayIdMatiere.add(res.getInt(1));
                return ArrayIdMatiere;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return ArrayIdMatiere;
    }

    // class chkoun y9ari fiih
    public ArrayList<Integer> trouvCorrespondanceClasseEnseignant(int id_class) {
        ArrayList<Integer> ArrayIdEnseignant = new ArrayList<Integer>();

        String query = "SELECT id_enseignant FROM correspondance WHERE id_class = ? ";
        try {
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_class);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                ArrayIdEnseignant.add(res.getInt(1));
                return ArrayIdEnseignant;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return ArrayIdEnseignant;
    }

    // prof win y9zii
    public ArrayList<Integer> trouvCorrespondanceEnseignantClasse(int id_enseignant) {
        ArrayList<Integer> ArrayIdClasse = new ArrayList<Integer>();

        String query = "SELECT id_classe FROM correspondance WHERE id_enseignant = ? ";
        try {
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_enseignant);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                ArrayIdClasse.add(res.getInt(1));
                return ArrayIdClasse;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return ArrayIdClasse;
    }

    // prof lmatiere y9ari fehom
    public ArrayList<Integer> trouvCorrespondanceEnseignantMatiereArrayList(int id_enseignant) {
        ArrayList<Integer> ArrayIdMatiere = new ArrayList<Integer>();

        String query = "SELECT id_matiere FROM correspondance WHERE id_enseingnant = ? ";
        try {
            PreparedStatement preparedStatement = cnn.preparedStatement(query);
            preparedStatement.setInt(1, id_enseignant);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                ArrayIdMatiere.add(res.getInt(1));
                return ArrayIdMatiere;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return ArrayIdMatiere;
    }

}

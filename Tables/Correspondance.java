package Tables;

public class Correspondance {
    private int id_enseignant;
    private int id_matiere;
    private int id_classe;

    public Correspondance(int id_enseignant, int id_matiere, int id_classe) {
        this.id_enseignant = id_enseignant;
        this.id_matiere = id_matiere;
        this.id_classe = id_classe;
    }

    public int getIdEnseignant() {
        return id_enseignant;
    }

    public int getIdMatiere() {
        return id_matiere;
    }

    public int getIdClasse() {
        return id_classe;
    }

    public void setIdEnseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

    public void setIdMatiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public void setIdClasse(int id_classe) {
        this.id_classe = id_classe;
    }

    public String toString() {
        return "id enseignant  =  " + this.id_enseignant + ",  id matiere =  " + this.id_matiere + ",  id classe =  "
                + this.id_classe;
    }
}

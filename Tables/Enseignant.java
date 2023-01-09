package Tables;

public class Enseignant extends Personnes {
    private int id_enseignant;

    public Enseignant(int id_enseignant, String nom, String prenom, String login, String pwd) {
        super(nom, prenom, login, pwd);
        this.id_enseignant = id_enseignant;
    }

    public Enseignant() {
    }

    public int getIdEnseignant() {
        return id_enseignant;
    }

    public void setIdEnseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

    public String toString() {
        return "id enseignant =  " + this.id_enseignant + super.toString();
    }
}

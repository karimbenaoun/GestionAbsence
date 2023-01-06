package Tables;

public class Etudiant extends Personnes {
    private int id_etudiant;
    private int id_classe;

    public Etudiant() {

    }

    public Etudiant(int id_etudiant, String nom, String prenom, String login, String pwd, int id_classe) {
        super(nom, prenom, login, pwd);
        this.id_etudiant = id_etudiant;
        this.id_classe = id_classe;
    }

    public Etudiant(String nom, String prenom, String login, String pwd, int id_classe) {
        super(nom, prenom, login, pwd);
        this.id_classe = id_classe;
    }

    public int getIdEtudiant() {
        return id_etudiant;
    }

    public int getIdClasse() {
        return id_classe;
    }

    public void setIdEtudiant(int id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public void setIdClasse(int id_classe) {
        this.id_classe = id_classe;
    }

    public String toString() {
        return "id etudiant =  " + this.id_etudiant + super.toString() + "id classe =  " + this.id_classe;
    }
}

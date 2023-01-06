package Tables;

public class Matiere {
    private int id_matiere;
    private String libelle;

    public Matiere(int id_matiere, String libelle) {
        this.id_matiere = id_matiere;
        this.libelle = libelle;
    }

    public int getIdMatiere() {
        return id_matiere;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setIdMatiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String toString() {
        return "id matiere = " + this.id_matiere + ", Libelle =  " + this.libelle;
    }
}
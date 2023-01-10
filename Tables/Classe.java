package Tables;

import java.util.Vector;

public class Classe {
    private int id_classe;
    private String libelle;
    private String niveau;
    private String filiere;

    public Classe(){}

    public Classe(int id_classe, String libelle, String niveau, String filiere) {
        this.id_classe = id_classe;
        this.libelle = libelle;
        this.niveau = niveau;
        this.filiere = filiere;

    }

    public int getIdClasse() {
        return id_classe;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setIdClasse(int id_classe) {
        this.id_classe = id_classe;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String toString() {
        return "id classe = " + this.id_classe + " Libelle = " + this.libelle + "  niveau = " + this.niveau
                + "filiere =  " + this.filiere;
    }
}
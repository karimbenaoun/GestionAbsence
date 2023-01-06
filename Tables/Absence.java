package Tables;

import java.util.Date;

public class Absence {
    private int numSeance;
    private Date date;
    private int id_etudiant;
    private int id_enseignant;

    public Absence(int numSeance, Date date, int id_etudiant, int id_enseignant) {
        this.numSeance = numSeance;
        this.date = date;
        this.id_etudiant = id_etudiant;
        this.id_enseignant = id_enseignant;
    }

    public int getnumSeance() {
        return numSeance;
    }

    public Date getDate() {
        return date;
    }

    public int getIdEtudiant() {
        return id_etudiant;
    }

    public int getIdEnseignant() {
        return id_enseignant;
    }

    public void setnumSeance(int numSeance) {
        this.numSeance = numSeance;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setIdEtudiant(int id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public void setIdEnseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

    public String toString() {
        return "numSeance =  " + this.numSeance + "Date = " + this.date + "id etudiant =  " + this.id_etudiant
                + "  id enseignant = " + this.id_enseignant;
    }

}

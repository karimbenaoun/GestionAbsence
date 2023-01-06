package Tables;

public class Responsable extends Personnes {
    private int id_responsable;

    public Responsable(int id_responsable, String nom, String prenom, String login, String pwd) {
        super(nom, prenom, login, pwd);
        this.id_responsable = id_responsable;
    }

    public int getIdResponsable() {
        return id_responsable;
    }

    public void setIdResponsable(int id_responsable) {
        this.id_responsable = id_responsable;
    }

    public String toString() {
        return "id_responsable =  " + this.id_responsable + super.toString();
    }
}

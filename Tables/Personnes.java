package Tables;

public class Personnes {
    private String nom;
    private String login;
    private String pwd;
    private String prenom;

    public Personnes() {

    }

    public Personnes(String nom, String prenom, String login, String pwd) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.pwd = pwd;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getLogin() {
        return login;
    }

    public String getPwd() {
        return pwd;
    }

    public String getPrenom() {
        return prenom;
    }

    public String toString() {
        return "le nom =" + this.nom + "  ,   le prenom = " + this.prenom;
    }

}
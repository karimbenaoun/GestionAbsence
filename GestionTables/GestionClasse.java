package GestionTables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import DataBase.Base;
import Tables.Classe;

public class GestionClasse {

    private Base dataBase;
    private Connection conn;
    private ResultSet resultat;
    private String query;
    private Vector<Classe> classe;

    private int id;
    private String libelle, filiaire, niveau;


    public Vector <Classe> getAllClasse(){
        dataBase = new Base();
        this.classe = new Vector() ;

        this.query = "SELECT * FROM classe ";
        resultat = dataBase.useStatament(query);
        try {
            while(resultat.next()){
                this.id = resultat.getInt(1);
                this.libelle = resultat.getString(2);
                this.filiaire = resultat.getString(3);
                this.niveau = resultat.getString(4);  
                for(int i = 0; i < classe.size(); i++){
                    
                    classe.get(i).setIdClasse(this.id);
                    classe.get(i).setLibelle(this.libelle);
                    classe.get(i).setFiliere(this.filiaire);
                    classe.get(i).setNiveau(this.niveau);

                    System.out.println("id : " + this.classe.get(i).getIdClasse() + " libelle: " + this.classe.get(i)
                            .getLibelle() + " filiaire : " + this.classe.get(i).getFiliere()
                            + " niveau " + this.classe.get(i).getNiveau());
                }
                System.out.println("id : " + this.id + " libelle: " + this.libelle + " filiaire : "+ this.filiaire + " niveau " + this.niveau);
            } 
                
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return classe;
    }

}
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
    private Vector<Classe> clonneClasse;

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
                this.filiaire = resultat.getString(4);
                this.niveau = resultat.getString(3);  
               
                Classe objClasse = new Classe();

                objClasse.setIdClasse(this.id);
                objClasse.setLibelle(this.libelle);
                objClasse.setNiveau(this.niveau);
                objClasse.setFiliere(this.filiaire);
                classe.addElement(objClasse);
                System.out.println("GC /> "+objClasse + "---->" + classe);
            } 
                
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return classe;
    }

}
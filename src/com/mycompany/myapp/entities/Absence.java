/**
 *
 * @author arij_
 */


package com.mycompany.myapp.entities;

//import java.sql.Date;

import java.util.Date;
//import java.sql.Timestamp;

/**
 *
 * @author Pc
 */
public class Absence {
     
    int id_absence;
    Date date_absence;
    int id_matiere;
    String nom_eleve;
    int ide;

    public Absence() {
    }

    public Absence(int id_absence, Date date_absence, int id_matiere, String nom_eleve, int ide) {
        this.id_absence = id_absence;
        this.date_absence = date_absence;
        this.id_matiere = id_matiere;
        this.nom_eleve = nom_eleve;
         this.ide = ide;
    }

    public String getNom_eleve() {
        return nom_eleve;
    }

    public void setNom_eleve(String nom_eleve) {
        this.nom_eleve = nom_eleve;
    }

    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

    public int getId_absence() {
        return id_absence;
    }

    public void setId_absence(int id_absence) {
        this.id_absence = id_absence;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere= id_matiere;
    }

    public Date getDate_absence() {
        return date_absence;
    }

    public void setDate_absence(Date date_absence) {
        this.date_absence = date_absence;
    }

  

    @Override
    public String toString() {
        return "Absence{" + "id_absence=" + id_absence + ", date_absence=" + date_absence + ", id_matiere=" + id_matiere + ", nom_eleve=" + nom_eleve + ", ide=" + ide + '}';
    }

    public Absence(Date date_absence, int id_matiere, String nom_eleve, int ide) {
        this.date_absence = date_absence;
        this.id_matiere = id_matiere;
        this.nom_eleve = nom_eleve;
        this.ide= ide;
    }

   
    
    
}

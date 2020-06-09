
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.myapp.entities;

/**
 *
 * @author Pc
 */
public class Eleve {
     
    int id_eleve;
    String nom_eleve;
    String prenom_eleve;
    int tel_eleve;
    String email_eleve;
    int nbr_absence;

    public Eleve() {
    }

    public Eleve(int id_eleve, String nom_eleve, String prenom_eleve, int tel_eleve, String email_eleve, int nbr_absence) {
        this.id_eleve = id_eleve;
        this.nom_eleve = nom_eleve;
        this.prenom_eleve = prenom_eleve;
        this.tel_eleve = tel_eleve;
        this.email_eleve = email_eleve;
        this.nbr_absence = nbr_absence;
    }
  public Eleve(int id_eleve, String nom_eleve, String prenom_eleve, int tel_eleve, int nbr_absence, String email_eleve) {
        this.id_eleve = id_eleve;
        this.nom_eleve = nom_eleve;
        this.prenom_eleve = prenom_eleve;
        this.tel_eleve = tel_eleve;
        this.nbr_absence = nbr_absence;
            this.email_eleve = email_eleve;
    }

    public Eleve(int id_eleve) {
        this.id_eleve = id_eleve;
    }

   

    public int getId_eleve() {
        return id_eleve;
    }

    public void setId_eleve(int id_eleve) {
        this.id_eleve = id_eleve;
    }

    public String getNom_eleve() {
        return nom_eleve;
    }

    public void setNom_eleve(String nom_eleve) {
        this.nom_eleve = nom_eleve;
    }

    public String getPrenom_eleve() {
        return prenom_eleve;
    }

    public void setPrenom_eleve(String prenom_eleve) {
        this.prenom_eleve = prenom_eleve;
    }

    public int getTel_eleve() {
        return tel_eleve;
    }

    public void setTel_eleve(int tel_eleve) {
        this.tel_eleve = tel_eleve;
    }

    public String getEmail_eleve() {
        return email_eleve;
    }

    public void setEmail_eleve(String email_eleve) {
        this.email_eleve = email_eleve;
    }

    @Override
    public String toString() {
        return "Eleve{" + "id_eleve=" + id_eleve + ", nom_eleve=" + nom_eleve + ", prenom_eleve=" + prenom_eleve + ", tel_eleve=" + tel_eleve + ", email_eleve=" + email_eleve + ", nbr_absence=" + nbr_absence + '}';
    }

    

    public int getNbr_absence() {
        return nbr_absence;
    }

    public void setNbr_absence(int nbr_absence) {
        this.nbr_absence = nbr_absence;
    }

   

 
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




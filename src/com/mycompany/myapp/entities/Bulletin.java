/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author arij_
 */
public class Bulletin {
     
    int id_bulletin;
  //  float note;
    int id_eleve;
    int id_classe;
    int id_matiere;
    float moyenne;
    int ide;

    public Bulletin() {
    }

    public Bulletin(int id_bulletin, int id_eleve, int id_classe, int id_matiere, float moyenne,int ide) {
        this.id_bulletin = id_bulletin;
       // this.note = note;
         this.id_eleve = id_eleve;
          this.id_classe = id_classe;
        this.id_matiere = id_matiere;
        this.moyenne = moyenne;
        this.ide=ide;
    }

    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

    
    public int getId_bulletin() {
        return id_bulletin;
    }

    public void setId_bulletin(int id_bulletin) {
        this.id_bulletin = id_bulletin;
    }

   /* public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }*/

    public int getId_eleve() {
        return id_eleve;
    }

    public void setId_eleve(int id_eleve) {
        this.id_eleve = id_eleve;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    @Override
    public String toString() {
        return "Bulletin{" + "id_bulletin=" + id_bulletin +  ", id_eleve=" + id_eleve + ", id_classe=" + id_classe + ", id_matiere=" + id_matiere + ", moyenne=" + moyenne + '}';
    }

    
    
}

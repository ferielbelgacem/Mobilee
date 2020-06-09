/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Employe;
import com.mycompany.myapp.services.ServiceEmploye;

/**
 *
 * @author User
 */
public class AddEmployerF extends Form{
     private Resources themeee;

   public AddEmployerF(Form previous) {
       themeee = UIManager.initFirstTheme("/themeee");

        setTitle("Un nouvel Employé");
        setLayout(BoxLayout.y());
        
    
   TextField tfid= new TextField("","id");
       TextField tfnom= new TextField("","nom");

       TextField tfprenom= new TextField("","prenom");
    ComboBox<String> rolef = new ComboBox();
        rolef.addItem("Responsable RH");
        
                rolef.addItem("Enseignant");
    Image im2 = themeee.getImage("unnamed.png");
            ImageViewer img2 = new ImageViewer(im2);
        
      TextField tfrole= new TextField("","role");                      

      TextField tfage= new TextField("","age");
  
           
      TextField nbrConge= new TextField("","nbrConge");
      TextField tfNbr_heure= new TextField("","nbrHeure");
        TextField tfsalaire= new TextField("","salaire");
    TextField tfprime= new TextField("","prime");
            //Image im = theme.getImage("im age.jpg");
            //ImageViewer img = new ImageViewer(im);
           
        Button btnValider = new Button("Ajouter");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfnom.getText().length()==0)||(tfprenom.getText().length()==0))
                    Dialog.show("Alert", "Veuillez entrer les champs correctement", new Command("OK"));
                else
                {
                    try {
                        Employe t = new Employe(Integer.parseInt(tfid.getText()),tfprenom.getText(), tfnom.getText(),Integer.parseInt(tfage.getText()),rolef.getSelectedItem(),Integer.parseInt(tfNbr_heure.getText()),Integer.parseInt(nbrConge.getText()),Integer.parseInt(tfsalaire.getText()),Integer.parseInt(tfprime.getText()));
                        if( ServiceEmploye.getInstance().addTask(t))
                            Dialog.show("Bienvenue","L'employé a été ajouté avec succès ",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("Erreur", "Entrer un entier", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(img2,tfid,tfprenom,tfnom,tfage,rolef,tfNbr_heure,nbrConge,tfsalaire,tfprime,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }  
}

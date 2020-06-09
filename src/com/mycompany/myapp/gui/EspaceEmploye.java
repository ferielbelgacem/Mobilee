/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Session;
import com.mycompany.myapp.entities.User;
//import com.mycompany.myapp.entities.User;

/**
 *
 * @author ferie
 */
public class EspaceEmploye extends Form {
                      private Form current;
           private Resources themeee;
               User User=Session.getCurrentSession();

    public EspaceEmploye(Form previous){
                  
          current = this; //Récupération de l'interface(Form) en cours
        setTitle("Espace Employés");
        setLayout(BoxLayout.y());
 Button btr = new Button("Se déconnecter");
              

           btr.addActionListener(e->{
           new Login(previous).show();
           
           });
 themeee = UIManager.initFirstTheme("/themeee");
            //Image im = theme.getImage("im age.jpg");
            //ImageViewer img = new ImageViewer(im);
            Image im2 = themeee.getImage("es.png");
            ImageViewer img2 = new ImageViewer(im2);
        add(new Label("Veuillez choisir une option"));
        final Button btnListTasks = new Button("Afficher la liste des Employés");
        final Button btnsup = new Button("Supprimer un Employé ");
              final  Button btnmod = new Button("Consulter la liste des candidats");
              final  Button btajout = new Button("Ajouter un Employé");

   
 /*      
btnListTasks.getAllStyles().setBorder(Border.createEmpty());
btnListTasks.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D_SHADOW_NORTH);
btnsup.getAllStyles().setBorder(Border.createEmpty());
btnsup.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D_SHADOW_NORTH);
btnmod.getAllStyles().setBorder(Border.createEmpty());
btnmod.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D_SHADOW_NORTH);
btnAddTask.getAllStyles().setBorder(Border.createEmpty());
btnAddTask.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D_SHADOW_NORTH);*/
        btnListTasks.addActionListener(e -> new ListEmploye(current).show());
                btnsup.addActionListener(e -> new SupprimerEmploye(current).show());
                                btnmod.addActionListener(e -> new ListCandidatForm(current).show());
            btajout.addActionListener(e -> new AddEmployerF(current).show());

                                /*
btr.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D_SHADOW_NORTH);
btr.getAllStyles().setBorder(Border.createEmpty());*/
        
        addAll(img2,btajout, btnListTasks,btnmod,btr);
    
                getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->  { new Login(current).show();});
try {
      
                Session.close();
            } catch (Exception ex) {
                ex.getMessage();
            }
    
    }

}
    

    
    
    
    


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

/**
 *
 * @author arij_
 */
public class GestionEcole extends Form{
     private Form current;
           private Resources themeee;
    public GestionEcole (Form p ){
     current = this; //Récupération de l'interface(Form) en cours
        setTitle("EASYCHOOL");
        setLayout(BoxLayout.y());
 
 themeee = UIManager.initFirstTheme("/themeee");
            //Image im = theme.getImage("im age.jpg");
            //ImageViewer img = new ImageViewer(im);
            Image im2 = themeee.getImage("es.png");
            ImageViewer img2 = new ImageViewer(im2);
        add(new Label("Bienvenue dans espace eleve"));
      //final  Button btnAddTask = new Button("Espace Employés ");
        final Button btnListTasks = new Button("Espace Eleves");
        //final Button btnsup = new Button("Espace Comptabilité ");
  
   

   
   /*    
btnListTasks.getAllStyles().setBorder(Border.createEmpty());
btnListTasks.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D_SHADOW_NORTH);
btnsup.getAllStyles().setBorder(Border.createEmpty());
btnsup.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D_SHADOW_NORTH);

btnAddTask.getAllStyles().setBorder(Border.createEmpty());
btnAddTask.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D_SHADOW_NORTH);*/
    //    btnAddTask.addActionListener(e -> new Login().show());
        btnListTasks.addActionListener(e -> new Login2(current).show());
      //  btnsup.addActionListener(e -> new LoginComp(current).show());
       // getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
           //     , e-> p.showBack());
             //   btnsup.addActionListener(e -> new SupprimerEmploye(current).show());


            addAll(img2,btnListTasks);
            

    
    }
}

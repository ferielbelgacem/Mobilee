/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author bhk
 */
public class eleve extends Form{
Form current;
private Resources themeee;
    public eleve() {
                themeee = UIManager.initFirstTheme("/themeee");

        
        
        
        
        current=this;
        
        setLayout(BoxLayout.y());
        
      //  add(new Label("Vous avez connecter en tant qu'eleve"));
       
       // Button btnListTasks = new Button("Afficher Inscription");
        
        //Button btnListnote = new Button("Afficher Inscription");
         Button btc = new Button("Deconnexion");
       
       add(new Label("Gestion des eleves"));
        Button btnAddTask = new Button("Ajouter inscription");
        Button btnListTasks = new Button("Afficher inscription");
          Button btnEditTasks = new Button("Modifier inscription");
              Button btnDeleteTasks = new Button("Supprimer inscription");
                Button btnab = new Button("consulter absence");
                    Button btnbul= new Button("consulter bulletin");
                   
                          
         ImageViewer img = new ImageViewer();
       /// img.setImage(theme.getImage("logo.png"));
         btnab.addActionListener(e-> new ListAbsenceForm(current).show());
        btnAddTask.addActionListener(e-> new AddEleveForm(current).show());
        btnListTasks.addActionListener(e-> new ListEleveForm(current).show());
            btc.addActionListener(e-> new GestionEcole(current).show());
             btnEditTasks.addActionListener(e-> new EditEleveForm(current).show());
              btnDeleteTasks.addActionListener(e-> new  DeleteEleveForm(current).show());
               btnbul.addActionListener(e-> new ListBulletinForm(current).show());
         //      btnexam.addActionListener(e-> new ListTasksFormm().show());
            //   btnclan.addActionListener(e-> new ListCalandrier().show());
                 //             btnnote.addActionListener(e-> new ListNote(current).show());
//getToolbar().addMaterialCommandToSideMenu("Map'", FontImage.MATERIAL_MAP, e -> { new Map(current).show(); });
               
         //   btc.addActionListener(e-> new conx().show());
        addAll(btnAddTask,btnListTasks,btnEditTasks,btnDeleteTasks,btnab,btnbul,btc);
        
    }                          

    
    
    }                          
    

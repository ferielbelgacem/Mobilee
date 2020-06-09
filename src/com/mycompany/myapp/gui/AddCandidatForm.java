/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
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
import com.mycompany.myapp.entities.Candidat;
import com.mycompany.myapp.services.ServiceCandidat;

/**
 *
 * @author bhk
 */
public class AddCandidatForm extends Form{
           private Resources themeee;

    public AddCandidatForm(Form previous) {
        setTitle("Une nouvelle candidature");
        setLayout(BoxLayout.y());
        
        TextField tfCin = new TextField("","cin_Candidat");
                

       TextField tfAge= new TextField("","age_Candidat");
                

       TextField tfName= new TextField("","nom_Candidat");

      TextField tfprenom= new TextField("","prenom_Candidat");                      

      TextField tfExp= new TextField("","experience_Candidat");
                           

themeee= UIManager.initFirstTheme("/themeee");
            //Image im = theme.getImage("im age.jpg");
            //ImageViewer img = new ImageViewer(im);
          Image im2 = themeee.getImage("unnamed.png");
            ImageViewer img2 = new ImageViewer(im2);
        Button btnValider = new Button("S'inscrire");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfName.getText().length()==0)||(tfprenom.getText().length()==0)||(tfExp.getText().length()==0))
                    Dialog.show("Alert", "Veuillez entrer les champs correctement", new Command("OK"));
                else
                {
                    try {
                        Candidat t = new Candidat(Integer.parseInt(tfCin.getText()), tfprenom.getText(),tfName.getText(),Integer.parseInt(tfAge.getText()),tfExp.getText());
                        if( ServiceCandidat.getInstance().addTask(t))
                            Dialog.show("Bienvenue","Vous êtes inscrits ",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("Erreur", "Entrer un entier", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(img2,tfCin,tfName,tfAge,tfprenom,tfExp,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }

   
    
    
}

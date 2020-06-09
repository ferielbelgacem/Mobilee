/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.TableModel;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Candidat;
import com.mycompany.myapp.services.ServiceCandidat;
import java.util.ArrayList;

/**
 *
 * @author bhk
 */
public  class ListCandidatForm extends Form{
Form current;
    private  Resources themeee;
    public ListCandidatForm(Form previous) {
   themeee = UIManager.initFirstTheme("/themeee");
            //Image im = theme.getImage("im age.jpg");
            //ImageViewer img = new ImageViewer(im);
            Image im2 = themeee.getImage("unnamed.png");
              Button btr = new Button("",im2);
               add(btr);
               
                                               Toolbar.setGlobalToolbar(true);
Style s = UIManager.getInstance().getComponentStyle("Title");


TextField searchField = new TextField("", "Liste des Candidats"); 
searchField.getHintLabel().setUIID("Title");
searchField.setUIID("Title");
searchField.getAllStyles().setAlignment(Component.LEFT);
getToolbar().setTitleComponent(searchField);
FontImage searchIcon = FontImage.createMaterial(FontImage.MATERIAL_SEARCH, s);
searchField.addDataChangeListener((i1, i2) -> { 
    String t = searchField.getText();
    if(t.length() < 1) {
        for(Component cmp : getContentPane()) {
            cmp.setHidden(false);
            cmp.setVisible(true);
        }
    } else {
        t = t.toLowerCase();
        for(Component cmp : getContentPane()) {
            String val = null;
            if(cmp instanceof Label) {
                val = ((Label)cmp).getText();
            } else {
                if(cmp instanceof TextArea) {
                    val = ((TextArea)cmp).getText();
                } else {
                    val = (String)cmp.getPropertyValue("text");
                }
            }
            boolean show = val != null && val.toLowerCase().indexOf(t) > -1;
            cmp.setHidden(!show); 
            cmp.setVisible(show);
        }
    }
    getContentPane().animateLayout(250);
});
getToolbar().addCommandToRightBar("", searchIcon, (e) -> {
    searchField.startEditingAsync(); 
});
     
               
               
                 btr.addActionListener(e->{
           new EspaceEmploye(previous).show();
           });
                   ImageViewer img2 = new ImageViewer(im2);

            Button btnc = new Button("Recherche");
                SpanLabel sp = new SpanLabel();
    TextField tfin=new TextField("cin","cin");
 
       // setTitle("La liste des Candidats");
   ArrayList<Candidat> ss;
        ss=ServiceCandidat.getInstance().getAllTasks();
        for (int i=0; i < ss.size();i++){
        Label l = new Label();    
  
                
           String  ch =   "cin:   "+ss.get(i).getCin_Candidat()+" "+
                   "nom:  "+ss.get(i).getNom_Candidat()+" "+
                                 "prenom:  "+ss.get(i).getPrenom_Candidat()+" "+
                                        "age:   "+ss.get(i).getAge_Candidat();
                               
                                //  "experienceCondidat:"+s.get(i).getExperience_Candidat();
                               
                            l.setText(ch);
                            
                            this.add(l);
                          
                            Candidat c =   new Candidat(ss.get(i).getCin_Candidat(),ss.get(i).getPrenom_Candidat(),ss.get(i).getNom_Candidat(),ss.get(i).getAge_Candidat(),ss.get(i).getExperience_Candidat());
                        
                              l.addPointerReleasedListener(ke -> {
                     new detailscandidat(c).show();
                    
                              });
                              
        }
        
   

    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.myapp.entities.Eleve;
import com.mycompany.myapp.services.ServiceEleve;
import static com.mycompany.myapp.utils.Statics.BASE_URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ListEleveForm extends Form{

    public ListEleveForm(Form previous) {
      //  setTitle("Liste des eleve");
                                        Toolbar.setGlobalToolbar(true);
Style s = UIManager.getInstance().getComponentStyle("Title");


TextField searchField = new TextField("", "liste des eleves"); 
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
     
        SpanLabel sp = new SpanLabel();
         ArrayList<Eleve> cl;
         cl=ServiceEleve.getInstance().getAllEleve();
          for (int i=0; i < cl.size();i++){
            
           // System.out.println(s.get(i).getNom_ass());
                         Label l = new Label();
                         Eleve c = new Eleve(cl.get(i).getId_eleve(),cl.get(i).getNom_eleve(),cl.get(i).getPrenom_eleve(),cl.get(i).getTel_eleve(),cl.get(i).getEmail_eleve(),cl.get(i).getNbr_absence());
                         String  ch = "le nom  : "+cl.get(i).getNom_eleve()+
                                 "  prenom :  "+cl.get(i).getPrenom_eleve()+""+
                          "  tel :  "+cl.get(i).getTel_eleve()+"        "+
                                   "  email :  "+cl.get(i).getEmail_eleve()+"        "+
                                   "  nbr  :  "+cl.get(i).getTel_eleve()+"        ";
                            l.setText(ch);
                         
                 l.addPointerReleasedListener(e -> {
                   new EleveDetaille(c).show();
                  });
        
                    this.add(l);

  }  
      //  sp.setText();
       // add(sp);
//        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
     getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> {new eleve().show();
                   
                   });
        
        
        
        
     
       
    }
    
    
    
    
    
   
}

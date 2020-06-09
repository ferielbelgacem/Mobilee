/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Eleve;
//import com.mycompany.myapp.gui.sms;
//import com.mycompany.myapp.entities.Task;
import com.mycompany.myapp.services.ServiceEleve;

/**
 *
 * @author bhk
 */
public class AddEleveForm extends Form{

    public AddEleveForm(Form previous) {
        setTitle("Ajouter une nouvelle inscription");
        setLayout(BoxLayout.y());
      TextField tfid= new TextField("","id_eleve");
        TextField tfNom = new TextField("","nom_eleve");
         TextField tfPrenom = new TextField("","prenom_eleve");
          TextField tfTel = new TextField("","tel_eleve");
           TextField tfAbs = new TextField("","nbr_absence");
            TextField tfEmail = new TextField("","email_eleve");
       
        Button btnValider = new Button("Valider inscription");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfNom.getText().length()==0)||(tfPrenom.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Eleve t = new Eleve(Integer.parseInt(tfid.getText()),tfNom.getText(),tfPrenom.getText(),Integer.parseInt(tfTel.getText()),Integer.parseInt(tfAbs.getText()),tfEmail.getText());
                        if( ServiceEleve.getInstance().addEleve(t))
                            Dialog.show("Success","Inscription Ajouté avec succes",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
       // btnValider.addActionListener(sms());
        addAll(tfid,tfNom,tfPrenom,tfTel,tfAbs,tfEmail,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> {new eleve().show();
                   
                   });        
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableModel;
import com.mycompany.myapp.entities.Absence;
import com.mycompany.myapp.services.ServiceAbsence;

/**
 *
 * @author bhk
 */
public class ListAbsenceForm extends Form{

    public ListAbsenceForm(Form previous) {
        Absence a = new Absence();
       
        setTitle("List absences");
        
      SpanLabel sp = new SpanLabel();
        sp.setText(ServiceAbsence.getInstance().getAllAbsence().toString());
     add(sp);
    //    getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> {new eleve().show();
                   
                   });
    /*TableModel model = new DefaultTableModel(new String[] {"id", "date", "idmat","nomeleve"}, new Object[][] {
    {a.getId_absence(), a.getDate_absence() , a.getId_matiere() , a.getNom_eleve()},
   
    });
    Table table = new Table(model);
   
          //sp.setText(ServiceAbsence.getInstance().getAllAbsence().toString());
   add(table);
   ServiceAbsence.getInstance().getAllAbsence().add(a);
  
            }
       */
    
}
}

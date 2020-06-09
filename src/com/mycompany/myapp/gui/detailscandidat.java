/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.myapp.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.ImageViewer;
import com.codename1.components.ToastBar;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.ListModel;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Candidat;
import com.mycompany.myapp.services.ServiceCandidat;

/**
 *
 * @author ferie
 */
public class detailscandidat extends Form {
        Form current;
    private  Resources themeee;

    public detailscandidat(Candidat c){
        Form p = null;
         
       
            
                         Label prenom = new Label();
                         Label nom = new Label();
                         Label cin = new Label();
                         Label experience = new Label();
                         Label age = new Label();
     TextField tfnom= new TextField("","nom");
      

     TextField tfprenom= new TextField("","prenom");


     TextField tfage= new TextField("","age");
    
     TextField tfexp= new TextField("","experienceCondidat");
         

     TextField tfcin= new TextField("","cin");
  
                prenom.setText(c.getPrenom_Candidat());
                         nom.setText(c.getNom_Candidat());
                         age.setText(String.valueOf(c.getAge_Candidat()));
                         cin.setText(String.valueOf(c.getCin_Candidat()));
                         experience.setText(c.getExperience_Candidat());

                           Button btsup = new Button("supprimer");
                           Button btmod = new Button("modifier");
                           
                             Dialog dlg = new Dialog("Avertissement");
    Style dlgStyle = dlg.getDialogStyle();
    dlgStyle.setBorder(Border.createEmpty());
    dlgStyle.setBgTransparency(255);
    dlgStyle.setBgColor(0xffffff);

    Label title = dlg.getTitleComponent();
    //title.setIcon(finalDuke.scaledHeight(title.getPreferredH()));
    title.getUnselectedStyle().setFgColor(0xff);
    title.getUnselectedStyle().setAlignment(Component.LEFT);

    dlg.setLayout(BoxLayout.y());
    Label blueLabel = new Label();
    blueLabel.setShowEvenIfBlank(true);
    blueLabel.getUnselectedStyle().setBgColor(0xff);
    blueLabel.getUnselectedStyle().setPadding(1, 1, 1, 1);
    blueLabel.getUnselectedStyle().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
    dlg.add(blueLabel);
    TextArea ta = new TextArea("Voulez vous vraiment supprimer ce candidat ");
    ta.setEditable(false);
    ta.setUIID("DialogBody");
    ta.getAllStyles().setFgColor(0);
    dlg.add(ta);

    Label grayLabel = new Label();
    grayLabel.setShowEvenIfBlank(true);
    grayLabel.getUnselectedStyle().setBgColor(0xcccccc);
    grayLabel.getUnselectedStyle().setPadding(1, 1, 1, 1);
    grayLabel.getUnselectedStyle().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
    dlg.add(grayLabel);

    Button ok = new Button(new Command("OUI"));
    Button non = new Button(new Command("Annuler"));
    ok.getAllStyles().setBorder(Border.createEmpty());
    ok.getAllStyles().setFgColor(0);
    dlg.add(ok);
    non.getAllStyles().setBorder(Border.createEmpty());
    non.getAllStyles().setFgColor(0);
    dlg.add(non);
     
btsup.addActionListener(e -> {
        dlg.showDialog();

    ToastBar.Status status = ToastBar.getInstance().createStatus();
            status.setMessage("Candidat Supprimé ...");
            status.setShowProgressIndicator(true);
            status.setIcon(createIcon(FontImage.MATERIAL_WORK));
            status.show();
            // Now do something that takes a while
                    status.setExpires(1500);
  
    
});
           ok.addActionListener((evt) -> {
               
                                try {
                                    
                             if( ServiceCandidat.getInstance().supprimerTask(c.getCin_Candidat()))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                            else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                             } catch (NumberFormatException ex) {
                                 Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                            }
                                                               new ListCandidatForm(current).show();

                           });
                         Button btnValider = new Button("valider");
//////////////////////////////////////////////////////////
                             Dialog dlgg = new Dialog("Erreur");
    Style dlgStylee = dlgg.getDialogStyle();
    dlgStylee.setBorder(Border.createEmpty());
    dlgStylee.setBgTransparency(255);
    dlgStylee.setBgColor(0xffffff);

    Label titlee = dlgg.getTitleComponent();
    //title.setIcon(finalDuke.scaledHeight(title.getPreferredH()));
    titlee.getUnselectedStyle().setFgColor(0xff);
    titlee.getUnselectedStyle().setAlignment(Component.LEFT);
                      
////////////////////////////////////////////////////////////                         
     btmod.addActionListener((evt) -> {
tfprenom.setText(c.getPrenom_Candidat());
                         tfnom.setText(c.getNom_Candidat());
                         tfage.setText(String.valueOf(c.getAge_Candidat()));
                         tfexp.setText(c.getExperience_Candidat());
                         tfcin.setText(String.valueOf(c.getCin_Candidat()));
                         
                                 addAll(tfcin,tfage,tfnom,tfprenom,tfexp,btnValider);
                                refreshTheme();
                            });
                            
                           btnValider.addActionListener(new ActionListener() {
                                @Override
                                 public void actionPerformed(ActionEvent evt) {
                if ((tfnom.getText().length()==0)||(tfprenom.getText().length()==0))
                    Dialog.show("Alert", "Entrer les champs", new Command("OK"));
                else
                {
                      try {
                                                  Candidat t = new Candidat(Integer.parseInt(tfcin.getText()), tfprenom.getText(),tfnom.getText(),Integer.parseInt(tfage.getText()),tfexp.getText());

                        if( ServiceCandidat.getInstance().ModifierTask(t))
                            Dialog.show("Succès","Votre candidature a été modifiée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("Erreur", "Entrer un entier ", new Command("OK"));
                    }
                   
                    
                }
                
                 new ListCandidatForm(current).show();
            }
                   
                           });
                       

    Button retour = new Button("retour");
       retour.addActionListener((evt) -> {
         new ListCandidatForm(current).show();
       });
  this.addAll(nom,prenom,age,cin,experience,btsup,btmod,retour);
  }
    private Image createIcon(char charcode) {
         
        int iconWidth = Display.getInstance().convertToPixels(8, true);
        Style iconStyle = new Style();
        Font iconFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
        if (Font.isNativeFontSchemeSupported()) {
            iconFont = Font.createTrueTypeFont("native:MainBold", null).derive((int)(iconWidth * 0.5), Font.STYLE_BOLD);
        }
        iconStyle.setFont(iconFont);
        iconStyle.setFgColor(0xffffff);
        iconStyle.setBgTransparency(0);

        FontImage completeIcon = FontImage.createMaterial(charcode, iconStyle);
        return completeIcon;
    }
    
    
    }
    


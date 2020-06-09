/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.myapp.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.ImageViewer;
import com.codename1.components.ToastBar;
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
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Employe;
import com.mycompany.myapp.services.ServiceEmploye;

/**
 *
 * @author ferie
 */
public class detailemploye  extends Form {
                                    private Form current;
    private  Resources themeee;
  public detailemploye(Employe  e) {
        themeee = UIManager.initFirstTheme("/themeee");
            //Image im = theme.getImage("im age.jpg");
            //ImageViewer img = new ImageViewer(im);
            
                                       Label id = new Label();

                           Label prenom = new Label();
                         Label nom = new Label();
                         Label role = new Label();
                         Label salaire = new Label();
                         Label prime = new Label();
                         Label nbrConge = new Label();
                         Label nbrHeure = new Label();
                         Label age = new Label();
                         TextField tfid= new TextField("","id");
       
         TextField tfnom= new TextField("","nom");
    

      TextField tfprenom= new TextField("","prenom");
       
    ComboBox<String> rolef = new ComboBox();
        rolef.addItem("Responsable RH");
        
                rolef.addItem("Enseignant");                     

     TextField tfage= new TextField("","age");
     TextField tfrole= new TextField("","role");


    TextField nbrCongee= new TextField("","nbrConge");
   
   TextField tfNbr_heure= new TextField("","nbrHeure");
   TextField tfsalaire= new TextField("","salaire");
   TextField tfprime= new TextField("","prime");
    

    id.setText(e.getPrenom_condidat());
                         prenom.setText(e.getPrenom_condidat());
                         nom.setText(e.getNom_condidat());
                         age.setText(String.valueOf(e.getAge()));
                         role.setText(e.getRole());
                         salaire.setText(String.valueOf(e.getSalaire()));
                         prime.setText(String.valueOf(e.getPrime()));
                         nbrConge.setText(String.valueOf(e.getNbr_conge()));
                         nbrHeure.setText(String.valueOf(e.getNbr_heure()));
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
    TextArea ta = new TextArea("Voulez vous vraiment supprimer cet employé ");
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
     btsup.addActionListener(je -> {
        dlg.showDialog();

  
  
    
});
                           ok.addActionListener((evt) -> {
                                try {
                             if( ServiceEmploye.getInstance().supprimerTask(e.getId()))
                            Dialog.show("Succès","L'employé a été supprimé",new Command("OK"));
                            else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                             } catch (NumberFormatException ex) {
                                 Dialog.show("Erreur", "Entrer un entier", new Command("OK"));
                            }
                                                               new ListEmploye(current).show();

                           });
                                                    Button btnValider = new Button("valider");

                            btmod.addActionListener((evt) -> {
tfprenom.setText(e.getPrenom_condidat());
                         tfnom.setText(e.getNom_condidat());
                         tfage.setText(String.valueOf(e.getAge()));
                         tfrole.setText(e.getRole());
                    
                         tfsalaire.setText(String.valueOf(e.getSalaire()));
                         tfprime.setText(String.valueOf(e.getPrime()));
                         nbrCongee.setText(String.valueOf(e.getNbr_conge()));
                         tfNbr_heure.setText(String.valueOf(e.getNbr_heure()));
                                 addAll(tfprenom,tfnom,tfage,tfrole,tfNbr_heure,nbrCongee,tfsalaire,tfprime,btnValider);
                                refreshTheme();
                            });
                            
                           btnValider.addActionListener(new ActionListener() {
                                @Override
                                 public void actionPerformed(ActionEvent evt) {
                if ((tfnom.getText().length()==0)||(tfprenom.getText().length()==0 ))
                    Dialog.show("Alert", "Entrer les champs", new Command("OK"));
                else
                {
                      try {
                                                  Employe t = new Employe(e.getId(),tfprenom.getText(), tfnom.getText(),Integer.parseInt(tfage.getText()),rolef.getSelectedItem(),Integer.parseInt(tfNbr_heure.getText()),Integer.parseInt(nbrConge.getText()),Integer.parseInt(tfsalaire.getText()),Integer.parseInt(tfprime.getText()));

                        if( ServiceEmploye.getInstance().ModifierTask(t))
                            Dialog.show("Succès","L'employé a été modifié",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("Erreur", "Entrer un entier", new Command("OK"));
                    }
                    
                    
                }
                
                 new ListEmploye(current).show();
            }
                   
                           });
                       
                        
 
         Button retour = new Button("retour");
       retour.addActionListener((evt) -> {
         new ListEmploye(current).show();
           
       });
 this.addAll(nom,prenom,age,role,salaire,prime,nbrConge,nbrHeure,btsup,btmod,retour);

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

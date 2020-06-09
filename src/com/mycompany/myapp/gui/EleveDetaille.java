/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.myapp.gui;

import com.codename1.components.ToastBar;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
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
import com.mycompany.myapp.entities.Eleve;
import com.mycompany.myapp.services.ServiceEleve;

/**
 *
 * @author Khadija
 */
public class EleveDetaille extends Form  {
     Form current;
    public EleveDetaille(Eleve cl){
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> {new ListEleveForm(current).show();
                   
                   });
        
          Container c = new Container(BoxLayout.y());
                        TextField nom =new TextField();
                           TextField prenom =new TextField();
                     
                          TextField tel =new TextField();
                           TextField email =new TextField();
                        TextField nbr=new TextField();
   
                         Label nomLabel = new Label();
                         Label prenomLabel = new Label();
                             Label telLabel = new Label();
                         Label emailLabel = new Label();
                             Label nbrLabel = new Label();
                      
                         nom.setText(cl.getNom_eleve());
                          prenom.setText(cl.getPrenom_eleve());
                        //   float tel = Float.parseFloat(obj.get.toString());
              //  t.setTel_eleve((int)tel);
                tel.setText(String.valueOf(cl.getTel_eleve()));
                        email.setText(cl.getEmail_eleve());
                         nbr.setText(String.valueOf(cl.getNbr_absence()));
                         Button sup = new Button("supprimer");
                         Button mod = new Button("modifier");
                         c.add(nomLabel).add(prenomLabel).add(telLabel).add(emailLabel).add(nbrLabel).add(sup).add(mod);
                      
                         
             Dialog dlgg = new Dialog("Warning");
    Style dlgStylee = dlgg.getDialogStyle();
    dlgStylee.setBorder(Border.createEmpty());
    dlgStylee.setBgTransparency(255);
    dlgStylee.setBgColor(0xffffff);

    Label titlee = dlgg.getTitleComponent();
    //title.setIcon(finalDuke.scaledHeight(title.getPreferredH()));
    titlee.getUnselectedStyle().setFgColor(0xff);
    titlee.getUnselectedStyle().setAlignment(Component.LEFT);

    dlgg.setLayout(BoxLayout.y());
    Label blueLabell = new Label();
    blueLabell.setShowEvenIfBlank(true);
    blueLabell.getUnselectedStyle().setBgColor(0xff);
    blueLabell.getUnselectedStyle().setPadding(1, 1, 1, 1);
    blueLabell.getUnselectedStyle().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
    dlgg.add(blueLabell);
    TextArea taa = new TextArea("Vous voulez vraiment Supprimer cette Eleve");
    taa.setEditable(false);
    taa.setUIID("DialogBody");
    taa.getAllStyles().setFgColor(0);
    dlgg.add(taa);

    Label grayLabell = new Label();
    grayLabell.setShowEvenIfBlank(true);
    grayLabell.getUnselectedStyle().setBgColor(0xcccccc);
    grayLabell.getUnselectedStyle().setPadding(1, 1, 1, 1);
    grayLabell.getUnselectedStyle().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
    dlgg.add(grayLabell);

    Button okk = new Button(new Command("OUI"));
    Button nonn = new Button(new Command("Annuler"));
    okk.getAllStyles().setBorder(Border.createEmpty());
    okk.getAllStyles().setFgColor(0);
    dlgg.add(okk);
    nonn.getAllStyles().setBorder(Border.createEmpty());
    nonn.getAllStyles().setFgColor(0);
    dlgg.add(nonn);
     
sup.addActionListener(e -> {
 
    dlgg.showDialog();
    ToastBar.Status statuss = ToastBar.getInstance().createStatus();
            statuss.setMessage("Supprission Annuler ...");
            statuss.setShowProgressIndicator(true);
            statuss.setIcon(createIcon(FontImage.MATERIAL_WORK));
            statuss.show();
            // Now do something that takes a while
            Display.getInstance().invokeAndBlock(()->{
                Util.sleep(1000);
            });
});              
                         
                         
                         
                         
                         
                         
                         okk.addActionListener((evt) -> {
                           
           
                        
                            try {
                             if( ServiceEleve.getInstance().DeleteEleveForm(cl))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                            else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                             } catch (NumberFormatException e) {
                                 Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                            }
                         
                                new ListEleveForm(current).show();

                              });
                               Button edit = new Button("edit");
                                 mod.addActionListener((evt) -> {
                                
                            c.add(nom).add(prenom).add(tel).add(email).add(nbr).add(edit);
                             refreshTheme();
                             });
                                 
                                 ///////////////////////////////////////////////////////////////////////////////////
                                  Dialog dlg = new Dialog("Warning");
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
    TextArea ta = new TextArea("Vous voulez vraiment Modifier cette Eleve");
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
     
edit.addActionListener(e -> {
 
    dlg.showDialog();
    ToastBar.Status status = ToastBar.getInstance().createStatus();
            status.setMessage("Modification Annuler...");
            status.setShowProgressIndicator(true);
            status.setIcon(createIcon(FontImage.MATERIAL_WORK));
            status.show();
            // Now do something that takes a while
                     status.setExpires(1500);

});
                                 //////////////////////////////////////////////////////////////////////////////////////////
                                    ok.addActionListener(new ActionListener() {
                                @Override
                                 public void actionPerformed(ActionEvent evt) {
                               
                                try {
                                Eleve clu = new Eleve(cl.getId_eleve(),nom.getText(),prenom.getText(),Integer.parseInt(tel.getText()),email.getText(),Integer.parseInt(nbr.getText()));
                              if( ServiceEleve.getInstance().EditEleveForm(clu))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                                         
                
                                        new ListEleveForm(current).show();
 
                                         }

             
                                         });

                         this.add(c);
                                 getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> { new ListEleveForm(current).show();});


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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.myapp.gui;


import com.codename1.charts.util.ColorUtil;
import com.codename1.components.ImageViewer;
import com.codename1.components.ToastBar;
import com.codename1.io.Util;
import com.codename1.ui.Button;
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
public class SupprimerEmploye extends Form{
        Form current ;
                            private Resources theme;

     public SupprimerEmploye(Form p) {
                 setTitle("Supprimer un employé");

            setLayout(BoxLayout.y());
                 TextField tfCin = new TextField("Entrez l'ID_Employe","id");
                                 tfCin.getAllStyles().setBgColor(ColorUtil.CYAN);

theme = UIManager.initFirstTheme("/theme");
            //Image im = theme.getImage("im age.jpg");
            //ImageViewer img = new ImageViewer(im);
            Image im2 = theme.getImage("employe.png");
            ImageViewer img2 = new ImageViewer(im2);
    Button btnsupp = new Button("Supprimer");
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
    TextArea ta = new TextArea("Vous voulez vraiment Supprimer cette Condidat");
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
     
btnsupp.addActionListener(e -> {
  
    dlg.showDialog();
      ToastBar.Status statuss = ToastBar.getInstance().createStatus();
            statuss.setMessage("Employé Supprimé ...");
            statuss.setShowProgressIndicator(true);
            statuss.setIcon(createIcon(FontImage.MATERIAL_WORK));
            statuss.show();
            // Now do something that takes a while
                    statuss.setExpires(1500);
  
});
       /* btnsupp.addActionListener(new ActionListener() {

              @Override
            public void actionPerformed(ActionEvent evt) {
                         if ((tfCin.getText().length()==0))
                /*  Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                                            Employe t = new Employe(Integer.parseInt(tfCin.getText()));
                        if( ServiceEmploye.getInstance().supprimerTask())

                            Dialog.show("Succès","L'employé a été supprimée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                    
                     

                     }});*/
                addAll(img2,tfCin,btnsupp);
                        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> p.showBack());

         
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

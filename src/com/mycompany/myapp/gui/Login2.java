/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import static com.codename1.ui.layouts.BorderLayout.center;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Session;
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.services.ServiceUser;
import com.codename1.social.FacebookConnect;
import com.codename1.ui.FontImage;

/**
 *
 * @author arij_
 */
public class Login2  extends Form{
     Form current;
    private static User User;
Form cuurent;
           private Resources theme;
            private Resources themeee;

    public Login2(Form p) {
        current = this; //Récupérsation de l'interface(Form) en cours
        current = this; //Récupérsation de l'interface(Form) en cours
        setTitle("Bienvenue sur EASYCHOOL");
            
             

        setLayout(new FlowLayout(Component.CENTER, Component.CENTER));
        Container cnt = new Container(BoxLayout.y());
            cnt.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_GRADIENT_RADIAL);
  cnt.getUnselectedStyle().setBackgroundGradientEndColor(0xFFBCCA);
        TextField username = new TextField(null, "username");
        username.getAllStyles().setBgColor(ColorUtil.CYAN);

        TextField password = new TextField(null, "password");
                        password.getAllStyles().setBgColor(ColorUtil.CYAN);

        password.setConstraint(TextField.PASSWORD);
        Button login = new Button("Se connecter");
theme = UIManager.initFirstTheme("/themeee");
            //Image im = theme.getImage("im age.jpg");
            //ImageViewer img = new ImageViewer(im);
            Image im2 = theme.getImage("es.png");
            ImageViewer img2 = new ImageViewer(im2);
                            add(img2);

        cnt.add(username);
        cnt.add(password);
        cnt.add(login);

        add(cnt);
       
      

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                {

                    User = ServiceUser.getInstance().Login(username.getText(), password.getText());
                    if (User != null) {
                        
                        username.setText("");
                        password.setText("");
                        Session.start(User);
                        
                        if (User.getRoles().equals("ROLE_USER")) {
                            new  eleve().show();
                        } else {
                          new  eleve().show();// lGotocandidat maneha lpage eli thebou temchioulha ki tconnectiou

                        }
                    } else {
                        Dialog.show("Alert", "This is already your home", "OK", null);
                    }

                }
                
               

        
                

            }
        });

 getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> {new GestionEcole(current).show();
                   
                   });
    }
    
    
    }    




    


    


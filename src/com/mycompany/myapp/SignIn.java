package com.mycompany.myapp;


import com.codename1.components.SignatureComponent;
import com.codename1.io.Log;
import com.codename1.social.Login;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.addNetworkErrorListener;
import static com.codename1.ui.CN.getCurrentForm;
import static com.codename1.ui.CN.updateNetworkThreadCount;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;

import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;

import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.gui.GestionEcole;
import java.io.IOException;


import userclassese.StateMachinee;
//import javax.smartcardio.Card;


public class SignIn {
  
    
    private Resources cards;

        private Form current;

    private Form loginForm;
    private Resources gamedata;
private static Resources res;
    private Resources theme;
private Resources themeee;
    private Login login;

    public void init(Object context) {
        try {
              
            // after loading the default theme we load the card images as a resource with
            // a fake DPI so they will be large enough. We store them in a resource rather 
            // than as files so we can use the MultiImage functionality
            
       
             theme = Resources.openLayered("/theme");
              UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
            themeee = Resources.openLayered("/themeee");
            UIManager.getInstance().setThemeProps(themeee.getTheme(themeee.getThemeResourceNames()[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
          
         updateNetworkThreadCount(2);

        themeee = UIManager.initFirstTheme("/themeee");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        }); 
    }

    public void start() {

        loginForm = new Form("Bienvenue à EASEYCHOOL");
        loginForm.setLayout(new BorderLayout());
        Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        center.setUIID("ContainerWithPadding");
Image sign = themeee.getImage("chboxv1.png");
        Image logo = themeee.getImage("es.png");
        Label l = new Label(logo);
        Container flow = new Container(new FlowLayout(Component.CENTER));
        flow.addComponent(l);
        center.addComponent(flow);

        final TextField username = new TextField();
        username.setHint("Username");
        final TextField pass = new TextField();
        pass.setHint("Password");
        pass.setConstraint(TextField.PASSWORD);
        
        Toolbar.setGlobalToolbar(true);
        
  loginForm.getToolbar().addMaterialCommandToSideMenu("Easychool",FontImage.MATERIAL_IMPORTANT_DEVICES, e -> {});

   loginForm.getToolbar().addMaterialCommandToSideMenu("Exit", FontImage.MATERIAL_EXIT_TO_APP, e -> {Display.getInstance().exitApplication();}); 
         ////////////////////////////////
       // Container c = new Container(new FlowLayout(Component.CENTER));
   // Button s = new Button("Time");



      loginForm.getToolbar().addMaterialCommandToSideMenu("To do Notes",FontImage.MATERIAL_NOTES, ev->{
        if (current != null) {
            current.show();
            return;
        }
        
        
        new StateMachinee("/theme_1");
   
          
          
        });
            loginForm.getToolbar().addMaterialCommandToSideMenu("Paint",FontImage.MATERIAL_NOTES, ev->{

          if(current != null){
            current.show();
            return;
        }
        Form hi = new Form("Paint");
        hi.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        hi.add("Enter Your Name:");
        hi.add(new TextField());
        hi.add("Paint:");
        SignatureComponent sig = new SignatureComponent();
        sig.addActionListener((evt)-> {
            System.out.println("The signature was changed");
            Image img = sig.getSignatureImage();
            // Now we can do whatever we want with the image of this signature.
        });
        hi.addComponent(sig);
        hi.show();
      
});

        Button signIn = new Button(" Get Started",sign);
        
       signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

               if(pass.getText().equals("")
                && username.getText().equals(""))
        {
            
     new GestionEcole(current).show();
        }
        else if(username.getText().equals("")
                && pass.getText().equals("")){
            new GestionEcole(current).show();
        }
        else{
        Dialog.show("error","login ou pwd invalid","ok","cancel");
        }
            }
        });
       
        center.addComponent(signIn);
       // center.addComponent(s);
        loginForm.addComponent(BorderLayout.CENTER, center);



        loginForm.show();
        
        ////////////////////////////
        
        
    
       
    }



    public void destroy() {
    }

    public void stop() {
         current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
}

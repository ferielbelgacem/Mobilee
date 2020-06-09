/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.location.Geofence;
import com.codename1.location.LocationManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
//import com.mycompany.myapp.entities.Club;
//import com.mycompany.myapp.entities.Evenement;
//import com.mycompany.myapp.entities.Membre;
import com.mycompany.myapp.entities.Task;
//import com.mycompany.myapp.gui.DeleteTaskForm;
import com.mycompany.myapp.utils.Statics;
import static com.mycompany.myapp.utils.Statics.BASE_URL2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author bhk
 */
/*
public class ServiceTask {

  //  public ArrayList<Membre> tasks;
    //public ArrayList<Club> tasksc;
    //public ArrayList<Evenement> taskse;
    //public Club c;
    public static ServiceTask instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceTask() {
         req = new ConnectionRequest();
    }

    public static ServiceTask getInstance() {
        if (instance == null) {
            instance = new ServiceTask();
        }
        return instance;
    }

    public boolean addTask(Membre m) {
            String url = Statics.BASE_URL2 + "neww?nom=" + m.getNom()+ "&prenom="+m.getPrenom()+ "&age=" + m.getAge();
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);   
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Membre> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
        
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
   
            for(Map<String,Object> obj : list){

                Membre m = new Membre();
                float id = Float.parseFloat(obj.get("id").toString());
                m.setId((int)id);
               
                m.setNom(obj.get("nom").toString());
                m.setPrenom(obj.get("prenom").toString());
              m.setAge(((int)Float.parseFloat(obj.get("age").toString())));
               
                tasks.add(m);
            }
            
            
        } catch (IOException ex) {
            
        }
         
        return tasks;
    }

    
      public boolean addClub(Club m) {
            String url = Statics.BASE_URL2 + "newwc?nom=" + m.getNom()+ "&type="+m.getType();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this); 
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Club> parseClub(String jsonText){
        try {
            tasksc=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
     
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Club m = new Club();
                float id = Float.parseFloat(obj.get("id").toString());
                m.setId((int)id);
               
                m.setNom(obj.get("nom").toString());
                m.setType(obj.get("type").toString());
                tasksc.add(m);
            }
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
/*
        return tasksc;
    }
    
    
      public boolean addEvent(Evenement m) {
            String url = Statics.BASE_URL2 + "newwe?nom=" + m.getNom()+ "&capacite="+m.getCapacite()+ "&date="+m.getDate();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this); 
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Evenement> parseEvent(String jsonText){
        try {
            taskse =new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
     
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Evenement m = new Evenement();
                float id = Float.parseFloat(obj.get("id").toString());
                m.setId((int)id);
                m.setDate(null);
                m.setNom(obj.get("nom").toString());
                 float capacite = Float.parseFloat(obj.get("capacity").toString());
                m.setCapacite((int)capacite);
                
                taskse.add(m);
            }
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
/*
        return taskse;
    }
    
    
    
    
    
    
    public ArrayList<Membre> getAllMembre(){
        String url = Statics.BASE_URL2+"alll";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                tasks = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks;
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    public ArrayList<Membre> getListMembre() {
        ArrayList<Membre> listmembre = new ArrayList<>();
           ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1/symfony/web/app_dev.php/clubb/tasks/alll");
        
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> result : list) {
                        Membre p = new Membre();
                        float id = Float.parseFloat(result.get("id").toString());
                        p.setId((int) id);
            
            
            
              
            p.setNom(result.get("nom").toString());
            p.setPrenom(result.get("prenom").toString());
             float age = Float.parseFloat(result.get("age").toString());
                        p.setAge((int) id);
          
                      listmembre.add(p);
            
                                

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println("list "+listmembre);
        return listmembre;
         
    }
    
    
    
    
    
    
    
    public boolean DeleteTaskForm(Membre m ) {
         
        String url = Statics.BASE_URL2 + "deleteReview?idReview=" + m.getId()  ;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
     public boolean EditTaskForm(Membre m ) {

        String url = Statics.BASE_URL2 + "editReview?idReview=" + m.getId()+ "&nom=" + m.getNom()+ "&prenom="+m.getPrenom()+ "&age=" + m.getAge(); ;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
     
     
      public ArrayList<Club> getAllClub(){
        String url = Statics.BASE_URL2+"alllc";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                tasksc = parseClub(new String(req.getResponseData()));
                req.removeResponseListener(this);
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasksc;
    }
    
    public boolean DeleteClub(Club m ) {
         
        String url = Statics.BASE_URL2 + "deleteReviewc?idReview=" + m.getId()  ;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    
    
    
    
     
    
     public boolean EditClub(Club m ) {

        String url = Statics.BASE_URL2 + "editReviewc?idReview=" + m.getId()+ "&nom=" + m.getNom()+ "&type="+m.getType(); ;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
     
     
public ArrayList<Evenement> getAllEvent(){
        String url = Statics.BASE_URL2+"allle";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                taskse = parseEvent(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return taskse;
    }
    
    public boolean DeleteEvent(Evenement m ) {
         
        String url = Statics.BASE_URL2 + "deleteReviewe?idReview=" + m.getId()  ;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
     public boolean EditEvent(Evenement m ) {

        String url = Statics.BASE_URL2 + "editReviewe?idReview=" + m.getId()+ "&nom=" + m.getNom()+ "&capacite="+m.getCapacite()+ "&date="+m.getDate(); ;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    
//      public ServiceTask l = new ServiceTask();


public Club parseC(String jsonText) throws IOException {
   
        Club c = new Club();
       
            JSONParser j = new JSONParser();

            Map<String, Object> UserListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

     

                float id = Float.parseFloat(UserListJson.get("id").toString());
                c.setId((int) (id));
       return c;
    }
}






 
     
     
     */
     


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
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Bulletin;

import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceBulletin {

    public ArrayList<Bulletin> bulletin;
    
    public static ServiceBulletin instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceBulletin() {
         req = new ConnectionRequest();
    }

    public static ServiceBulletin getInstance() {
        if (instance == null) {
            instance = new ServiceBulletin();
        }
        return instance;
    }
//
    /*public boolean addAbsence(Absence t) {
        String url = Statics.BASE_URL + "neww?id="+t.getId_absence()+"&date=" + t.getDate_absence()+ "&idmatiere="+t.getId_matiere()+"&nom=" +t.getNom_eleve();
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
*/
    public ArrayList<Bulletin> parseBulletins(String jsonText){
        try {
           bulletin=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> bulletinListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)bulletinListJson.get("root");
            for(Map<String,Object> obj : list){
                Bulletin t = new Bulletin();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId_bulletin((int)id);
                  float moy = Float.parseFloat(obj.get("moyenne").toString());
                t.setMoyenne((int)moy);
                 //  float idel = Float.parseFloat(obj.get("idEleve").toString());
             //   t.setId_eleve((int)idel);
                   float ide = Float.parseFloat(obj.get("ide").toString());
                t.setIde((int)ide);
                
               // t.setNom_eleve(((int)Float.parseFloat(obj.get("status").toString())));
//                t.setNom_eleve(obj.get("nomEleve").toString());
             //     float idmat = Float.parseFloat(obj.get("idMatiere").toString());
                 
                // t.setId_matiere((int)idmat);
                // int ide=3;
                 
            
            bulletin.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return bulletin;
    }
    
    public ArrayList<Bulletin> getAllBulletin(){
        String url = Statics.BASE_URL+"albul";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                bulletin = parseBulletins(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return bulletin;
    }
    
    /*
    
     public boolean DeleteAbsenceForm(Absence t ) {
         
        String url = Statics.BASE_URL + "deleteReview?idReview=" + t.getId_absence();
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
    
     public boolean EditAbsenceForm(Absence t ) {

        String url = Statics.BASE_URL + "editReview?id="+t.getId_absence()+"&date=" + t.getDate_absence()+ "&idmatiere="+t.getId_matiere()+"&nom=" +t.getNom_eleve();;
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
*/
    
    
    
}

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
import com.mycompany.myapp.entities.Eleve;
import com.mycompany.myapp.entities.Task;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceEleve {

    public ArrayList<Eleve> eleve;
    
    public static ServiceEleve instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceEleve() {
         req = new ConnectionRequest();
    }

    public static ServiceEleve getInstance() {
        if (instance == null) {
            instance = new ServiceEleve();
        }
        return instance;
    }
//
    public boolean addEleve(Eleve t) {
        String url = Statics.BASE_URL + "neww?id="+t.getId_eleve()+"&nom=" + t.getNom_eleve() + "&prenom="+t.getPrenom_eleve()+"&tel=" +t.getTel_eleve()+"&abs=" +t.getNbr_absence()+"&emailEleve=" +t.getEmail_eleve() ;
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

    public ArrayList<Eleve> parseEleves(String jsonText){
        try {
            eleve=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> elevesListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)elevesListJson.get("root");
            for(Map<String,Object> obj : list){
                Eleve t = new Eleve();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId_eleve((int)id);
               // t.setNom_eleve(((int)Float.parseFloat(obj.get("status").toString())));
                t.setNom_eleve(obj.get("nom").toString());
                t.setPrenom_eleve(obj.get("prenom").toString());
                 float tel = Float.parseFloat(obj.get("tel").toString());
                t.setTel_eleve((int)tel);
                 float nbab = Float.parseFloat(obj.get("abs").toString());
                t.setNbr_absence((int)nbab);
                 t.setEmail_eleve(obj.get("emailEleve").toString());
                eleve.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return eleve;
    }
    
    public ArrayList<Eleve> getAllEleve(){
        String url = Statics.BASE_URL+"alll";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                eleve = parseEleves(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return eleve;
    }
    
    
    
     public boolean DeleteEleveForm(Eleve t ) {
         
        String url = Statics.BASE_URL + "deleteReview?idReview=" + t.getId_eleve();
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
    
     public boolean EditEleveForm(Eleve t ) {

        String url = Statics.BASE_URL + "editReview?idReview="+t.getId_eleve()+"&nom=" + t.getNom_eleve() + "&prenom="+t.getPrenom_eleve()+"&tel=" +t.getTel_eleve()+"&abs=" +t.getNbr_absence()+"&emailEleve=" +t.getEmail_eleve() ;; ;
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

    
    
    
}

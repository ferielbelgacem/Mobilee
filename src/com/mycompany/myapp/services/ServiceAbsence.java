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
import com.mycompany.myapp.entities.Absence;
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
public class ServiceAbsence {

    public ArrayList<Absence> absence;
    
    public static ServiceAbsence instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceAbsence() {
         req = new ConnectionRequest();
    }

    public static ServiceAbsence getInstance() {
        if (instance == null) {
            instance = new ServiceAbsence();
        }
        return instance;
    }

    public ArrayList<Absence> parseAbsences(String jsonText){
        try {
           absence=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> absenceListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)absenceListJson.get("root");
            for(Map<String,Object> obj : list){
                Absence t = new Absence();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId_absence((int)id);
               // t.setNom_eleve(((int)Float.parseFloat(obj.get("status").toString())));
//                t.setNom_eleve(obj.get("nomEleve").toString());
             //     float idmat = Float.parseFloat(obj.get("idMatiere").toString());
                 
                // t.setId_matiere((int)idmat);
             //     int ide=3;
                    float ide = Float.parseFloat(obj.get("ide").toString());
                t.setIde((int)ide);
                  
            
            absence.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return absence;
    }
    
    public ArrayList<Absence> getAllAbsence(){
        String url = Statics.BASE_URL+"alab";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                absence = parseAbsences(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return absence;
    }
    
  
    
    
    
}

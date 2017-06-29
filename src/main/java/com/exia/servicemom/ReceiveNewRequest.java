/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exia.servicemom;

import com.exia.model.File;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.jws.WebService;

/**
 *
 * @author Guillaume-PC
 */
@Stateless
@WebService(endpointInterface="com.exia.servicemom.ReceiveNewRequestEndPointInterface", portName="ReceiveTextFilePort", serviceName="sendTextFile")
public class ReceiveNewRequest implements ReceiveNewRequestEndPointInterface {
    
    @Inject
    private JMSContext context;

    @Resource(lookup = "jms/QueueTransferFile")
    private Queue textFileQueue; 
    
    @Override
    public List<String> getTextFile(List<String> content, List<String> name, String key, String tokenUser) 
    {
        //Reception d'un fichier depuis le C#
        //Envoyer le fichier dans la queue
        
        System.out.println("Nouvelle demande : clef : " + key);
        
        List<File> files = new ArrayList<File>(); 
        
        for(int i = 0; i < content.size(); i++)
        {
            File file = new File();
            file.setContent(content.get(i));
            file.setName(name.get(i));
            file.setKey(key);
            file.setTokenUser(tokenUser);
            
            files.add(file);
        }

        putTextFileInJMSQueue(files);
        
        return name;
    }

    private void putTextFileInJMSQueue(List<File> files)
    {
        try 
        {
            //Solution avec JSON
            ObjectMapper mapper = new ObjectMapper();

            String jsonInString = mapper.writeValueAsString(files);
 
            TextMessage msg = context.createTextMessage(jsonInString);

            context.createProducer().send(textFileQueue, msg);
        } 
        catch(JsonProcessingException ex) 
        {
            Logger.getLogger(ReceiveNewRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

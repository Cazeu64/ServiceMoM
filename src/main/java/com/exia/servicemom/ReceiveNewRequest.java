/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exia.servicemom;

import com.exia.model.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
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

    @Resource(lookup = "jms/TextFileQueue")
    private Queue textFileQueue; 
    
    @Override
    public Boolean getTextFile(String text, String name, String key) 
    {
        //Reception d'un fichier depuis le C#
        //Envoyer le fichier dans la queue
        
        File file = new File();
        //file.setContent(message.getBody(String.class));
        file.setContent(text);
        file.setName(name);
        file.setKey(key);
        
        putTextFileInJMSQueue(file);
        
        return true;
    }

    private void putTextFileInJMSQueue(File textFile)
    {
        //JAXBContext jaxbContext;
        
        try 
        {
            /*
            jaxbContext = JAXBContext.newInstance(File.class);
            
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            StringWriter writer = new StringWriter();

            jaxbMarshaller.marshal(textFile, writer);
            String xmlMessage = writer.toString();
            */
            System.out.println("Envoi du fichier " + textFile.getName());

            TextMessage msg = context.createTextMessage(textFile.toString()); //xmlMessage

            context.createProducer().send(textFileQueue, msg);
        } 
        //catch(JAXBException ex)
        catch(Exception ex)
        {
            Logger.getLogger(ReceiveNewRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exia.servicemom;

import com.exia.model.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Guillaume-PC
 */

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/TextFileQueue")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})

@Stateless
@LocalBean
public class MessageReceiver implements MessageListener
{   
    @Inject
    private TextFileValidator textFileValidator;
    
    @Override
    public void onMessage(Message message)
    {
        try 
        {
            //file = createFileFromSring(message.getBody(String.class));
            System.out.println("Message reçu : " + message.getBody(String.class));
            String fileTxt = message.getBody(String.class);

            //file.setContent(message.getStringProperty("content"));
            //file.setName(message.getStringProperty("name"));
            //file.setKey(message.getStringProperty("key"));
            
            if(textFileValidator.processChecking(fileTxt))
            {
                //Stoper tous les test sur ce fichier, clef trouvé
            }
            else
            {
                //On continue
            }
            
            //Traitement du fichier en cours  
        } 
        catch(JMSException ex) 
        {
            Logger.getLogger(MessageReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public File createFileFromSring(String fileString)
    {
        String[] tabString = fileString.split("|");
        
        File fileRet = new File();
        fileRet.setContent(tabString[0]);
        fileRet.setName(tabString[1]);
        fileRet.setKey(tabString[2]);
        
        return fileRet;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exia.servicemom;

import com.exia.remote.CheckingEndpoint;
import com.exia.remote.CheckingService;
import com.exia.model.File;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Guillaume-PC
 */
@Stateless
public class SoapTextFileValidator implements TextFileValidator 
{
    @WebServiceRef(CheckingService.class)
    private CheckingEndpoint checking;
    
    @Override
    public Boolean processChecking(String file) 
    {
        Boolean isValid = checking.checkValidity(file);
        return isValid;
    }
}

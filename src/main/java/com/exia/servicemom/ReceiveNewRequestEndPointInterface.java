/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exia.servicemom;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author Guillaume-PC
 */

@WebService(name = "CheckingEndpoint")
public interface ReceiveNewRequestEndPointInterface {
    @WebMethod(operationName = "transferTextFile")
    @WebResult(name = "resultTransfer")
    List<String> getTextFile(List<String> content, List<String> name, String key, String tokenUser);
}

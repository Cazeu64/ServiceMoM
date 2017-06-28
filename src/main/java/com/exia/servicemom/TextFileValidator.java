/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exia.servicemom;

import javax.ejb.Local;

/**
 *
 * @author Guillaume-PC
 */
@Local
public interface TextFileValidator {
    public Boolean processChecking(String file);
}

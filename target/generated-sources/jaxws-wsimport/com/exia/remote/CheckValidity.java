
package com.exia.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour checkValidity complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="checkValidity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="textToCheck" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkValidity", propOrder = {
    "textToCheck"
})
public class CheckValidity {

    protected String textToCheck;

    /**
     * Obtient la valeur de la propriété textToCheck.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextToCheck() {
        return textToCheck;
    }

    /**
     * Définit la valeur de la propriété textToCheck.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextToCheck(String value) {
        this.textToCheck = value;
    }

}

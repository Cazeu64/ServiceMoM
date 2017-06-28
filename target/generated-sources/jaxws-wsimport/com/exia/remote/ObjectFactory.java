
package com.exia.remote;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.exia.remote package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CheckValidityResponse_QNAME = new QName("http://main.exia.com/", "checkValidityResponse");
    private final static QName _CheckValidity_QNAME = new QName("http://main.exia.com/", "checkValidity");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.exia.remote
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckValidityResponse }
     * 
     */
    public CheckValidityResponse createCheckValidityResponse() {
        return new CheckValidityResponse();
    }

    /**
     * Create an instance of {@link CheckValidity }
     * 
     */
    public CheckValidity createCheckValidity() {
        return new CheckValidity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckValidityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://main.exia.com/", name = "checkValidityResponse")
    public JAXBElement<CheckValidityResponse> createCheckValidityResponse(CheckValidityResponse value) {
        return new JAXBElement<CheckValidityResponse>(_CheckValidityResponse_QNAME, CheckValidityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckValidity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://main.exia.com/", name = "checkValidity")
    public JAXBElement<CheckValidity> createCheckValidity(CheckValidity value) {
        return new JAXBElement<CheckValidity>(_CheckValidity_QNAME, CheckValidity.class, null, value);
    }

}

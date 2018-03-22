
package com.sunland.test.webservice.myservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sunland.test.webservice.server package. 
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

    private final static QName _GetAddressByPhoneNoResponse_QNAME = new QName("http://server.webservice.test.sunland.com/", "getAddressByPhoneNoResponse");
    private final static QName _GetAddressByPhoneNo_QNAME = new QName("http://server.webservice.test.sunland.com/", "getAddressByPhoneNo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sunland.test.webservice.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAddressByPhoneNoResponse }
     * 
     */
    public GetAddressByPhoneNoResponse createGetAddressByPhoneNoResponse() {
        return new GetAddressByPhoneNoResponse();
    }

    /**
     * Create an instance of {@link GetAddressByPhoneNo }
     * 
     */
    public GetAddressByPhoneNo createGetAddressByPhoneNo() {
        return new GetAddressByPhoneNo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAddressByPhoneNoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.test.sunland.com/", name = "getAddressByPhoneNoResponse")
    public JAXBElement<GetAddressByPhoneNoResponse> createGetAddressByPhoneNoResponse(GetAddressByPhoneNoResponse value) {
        return new JAXBElement<GetAddressByPhoneNoResponse>(_GetAddressByPhoneNoResponse_QNAME, GetAddressByPhoneNoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAddressByPhoneNo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.test.sunland.com/", name = "getAddressByPhoneNo")
    public JAXBElement<GetAddressByPhoneNo> createGetAddressByPhoneNo(GetAddressByPhoneNo value) {
        return new JAXBElement<GetAddressByPhoneNo>(_GetAddressByPhoneNo_QNAME, GetAddressByPhoneNo.class, null, value);
    }

}

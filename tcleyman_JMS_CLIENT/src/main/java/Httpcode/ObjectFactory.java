
package Httpcode;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Httpcode package. 
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

    private final static QName _SayHello2Response_QNAME = new QName("http://tcleyman/", "sayHello2Response");
    private final static QName _SayHello2_QNAME = new QName("http://tcleyman/", "sayHello2");
    private final static QName _SayHelloResponse_QNAME = new QName("http://tcleyman/", "sayHelloResponse");
    private final static QName _SayHello_QNAME = new QName("http://tcleyman/", "sayHello");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Httpcode
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayHello2Response }
     * 
     */
    public SayHello2Response createSayHello2Response() {
        return new SayHello2Response();
    }

    /**
     * Create an instance of {@link SayHello2 }
     * 
     */
    public SayHello2 createSayHello2() {
        return new SayHello2();
    }

    /**
     * Create an instance of {@link SayHello }
     * 
     */
    public SayHello createSayHello() {
        return new SayHello();
    }

    /**
     * Create an instance of {@link SayHelloResponse }
     * 
     */
    public SayHelloResponse createSayHelloResponse() {
        return new SayHelloResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHello2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tcleyman/", name = "sayHello2Response")
    public JAXBElement<SayHello2Response> createSayHello2Response(SayHello2Response value) {
        return new JAXBElement<SayHello2Response>(_SayHello2Response_QNAME, SayHello2Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHello2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tcleyman/", name = "sayHello2")
    public JAXBElement<SayHello2> createSayHello2(SayHello2 value) {
        return new JAXBElement<SayHello2>(_SayHello2_QNAME, SayHello2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tcleyman/", name = "sayHelloResponse")
    public JAXBElement<SayHelloResponse> createSayHelloResponse(SayHelloResponse value) {
        return new JAXBElement<SayHelloResponse>(_SayHelloResponse_QNAME, SayHelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tcleyman/", name = "sayHello")
    public JAXBElement<SayHello> createSayHello(SayHello value) {
        return new JAXBElement<SayHello>(_SayHello_QNAME, SayHello.class, null, value);
    }

}

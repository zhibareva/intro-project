
package org.example.soap.ws.client.generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PersonsPort", targetNamespace = "http://localhost:7071/ws")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PersonsPort {


    /**
     * 
     * @param personRequest
     * @return
     *     returns org.example.soap.ws.client.generated.PersonResponse
     */
    @WebMethod(operationName = "Person")
    @WebResult(name = "PersonResponse", targetNamespace = "http://localhost:7071/ws", partName = "PersonResponse")
    public PersonResponse person(
        @WebParam(name = "PersonRequest", targetNamespace = "http://localhost:7071/ws", partName = "PersonRequest")
        PersonRequest personRequest);

}

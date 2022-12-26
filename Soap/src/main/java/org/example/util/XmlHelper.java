package org.example.util;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlHelper {
    private XmlHelper() {
    }

    static final TransformerFactory factory = TransformerFactory.newInstance();

    public static String transform(String xmlRequest) throws TransformerException {
        Source xslt = new StreamSource(new File("Soap/src/main/resources/PersonResponse.xsl"));
        Transformer transformer = factory.newTransformer(xslt);
        Source xml = new StreamSource(new StringReader(xmlRequest));
        StringWriter writer = new StringWriter();
        transformer.transform(xml, new StreamResult(writer));
        return writer.toString();
    }
}

package ru.skillbench.tasks.javax.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.InputStream;
import java.io.StringWriter;

public class SimpleXMLImpl implements SimpleXML {
    @Override
    public String createXML(String tagName, String textNode) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            Document doc = factory.newDocumentBuilder().newDocument();

            Element root = doc.createElement(tagName);
            root.appendChild(doc.createTextNode(textNode));
            doc.appendChild(root);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));

            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String parseRootElement(InputStream xmlStream) throws SAXException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();

            factory.setValidating(true);
            factory.setNamespaceAware(false);
            SAXParser parser = factory.newSAXParser();

            class SAXHandler extends DefaultHandler {
                private String rootName;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (rootName == null)
                        rootName = qName;
                }

                public String getRootName() {
                    return rootName;
                }
            }

            SAXHandler handler = new SAXHandler();
            parser.parse(xmlStream, handler);
            return handler.getRootName();
        } catch (SAXException e) {
            throw new SAXException();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

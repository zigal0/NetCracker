package ru.skillbench.tasks.javax.xml;

import com.sun.org.apache.xml.internal.serializer.ElemDesc;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("emp-hier.xml");

        XPathCaller xPathCaller = new XPathCallerImpl();
//        Element[] result = xPathCaller.getEmployees(doc, "30", "emp-hier");
//        Element[] result = xPathCaller.getOrdinaryEmployees(doc, "emp-hier");
//        Element[] result = xPathCaller.getTopManagement(doc, "emp-hier");
//        System.out.println(xPathCaller.getHighestPayed(doc, "emp-hier"));
//        System.out.println(xPathCaller.getHighestPayed(doc, "20", "emp-hier"));

        Element[] result = xPathCaller.getCoworkers(doc, "7521","emp-hier");
        for (Element element : result) {
            System.out.println(element.getElementsByTagName("ename").item(0).getTextContent());
        }
//        System.out.println(xPathCaller.getHighestPayed(doc, "emp-hier"));
//        System.out.println(xPathCaller.getHighestPayed(doc, "20","emp-hier"));
//        System.out.println(Arrays.toString(xPathCaller.getTopManagement(doc, "emp-hier")));
    }
}

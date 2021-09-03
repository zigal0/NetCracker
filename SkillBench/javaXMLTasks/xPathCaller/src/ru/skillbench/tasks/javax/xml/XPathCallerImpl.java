package ru.skillbench.tasks.javax.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.xpath.*;

public class XPathCallerImpl implements XPathCaller {

    private Element[] compileExecuteTransform(Document src, String toCompile) {

        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        try {
            NodeList nodes = (NodeList) xpath.compile(toCompile).evaluate(src, XPathConstants.NODESET);
            Element[] toElements = new Element[nodes.getLength()];
            for (int i = 0; i < nodes.getLength(); i++) {
                toElements[i] = (Element) nodes.item(i);
            }
            return toElements;
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Element[] getEmployees(Document src, String deptno, String docType) {
        return compileExecuteTransform(src, "//employee[@deptno=" + deptno + "]");
    }

    @Override
    public String getHighestPayed(Document src, String docType) {
        Element[] result = compileExecuteTransform(src, "//employee[not(sal < //employee/sal)]");
        if (result == null) {
            return null;
        }
        return result[0].getElementsByTagName("ename").item(0).getTextContent();
    }

    @Override
    public String getHighestPayed(Document src, String deptno, String docType) {
        Element[] result = compileExecuteTransform(src, "//employee[@deptno="
                + deptno + " and not(sal < //employee[@deptno =" + deptno + "]/sal)]");
        if (result == null) {
            return null;
        }
        return result[0].getElementsByTagName("ename").item(0).getTextContent();
    }

    @Override
    public Element[] getTopManagement(Document src, String docType) {
        if (docType.equals("emp-hier")) {
            return compileExecuteTransform(src, "//employee[count(ancestor::*) = 0]");
        }
        return compileExecuteTransform(src, "//employee[not (@mgr)]");
    }

    @Override
    public Element[] getOrdinaryEmployees(Document src, String docType) {
        if (docType.equals("emp-hier")) {
            return compileExecuteTransform(src, "//employee[not(./employee)]");
        }
        return compileExecuteTransform(src, "//employee[not(@empno = (//@mgr))]");
    }

    @Override
    public Element[] getCoworkers(Document src, String empno, String docType) {
        if (docType.equals("emp-hier")) {
            return compileExecuteTransform(src, "//employee[@empno = '" + empno + "']/preceding-sibling::employee | //employee[@empno = '" + empno + "']/following-sibling::employee");
        }
        return compileExecuteTransform(src, "//employee[@mgr = //employee[@empno = //employee[@empno = '"
                + empno + "']/@mgr]/@empno and @empno != '" + empno + "']");
    }
}

package main.core.parsers;

import main.core.parsers.domroutines.DomBaseRoutine;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderDomParser<T> {
    public List<T> getDataFromFile(String filePath, DomBaseRoutine<T> routine) {
        List<T> values;
        var file = new File(filePath);
        try {
            var factory =
                    DocumentBuilderFactory.newInstance();
            var builder = factory.newDocumentBuilder();
            var document = builder.parse(file);
            var nodeList = document.getDocumentElement().getElementsByTagName(routine.className);
            values = new ArrayList<>(nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() != Node.TEXT_NODE) {
                    values.add(routine.getFromNode(nodeList.item(i)));
                }
            }
            return values;
        } catch (IOException | ParserConfigurationException | SAXException e) {
            //log
            return null;
        }
    }
}

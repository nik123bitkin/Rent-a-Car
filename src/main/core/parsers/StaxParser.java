package main.core.parsers;

import main.core.parsers.staxroutines.IStaxRoutine;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class StaxParser<T> {

    public List<T> parseFile(String filePath, IStaxRoutine<T> routine)  {
        var xmlInputFactory = XMLInputFactory.newFactory();
        try {
            var inputStream = new FileInputStream(filePath);
            var reader = xmlInputFactory.createXMLEventReader(inputStream);
            return routine.parse(reader);
        } catch (FileNotFoundException | XMLStreamException e) {
            //log
            return null;
        }
    }
}

package services;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.Model;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import static java.util.logging.Level.ALL;
import static java.util.logging.Level.SEVERE;

public class XmlParser {
    private final String XML_SOURCE = "C:\\Files\\Projects\\Java\\Lab2\\xml_source\\model.xml";
    private final String XSD_SOURCE = "C:\\Files\\Projects\\Java\\Lab2\\xml_source\\model.xsd";
    private final String LOG_SOURCE = "C:\\Files\\Projects\\Java\\Lab2\\xml_source\\log.txt";

    private final Logger logger = Logger.getLogger(XmlParser.class.getName());

    public void serialize(Model model){
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JavaTimeModule());
            xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            xmlMapper.writeValue(new File(XML_SOURCE), model);
        }catch(Exception ignored){}
    }

    public Model loadModel(){
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xmlText = new String(Files.readAllBytes(Paths.get(XML_SOURCE)));
            return xmlMapper.readValue(xmlText, Model.class);
        }catch(IOException ex){
            logger.log(SEVERE, "IOException occured");
            return null;
        }
    }

    public boolean validate(){
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(XSD_SOURCE));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(XML_SOURCE));
            logger.info("Validated");
            return true;
        } catch (IOException e) {
            logger.log(SEVERE, "IOException occured");
        } catch (org.xml.sax.SAXException e) {
            logger.log(SEVERE, "SAXException occured");
        }
        return false;
    }

    public XmlParser() {
        try {
            FileHandler fileHandler = new FileHandler(LOG_SOURCE);
            fileHandler.setLevel(ALL);
            logger.addHandler(fileHandler);
        }catch(IOException e){
            logger.addHandler(new ConsoleHandler());
        }
        logger.setLevel(ALL);
    }
}

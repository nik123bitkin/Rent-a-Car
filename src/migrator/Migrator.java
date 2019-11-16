package migrator;


import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.logging.Level.*;

public class Migrator {

    private final Logger logger = Logger.getLogger(Migrator.class.getName());

    public void validate(/*File xmlFile, File xsdFile*/){
        File xmlFile = new File("C:\\Files\\Projects\\Java\\RentCarService\\xml_source\\model.xml");
        File xsdFile = new File("C:\\Files\\Projects\\Java\\RentCarService\\xml_source\\model.xsd");
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
            System.out.println("Validated");
            logger.info("Validated");
        } catch (IOException e) {
            logger.log(SEVERE, "IOException occured");
            System.out.println("Exception: " + e.getMessage());
        } catch (org.xml.sax.SAXException e) {
            logger.log(SEVERE, "SAXException occured");
        }
    }

    public Migrator(){
        try {
            FileHandler fileHandler =
                    new FileHandler("C:\\Files\\Projects\\Java\\RentCarService\\xml_source\\log.txt");
            fileHandler.setLevel(ALL);
            logger.addHandler(fileHandler);
        }catch(IOException e){
            logger.addHandler(new ConsoleHandler());
        }
        logger.setLevel(ALL);
    }
}

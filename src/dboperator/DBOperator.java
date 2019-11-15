package dboperator;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import entities.Car;
import entities.User;
import model.Model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * Class that process data storing-retrieving operations
 */
public class DBOperator {
    private final String source = "C:\\Files\\Projects\\Java\\RentCarService\\xml_source\\model.xml";
    private int currentUserID = 1;
    private int currentCarID = 1;

    public int addUser(User user){ //update user id as side effect
        user.setId(currentUserID);
        currentUserID++;
        return 0;
    }

    public int removeUser(Integer id){
        return 0;
    }

    public int updateUser(User user){
        return 0;
    }

    public int addCar(Car car){ //update car id as side effect
        car.setId(currentCarID);
        currentCarID++;
        return 0;
    }

    public int removeCar(Integer id){
        return 0;
    }

    public int updateCar(Car car){
        return 0;
    }

    /**
     * This method serializes users and cars into xml-file
     * @param model app model
     * @throws IOException when file error occurred
     * @see IOException
     */
    public void serialize(Model model) throws Exception{//TODO: remove exception
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(source), model);
    }

    /**
     * This method deserializes xml-file into two array lists
     * @return array of two array lists as Objects, [0] is users, [1] is cars. null appears if reading error occurred
     * @throws IOException
     */
    public Model deserializeModel() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        String xmlText = new String(Files.readAllBytes(Paths.get(source)));
        return xmlMapper.readValue(xmlText, Model.class);
    }

    public DBOperator() {}
}

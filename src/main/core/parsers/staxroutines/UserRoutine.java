package main.core.parsers.staxroutines;

import main.core.entities.User;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.events.XMLEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRoutine implements IStaxRoutine {
    @Override
    public List<User> parse(XMLEventReader reader) {
        List<User> users = new ArrayList<>();
        User user = null;
        XMLEvent nextEvent;
        try {
            while (reader.hasNext()) {
                nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {
                    var startElement = nextEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "user":
                            user = new User();
                            var id = startElement.getAttributeByName(new QName("id"));
                            if (id != null) {
                                user.setId(Integer.parseInt(id.getValue()));
                            }
                            break;
                        case "name":
                            nextEvent = reader.nextEvent();
                            Objects.requireNonNull(user).setName(nextEvent.asCharacters().getData());
                            break;
                        case "surname":
                            nextEvent = reader.nextEvent();
                            Objects.requireNonNull(user).setSurname(nextEvent.asCharacters().getData());
                            break;
                    }
                }
                if (nextEvent.isEndElement()) {
                    var endElement = nextEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("user")) {
                        users.add(user);
                    }
                }
            }
        }catch (Exception ignored){}
        return users;
    }
}

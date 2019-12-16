package main.core.parsers.staxroutines;

import javax.xml.stream.XMLEventReader;
import java.util.List;

public interface IStaxRoutine<T> {
    List<T> parse(XMLEventReader reader);
}

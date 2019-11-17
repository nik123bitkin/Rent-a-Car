package entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

abstract class Entity {
    @JacksonXmlProperty(isAttribute = true)
    protected int id;
}

package entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

abstract class Entity {
    @JacksonXmlProperty(isAttribute = true)
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package main.core.parsers.domroutines;

import org.w3c.dom.Node;

public abstract class DomBaseRoutine<T> {
    public String className;

    public abstract T getFromNode(Node node);

    DomBaseRoutine(String className) {
        this.className = className;
    }
}

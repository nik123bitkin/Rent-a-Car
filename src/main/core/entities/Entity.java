package main.core.entities;

abstract class Entity {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected int id;
}

package com.labbati.cando;

public class Constraint {

    private String name;

    private Object value;

    public Constraint(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}

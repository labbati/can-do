package com.labbati.cando;

public final class Constraint {

    private String name;

    private Object value;

    private boolean active;

    public Constraint(String name, Object value) {
        this(name, value, true);
    }

    public Constraint(String name, Object value, boolean active) {
        this.name = name;
        this.value = value;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}

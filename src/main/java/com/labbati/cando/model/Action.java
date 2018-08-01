package com.labbati.cando.model;

import java.util.*;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;

public final class Action {

    private String name;

    private boolean allowed;

    private List<Constraint> constraints;

    public Action(String name, boolean allowed, List<Constraint> constraints) {
        this.name = name;
        this.constraints = constraints;
        this.allowed = allowed;
    }

    public Action(String name, BooleanSupplier activator, List<Constraint> constraints) {
        this(name, activator.getAsBoolean(), constraints);
    }

    public static Action allow(String name, BooleanSupplier activator, List<Constraint> constraints) {
        return new Action(name, activator.getAsBoolean());
    }

    public Action(String name, boolean allowed) {
        this(name, allowed, new ArrayList<>());
    }

    public static Action allow(String name) {
        return new Action(name, true);
    }

    public static Action allow(String name, BooleanSupplier activator) {
        return new Action(name, activator.getAsBoolean());
    }

    public static <T> Action allow(String name, T instance, Predicate<T> activator) {
        return new Action(name, activator.test(instance));
    }

    public static Action deny(String name) {
        return new Action(name, false);
    }

    public String getName() {
        return name;
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }

    public boolean isAllowed() {
        return allowed;
    }
}

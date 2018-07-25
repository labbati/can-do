package com.labbati.cando;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;

public final class Action {

    private String name;

    private boolean allowed;

    private Set<Constraint> constraints;

    public Action(String name, boolean allowed, Set<Constraint> constraints) {
        this.name = name;
        this.constraints = constraints;
        this.allowed = allowed;
    }

    public Action(String name, boolean allowed) {
        this(name, allowed, new HashSet<>());
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

    public Set<Constraint> getConstraints() {
        return constraints;
    }

    public boolean isAllowed() {
        return allowed;
    }
}

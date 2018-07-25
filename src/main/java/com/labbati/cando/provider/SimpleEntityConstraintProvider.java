package com.labbati.cando.provider;

import com.labbati.cando.Constraint;

import java.util.function.Function;

public final class SimpleEntityConstraintProvider<T> implements EntityConstraintProvider<T> {

    private String name;

    private Function<T, Boolean> activator;

    private Function<T, Object> valueProvider;

    public SimpleEntityConstraintProvider(String name, Function<T, Object> valueProvider, Function<T, Boolean> activator) {
        this.name = name;
        this.activator = activator;
        this.valueProvider = valueProvider;
    }

    @Override
    public Constraint apply(T entity) {
        return new Constraint(name, valueProvider.apply(entity), activator.apply(entity));
    }
}

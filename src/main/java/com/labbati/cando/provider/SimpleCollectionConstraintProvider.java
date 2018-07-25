package com.labbati.cando.provider;

import com.labbati.cando.Constraint;

import java.util.function.Function;

public class SimpleCollectionConstraintProvider<T> implements CollectionConstraintProvider<T> {

    private String name;

    private Function<Class<T>, Boolean> activator;

    private Function<Class<T>, Object> valueProvider;

    public SimpleCollectionConstraintProvider(String name, Function<Class<T>, Object> valueProvider, Function<Class<T>, Boolean> activator) {
        this.name = name;
        this.activator = activator;
        this.valueProvider = valueProvider;
    }

    @Override
    public Constraint apply(Class<T> type) {
        return new Constraint(name, valueProvider.apply(type), activator.apply(type));
    }
}

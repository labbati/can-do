package com.labbati.cando;

import java.util.Collection;
import java.util.function.BiFunction;

public class SimpleCollectionActionProvider<T> implements CollectionActionProvider<T> {

    final private String name;

    final private BiFunction<Class<T>, Collection<T>, Boolean> allowEvaluator;

    public SimpleCollectionActionProvider(String name, BiFunction<Class<T>, Collection<T>, Boolean> allowEvaluator) {
        this.name = name;
        this.allowEvaluator = allowEvaluator;
    }

    @Override
    public Action apply(Class<T> type, Collection<T> entities) {
        return new Action(name, allowEvaluator.apply(type, entities));
    }
}

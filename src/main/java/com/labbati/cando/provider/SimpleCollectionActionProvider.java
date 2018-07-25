package com.labbati.cando.provider;

import com.labbati.cando.Action;

import java.util.function.Function;

public class SimpleCollectionActionProvider<T> implements CollectionActionProvider<T> {

    final private String name;

    final private Function<Class<T>, Boolean> allowEvaluator;

    public SimpleCollectionActionProvider(String name, Function<Class<T>, Boolean> allowEvaluator) {
        this.name = name;
        this.allowEvaluator = allowEvaluator;
    }

    @Override
    public Action apply(Class<T> type) {
        return new Action(name, allowEvaluator.apply(type));
    }
}

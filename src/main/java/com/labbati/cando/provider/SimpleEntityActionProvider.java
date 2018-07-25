package com.labbati.cando.provider;

import com.labbati.cando.Action;

import java.util.function.Function;

public class SimpleEntityActionProvider<T> implements EntityActionProvider<T> {

    final private String name;

    final private Function<T, Boolean> allowEvaluator;

    public SimpleEntityActionProvider(String name, Function<T, Boolean> allowEvaluator) {
        this.name = name;
        this.allowEvaluator = allowEvaluator;
    }

    @Override
    public Action apply(T entity) {
        return new Action(name, allowEvaluator.apply(entity));
    }
}

package com.labbati.cando.builder;

import com.labbati.cando.provider.CollectionActionProvider;
import com.labbati.cando.provider.CollectionConstraintProvider;
import com.labbati.cando.provider.SimpleCollectionActionProvider;
import com.labbati.cando.provider.SimpleCollectionConstraintProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CollectionActionProviderBuilder<T> {

    private final Class<T> type;

    private final String name;

    private Function<Class<T>, Boolean> allowEvaluator = (type) -> true;

    private final List<CollectionConstraintProvider<T>> constraints = new ArrayList<>();

    public CollectionActionProviderBuilder(Class<T> type, String name) {
        this.name = name;
        this.type = type;
    }

    public CollectionActionProviderBuilder<T> allowWhen(Function<Class<T>, Boolean> evaluator) {
        this.allowEvaluator = evaluator;
        return this;
    }

    public CollectionActionProviderBuilder<T> denyWhen(Function<Class<T>, Boolean> evaluator) {
        this.allowEvaluator = (type) -> !evaluator.apply(type);
        return this;
    }

    public CollectionActionProviderBuilder<T> withConstraint(String name, Object value) {
        return withConstraint(name, value, t -> true);
    }

    public CollectionActionProviderBuilder<T> withConstraint(String name, Object value, Function<Class<T>, Boolean> activator) {
        return withConstraint(name, t -> value, activator);
    }

    public CollectionActionProviderBuilder<T> withConstraint(String name, Function<Class<T>, Object> valueProvider, Function<Class<T>, Boolean> activator) {
        constraints.add(new SimpleCollectionConstraintProvider<>(name, valueProvider, activator));
        return this;
    }

    public CollectionActionProvider<T> build() {
        return new SimpleCollectionActionProvider<>(name, allowEvaluator);
    }
}

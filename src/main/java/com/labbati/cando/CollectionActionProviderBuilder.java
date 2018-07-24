package com.labbati.cando;

import java.util.Collection;
import java.util.function.BiFunction;

public class CollectionActionProviderBuilder<T> {

    private final Class<T> type;

    private final String name;

    private BiFunction<Class<T>, Collection<T>, Boolean> allowEvaluator = (type, list) -> true;

    private CollectionActionProviderBuilder(Class<T> type, String name) {
        this.name = name;
        this.type = type;
    }

    public static <T> CollectionActionProviderBuilder<T> onCollection(Class<T> type, String name) {
        return new CollectionActionProviderBuilder<>(type, name);
    }

    public CollectionActionProviderBuilder allowWhen(BiFunction<Class<T>, Collection<T>, Boolean> evaluator) {
        this.allowEvaluator = evaluator;
        return this;
    }

    public CollectionActionProviderBuilder denyWhen(BiFunction<Class<T>, Collection<T>, Boolean> evaluator) {
        this.allowEvaluator = (type, list) -> !evaluator.apply(type, list);
        return this;
    }

    public CollectionActionProvider<T> build() {
        return new SimpleCollectionActionProvider<>(name, allowEvaluator);
    }
}

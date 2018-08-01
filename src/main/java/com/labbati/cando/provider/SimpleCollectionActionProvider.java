package com.labbati.cando.provider;

import com.labbati.cando.model.Action;
import com.labbati.cando.model.Constraint;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SimpleCollectionActionProvider<T> implements CollectionActionProvider<T> {

    final private String name;

    final private Function<Class<T>, Boolean> allowEvaluator;

    final private List<CollectionConstraintProvider<T>> constraintProviders;

    public SimpleCollectionActionProvider(String name, Function<Class<T>, Boolean> allowEvaluator, List<CollectionConstraintProvider<T>> constraintProviders) {
        this.name = name;
        this.allowEvaluator = allowEvaluator;
        this.constraintProviders = constraintProviders;
    }

    @Override
    public Action provide(Class<T> type, Boolean includeInactiveConstraints) {
        List<Constraint> constraints = constraintProviders.stream()
            .map(cp -> cp.apply(type))
            .filter(c -> includeInactiveConstraints || c.isActive())
            .collect(Collectors.toList());
        return new Action(name, allowEvaluator.apply(type), constraints);
    }
}

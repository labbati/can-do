package com.labbati.cando.provider;

import com.labbati.cando.model.Action;
import com.labbati.cando.model.Constraint;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SimpleEntityActionProvider<T> implements EntityActionProvider<T> {

    final private String name;

    final private Function<T, Boolean> allowEvaluator;

    final private List<EntityConstraintProvider<T>> constraintProviders;

    public SimpleEntityActionProvider(String name, Function<T, Boolean> allowEvaluator, List<EntityConstraintProvider<T>> constraintProviders) {
        this.name = name;
        this.allowEvaluator = allowEvaluator;
        this.constraintProviders = constraintProviders;
    }

    @Override
    public Action provide(T entity, Boolean includeInactiveConstraints) {
        List<Constraint> constraints = constraintProviders.stream()
            .map(cp -> cp.provide(entity))
            .filter(c -> includeInactiveConstraints || c.isActive())
            .collect(Collectors.toList());
        return new Action(name, allowEvaluator.apply(entity), constraints);
    }
}
